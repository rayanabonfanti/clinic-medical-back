package com.clinical.medical.crud.repository;

import com.clinical.medical.crud.model.Datas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatasRepository extends JpaRepository<Datas, Integer> {
    Datas findByName(String name);
    Optional<Datas> findById(Integer id);
}
