package com.tw.apistackbase.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
}
