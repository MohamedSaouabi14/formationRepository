package org.sid.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
    @Id
    private String id;
    private String name;
    private String photoName;
    private String type;
    private String nameCoach;
    private double price;
    private String date;
}
