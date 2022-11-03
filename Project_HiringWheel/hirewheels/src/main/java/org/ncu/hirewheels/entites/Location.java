package org.ncu.hirewheels.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "location")
public class Location {

	@Id
	@Column(name = "locationId", columnDefinition = "numeric(10)")
	private int locationId;

	@Column(name = "location_name", columnDefinition = "varchar(50)", nullable = false)
	private String location_name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "location")
	@Column(name = "booking")
	private List<Booking> booking;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "location")
	@JoinColumn(name = "vehicle_id", columnDefinition = "numeric(10)", nullable = false)
	private List<Vehicle> vehicle;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", columnDefinition = "numeric(10)", nullable = false)
	private City city;

}
