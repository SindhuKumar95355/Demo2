package Entity_and_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Con_DB {
	
	 public Con_DB()
	{
		
	}
	
	static Connection con;
	
	public static Connection getConnection()
	{
		con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/authentication","root","sindhu8970");
		}
		catch(SQLException | ClassNotFoundException a)
		{
			a.printStackTrace();
		}
		return con;
	}
	
	private int id;
	private String name;
	private String Email;
	private String password;
	private String USN;
	private String branch;

	public Con_DB(String name, String email, String password, String uSN, String branch) {
		super();
		this.name = name;
		Email = email;
		this.password = password;
		USN = uSN;
		this.branch = branch;
	}


	public static Connection getCon() {
		return con;
	}


	public static void setCon(Connection con) {
		Con_DB.con = con;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUSN() {
		return USN;
	}


	public void setUSN(String uSN) {
		USN = uSN;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public Con_DB(String name, String email, String password, String branch) {
		super();
		this.name = name;
		Email = email;
		this.password = password;
		this.branch = branch;
	}

	
	public Con_DB(int id, String name, String email, String password, String uSN, String branch) {
		super();
		this.id = id;
		this.name = name;
		Email = email;
		this.password = password;
		USN = uSN;
		this.branch = branch;
	}

}
