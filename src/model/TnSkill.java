package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "TnSkills" database table.
 * 
 */
@Entity
@Table(name="\"TnSkills\"")
@NamedQuery(name="TnSkill.findAll", query="SELECT t FROM TnSkill t")
public class TnSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TNSKILLS_SKILLID_GENERATOR", sequenceName="TNSKILLS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TNSKILLS_SKILLID_GENERATOR")
	private Long skillid;

	private String skill;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TnUser tnUser;

	public TnSkill() {
	}

	public Long getSkillid() {
		return this.skillid;
	}

	public void setSkillid(Long skillid) {
		this.skillid = skillid;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public TnUser getTnUser() {
		return this.tnUser;
	}

	public void setTnUser(TnUser tnUser) {
		this.tnUser = tnUser;
	}

}