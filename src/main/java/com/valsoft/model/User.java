package com.valsoft.model;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Asus on 18.06.2017.
 */
@Entity
@Table(name = "USER1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER1_ID")
    private Long id;

    @Size(min = 3, max = 50)
    @Column(name = "NICK_NAME", nullable = false)
    private String nickName;

    @Size(min = 6, max = 20)
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Size(min = 3, max = 50)
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Size(min = 3, max = 50)
    @Column(name = "SECOND_NAME", nullable = false)
    private String secondName;

    @ManyToOne
    //@JoinTable(name = "ROLE")
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Budget> adminedBudgets;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<BudgetUser> budgetUsers;

    @Column(name = "IMAGE")
    private String image = "";

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Budget> getAdminedBudgets() {
        return adminedBudgets;
    }

    public void setAdminedBudgets(Set<Budget> adminedBudgets) {
        this.adminedBudgets = adminedBudgets;
    }

    public Set<BudgetUser> getBudgetUsers() {
        return budgetUsers;
    }

    public void setBudgetUsers(Set<BudgetUser> budgetUsers) {
        this.budgetUsers = budgetUsers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
             //   ", role=" + role +
                ", image='" + image + '\'' +
                '}';
    }
}
