package com.mycompany.property_management.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "OWNER_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String ownerName;
        private String ownerEmail;
        private String password;


}
