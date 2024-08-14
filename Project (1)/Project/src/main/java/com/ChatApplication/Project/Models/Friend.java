package com.ChatApplication.Project.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Friend {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   private String sender;
   private String receiver;
   private String status;
}
