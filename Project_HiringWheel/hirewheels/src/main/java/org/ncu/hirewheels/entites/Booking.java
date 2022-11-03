package org.ncu.hirewheels.entites;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookingId", columnDefinition = "numeric(10)", nullable = false)
	private int bookingId;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id", nullable = false, columnDefinition = "numeric(10)")
	private User users;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicleId", nullable = false, columnDefinition = "numeric(10)")
	private Vehicle vehicle;

	@Column(name = "PickUpDate", columnDefinition = "date", nullable = false)
	private Date pickUpDate;

	@Column(name = "DropOffDate", columnDefinition = "date", nullable = false)
	private Date dropOffDate;

	@Column(name = "BookingDate", columnDefinition = "date", nullable = false)
	private Date bookingDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "location", nullable = false)
	private Location location;

	@Column(name = "Amount", columnDefinition = "numeric(10,2)")
	private long amount;

}