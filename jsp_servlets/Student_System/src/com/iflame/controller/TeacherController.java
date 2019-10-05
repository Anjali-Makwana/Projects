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

public class TeacherController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = req.getParameter("teacherUn");
		String password = req.getParameter("teacherPwd");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:xe");
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from SHIRALI.teacher");
			
			while(rs.next()){
				System.out.print("UserName " + rs.getString(1) +"Password " + rs.getString(2));
			}
			
			rs = stmt.executeQuery("select * from SHIRALI.teacher where username='" + userName + "'");
			rs.last();
			int size=rs.getRow();
			if(size <= 0){
				System.out.print("Teacher does not exist");
				req.setAttribute("errMsg","Teacher does not exist");
				req.getRequestDispatcher("teacher_login.jsp").forward(req, resp);
			}
			else {
				System.out.print("Validation Successful");
				req.getSession().setAttribute("currTeacher", userName);
				req.getRequestDispatcher("teacher_home.jsp").forward(req, resp);
			}
			
			con.close();
		} catch (ClassNotFoundException e) {
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
		String uName = req.getParameter("uName");
		String pwd = req.getParameter("pwd");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:xe");
			
			Statement stmt = con.createStatement();
			
			String qry = "insert into SHIRALI.teacher (username, pwd)" +
					"values('" + uName + "','" + pwd + "')";
			
			stmt.executeUpdate(qry);
			
			req.getRequestDispatcher("teacher_home.jsp").forward(req, resp);
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
