package com.hibernate.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "menu")
public class Menu {
    private Integer id;
    private String name;
    private Set<Role> role=new HashSet<>();

@ManyToMany(mappedBy = "menu")

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
    @Id
    @GeneratedValue
    @Column(name = "m_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
@Column(name ="m_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
