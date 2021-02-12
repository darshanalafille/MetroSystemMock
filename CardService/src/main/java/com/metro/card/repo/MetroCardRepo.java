package com.metro.card.repo;

import com.metro.card.entity.MetroCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetroCardRepo extends JpaRepository<MetroCard,Long> {
}
