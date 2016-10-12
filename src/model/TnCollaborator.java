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
	@SequenceGenerator(name="TNCOLLABORATORS_COLLABORATORID_GENERATOR", sequenceName="TNCOLLABORATORS_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TNCOLLABORATORS_COLLABORATORID_GENERATOR")
	private Long collaboratorid;

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

	public Long getCollaboratorid() {
		return this.collaboratorid;
	}

	public void setCollaboratorid(Long collaboratorid) {
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