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
@Table(name = "vehicle_subcategory")
public class Vehicle_subcategory {
	@Id
	@Column(name = "subcategory_id", columnDefinition = "numeric(10)")
	private int subcategory_id;

	@Column(name = "vehicle_subcategory_name", columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String vehicle_subcategory;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "v_subcategory")
	private List<Vehicle> vehicle;

	@Column(name = "price_per_day", columnDefinition = "numeric(10,2)", nullable = false)
	private int price_per_day;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "category", columnDefinition = "numeric(10)", nullable = false)
	private Vehicle_category v_category;
}