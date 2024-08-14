package com.ChatApplication.Project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserFriends {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    @OneToOne
    @JoinColumn(name = "frnd_id")
    private Frnd f;
}
