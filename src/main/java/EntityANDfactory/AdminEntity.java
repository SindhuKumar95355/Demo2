package EntityANDfactory;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AdminTable")
public class AdminEntity {
	
	@Column(name = "Admin_ID")
	@Id
	private int Aid;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date AddedDate;
	
	public AdminEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminEntity( String name,String email, String password) {
		super();
		Aid = new Random().nextInt(50);
		this.name = name;
		this.email = email;
		this.password = password;
		AddedDate = new Date();
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getAid() {
		return Aid;
	}

	public void setAid(int aid) {
		Aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAddedDate() {
		return AddedDate;
	}

	public void setAddedDate(Date addedDate) {
		AddedDate = addedDate;
	}
	
	

}
