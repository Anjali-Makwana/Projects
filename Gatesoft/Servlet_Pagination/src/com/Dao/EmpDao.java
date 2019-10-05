package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Util.EmpConnection;
import com.bean.Emp;

public class EmpDao {

	public static List<Emp> getData(int start,int total){  
        List<Emp> list=new ArrayList<Emp>();  
        try{  
            Connection con=EmpConnection.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from employee limit "+(start-1)+","+total);  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setEmpid(rs.getInt(1));  
                e.setEmpname(rs.getString(2));  
                 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){System.out.println(e);}  
        return list;  
    }  
}
