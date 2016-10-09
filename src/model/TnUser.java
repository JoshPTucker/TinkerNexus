package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "TnUsers" database table.
 * 
 */
@Entity
@Table(name="\"TnUsers\"")
@NamedQuery(name="TnUser.findAll", query="SELECT t FROM TnUser t")
public class TnUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer userid;

	private String address;

	private String expertauth;

	private String facebook;

	private String gravatarurl;

	private String linkedin;

	private String passwordhsd;

	private String useremail;

	private String username;

	private Integer verified;

	private Integer zipcode;

	//bi-directional many-to-one association to TnCollaborator
	@OneToMany(mappedBy="tnUser")
	private List<TnCollaborator> tnCollaborators;

	//bi-directional many-to-one association to TnComment
	@OneToMany(mappedBy="tnUser")
	private List<TnComment> tnComments;

	//bi-directional many-to-one association to TnExpert
	@OneToMany(mappedBy="tnUser")
	private List<TnExpert> tnExperts;

	//bi-directional many-to-one association to TnFollower
	@OneToMany(mappedBy="tnUser")
	private List<TnFollower> tnFollowers;

	//bi-directional many-to-one association to TnProjectAsset
	@OneToMany(mappedBy="tnUser")
	private List<TnProjectAsset> tnProjectAssets;

	//bi-directional many-to-one association to TnProject
	@OneToMany(mappedBy="tnUser")
	private List<TnProject> tnProjects;

	//bi-directional many-to-one association to TnSkill
	@OneToMany(mappedBy="tnUser")
	private List<TnSkill> tnSkills;

	public TnUser() {
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExpertauth() {
		return this.expertauth;
	}

	public void setExpertauth(String expertauth) {
		this.expertauth = expertauth;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getGravatarurl() {
		return this.gravatarurl;
	}

	public void setGravatarurl(String gravatarurl) {
		this.gravatarurl = gravatarurl;
	}

	public String getLinkedin() {
		return this.linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getPasswordhsd() {
		return this.passwordhsd;
	}

	public void setPasswordhsd(String passwordhsd) {
		this.passwordhsd = passwordhsd;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getVerified() {
		return this.verified;
	}

	public void setVerified(Integer verified) {
		this.verified = verified;
	}

	public Integer getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public List<TnCollaborator> getTnCollaborators() {
		return this.tnCollaborators;
	}

	public void setTnCollaborators(List<TnCollaborator> tnCollaborators) {
		this.tnCollaborators = tnCollaborators;
	}

	public TnCollaborator addTnCollaborator(TnCollaborator tnCollaborator) {
		getTnCollaborators().add(tnCollaborator);
		tnCollaborator.setTnUser(this);

		return tnCollaborator;
	}

	public TnCollaborator removeTnCollaborator(TnCollaborator tnCollaborator) {
		getTnCollaborators().remove(tnCollaborator);
		tnCollaborator.setTnUser(null);

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
		tnComment.setTnUser(this);

		return tnComment;
	}

	public TnComment removeTnComment(TnComment tnComment) {
		getTnComments().remove(tnComment);
		tnComment.setTnUser(null);

		return tnComment;
	}

	public List<TnExpert> getTnExperts() {
		return this.tnExperts;
	}

	public void setTnExperts(List<TnExpert> tnExperts) {
		this.tnExperts = tnExperts;
	}

	public TnExpert addTnExpert(TnExpert tnExpert) {
		getTnExperts().add(tnExpert);
		tnExpert.setTnUser(this);

		return tnExpert;
	}

	public TnExpert removeTnExpert(TnExpert tnExpert) {
		getTnExperts().remove(tnExpert);
		tnExpert.setTnUser(null);

		return tnExpert;
	}

	public List<TnFollower> getTnFollowers() {
		return this.tnFollowers;
	}

	public void setTnFollowers(List<TnFollower> tnFollowers) {
		this.tnFollowers = tnFollowers;
	}

	public TnFollower addTnFollower(TnFollower tnFollower) {
		getTnFollowers().add(tnFollower);
		tnFollower.setTnUser(this);

		return tnFollower;
	}

	public TnFollower removeTnFollower(TnFollower tnFollower) {
		getTnFollowers().remove(tnFollower);
		tnFollower.setTnUser(null);

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
		tnProjectAsset.setTnUser(this);

		return tnProjectAsset;
	}

	public TnProjectAsset removeTnProjectAsset(TnProjectAsset tnProjectAsset) {
		getTnProjectAssets().remove(tnProjectAsset);
		tnProjectAsset.setTnUser(null);

		return tnProjectAsset;
	}

	public List<TnProject> getTnProjects() {
		return this.tnProjects;
	}

	public void setTnProjects(List<TnProject> tnProjects) {
		this.tnProjects = tnProjects;
	}

	public TnProject addTnProject(TnProject tnProject) {
		getTnProjects().add(tnProject);
		tnProject.setTnUser(this);

		return tnProject;
	}

	public TnProject removeTnProject(TnProject tnProject) {
		getTnProjects().remove(tnProject);
		tnProject.setTnUser(null);

		return tnProject;
	}

	public List<TnSkill> getTnSkills() {
		return this.tnSkills;
	}

	public void setTnSkills(List<TnSkill> tnSkills) {
		this.tnSkills = tnSkills;
	}

	public TnSkill addTnSkill(TnSkill tnSkill) {
		getTnSkills().add(tnSkill);
		tnSkill.setTnUser(this);

		return tnSkill;
	}

	public TnSkill removeTnSkill(TnSkill tnSkill) {
		getTnSkills().remove(tnSkill);
		tnSkill.setTnUser(null);

		return tnSkill;
	}

}