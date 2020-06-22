package org.sid.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    private String id;
    private String name;
    private String lastname;
    private String adresse;
    @Email
    private String mail;

    private String phone_number;

    private String adresse_postal;

}
