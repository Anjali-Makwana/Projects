package com.SpringCrud.services;

import java.util.List;

import com.SpringCrud.bean.SpringCrudBean;

public interface SpringCrudServices {

	public boolean saveData(SpringCrudBean bean);
	
	public List<?> displayData();
}
