package com.ChatApplication.Project.Repository;

import com.ChatApplication.Project.Models.Frnd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrndDao extends JpaRepository<Frnd, Integer> {
}
