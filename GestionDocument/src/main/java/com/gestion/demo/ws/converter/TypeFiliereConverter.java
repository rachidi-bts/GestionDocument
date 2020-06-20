package com.gestion.demo.ws.converter;
 
import org.springframework.stereotype.Component;

import com.gestion.demo.bean.TypeFiliere;
import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.TypeFiliereVo;

 @Component 
public class TypeFiliereConverter extends AbstractConverter<TypeFiliere,TypeFiliereVo>{ 

@Override 
	public TypeFiliere toItem(TypeFiliereVo vo) {
	if (vo == null) {
	 return null;
  } else {
  	TypeFiliere item = new TypeFiliere();
		 if(StringUtil.isNotEmpty(vo.getLibelle()))
              item.setLibelle(vo.getLibelle());
		 if(StringUtil.isNotEmpty(vo.getId()))
              item.setId(NumberUtil.toLong(vo.getId()));


	return item;
		}
 }

@Override 
	public TypeFiliereVo toVo(TypeFiliere item) {
		if (item == null) {
		return null;
  	} else {
		TypeFiliereVo vo = new TypeFiliereVo();

		if(StringUtil.isNotEmpty(item.getLibelle()))
			vo.setLibelle(item.getLibelle());
		
		 if(item.getId()!=null)
			vo.setId(NumberUtil.toString(item.getId()));

			return vo;

		}
 }
public void init() { 

}
 } 
