package com.fpt.petstore.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Entidade da tabela de contato
 */
@Entity
@Table(name = "contact")
@Getter
@Setter
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;
    private String message;
    private Date contactDate;

    public Contact(String name, String email,String message,Date contactDate) {
        this.name = name;
        this.email=email;
        this.message = message;
        this.contactDate=contactDate;
    }
}
