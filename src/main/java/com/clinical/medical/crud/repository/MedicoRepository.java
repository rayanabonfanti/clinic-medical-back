package com.clinical.medical.crud.repository;

import com.clinical.medical.crud.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico,Integer> {
    Medico findByMedicoCRM(Integer MedicoCRM);
    Optional<Medico> findById(Integer id);
}
