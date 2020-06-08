
package com.gestion.demo.service.impl;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.dao.DemmandeDocumentDao;
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
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

@Service

public class DemmandeDocumentServiceImpl implements DemmandeDocumentService {

	@Autowired

	private DemmandeDocumentDao demmandedocumentDao;

	@Autowired

	private EntityManager entityManager;

	@Autowired

	private DemmandeurService demmandeurService;

	@Autowired

	private TypeDocumentService typedocumentService;

	@Autowired

	private EtatDemmandeService etatdemmandeService;

	@Override
	public DemmandeDocument save(DemmandeDocument demmandedocument) {

		if (demmandedocument == null) {
			return null;
		} else {
			demmandedocumentDao.save(demmandedocument);
			return demmandedocument;
		}
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
	public int infoDemmandeurPdf(String cin) throws DocumentException, FileNotFoundException {
		Demmandeur demmandeur = demmandeurService.findByCin(cin);
		String pattern = "dd/MM/yyyy";
		String pattern2 = "yyyy";
		String pattern3 = "dd MMMM yyyy ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat(pattern3);
		Document document = new Document();
		 PdfWriter.getInstance(document, new FileOutputStream("DocumentPdf.pdf"));
		document.open();
		

		Paragraph p1 = new Paragraph("ROYAUME DU MAROC" + "\n" + "Université Cadi Ayyad." + "\n" +
		"Faculté des Sciences et Techniques"
						+ "\n" + "Gueliz-Marrakech" + "\n" + "\n" + "Service des Affaires Estudiantines");
		p1.setAlignment(Element.ALIGN_LEFT);
		document.add(p1);

		/*
		Paragraph p2 = new Paragraph("المملكة المغربية" + "\n" + "جامعة القاضي عياض" + "\n"
				+ "كلية العلوم و التقنيات مراكش" + "\n" + "\n" + "\n" + "مصلحة الشؤون الطلابية");
		p2.setAlignment(Element.ALIGN_RIGHT);
		document.add(p2);
		*/
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 20, BaseColor.BLACK);
		Paragraph p3 = new Paragraph("\n " + "Certificat de scolarité", font);
		p3.setAlignment(Element.ALIGN_CENTER);
		document.add(p3);
		

		Paragraph p = new Paragraph();
		p.add("\n\n\n\t" + "Le Doyen de la Faculté des Sciences et Techniques de Marrakech atteste que l'étudiante:"
				+ "\n\n \t" + "Mademoiselle  " + demmandeur.getNom() + " " + demmandeur.getPrenom() + "\n\n \t"
				+ "Numéro de la carte d'identité nationale : " + demmandeur.getCin() + "\n\n \t"
				+ "Code national de l'étudiante : " + "\t" + demmandeur.getCne() + "\n\n\t" + "née le"
				+ " " + simpleDateFormat3.format(demmandeur.getDateNaissance()) + " " + "à" + " " +
				demmandeur.getVilleNaissance() + " " + "(MAROC)" + "\n\n\n \t"
				+ "est régulièrement inscrite à la Faculté des Sciences et Techniques Gueliz-Marrakech pour" + "\n \t"
				+ "l'année universitaire" + " " + simpleDateFormat2.format(demmandeur.getAnneeInscription()) + "." + "\n\n \t"
				+ "Diplôme : 3ème Année LST" + " " + demmandeur.getFiliere().getLibelle() + "\n\n \t" + "Année : LST "
				+ " " + demmandeur.getFiliere().getLibelle());
		document.add(p);
		Paragraph p4 = new Paragraph("\n\n \t"+"                                                                       " +
		"Fait à Marrakech , le " + simpleDateFormat3.format(new Date()));
		
		document.add(p4);

		Paragraph p5 = new Paragraph("\n \r\r\r\r"  + demmandeur.getCodeApogee() + "\n \r");
		p5.setAlignment(Element.ALIGN_RIGHT);
		document.add(p5);
		
		// ligne
		document.add(new LineSeparator()); // Thick line
		
		Paragraph p6 = new Paragraph("Adresse :  B.P549, Av.Abdelkarim elkhattabi" + "\t\t\t\t\t" + "العنوان" + "\n"
				+ "Gueliz-Marrakech" + "\n" + "Tél: +212 24 43 34" + "         "
		+ "                                                       " + "Fax: +212 24 43 31" + "\n" 
				+ "\r");
		p6.setAlignment(Element.ALIGN_LEFT);
		document.add(p6);

		// ligne
		document.add(new LineSeparator()); // Thick line
		Paragraph p7 = new Paragraph("\t Le présent document n'est délivré qu'en un seul exemplaire." + "\n"
				+ "Il appartient à l'étudiant d'en faire dephotocopies certifiées conformes.");
		p7.setAlignment(Element.ALIGN_CENTER);
		document.add(p7);
		document.close();
		return 1;
	}

}
