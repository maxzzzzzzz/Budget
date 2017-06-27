package com.valsoft.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Asus on 18.06.2017.
 */
@Entity
@Table(name = "ACTION")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BUDGET_USER_ID")
    private BudgetUser budgetUser;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SubAction> subActions;



    @Size(min = 3, max = 50)
    @Column(name = "TYPE")
    private String type;

    public Action() {
    }

    public Set<SubAction> getSubActions() {
        return subActions;
    }

    public void setSubActions(Set<SubAction> subActions) {
        this.subActions = subActions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BudgetUser getBudgetUser() {
        return budgetUser;
    }

    public void setBudgetUser(BudgetUser budgetUser) {
        this.budgetUser = budgetUser;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", budgetUser="  +
                ", type='" + type + '\'' +
                '}';
    }

}
