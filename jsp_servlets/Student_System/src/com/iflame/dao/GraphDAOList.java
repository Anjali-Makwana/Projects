package com.iflame.dao;

import java.io.Serializable;
import java.util.List;

public class GraphDAOList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String teacherName;
	
	private List<Integer> grade;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public List<Integer> getGrade() {
		return grade;
	}

	public void setGrade(List<Integer> grade) {
		this.grade = grade;
	}
	
	

}
