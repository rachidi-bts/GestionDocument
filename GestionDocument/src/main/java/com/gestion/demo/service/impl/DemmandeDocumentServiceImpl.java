
package com.gestion.demo.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.bean.TypeDocument;
import com.gestion.demo.dao.DemmandeDocumentDao;
import com.gestion.demo.dao.DemmandeurDao;
import com.gestion.demo.service.facade.DemmandeDocumentService;
import com.gestion.demo.service.facade.DemmandeurService;
import com.gestion.demo.service.facade.EtatDemmandeService;
import com.gestion.demo.service.facade.TypeDocumentService;
import com.gestion.demo.service.util.SearchUtil;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
//import com.itextpdf.layout.element.Text;

@Service

public class DemmandeDocumentServiceImpl implements DemmandeDocumentService {

	@Autowired

	private DemmandeDocumentDao demmandedocumentDao;

	@Autowired

	private EntityManager entityManager;

	@Autowired
	private DemmandeurService demmandeurService;
	@Autowired
	private DemmandeurDao demmandeurDao;
	@Autowired

	private TypeDocumentService typedocumentService;

	
	@Autowired
	private EtatDemmandeService etatdemmandeService;

	@Override
	public int save(DemmandeDocument demmandedocument) {
      Demmandeur demmandeur = demmandeurDao.findByCne(demmandedocument.getDemmandeur().getCne());
      TypeDocument typeDocument = typedocumentService.findByLibelle(demmandedocument.getTypeDocument().getLibelle());
      demmandedocument.setDemmandeur(demmandeur);
      demmandedocument.setTypeDocument(typeDocument);
      demmandedocument.setEtatDemmande(etatdemmandeService.findByLibelle("non traitée"));
      demmandedocument.setDateDemmande(new Date());
      demmandedocument.setDateValidation(null);
		if (demmandedocument == null) {
			return -1;
		} else {
			if(demmandedocument.getTypeDocument().getLibelle().equals("Attestation d'inscription")) {
				if(demmandedocument.getDemmandeur().getNombreDeAttestationInscriptionRestantes() == 0) {
					return -2;
						} else {
							demmandedocument.getDemmandeur().setNombreDeAttestationInscriptionRestantes((demmandedocument.getDemmandeur().getNombreDeAttestationInscriptionRestantes() -1));
							System.out.println(demmandedocument.getDemmandeur().getNombreDeAttestationInscriptionRestantes());
							demmandeurDao.save(demmandedocument.getDemmandeur());
							demmandedocumentDao.save(demmandedocument);
						}				
			}
			if(demmandedocument.getTypeDocument().getLibelle().equals("Certificat de scolarité")) {
				if(demmandedocument.getDemmandeur().getNombreDeAttestationScolariteRestantes() == 0) {
					return -3;
						} else {
							demmandedocument.getDemmandeur().setNombreDeAttestationScolariteRestantes((demmandedocument.getDemmandeur().getNombreDeAttestationScolariteRestantes() -1));
							demmandeurDao.save(demmandedocument.getDemmandeur());
							demmandedocumentDao.save(demmandedocument);
						}
			}
			
		}
		return 1;
	}

	@Override
	public List<DemmandeDocument> findAll() {
		return demmandedocumentDao.findAll();
	}

	@Override
	public DemmandeDocument findById(Long id) {
		return demmandedocumentDao.getOne(id);
	}

	@Override
	public int delete(DemmandeDocument demmandedocument) {
		if (demmandedocument == null) {
			return -1;
		} else {
			demmandedocumentDao.delete(demmandedocument);
			return 1;
		}
	}

	@Override
	public void deleteById(Long id) {
		demmandedocumentDao.deleteById(id);
	}

	public void clone(DemmandeDocument demmandedocument, DemmandeDocument demmandedocumentClone) {
		if (demmandedocument != null && demmandedocumentClone != null) {
			demmandedocumentClone.setId(demmandedocument.getId());
			demmandedocumentClone.setDateDemmande(demmandedocument.getDateDemmande());
			demmandedocumentClone.setDateValidation(demmandedocument.getDateValidation());
			demmandedocumentClone.setDemmandeur(demmandeurService.clone(demmandedocument.getDemmandeur()));
			demmandedocumentClone.setTypeDocument(typedocumentService.clone(demmandedocument.getTypeDocument()));
			demmandedocumentClone.setEtatDemmande(etatdemmandeService.clone(demmandedocument.getEtatDemmande()));
		}
	}

