package com.tw.apistackbase.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "crowndetail")
public class CrownDetail {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String objectiveCase;

    private String subjectiveCase;

    public CrownDetail(@NotNull String objectiveCase, String subjectiveCase) {
        this.objectiveCase = objectiveCase;
        this.subjectiveCase = subjectiveCase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectiveCase() {
        return objectiveCase;
    }

    public void setObjectiveCase(String objectiveCase) {
        this.objectiveCase = objectiveCase;
    }

    public String getSubjectiveCase() {
        return subjectiveCase;
    }

    public void setSubjectiveCase(String subjectiveCase) {
        this.subjectiveCase = subjectiveCase;
    }
}
