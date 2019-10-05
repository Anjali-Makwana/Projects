package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Util.Register_Connection;
import com.bean.Bean;

public class Queries {
	
	public static int insert(Bean b) throws ClassNotFoundException, SQLException {
		
		Connection con= Register_Connection.getconnection();
		PreparedStatement ps=con.prepareStatement("insert into employee(empname) values(?)");
		
		ps.setString(1,((Bean) b).getName());
		int i=0;
		i=ps.executeUpdate();
		return i;
		
	}

	public static List<Bean> show_data() throws SQLException, ClassNotFoundException{
		
		Connection con=Register_Connection.getconnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from employee");
		
		List list=new ArrayList<>();
		while(rs.next())
		{
			Bean b=new Bean();
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
			list.add(b);
		}
		return list;
		
	}
	
	public static Bean getID(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=Register_Connection.getconnection();
		PreparedStatement ps=con.prepareStatement("Select * from employee where empid=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		Bean b=new Bean();
		while(rs.next())
		{
			b.setId(rs.getInt(1));
			b.setName(rs.getString(2));
		}
		
		return b;
		
	}
	
	
	public static int delete(Bean bean) throws ClassNotFoundException, SQLException
	{
		int i=0;
		Connection con=Register_Connection.getconnection();
		PreparedStatement ps=con.prepareStatement("delete from employee where empid=?");
		ps.setInt(1,bean.getId());
		i=ps.executeUpdate();
		System.out.println("successfully deleted "+i);
		return i;
		
	}
	
	public static int update(Bean b) throws ClassNotFoundException, SQLException {
		
		Connection con=Register_Connection.getconnection();
		PreparedStatement ps=con.prepareStatement("update employee set empname=? where empid=?");
		ps.setString(1,b.getName());
		ps.setInt(2, b.getId());
		int i=0;
		i=ps.executeUpdate();
		return i;
		
	}
	
}
