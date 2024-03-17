package com.fixdecode.sbcruddemo.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity // set a table in database
@Table(name="pet")
@NoArgsConstructor // set a default constructor
@Data
public class Pet
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Every pets have a name!")
    private String name;
    @NotBlank(message = "Every pets have a Color pls enter the color of your pet")
    private String color;

    public Pet(String name,String color)
    {
        this.name=name;
        this.color = color;
    }
}
