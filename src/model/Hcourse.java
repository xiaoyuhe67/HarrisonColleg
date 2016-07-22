package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCOURSE database table.
 * 
 */
@Entity
@NamedQuery(name="Hcourse.findAll", query="SELECT h FROM Hcourse h")
public class Hcourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCOURSE_COURSEID_GENERATOR", sequenceName="HCOURSE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCOURSE_COURSEID_GENERATOR")
	private long courseid;

	private String coursedes;

	private String coursename;

	private long credits;

	private String subjectcode;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hcourse")
	private List<Hclass> hclasses;

	//bi-directional many-to-one association to Hdepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENTID")
	private Hdepartment hdepartment;

	public Hcourse() {
	}

	public long getCourseid() {
		return this.courseid;
	}

	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}

	public String getCoursedes() {
		return this.coursedes;
	}

	public void setCoursedes(String coursedes) {
		this.coursedes = coursedes;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public long getCredits() {
		return this.credits;
	}

	public void setCredits(long credits) {
		this.credits = credits;
	}

	public String getSubjectcode() {
		return this.subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHcourse(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHcourse(null);

		return hclass;
	}

	public Hdepartment getHdepartment() {
		return this.hdepartment;
	}

	public void setHdepartment(Hdepartment hdepartment) {
		this.hdepartment = hdepartment;
	}

}