package com.iflame.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numOfStudents = Integer.parseInt(req.getParameter("numOfStudents"));
		
		//for(int i = 0; i < numOfStudents; i++){
			req.getRequestDispatcher("Student_Feedback.jsp").forward(req, resp);
		//}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] dept = req.getParameterValues("dept");
		System.out.print("DEPARTMENT SIZE " + dept.length);
		String[] year = req.getParameterValues("year");
		String[] semester = req.getParameterValues("sem");
		String[] subject = req.getParameterValues("subject");
		
		String currStudent = (String)req.getSession().getAttribute("currStudent");
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:xe");
			
			Statement stmt = con.createStatement();
			for(int i = 0; i < dept.length; i++){
				
				String qry = "insert into SHIRALI.feedback (student_id, dept, teacher_user_name, year, semester, grade, subject)" +
						"values('" + currStudent + "','" + dept[i] + "',null, " + Integer.parseInt(year[i]) + "," +
						Integer.parseInt(semester[i]) + ",'A','" + subject[i] + "')"; 
				
				System.out.print("Query " + qry);
				
				stmt.executeUpdate(qry);
			}
			
			req.getSession().setAttribute("successMsg", "Data inserted successfully");
			req.getRequestDispatcher("Student_Feedback.jsp").forward(req, resp);
			
			
			
		}
		catch(ClassNotFoundException e ){
			
		}
		catch(SQLException e){
			
		}
	}
	
	private String findRating(HttpServletRequest req){
		String[] q1 = req.getParameterValues("q1");
		String[] q2 = req.getParameterValues("q2");
		String[] q3 = req.getParameterValues("q3");
		String[] q4 = req.getParameterValues("q4");
		
		
		
		for(int i = 0; i < q1.length; i++){
			/*if(q1[i].equals("Excellent")){
				pMap.put("Excellent", pMap.get("Excellent") + 1);
			}
			if(q1[i].equals("Very Good")){
				pMap.put("Very Good", pMap.get("Very Good") + 1);
			}
			if(q1[i].equals("Good")){
				pMap.put("Good", pMap.get("Good") + 1);
			}*/
			
			Map<String, Integer> pMap = new LinkedHashMap<>();
			pMap.put("Excellent", 0);
			pMap.put("Very Good", 0);
			pMap.put("Good", 0);
			
			if(q1[i].equals("1")){
				pMap.put("Excellent", pMap.get("Excellent") + 1);
			}
			
			
		}
		
		
		
		
		
		return "";
	}
	
	

}
