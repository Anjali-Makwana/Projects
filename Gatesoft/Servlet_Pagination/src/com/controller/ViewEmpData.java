package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.EmpDao;
import com.bean.Emp;

/**
 * Servlet implementation class ViewEmpData
 */
@WebServlet("/ViewEmpData")
public class ViewEmpData extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewEmpData() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			PrintWriter out=response.getWriter();

		int pageid= Integer.parseInt(request.getParameter("page"));
		int total=3;
		if(pageid!=1)
		
		{
			pageid-=1;
			pageid=pageid*total+1;
			
		}
	
		List<Emp> list=EmpDao.getData(pageid, total);
		request.setAttribute("list", list);
		request.getRequestDispatcher("View.jsp").forward(request, response);;
		/*out.print("<h1>Page No: "+pageid+"</h1>");  
        out.print("<table border='1' cellpadding='4' width='60%'>");  
        out.print("<tr><th>Id</th><th>Name</th><th>");  
        for(Emp e:list){  
            out.print("<tr><td>"+e.getEmpid()+"</td><td>"+e.getEmpname()+"</td></tr>");  
        }  
        out.print("</table>");  
          
        out.print("<a href='ViewEmpData?page=1'>1</a> ");  
        out.print("<a href='ViewEmpData?page=2'>2</a> ");  
        out.print("<a href='ViewServlet?page=3'>3</a> ");  

        out.close();
*/	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
	}

}
