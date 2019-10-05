package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.RequestProcessingPolicyValue;

import com.Dao.Queries;
import com.bean.Bean;

/**
 * Servlet implementation class Update_Controller
 */
@WebServlet("/Update_Controller")
public class Update_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("param"));
		int j=0;
		try {
			Bean b=Queries.getID(id);
			request.setAttribute("b",b);
			request.getRequestDispatcher("Update.jsp").forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(j>0)
		{
			response.setContentType("html/text");
			PrintWriter pw=response.getWriter();
			pw.print("updated successfully");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("param"));
		String name=request.getParameter("name");
		Bean b=new Bean();
		b.setId(id);
		b.setName(name);
		int i=0;
		try {
			i=Queries.update(b);
		
			System.out.println("updatable page");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Bean> list=Queries.show_data();
			request.setAttribute("list", list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("Admin.jsp").forward(request,response);
	}
	

}
