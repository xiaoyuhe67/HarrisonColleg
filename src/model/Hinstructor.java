package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HINSTRUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Hinstructor.findAll", query="SELECT h FROM Hinstructor h")
public class Hinstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HINSTRUCTOR_INSTRUCTORID_GENERATOR", sequenceName="HINSTRUCTOR_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HINSTRUCTOR_INSTRUCTORID_GENERATOR")
	private long instructorid;

	private String instructorname;

	private String officenumber;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hinstructor")
	private List<Hclass> hclasses;

	//bi-directional many-to-one association to Hdepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENTID")
	private Hdepartment hdepartment;

	//bi-directional many-to-one association to Huser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Huser huser;

	public Hinstructor() {
	}

	public long getInstructorid() {
		return this.instructorid;
	}

	public void setInstructorid(long instructorid) {
		this.instructorid = instructorid;
	}

	public String getInstructorname() {
		return this.instructorname;
	}

	public void setInstructorname(String instructorname) {
		this.instructorname = instructorname;
	}

	public String getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(String officenumber) {
		this.officenumber = officenumber;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHinstructor(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHinstructor(null);

		return hclass;
	}

	public Hdepartment getHdepartment() {
		return this.hdepartment;
	}

	public void setHdepartment(Hdepartment hdepartment) {
		this.hdepartment = hdepartment;
	}

	public Huser getHuser() {
		return this.huser;
	}

	public void setHuser(Huser huser) {
		this.huser = huser;
	}

}