	public DemmandeDocument clone(DemmandeDocument demmandedocument) {
		if (demmandedocument == null) {
			return null;
		} else {
			DemmandeDocument demmandedocumentClone = new DemmandeDocument();
			clone(demmandedocument, demmandedocumentClone);
			return demmandedocumentClone;
		}
	}

	public List<DemmandeDocument> clone(List<DemmandeDocument> demmandedocuments) {
		if (demmandedocuments == null) {
			return null;
		} else {
			List<DemmandeDocument> demmandedocumentsClone = new ArrayList();
			demmandedocuments.forEach((demmandedocument) -> {
				demmandedocumentsClone.add(clone(demmandedocument));
			});
			return demmandedocumentsClone;
		}
	}

	@Override
	public List<DemmandeDocument> findByCriteria(Long idMin, Long idMax, Date dateDemmandeMin, Date dateDemmandeMax,
			Date dateValidationMin, Date dateValidationMax) {
		return entityManager.createQuery(
				constructQuery(idMin, idMax, dateDemmandeMin, dateDemmandeMax, dateValidationMin, dateValidationMax))
				.getResultList();
	}

	private String constructQuery(Long idMin, Long idMax, Date dateDemmandeMin, Date dateDemmandeMax,
			Date dateValidationMin, Date dateValidationMax) {
		String query = "SELECT d FROM DemmandeDocument d where 1=1 ";
		query += SearchUtil.addConstraintMinMax("d", "id", idMin, idMax);
		query += SearchUtil.addConstraintMinMaxDate("d", " dateDemmande", dateDemmandeMin, dateDemmandeMax);
		query += SearchUtil.addConstraintMinMaxDate("d", " dateValidation", dateValidationMin, dateValidationMax);

		return query;
	}

	@Override
	public List<DemmandeDocument> findByDemmandeurNom(String nom) {
		return demmandedocumentDao.findByDemmandeurNom(nom);
	}

	@Override
	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee) {
		return demmandedocumentDao.findByDemmandeurCodeApogee(codeApogee);
	}

	@Override
	public List<DemmandeDocument> findByDemmandeurCne(String cne) {
		return demmandedocumentDao.findByDemmandeurCne(cne);
	}

	@Override
	public List<DemmandeDocument> findByDemmandeurCin(String cin) {
		return demmandedocumentDao.findByDemmandeurCin(cin);
	}

	@Override
	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle) {
		return demmandedocumentDao.findByTypeDocumentLibelle(libelle);
	}

	@Override
	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle) {
		return demmandedocumentDao.findByEtatDemmandeLibelle(libelle);
	}

	@Override
	public DemmandeDocumentDao findByDateDemmande(Date dateDemmande) {
		return demmandedocumentDao.findByDateDemmande(dateDemmande);
	}

