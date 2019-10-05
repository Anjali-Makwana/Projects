package com.SpringCrud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SpringCrud entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "springcrud", catalog = "test")
public class SpringCrud implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String password;
	private String email;
	private String contact;
	private Integer active;

	// Constructors

	/** default constructor */
		public SpringCrud() {
		}

	/** minimal constructor */
		public SpringCrud(Integer id) {
			this.id = id;
		}

	/** full constructor */
		public SpringCrud(Integer id, String name, String password, String email,
				String contact, Integer active) {
			this.id = id;
			this.name = name;
			this.password = password;
			this.email = email;
			this.contact = contact;
			this.active = active;
		}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 8, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 32)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "contact", length = 32)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "active")
	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
