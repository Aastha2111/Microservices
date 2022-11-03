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
@Table(name = "vehicle_category")
public class Vehicle_category {
	@Id
	@Column(name = "category_id", columnDefinition = "numeric(10)", nullable = false)
	private long id;

	@Column(name = "category", columnDefinition = "varchar(50)", nullable = false, unique = true)
	private String category;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "v_category")
	private List<Vehicle_subcategory> v_subcategory;

}