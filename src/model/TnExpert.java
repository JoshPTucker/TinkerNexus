package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "TnExperts" database table.
 * 
 */
@Entity
@Table(name="\"TnExperts\"")
@NamedQuery(name="TnExpert.findAll", query="SELECT t FROM TnExpert t")
public class TnExpert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TNEXPERTS_EXPERTID_GENERATOR", sequenceName="TNEXPERTS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TNEXPERTS_EXPERTID_GENERATOR")
	private Long expertid;

	private Integer charge;

	private String expertisearea;

	private String industry;

	private Boolean verified;

	//bi-directional many-to-one association to TnUser
	@ManyToOne
	@JoinColumn(name="userid")
	private TnUser tnUser;

	public TnExpert() {
	}

	public Long getExpertid() {
		return this.expertid;
	}

	public void setExpertid(Long expertid) {
		this.expertid = expertid;
	}

	public Integer getCharge() {
		return this.charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

	public String getExpertisearea() {
		return this.expertisearea;
	}

	public void setExpertisearea(String expertisearea) {
		this.expertisearea = expertisearea;
	}

	public String getIndustry() {
		return this.industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Boolean getVerified() {
		return this.verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public TnUser getTnUser() {
		return this.tnUser;
	}

	public void setTnUser(TnUser tnUser) {
		this.tnUser = tnUser;
	}

}