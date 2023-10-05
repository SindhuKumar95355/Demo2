package EntityANDfactory;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CRUD")
public class ENT1 {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SL_NO;
	@Id
	private int ID;
	
	private String Name;
	
	private String Role;
	
	private String City;
	
	@Temporal(value = TemporalType.DATE)
	private Date JoinedDate;
	
	private String Work_Status;

	
	public ENT1() {
		super();
	}

	public ENT1( String name, String role, String city, String work_Status) {
		super();
		
		ID = new Random().nextInt(1000);
		Name = name;
		Role = role;
		City = city;
		JoinedDate = new Date();
		Work_Status = work_Status;
	}

	public int getSL_NO() {
		return SL_NO;
	}


	public int getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public Date getJoinedDate() {
		return JoinedDate;
	}

	public String getWork_Status() {
		return Work_Status;
	}

	public void setWork_Status(String work_Status) {
		Work_Status = work_Status;
	}

	@Override
	public String toString() {
		return "ENT1 [SL_NO=" + SL_NO + ", ID=" + ID + ", Name=" + Name + ", Role=" + Role + ", City=" + City
				+ ", JoinedDate=" + JoinedDate + ", Work_Status=" + Work_Status + "]";
	}
	
	
	
	
	

}
