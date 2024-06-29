package hu.infokristaly.forrasdatagenerator.entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.CascadeType;

// Generated 2012.09.26. 11:18:58 by Hibernate Tools 4.0.0

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

/**
 * Organizationunit generated by hbm2java
 */
@Entity
@Table(name = "organizationunit", schema = "public")
public class Organizationunit implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -576319707322945129L;
    
    private Long id;
    private Company company;
    private String organizationunitName;
    private String shortname;
    private String description;
    private Boolean registerunit;
    private Boolean onlyregister;
    private Icon icon;
    private List<Addresses> addresses;
	@Version
	private Long version;

    public Organizationunit() {
    	this.addresses = new LinkedList<Addresses>();
    }

    public Organizationunit(Long id) {
        this.id = id;
    }

    public Organizationunit(Long id, Company company, String organizationunitName, String shortname, String description, Boolean registerunit, Boolean onlyregister, Icon icon) {
        this.id = id;
        this.company = company;
        this.organizationunitName = organizationunitName;
        this.shortname = shortname;
        this.description = description;
        this.registerunit = registerunit;
        this.onlyregister = onlyregister;
        this.icon = icon;
        this.addresses = new LinkedList<Addresses>();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "organizationunitid", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "company")
    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Column(name = "organizationunit", length = 128)
    public String getOrganizationunitName() {
        return this.organizationunitName;
    }

    public void setOrganizationunitName(String organizationunit) {
        this.organizationunitName = organizationunit;
    }

    @Column(name = "shortname", length = 8)
    public String getShortname() {
        return this.shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "registerunit")
    public Boolean getRegisterunit() {
        return this.registerunit;
    }

    public void setRegisterunit(Boolean registerunit) {
        this.registerunit = registerunit;
    }

    @Column(name = "onlyregister")
    public Boolean getOnlyregister() {
        return this.onlyregister;
    }

    public void setOnlyregister(Boolean onlyregister) {
        this.onlyregister = onlyregister;
    }

    @ManyToOne
    @JoinColumn(name = "icon")
    public Icon getIcon() {
        return this.icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "organization_address", joinColumns = { @JoinColumn(name = "organizationid", referencedColumnName = "organizationunitid") }, inverseJoinColumns = { @JoinColumn(name = "addressid", referencedColumnName = "id") })
	public List<Addresses> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Addresses> addresses) {
		this.addresses = addresses;
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
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((onlyregister == null) ? 0 : onlyregister.hashCode());
		result = prime * result + ((organizationunitName == null) ? 0 : organizationunitName.hashCode());
		result = prime * result + ((registerunit == null) ? 0 : registerunit.hashCode());
		result = prime * result + ((shortname == null) ? 0 : shortname.hashCode());
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
		Organizationunit other = (Organizationunit) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
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
		if (onlyregister == null) {
			if (other.onlyregister != null)
				return false;
		} else if (!onlyregister.equals(other.onlyregister))
			return false;
		if (organizationunitName == null) {
			if (other.organizationunitName != null)
				return false;
		} else if (!organizationunitName.equals(other.organizationunitName))
			return false;
		if (registerunit == null) {
			if (other.registerunit != null)
				return false;
		} else if (!registerunit.equals(other.registerunit))
			return false;
		if (shortname == null) {
			if (other.shortname != null)
				return false;
		} else if (!shortname.equals(other.shortname))
			return false;
		return true;
	}    
}