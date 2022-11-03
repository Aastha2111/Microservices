package org.ncu.hirewheels.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "City")
public class City {

	@Id
	@Column(name = "city", columnDefinition = "numeric(10)")
	private int cityId;

	@Column(name = "city_name", nullable = false)
	private String city_name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "city")
	private List<Location> location;
}