package com.SpringCrud.entity;
// Generated Jul 19, 2018 3:12:50 PM by Hibernate Tools 5.3.0.Beta2

/**
 * HibernateSequence generated by hbm2java
 */
public class HibernateSequence implements java.io.Serializable {

	private Long nextVal;

	public HibernateSequence() {
	}

	public HibernateSequence(Long nextVal) {
		this.nextVal = nextVal;
	}

	public Long getNextVal() {
		return this.nextVal;
	}

	public void setNextVal(Long nextVal) {
		this.nextVal = nextVal;
	}

}
