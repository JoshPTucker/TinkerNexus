package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TnProjects" database table.
 * 
 */
@Entity
@Table(name="\"TnProjects\"")
@NamedQuery(name="TnProject.findAll", query="SELECT t FROM TnProject t")
public class TnProject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TNPROJECTS_PROJECTID_GENERATOR", sequenceName="TNPROJECTS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TNPROJECTS_PROJECTID_GENERATOR")
	private Long projectid;

	private Boolean collaboratorcheck;

	private Boolean commentsenabled;

	private Long organizationid;

	private Boolean privatecheck;

	private String projectname;

	private Integer rating;

	@Column(name="\"userid \"")
	private Long userid_;

	//bi-directional many-to-one association to TnCollaborator
	@OneToMany(mappedBy="tnProject")
	private List<TnCollaborator> tnCollaborators;

	//bi-directional many-to-one association to TnComment
	@OneToMany(mappedBy="tnProject")
	private List<TnComment> tnComments;

	//bi-directional many-to-one association to TnFollower
	@OneToMany(mappedBy="tnProject")
	private List<TnFollower> tnFollowers;

	//bi-directional many-to-one association to TnProjectAsset
	@OneToMany(mappedBy="tnProject")
	private List<TnProjectAsset> tnProjectAssets;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumns({
		})
	private TnUser tnUser;

	public TnProject() {
	}

	public Long getProjectid() {
		return this.projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Boolean getCollaboratorcheck() {
		return this.collaboratorcheck;
	}

	public void setCollaboratorcheck(Boolean collaboratorcheck) {
		this.collaboratorcheck = collaboratorcheck;
	}

	public Boolean getCommentsenabled() {
		return this.commentsenabled;
	}

	public void setCommentsenabled(Boolean commentsenabled) {
		this.commentsenabled = commentsenabled;
	}

	public Long getOrganizationid() {
		return this.organizationid;
	}

	public void setOrganizationid(Long organizationid) {
		this.organizationid = organizationid;
	}

	public Boolean getPrivatecheck() {
		return this.privatecheck;
	}

	public void setPrivatecheck(Boolean privatecheck) {
		this.privatecheck = privatecheck;
	}

	public String getProjectname() {
		return this.projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Long getUserid_() {
		return this.userid_;
	}

	public void setUserid_(Long userid_) {
		this.userid_ = userid_;
	}

	public List<TnCollaborator> getTnCollaborators() {
		return this.tnCollaborators;
	}

	public void setTnCollaborators(List<TnCollaborator> tnCollaborators) {
		this.tnCollaborators = tnCollaborators;
	}

	public TnCollaborator addTnCollaborator(TnCollaborator tnCollaborator) {
		getTnCollaborators().add(tnCollaborator);
		tnCollaborator.setTnProject(this);

		return tnCollaborator;
	}

	public TnCollaborator removeTnCollaborator(TnCollaborator tnCollaborator) {
		getTnCollaborators().remove(tnCollaborator);
		tnCollaborator.setTnProject(null);

		return tnCollaborator;
	}

	public List<TnComment> getTnComments() {
		return this.tnComments;
	}

	public void setTnComments(List<TnComment> tnComments) {
		this.tnComments = tnComments;
	}

	public TnComment addTnComment(TnComment tnComment) {
		getTnComments().add(tnComment);
		tnComment.setTnProject(this);

		return tnComment;
	}

	public TnComment removeTnComment(TnComment tnComment) {
		getTnComments().remove(tnComment);
		tnComment.setTnProject(null);

		return tnComment;
	}

	public List<TnFollower> getTnFollowers() {
		return this.tnFollowers;
	}

	public void setTnFollowers(List<TnFollower> tnFollowers) {
		this.tnFollowers = tnFollowers;
	}

	public TnFollower addTnFollower(TnFollower tnFollower) {
		getTnFollowers().add(tnFollower);
		tnFollower.setTnProject(this);

		return tnFollower;
	}

	public TnFollower removeTnFollower(TnFollower tnFollower) {
		getTnFollowers().remove(tnFollower);
		tnFollower.setTnProject(null);

		return tnFollower;
	}

	public List<TnProjectAsset> getTnProjectAssets() {
		return this.tnProjectAssets;
	}

	public void setTnProjectAssets(List<TnProjectAsset> tnProjectAssets) {
		this.tnProjectAssets = tnProjectAssets;
	}

	public TnProjectAsset addTnProjectAsset(TnProjectAsset tnProjectAsset) {
		getTnProjectAssets().add(tnProjectAsset);
		tnProjectAsset.setTnProject(this);

		return tnProjectAsset;
	}

	public TnProjectAsset removeTnProjectAsset(TnProjectAsset tnProjectAsset) {
		getTnProjectAssets().remove(tnProjectAsset);
		tnProjectAsset.setTnProject(null);

		return tnProjectAsset;
	}

	public TnUser getTnUser() {
		return this.tnUser;
	}

	public void setTnUser(TnUser tnUser) {
		this.tnUser = tnUser;
	}

}