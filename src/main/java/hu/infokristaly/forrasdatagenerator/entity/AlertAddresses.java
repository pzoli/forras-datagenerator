package hu.infokristaly.forrasdatagenerator.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
public class AlertAddresses {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic
	private Long id;
	@Basic
	private String addresseName;
	@Basic
	private String phone;
	@Basic
	private Boolean enabled;
	@Version
	private Long version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddresseName() {
		return addresseName;
	}
	public void setAddresseName(String name) {
		this.addresseName = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
		
}