//PDF
	@Override
	public int infoDemmandeurPdf(String cin, String libelle) throws DocumentException, FileNotFoundException {
		Demmandeur demmandeur = demmandeurService.findByCin(cin);
		TypeDocument typeDocument = typedocumentService.findByLibelle(libelle);
		String pattern = "dd/MM/yyyy";
		String pattern2 = "yyyy";
		String pattern3 = "dd MMMM yyyy ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
		Document document = new Document();
		 PdfWriter.getInstance(document, new FileOutputStream(demmandeur.getNom() + demmandeur.getPrenom() + ".pdf"));
		document.open();
		
        
		Font font1 = FontFactory.getFont(FontFactory.TIMES, 9, BaseColor.BLACK);
		Paragraph p1 = new Paragraph("ROYAUME DU MAROC" + "\n" + "Université Cadi Ayyad." + "\n" +
		"Faculté des Sciences et Techniques"
						+ "\n" + "Gueliz-Marrakech" + "\n" + "\n" , font1);
		p1.setAlignment(Element.ALIGN_LEFT);
		document.add(p1);
		
		Font font2 = FontFactory.getFont(FontFactory.TIMES, 10, Font.UNDERLINE);
		Paragraph p2 = new Paragraph("Service des Affaires Estudiantines" , font2);
		p2.setAlignment(Element.ALIGN_LEFT);
		document.add(p2);
		

		/*
		Paragraph p2 = new Paragraph("المملكة المغربية" + "\n" + "جامعة القاضي عياض" + "\n"
				+ "كلية العلوم و التقنيات مراكش" + "\n" + "\n" + "\n" + "مصلحة الشؤون الطلابية");
		p2.setAlignment(Element.ALIGN_RIGHT);
		document.add(p2);
		*/
		
		 Font font3 = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 20, Font.UNDERLINE);
		Paragraph p3 = new Paragraph("\n " + typeDocument.getLibelle(), font3);
		p3.setAlignment(Element.ALIGN_CENTER);
		document.add(p3);
		

		Font font = FontFactory.getFont(FontFactory.TIMES, 11);
		Paragraph p = new Paragraph("\n\n\n" + "   " + "Le Doyen de la Faculté des Sciences et Techniques de Marrakech atteste que l'étudiant(e):"
				+ "\n\n" + "   " + "Nom complet:  " + demmandeur.getNom() + " " + demmandeur.getPrenom() + "\n\n" + "   "
				+ "Numéro de la carte d'identité nationale : " + demmandeur.getCin() + "\n\n" + "   "
				+ "Code national de l'étudiant(e) : " + "                 " + demmandeur.getCne() + "\n\n" + "   " + "né(e) le"
				+ " " + simpleDateFormat3.format(demmandeur.getDateNaissance()) + " " + "à" + " " +
				demmandeur.getVilleNaissance() + " " + "(" + demmandeur.getPaysNaissance() + ")" + "\n\n" + "   "
				+ "est régulièrement inscrit(e) à la Faculté des Sciences et Techniques Gueliz-Marrakech pour" + "\n" + "   "
				+ "l'année universitaire" + " " + simpleDateFormat2.format(demmandeur.getAnneeInscription()) + "." + "\n\n" + "   "
				, font);
		
		Font fontt = FontFactory.getFont(FontFactory.TIMES, 11, Font.UNDERLINE);
		Phrase diplome = new Phrase("Diplôme :", fontt);
		Phrase phh = new Phrase("  " + "3ème Année LST" + " " + demmandeur.getFiliere().getAbrv() + "\n\n" +"   ", font);
		Phrase annee = new Phrase("Année :", fontt);
		Phrase phh2 = new Phrase("      " + "LST" + " " + demmandeur.getFiliere().getLibelle(), font);
		p.add(diplome);
		p.add(phh);
		p.add(annee);
		p.add(phh2);
		document.add(p);
		
		Paragraph p4 = new Paragraph("\n\n\n" + "                               "
				+ "                                                                " +
		"Fait à Marrakech , le " + simpleDateFormat3.format(new Date()), font);
		document.add(p4);

		Paragraph p5 = new Paragraph("\n \r\r\r\r"  + demmandeur.getCodeApogee() + "\n \r");
		p5.setAlignment(Element.ALIGN_RIGHT);
		document.add(p5);
		
		// ligne
		document.add(new LineSeparator()); // Thick line
		
		Phrase ph1 = new Phrase(" Adresse :", font2);
		Phrase ph2 = new Phrase("   " + "B.P549, Av.Abdelkarim elkhattabi \t\t\t\t\t" + "العنوان" + "\n"
		+"                     " + "Gueliz-Marrakech" + "\n" + "                     " + "Tél: +212 24 43 34" + 
				"                                               "
		+ "                                                                            " + "Fax: +212 24 43 31" + "\n" 
				+ "\r", font1);
		/*String FONT = "resources/fonts/NotoNaskhArabic-Regular.ttf";
		Font f = FontFactory.getFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	    final String arabic2 = "\u0627\u0644\u0639\u0646\u0648\u0627\u0646" ;
	    Phrase ph6 = new Phrase();
		ph6.add(new Chunk(arabic2,f));*/
		Paragraph p6 = new Paragraph();
		p6.add(ph1);
		p6.add(ph2);
		//p6.add(ph6);
		document.add(p6);
	

		// ligne
		document.add(new LineSeparator()); // Thick line
		Paragraph p7 = new Paragraph("\t Le présent document n'est délivré qu'en un seul exemplaire." + "\n"
				+ "Il appartient à l'étudiant d'en faire dephotocopies certifiées conformes.", font1);
		p7.setAlignment(Element.ALIGN_CENTER);
		
		document.add(p7);
		document.close();
		return 1;
	}

}
