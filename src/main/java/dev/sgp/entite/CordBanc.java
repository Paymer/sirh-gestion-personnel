package dev.sgp.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Banc")
public class CordBanc {

	@Id
	@Column (name = "Matricule")
	private int id;
	
	@Column (name = "BIC")
	private String BIC;
	@Column (name = "IBAN")
	private String IBAN;
	@Column (name = "VAN")
	private String VAN;
	
	
	
	
	
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		BIC = bIC;
	}
	public String getIBAN() {
		return IBAN;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVAN() {
		return VAN;
	}
	public void setVAN(String vAN) {
		VAN = vAN;
	}
	
	
	
	
	
	
}
