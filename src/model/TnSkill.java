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
	private Integer skillid;

	private String skill;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TnUser tnUser;

	public TnSkill() {
	}

	public Integer getSkillid() {
		return this.skillid;
	}

	public void setSkillid(Integer skillid) {
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