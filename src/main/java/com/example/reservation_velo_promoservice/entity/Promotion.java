package com.example.reservation_velo_promoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double discountPercentage;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;

    @Column(name = "pack_id")
    private Long packId;
}
