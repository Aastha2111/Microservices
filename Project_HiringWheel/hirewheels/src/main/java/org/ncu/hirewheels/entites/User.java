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
//@Data    //@getter + @setter + @code + @requiredArgsConstructor
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that checkall
//non-transient fields. Will also generate setters for all non-final fields, as well as a constructor


@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", columnDefinition = "numeric(10)")
	private long id;

	@Column(name = "first_name", nullable = false, columnDefinition = "varchar(50)")
	private String firstName;

	@Column(name = "last_name", columnDefinition = "varchar(50)")
	private String lastName;

	@Column(name = "email", nullable = false, columnDefinition = "varchar(50)", unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "role")
	private Role role;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "users")
	private List<Booking> booking;

}
