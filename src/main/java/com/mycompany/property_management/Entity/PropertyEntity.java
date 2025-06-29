package com.mycompany.property_management.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   @Column(name = "PROPERTY_TITLE" ,nullable = false)
    private String title;
    private String description;
    private String ownerName;
    private double price;
    @Column(name = "PROPERTY_EMAIL" ,nullable = false)
    private String ownerEmail;
    private String address;
}
