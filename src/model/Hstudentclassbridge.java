package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HSTUDENTCLASSBRIDGE database table.
 * 
 */
@Entity
@NamedQuery(name="Hstudentclassbridge.findAll", query="SELECT h FROM Hstudentclassbridge h")
public class Hstudentclassbridge implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HSTUDENTCLASSBRIDGE_BRIDGEID_GENERATOR", sequenceName="HSTUDENTCLASSBRIDGE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HSTUDENTCLASSBRIDGE_BRIDGEID_GENERATOR")
	private long bridgeid;

	private long grade;

	//bi-directional many-to-one association to Hclass
	@ManyToOne
	@JoinColumn(name="CLASSID")
	private Hclass hclass;

	//bi-directional many-to-one association to Hstudent
	@ManyToOne
	@JoinColumn(name="STUDENTID")
	private Hstudent hstudent;

	public Hstudentclassbridge() {
	}

	public long getBridgeid() {
		return this.bridgeid;
	}

	public void setBridgeid(long bridgeid) {
		this.bridgeid = bridgeid;
	}

	public long getGrade() {
		return this.grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public Hclass getHclass() {
		return this.hclass;
	}

	public void setHclass(Hclass hclass) {
		this.hclass = hclass;
	}

	public Hstudent getHstudent() {
		return this.hstudent;
	}

	public void setHstudent(Hstudent hstudent) {
		this.hstudent = hstudent;
	}

}