package com.xloop.resourceloop.creatingstaff.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( nullable = false)
    private String fullName;

    @Column()
    private String imageUrl;

    

}
