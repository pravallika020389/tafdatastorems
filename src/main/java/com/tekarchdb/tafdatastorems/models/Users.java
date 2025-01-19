package com.tekarchdb.tafdatastorems.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String username;
    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String email;
    @Column(name = "phone_number", columnDefinition = "varchar(15)", nullable = true)
    private String phoneNumber;
    @CreationTimestamp // Automatically sets the current timestamp
    @Column(name = "created_at" , updatable = false) // Prevent updates to this column
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at" ,updatable = true)
    private LocalDate updatedAt;

}
