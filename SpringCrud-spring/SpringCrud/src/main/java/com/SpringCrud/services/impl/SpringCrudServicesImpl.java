package com.SpringCrud.services.impl;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringCrud.bean.SpringCrudBean;
import com.SpringCrud.common.CommonDao;
import com.SpringCrud.entity.SpringCrud;
import com.SpringCrud.services.SpringCrudServices;

@Service
public class SpringCrudServicesImpl implements SpringCrudServices {

	@Autowired
	EntityManagerFactory entity;
	
	@Autowired
	CommonDao dao;
	
	@Override
	public boolean saveData(SpringCrudBean bean) {

		Session session=getHibernateSession();
		SpringCrud crud=new SpringCrud();
		String getMax=dao.getMaxValue("springcrud", "id", null);
		crud.setId(Integer.parseInt(getMax));
		crud.setName(bean.getName());
		crud.setPassword(bean.getPassword());
		crud.setEmail(bean.getEmail());
		crud.setContact(bean.getContact());
		crud.setActive(1);
		session.save(crud);
		session.beginTransaction();
		session.flush();
		session.getTransaction().commit();
		return false;
	}
	public Connection getConnection() {
		SessionImpl impl=(SessionImpl)getHibernateSession();
		return impl.connection();
	}
	public Session getHibernateSession() {
		return entity.createEntityManager().unwrap(Session.class);
	}
	@Override
	public List<?> displayData() {
		List<?> getResultList = null;
		dao.getQueryData("SELECT id,NAME,email,contact,active FROM springcrud");
		return getResultList;
	}
}
