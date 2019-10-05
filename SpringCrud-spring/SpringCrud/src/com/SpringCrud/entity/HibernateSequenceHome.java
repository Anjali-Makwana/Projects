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
 * Home object for domain model class HibernateSequence.
 * @see com.SpringCrud.entity.HibernateSequence
 * @author Hibernate Tools
 */
public class HibernateSequenceHome {

	private static final Log log = LogFactory.getLog(HibernateSequenceHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(HibernateSequence transientInstance) {
		log.debug("persisting HibernateSequence instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(HibernateSequence instance) {
		log.debug("attaching dirty HibernateSequence instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HibernateSequence instance) {
		log.debug("attaching clean HibernateSequence instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(HibernateSequence persistentInstance) {
		log.debug("deleting HibernateSequence instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HibernateSequence merge(HibernateSequence detachedInstance) {
		log.debug("merging HibernateSequence instance");
		try {
			HibernateSequence result = (HibernateSequence) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public HibernateSequence findById(java.lang.Long id) {
		log.debug("getting HibernateSequence instance with id: " + id);
		try {
			HibernateSequence instance = (HibernateSequence) sessionFactory.getCurrentSession()
					.get("com.SpringCrud.entity.HibernateSequence", id);
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

	public List findByExample(HibernateSequence instance) {
		log.debug("finding HibernateSequence instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.SpringCrud.entity.HibernateSequence")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
