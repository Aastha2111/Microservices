package org.ncu.hirewheels.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;

	@Column(name = "vehicleModel", columnDefinition = "varchar(50)", nullable = false)
	private String v_model;

	@Column(name = "vehicleNumber", columnDefinition = "char(10)", nullable = false)
	private String v_number;

	@Column(name = "vehicleSubCategory")
	private int v_subCategoryId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "subcategory", nullable = false)
	private Vehicle_subcategory v_subcategory;

	@Column(name = "vehicleColor", columnDefinition = "varchar(50)", nullable = false)
	private int v_color;

	@Column(name = "vehicleFuelTypeId", nullable = false)
	private int v_fuelTypeId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fuel_type", columnDefinition = "numeric(10)", nullable = false)
	private Fuel_type fueltype;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "location", nullable = false)
	private Location location;

	@Column(name = "vehicleImageUrl", nullable = false)
	private String v_imgUrl;

	@Column(name = "vehicleAvailability", columnDefinition = "NUMERIC(1) default 1")
	private int availabilityStatus;

	@Column(name = "pricePerDay")
	private long v_pricePerDay;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "vehicle")
	@Column(name = "booking")
	private List<Booking> booking;

}