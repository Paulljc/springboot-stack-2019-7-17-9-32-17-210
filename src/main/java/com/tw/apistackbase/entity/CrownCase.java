package com.tw.apistackbase.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "CrownCase")
public class CrownCase {

    @Id
    @GeneratedValue()
    private Long id;

    @NotNull
    private String caseName;

    @NotNull
    private Date caseTime;

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(Date caseTime) {
        this.caseTime = caseTime;
    }

    public CrownCase(@NotNull String caseName, @NotNull Date caseTime) {
        this.caseName = caseName;
        this.caseTime = caseTime;
    }

    @OneToOne
    private CrownDetail crownDetail;

    public CrownCase(String caseName) {
        this.caseName = caseName;
    }
}
