package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "TnFollowers" database table.
 * 
 */
@Entity
@Table(name="\"TnFollowers\"")
@NamedQuery(name="TnFollower.findAll", query="SELECT t FROM TnFollower t")
public class TnFollower implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TNFOLLOWERS_FOLLOWERID_GENERATOR", sequenceName="TNFOLLOWERS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TNFOLLOWERS_FOLLOWERID_GENERATOR")
	private Integer followerid;

	//bi-directional many-to-one association to TnProject
	@ManyToOne
	@JoinColumn(name="projectid")
	private TnProject tnProject;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TnUser tnUser;

	public TnFollower() {
	}

	public Integer getFollowerid() {
		return this.followerid;
	}

	public void setFollowerid(Integer followerid) {
		this.followerid = followerid;
	}

	public TnProject getTnProject() {
		return this.tnProject;
	}

	public void setTnProject(TnProject tnProject) {
		this.tnProject = tnProject;
	}

	public TnUser getTnUser() {
		return this.tnUser;
	}

	public void setTnUser(TnUser tnUser) {
		this.tnUser = tnUser;
	}

}