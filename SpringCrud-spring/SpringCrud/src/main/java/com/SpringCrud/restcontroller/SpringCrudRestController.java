package com.SpringCrud.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCrud.bean.SpringCrudBean;
import com.SpringCrud.services.SpringCrudServices;

@RestController
public class SpringCrudRestController {

	@Autowired
	SpringCrudServices service; 
	
	@RequestMapping(value="/saveData",method=RequestMethod.POST)
	public boolean saveData(@RequestBody SpringCrudBean bean) {
		return service.saveData(bean);
	}
	
	@RequestMapping(value="/saveData")
	public void displayData(ModelMap map) {
		map.put("displaylist",service.displayData());
	}
	
}
