package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "user")
public class User {
    private Integer id;
    private String account;
    private Set<Role> role=new HashSet<>();
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "u_id")},inverseJoinColumns = {@JoinColumn(name = "r_id")})
    public Set<Role> getRole() {
    return role;
}

    public void setRole(Set<Role> role) {
        this.role = role;
    }
@Id
@Column(name = "u_id")
@GeneratedValue(generator = "_native")
@GenericGenerator(name = "_native",strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "u_name")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


}
