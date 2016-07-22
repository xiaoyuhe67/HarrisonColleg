package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HMAJOR database table.
 * 
 */
@Entity
@NamedQuery(name="Hmajor.findAll", query="SELECT h FROM Hmajor h")
public class Hmajor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HMAJOR_MAJORID_GENERATOR", sequenceName="HMAJOR_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HMAJOR_MAJORID_GENERATOR")
	private long majorid;

	private String majorname;

	//bi-directional many-to-one association to Hdepartment
	@ManyToOne
	@JoinColumn(name="DEPARTMENTID")
	private Hdepartment hdepartment;

	//bi-directional many-to-one association to Hstudent
	@OneToMany(mappedBy="hmajor")
	private List<Hstudent> hstudents;

	public Hmajor() {
	}

	public long getMajorid() {
		return this.majorid;
	}

	public void setMajorid(long majorid) {
		this.majorid = majorid;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public Hdepartment getHdepartment() {
		return this.hdepartment;
	}

	public void setHdepartment(Hdepartment hdepartment) {
		this.hdepartment = hdepartment;
	}

	public List<Hstudent> getHstudents() {
		return this.hstudents;
	}

	public void setHstudents(List<Hstudent> hstudents) {
		this.hstudents = hstudents;
	}

	public Hstudent addHstudent(Hstudent hstudent) {
		getHstudents().add(hstudent);
		hstudent.setHmajor(this);

		return hstudent;
	}

	public Hstudent removeHstudent(Hstudent hstudent) {
		getHstudents().remove(hstudent);
		hstudent.setHmajor(null);

		return hstudent;
	}

}