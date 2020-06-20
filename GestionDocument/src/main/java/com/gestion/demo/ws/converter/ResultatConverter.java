package  com.gestion.demo.ws.converter;

import org.springframework.stereotype.Component;

import com.gestion.demo.bean.Resultat;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.ResultatVo;

@Component 
public class ResultatConverter extends AbstractConverter<Resultat,ResultatVo>{ 

	public  ResultatConverter(){
		init(false);
	}

	@Override 
 	public Resultat toItem(ResultatVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Resultat item = new Resultat();
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public ResultatVo toVo(Resultat item) {
 		if (item == null) {
    		return null;
      	} else {
			ResultatVo vo = new ResultatVo();

			if(StringUtil.isNotEmpty(item.getLibelle()))
				vo.setLibelle(item.getLibelle());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(boolean value) { 
	}

} 
