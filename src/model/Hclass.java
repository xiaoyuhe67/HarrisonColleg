package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCLASS database table.
 * 
 */
@Entity
@NamedQuery(name="Hclass.findAll", query="SELECT h FROM Hclass h")
public class Hclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCLASS_CLASSID_GENERATOR", sequenceName="HCLASS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCLASS_CLASSID_GENERATOR")
	private long classid;

	private String classtime;

	private String crnnumber;

	@Column(name="\"SECTION\"")
	private long section;

	private long studentcount;

	private long weekday;

	//bi-directional many-to-one association to Hclassroom
	@ManyToOne
	@JoinColumn(name="CLASSROOMID")
	private Hclassroom hclassroom;

	//bi-directional many-to-one association to Hcourse
	@ManyToOne
	@JoinColumn(name="COURSEID")
	private Hcourse hcourse;

	//bi-directional many-to-one association to Hinstructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private Hinstructor hinstructor;

	//bi-directional many-to-one association to Hstudentclassbridge
	@OneToMany(mappedBy="hclass")
	private List<Hstudentclassbridge> hstudentclassbridges;

	public Hclass() {
	}

	public long getClassid() {
		return this.classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public String getClasstime() {
		return this.classtime;
	}

	public void setClasstime(String classtime) {
		this.classtime = classtime;
	}

	public String getCrnnumber() {
		return this.crnnumber;
	}

	public void setCrnnumber(String crnnumber) {
		this.crnnumber = crnnumber;
	}

	public long getSection() {
		return this.section;
	}

	public void setSection(long section) {
		this.section = section;
	}

	public long getStudentcount() {
		return this.studentcount;
	}

	public void setStudentcount(long studentcount) {
		this.studentcount = studentcount;
	}

	public long getWeekday() {
		return this.weekday;
	}

	public void setWeekday(long weekday) {
		this.weekday = weekday;
	}

	public Hclassroom getHclassroom() {
		return this.hclassroom;
	}

	public void setHclassroom(Hclassroom hclassroom) {
		this.hclassroom = hclassroom;
	}

	public Hcourse getHcourse() {
		return this.hcourse;
	}

	public void setHcourse(Hcourse hcourse) {
		this.hcourse = hcourse;
	}

	public Hinstructor getHinstructor() {
		return this.hinstructor;
	}

	public void setHinstructor(Hinstructor hinstructor) {
		this.hinstructor = hinstructor;
	}

	public List<Hstudentclassbridge> getHstudentclassbridges() {
		return this.hstudentclassbridges;
	}

	public void setHstudentclassbridges(List<Hstudentclassbridge> hstudentclassbridges) {
		this.hstudentclassbridges = hstudentclassbridges;
	}

	public Hstudentclassbridge addHstudentclassbridge(Hstudentclassbridge hstudentclassbridge) {
		getHstudentclassbridges().add(hstudentclassbridge);
		hstudentclassbridge.setHclass(this);

		return hstudentclassbridge;
	}

	public Hstudentclassbridge removeHstudentclassbridge(Hstudentclassbridge hstudentclassbridge) {
		getHstudentclassbridges().remove(hstudentclassbridge);
		hstudentclassbridge.setHclass(null);

		return hstudentclassbridge;
	}

}