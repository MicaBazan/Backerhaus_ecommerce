package com.Backerhaus_Ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class rolModel {

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<personaModel> personas = new HashSet<>();
}
