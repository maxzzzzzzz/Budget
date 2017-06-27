package com.valsoft.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Asus on 18.06.2017.
 */
@Entity
@Table(name = "BUDGET")
public class Budget {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUDGET_ID")
    private Long id;

    @Size(min=3, max=50)
    @Column(name = "NAME", nullable = false)
    private String name;

    @Size(min=3, max=150)
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public Budget(String name, String description, LocalDate creationDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }
    public Budget(Long id){
        this.id=id;
    }
    public Budget(Long id,String name, String description, LocalDate creationDate) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User admin;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<BudgetUser> budgetUsers;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "CREATION_DATE", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Set<BudgetUser> getBudgetUsers() {
        return budgetUsers;
    }

    public void setBudgetUsers(Set<BudgetUser> budgetUsers) {
        this.budgetUsers = budgetUsers;
    }
}
