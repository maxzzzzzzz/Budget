package com.valsoft.model;

import javax.persistence.*;
import javax.xml.ws.Service;
import java.util.Set;

/**
 * Created by Asus on 18.06.2017.
 */
@Entity
@Table(name = "BUDGET_USER")
public class BudgetUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUDGET_USER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BUDGET_ID")
    private Budget budget;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Action> actions;

    public BudgetUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "BudgetUser{" +
                "id=" + id +
              //  ", budget=" + budget +
             //   ", user=" + user +
                '}';
    }
}
