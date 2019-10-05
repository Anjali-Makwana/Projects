package com.iflame.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iflame.dao.GraphDAO;
import com.iflame.dao.GraphDAOList;

public class GraphController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<GraphDAO> graphList = new ArrayList<GraphDAO>();
		List<GraphDAOList> graphs = new ArrayList<GraphDAOList>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:SYSTEM/oracle@localhost:1521:xe");
			
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("select teacher_user_name, "
					+ "sum(decode(grade, 'A', 1, 'B', 2, 'C', 3, '', 0)) as grade from "+
						"ANJALI.feedback group by teacher_user_name");
			
			
			
			while(rs.next()){
				
				/*GraphDAO dao = new GraphDAO();
				dao.setTeacherName(rs.getString(1));
				dao.setGrade(rs.getInt(2));*/
				
				GraphDAOList daoL = new GraphDAOList();
				daoL.setTeacherName(rs.getString(1));
				
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(rs.getInt(2));
				
				daoL.setGrade(temp);
				
				//graphList.add(dao);
				graphs.add(daoL);
			}
			
			
			
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson json = new Gson();
		String jsonInput2 = json.toJson(graphList);
		
		String jsonInput = json.toJson(graphs);
		
		
		
		
		//jsonInput.replaceAll("\"", "'");
		
		System.out.print(jsonInput);
		
		
		resp.setContentType("application/json");
		
		resp.getWriter().write(jsonInput2);
		
		resp.getWriter().flush();
		resp.getWriter().close();
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
