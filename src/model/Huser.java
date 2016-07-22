package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Huser.findAll", query="SELECT h FROM Huser h")
public class Huser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HUSER_USERID_GENERATOR", sequenceName="HUSER_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HUSER_USERID_GENERATOR")
	private long userid;

	private String pwd;

	private String useremail;

	private String username;

	private long userrole;

	//bi-directional many-to-one association to Hinstructor
	@OneToMany(mappedBy="huser")
	private List<Hinstructor> hinstructors;

	//bi-directional many-to-one association to Hstudent
	@OneToMany(mappedBy="huser")
	private List<Hstudent> hstudents;

	public Huser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserrole() {
		return this.userrole;
	}

	public void setUserrole(long userrole) {
		this.userrole = userrole;
	}

	public List<Hinstructor> getHinstructors() {
		return this.hinstructors;
	}

	public void setHinstructors(List<Hinstructor> hinstructors) {
		this.hinstructors = hinstructors;
	}

	public Hinstructor addHinstructor(Hinstructor hinstructor) {
		getHinstructors().add(hinstructor);
		hinstructor.setHuser(this);

		return hinstructor;
	}

	public Hinstructor removeHinstructor(Hinstructor hinstructor) {
		getHinstructors().remove(hinstructor);
		hinstructor.setHuser(null);

		return hinstructor;
	}

	public List<Hstudent> getHstudents() {
		return this.hstudents;
	}

	public void setHstudents(List<Hstudent> hstudents) {
		this.hstudents = hstudents;
	}

	public Hstudent addHstudent(Hstudent hstudent) {
		getHstudents().add(hstudent);
		hstudent.setHuser(this);

		return hstudent;
	}

	public Hstudent removeHstudent(Hstudent hstudent) {
		getHstudents().remove(hstudent);
		hstudent.setHuser(null);

		return hstudent;
	}

}