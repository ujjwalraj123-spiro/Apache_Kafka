package org.example.repository;

import org.example.dto.BmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepo extends JpaRepository<BmsEntity, Integer> {

    BmsEntity findByBmsId(String bmsId);
}
