package com.example.pack_mservice.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Pack implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "packId")
    private Long packId;
    private String type;
    private String duree;
    private String prix;
    private String description;
    @ManyToMany
    Set<Activity> activities = new HashSet<>();
}
