package com.tw.apistackbase.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "procuratorate")
public class Procuratorate {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true, length = 50)
    private String name;

    @OneToMany
    private Set<Prosecutor> prosecutors;

    public Procuratorate(@NotNull String name, Set<Prosecutor> prosecutors) {
        this.name = name;
        this.prosecutors = prosecutors;
    }

    public Procuratorate(@NotNull String name) {
        this.name = name;
    }

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

    public Set<Prosecutor> getProsecutors() {
        return prosecutors;
    }

    public void setProsecutors(Set<Prosecutor> prosecutors) {
        this.prosecutors = prosecutors;
    }

    public Procuratorate() {
    }
}
