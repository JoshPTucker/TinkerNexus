package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "TnComments" database table.
 * 
 */
@Entity
@Table(name="\"TnComments\"")
@NamedQuery(name="TnComment.findAll", query="SELECT t FROM TnComment t")
public class TnComment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer commentid;

	private String commenttext;

	//bi-directional many-to-one association to TnProject
	@ManyToOne
	@JoinColumn(name="projectid")
	private TnProject tnProject;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TnUser tnUser;

	public TnComment() {
	}

	public Integer getCommentid() {
		return this.commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public String getCommenttext() {
		return this.commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
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