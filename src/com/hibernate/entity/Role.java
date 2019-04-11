package com.hibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "role")
public class Role {
    private Integer id;
    private String name;

    private Set<User> user=new HashSet<>();
    @ManyToMany(mappedBy = "role")
    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }


    private Set<Menu> menu=new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_menu",joinColumns ={@JoinColumn(name = "r_id")},inverseJoinColumns = {@JoinColumn(name = "m_id")})
    public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }

    @Id
    @Column(name = "m_id")
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native",strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "r_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
