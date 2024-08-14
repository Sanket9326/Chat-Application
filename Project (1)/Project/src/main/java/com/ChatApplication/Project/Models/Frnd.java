package com.ChatApplication.Project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Frnd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
}
