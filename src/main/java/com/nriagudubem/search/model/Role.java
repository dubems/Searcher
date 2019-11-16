package com.nriagudubem.search.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
