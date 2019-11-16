package com.nriagudubem.search.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @NoArgsConstructor
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String queryString;

    @OneToMany
    @JoinColumn(name = "search_id")
    private Set<Email> emails = new HashSet<>();

    @CreationTimestamp
    LocalDate createdAt;

    @UpdateTimestamp
    LocalDate updateAt;
}
