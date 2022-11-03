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
@Table(name = "Role")
public class Role {

    @Id
    @Column(name = "role", columnDefinition = "numeric(10)")
    private Long roleId;

    @Column(name = "role", nullable = false, columnDefinition = "varchar(50)", unique = true)
    private String role_name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "role")
    private List<User> user;

}