package DaoClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity_and_DB.Con_DB;

public class DAO {
	
	
	static final String InsertQuery = "Insert into auth1 (name,email,password,usn,branch) value(?,?,?,?,?)";
	static final String UpdateQuery = "Update  auth1 set name=?,email=?,password=?,usn=?,branch=? where sl_no=?";
	static final String deleteQuery = "Delete from auth1 where sl_no=?";
	static final String ReadQuery = "Select * from auth1";
	static final String Read_by_id = "Select * from auth1 where sl_no=?";
	static final String Read_by_usn_Query = "Select * from auth1 where email=? and password=?";
	
	static Connection con;
	static PreparedStatement ps;
	
	public static Con_DB display_by_id(int id)
	{
		Con_DB con1 = null;
		
		con = Con_DB.getConnection();
		try {
			ps = con.prepareStatement(Read_by_id);
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next())
			{
				con1 = new Con_DB();
				con1.setId(rs.getInt(1));
				con1.setName(rs.getString(2));
				con1.setEmail(rs.getString(3));
				con1.setPassword(rs.getString(4));
				con1.setUSN(rs.getString(5));
				con1.setBranch(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con1;
		
	}
	
	public static boolean delete(int id)
	{
		boolean b = false;
		con = Con_DB.getConnection();
		try {
			ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			ps.execute();
			b = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return b;
	}
	
	public static List<Con_DB> displayAll()
	{
		List<Con_DB> list = new ArrayList<>();
		Con_DB con1;
		
		con = Con_DB.getConnection();
		try {
			ps = con.prepareStatement(ReadQuery);
			ResultSet rs =  ps.executeQuery();
			
			while(rs.next())
			{
				con1 = new Con_DB();
				
				con1.setId(rs.getInt(1));
				con1.setName(rs.getString(2));
				con1.setEmail(rs.getString(3));
				con1.setPassword(rs.getString(4));
				con1.setUSN(rs.getString(5));
				con1.setBranch(rs.getString(6));
				
				list.add(con1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static boolean  update(Con_DB update)
	{
		con = Con_DB.getConnection();
//		Con_DB c = null;
		
		boolean b = false;
		try {
			ps = con.prepareStatement(UpdateQuery);
			ps.setString(1, update.getName());
			ps.setString(2, update.getEmail());
			ps.setString(3, update.getPassword());
			ps.setString(4, update.getUSN());
			ps.setString(5, update.getBranch());
			ps.setInt(6, update.getId());
			
			ps.execute();
			b= true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	public static Con_DB login_by_details(String email, String pass){
		
		con = Con_DB.getConnection();
		Con_DB con1 = null; 
		try
		{
		ps = con.prepareStatement(Read_by_usn_Query);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				con1 = new Con_DB();
				
				con1.setId(rs.getInt(1));
				con1.setName(rs.getString(2));
				con1.setEmail(rs.getString(3));
				con1.setPassword(rs.getString(4));
				con1.setUSN(rs.getString(5));
				con1.setBranch(rs.getString(6));
			}
		}
		catch(SQLException a)
		{
			a.printStackTrace();
		}
			
		return con1;
	
	}
	
	public static boolean insert(Con_DB insert)
	{
		boolean b = false;
		try
		{
		con = Con_DB.getConnection();
		ps = con.prepareStatement(InsertQuery);
		ps.setString(1, insert.getName());
		ps.setString(2, insert.getEmail());
		ps.setString(3, insert.getPassword());
		ps.setString(4, insert.getUSN());
		ps.setString(5, insert.getBranch());
		ps.execute();
		b=true;
		}
		catch(SQLException a)
		{
			a.printStackTrace();
		}
		return b;
	}
	


}
