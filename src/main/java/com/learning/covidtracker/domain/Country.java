package com.learning.covidtracker.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String slug;
	private String iso2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Country other = (Country) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Country() {
	}

	public Country(String name, String slug, String iso2) {
		super();
		this.name = name;
		this.slug = slug;
		this.iso2 = iso2;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", slug=" + slug + ", iso2=" + iso2 + "]";
	}

}
