package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "TnProjectAssets" database table.
 * 
 */
@Entity
@Table(name="\"TnProjectAssets\"")
@NamedQuery(name="TnProjectAsset.findAll", query="SELECT t FROM TnProjectAsset t")
public class TnProjectAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer assetid;

	private String asset;

	@Temporal(TemporalType.DATE)
	private Date uploadate;

	//bi-directional many-to-one association to TnProject
	@ManyToOne
	@JoinColumn(name="projectid")
	private TnProject tnProject;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TnUser tnUser;

	public TnProjectAsset() {
	}

	public Integer getAssetid() {
		return this.assetid;
	}

	public void setAssetid(Integer assetid) {
		this.assetid = assetid;
	}

	public String getAsset() {
		return this.asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public Date getUploadate() {
		return this.uploadate;
	}

	public void setUploadate(Date uploadate) {
		this.uploadate = uploadate;
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