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
    private Long caseTime;

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

    public Long getCaseTime() {
        return caseTime;
    }

    public void setCaseTime(Long caseTime) {
        this.caseTime = caseTime;
    }

    public CrownDetail getCrownDetail() {
        return crownDetail;
    }

    public void setCrownDetail(CrownDetail crownDetail) {
        this.crownDetail = crownDetail;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    @OneToOne
    private CrownDetail crownDetail;

    @ManyToOne
    @NotNull
    private Procuratorate procuratorate;

    public CrownCase(@NotNull String caseName, @NotNull Long caseTime, CrownDetail crownDetail, @NotNull Procuratorate procuratorate) {
        this.caseName = caseName;
        this.caseTime = caseTime;
        this.crownDetail = crownDetail;
        this.procuratorate = procuratorate;
    }
}
