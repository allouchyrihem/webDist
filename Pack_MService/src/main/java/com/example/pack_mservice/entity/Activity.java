package com.example.pack_mservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activityId")
    private Long activityId;
    private String time;
    private String detail;
    @ManyToMany(mappedBy ="activities")
    Set<Pack> packs = new HashSet<>();
}
