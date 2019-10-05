package com.iflame.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePasswordController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oldPwd = req.getParameter("oldPwd");
		String newPwd = req.getParameter("newPwd");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:xe");
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);
			String currTeacher = (String)req.getSession().getAttribute("currTeacher");
			ResultSet rs = stmt.executeQuery("select * from SHIRALI.teacher where pwd='" + oldPwd + "' and username='" + currTeacher + "'");
			
			rs.last();
			int size = rs.getRow();
			
			if(size >= 1){
				stmt.executeUpdate("update SHIRALI.teacher set pwd = '" + newPwd + "' where username = '" + currTeacher + "'");
				
			}
			else 
			{
				req.setAttribute("errMsg", "Passwords doesn't match");
				req.getRequestDispatcher("change_pwd.jsp").forward(req, resp);
			}
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
