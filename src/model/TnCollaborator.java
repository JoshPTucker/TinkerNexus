package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "TnCollaborators" database table.
 * 
 */
@Entity
@Table(name="\"TnCollaborators\"")
@NamedQuery(name="TnCollaborator.findAll", query="SELECT t FROM TnCollaborator t")
public class TnCollaborator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer collaboratorid;

	private Boolean candownload;

	private Boolean canupload;

	//bi-directional many-to-one association to TnProject
	@ManyToOne
	@JoinColumn(name="projectid")
	private TnProject tnProject;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TnUser tnUser;

	public TnCollaborator() {
	}

	public Integer getCollaboratorid() {
		return this.collaboratorid;
	}

	public void setCollaboratorid(Integer collaboratorid) {
		this.collaboratorid = collaboratorid;
	}

	public Boolean getCandownload() {
		return this.candownload;
	}

	public void setCandownload(Boolean candownload) {
		this.candownload = candownload;
	}

	public Boolean getCanupload() {
		return this.canupload;
	}

	public void setCanupload(Boolean canupload) {
		this.canupload = canupload;
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