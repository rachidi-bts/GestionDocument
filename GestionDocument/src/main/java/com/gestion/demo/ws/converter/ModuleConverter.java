package  com.gestion.demo.ws.converter;

import org.springframework.stereotype.Component;

import com.gestion.demo.service.util.NumberUtil;
import com.gestion.demo.service.util.StringUtil;
import com.gestion.demo.ws.vo.ModuleVo;
import com.gestion.demo.bean.Module;

@Component 
public class ModuleConverter extends AbstractConverter<Module,ModuleVo>{ 


	@Override 
 	public Module toItem(ModuleVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Module item = new Module();
			 if(StringUtil.isNotEmpty(vo.getLibelle()))
                  item.setLibelle(vo.getLibelle());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public ModuleVo toVo(Module item) {
 		if (item == null) {
    		return null;
      	} else {
			ModuleVo vo = new ModuleVo();

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
