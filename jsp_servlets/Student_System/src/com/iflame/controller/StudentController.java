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

public class StudentController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("studId");
		String userName = req.getParameter("studUn");
		String name = req.getParameter("studName");
		String password = req.getParameter("studPwd");
		
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:xe");
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select * from SHIRALI.student");
			
			while(rs.next()){
				System.out.print("ID " + rs.getString(1) + "Name" + rs.getString(2) 
				+"UserName " + rs.getString(3) +"Password " + rs.getString(4));
				
				
			}
			
			rs = stmt.executeQuery("select * from SHIRALI.student where id='" + id + 
					"' and username='" + userName + "' and name = '" + name + "' and pwd='" + password + "'");
			rs.last();
			int size=rs.getRow();
			System.out.print("SIZE IS : " + size);
			if(size <= 0){
				System.out.print("This student does not exist");
				req.setAttribute("errMsg","This student does not exist");
				req.getRequestDispatcher("student_login.jsp").forward(req, resp);
			}
			else {
				
				System.out.print("Validation Successful");
				req.getSession().setAttribute("currStudent", id);
				req.getRequestDispatcher("Student_Data_Entry.jsp").forward(req, resp);
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
		String id = req.getParameter("sid");
		String name = req.getParameter("sname");
		String pwd = req.getParameter("pwd");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:xe");
			
			Statement stmt = con.createStatement();
			
			String qry = "insert into SHIRALI.student (id, name, username, pwd)" +
					"values('" + id + "','" + name + "','"+ uName + "','" + pwd + "')";
			
			stmt.executeUpdate(qry);
			
			req.getRequestDispatcher("Admin_Home.jsp").forward(req, resp);
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
