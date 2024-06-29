package hu.infokristaly.forrasdatagenerator.entity;

// Generated 2012.09.26. 11:18:58 by Hibernate Tools 4.0.0

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;


/**
 * Company generated by hbm2java
 */
@Entity
@Table(name = "company", schema = "public")
public class Company implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2376060991535387263L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "companyid", unique = true, nullable = false)
    private Long id;
    @Column(name = "companyname", length = 128)
    private String companyName;
    @Column(name = "vcard")
    @Lob
    private String vCard;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "icon")
    private Icon icon;
	@Version
	private Long version;

    public Company() {
    }

    public Company(Long id) {
        this.id = id;
    }

    public Company(Long id, String companyname, String description, Icon icon) {
        this.id = id;
        this.companyName = companyname;
        this.description = description;
        this.icon = icon;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyname) {
        this.companyName = companyname;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVCard() {
        return this.vCard;
    }
    
    public void setVCard(String vCard) {
    	this.vCard = vCard;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((vCard == null) ? 0 : vCard.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (vCard == null) {
			if (other.vCard != null)
				return false;
		} else if (!vCard.equals(other.vCard))
			return false;
		return true;
	}
}
