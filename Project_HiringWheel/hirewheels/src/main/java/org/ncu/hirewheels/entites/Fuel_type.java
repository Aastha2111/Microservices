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
@Table(name = "fuel_type")
public class Fuel_type {

	@Id
	@Column(name = "fuelId", columnDefinition = "numeric(10)")
	private int fuelId;

	@Column(name = "fuel_type", columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String fuel_type;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "fueltype")
	private List<Vehicle> vehicle;

}