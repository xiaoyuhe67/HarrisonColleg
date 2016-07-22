package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HSTUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Hstudent.findAll", query="SELECT h FROM Hstudent h")
public class Hstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HSTUDENT_STUDENTID_GENERATOR", sequenceName="HSTUDENT_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HSTUDENT_STUDENTID_GENERATOR")
	private long studentid;

	private String entryyear;

	private String studentname;

	//bi-directional many-to-one association to Hmajor
	@ManyToOne
	@JoinColumn(name="MAJORID")
	private Hmajor hmajor;

	//bi-directional many-to-one association to Huser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Huser huser;

	//bi-directional many-to-one association to Hstudentclassbridge
	@OneToMany(mappedBy="hstudent")
	private List<Hstudentclassbridge> hstudentclassbridges;

	public Hstudent() {
	}

	public long getStudentid() {
		return this.studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getEntryyear() {
		return this.entryyear;
	}

	public void setEntryyear(String entryyear) {
		this.entryyear = entryyear;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public Hmajor getHmajor() {
		return this.hmajor;
	}

	public void setHmajor(Hmajor hmajor) {
		this.hmajor = hmajor;
	}

	public Huser getHuser() {
		return this.huser;
	}

	public void setHuser(Huser huser) {
		this.huser = huser;
	}

	public List<Hstudentclassbridge> getHstudentclassbridges() {
		return this.hstudentclassbridges;
	}

	public void setHstudentclassbridges(List<Hstudentclassbridge> hstudentclassbridges) {
		this.hstudentclassbridges = hstudentclassbridges;
	}

	public Hstudentclassbridge addHstudentclassbridge(Hstudentclassbridge hstudentclassbridge) {
		getHstudentclassbridges().add(hstudentclassbridge);
		hstudentclassbridge.setHstudent(this);

		return hstudentclassbridge;
	}

	public Hstudentclassbridge removeHstudentclassbridge(Hstudentclassbridge hstudentclassbridge) {
		getHstudentclassbridges().remove(hstudentclassbridge);
		hstudentclassbridge.setHstudent(null);

		return hstudentclassbridge;
	}

}