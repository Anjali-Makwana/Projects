package com.SpringCrud.entity;
// Generated Jul 19, 2018 3:12:50 PM by Hibernate Tools 5.3.0.Beta2

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Springcrud.
 * @see com.SpringCrud.entity.Springcrud
 * @author Hibernate Tools
 */
public class SpringcrudHome {

	private static final Log log = LogFactory.getLog(SpringcrudHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Springcrud transientInstance) {
		log.debug("persisting Springcrud instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Springcrud instance) {
		log.debug("attaching dirty Springcrud instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Springcrud instance) {
		log.debug("attaching clean Springcrud instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Springcrud persistentInstance) {
		log.debug("deleting Springcrud instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Springcrud merge(Springcrud detachedInstance) {
		log.debug("merging Springcrud instance");
		try {
			Springcrud result = (Springcrud) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Springcrud findById(int id) {
		log.debug("getting Springcrud instance with id: " + id);
		try {
			Springcrud instance = (Springcrud) sessionFactory.getCurrentSession()
					.get("com.SpringCrud.entity.Springcrud", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Springcrud instance) {
		log.debug("finding Springcrud instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.SpringCrud.entity.Springcrud")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
