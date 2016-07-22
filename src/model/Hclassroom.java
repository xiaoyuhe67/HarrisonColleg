package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCLASSROOM database table.
 * 
 */
@Entity
@NamedQuery(name="Hclassroom.findAll", query="SELECT h FROM Hclassroom h")
public class Hclassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCLASSROOM_CLASSROOMID_GENERATOR", sequenceName="HCLASSROOM_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCLASSROOM_CLASSROOMID_GENERATOR")
	private long classroomid;

	private String buildingname;

	private long maxcapacity;

	private String roomnumber;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hclassroom")
	private List<Hclass> hclasses;

	public Hclassroom() {
	}

	public long getClassroomid() {
		return this.classroomid;
	}

	public void setClassroomid(long classroomid) {
		this.classroomid = classroomid;
	}

	public String getBuildingname() {
		return this.buildingname;
	}

	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}

	public long getMaxcapacity() {
		return this.maxcapacity;
	}

	public void setMaxcapacity(long maxcapacity) {
		this.maxcapacity = maxcapacity;
	}

	public String getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHclassroom(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHclassroom(null);

		return hclass;
	}

}