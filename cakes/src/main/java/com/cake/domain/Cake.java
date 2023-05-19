package com.cake.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cakes")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cakeId;

    @Column(name = "cake_name")
    private String cakeName;

    @Column(name = "cake_description")
    private String cakeDescription;

    @Column(name = "cake_created_date")
    private LocalDate cakeCreatedDate;

    @Column(name = "cake_url")
    private String cakeURL;

}
