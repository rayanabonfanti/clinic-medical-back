package com.clinical.medical.crud.repository;

import com.clinical.medical.crud.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository <Paciente, Integer> {
    Paciente findByDataNascimento(Date Data_nascimento);
    Optional<Paciente> findById(Integer id);
}
