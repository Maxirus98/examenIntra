package com.examenintraprojet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    String id;
    String fullName;
    String email;
    String phoneNumber;
    String address;
    Boolean isActive;
}
