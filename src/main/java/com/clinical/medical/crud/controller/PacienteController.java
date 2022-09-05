package com.clinical.medical.crud.controller;

import com.clinical.medical.crud.model.Medico;
import com.clinical.medical.crud.model.Paciente;
import com.clinical.medical.crud.model.dto.MedicoDTO;
import com.clinical.medical.crud.model.dto.PacienteDTO;
import com.clinical.medical.crud.service.MedicoService;
import com.clinical.medical.crud.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/paciente/")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping()
    public ResponseEntity<?> list() {
        try {
            List<Paciente> listPaciente = pacienteService.listPacientes();
            if (!listPaciente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(listPaciente);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foram encontrados registros de pacientes!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody PacienteDTO pacienteDTO) {
        try {
            Paciente pacienteSave = pacienteService.savePaciente(pacienteDTO);
            if (!Objects.isNull(pacienteSave)) {
                return ResponseEntity.status(HttpStatus.OK).body(pacienteSave);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nao foi possivel cadastrar paciente!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        try {
            boolean removed = pacienteService.remove(id);
            if (removed) {
                return ResponseEntity.status(HttpStatus.OK).body(removed);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível remover paciente!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody PacienteDTO pacienteDTO) {
        try {
            Paciente paciente = pacienteService.edit(id, pacienteDTO);
            if (!Objects.isNull(paciente)) {
                return ResponseEntity.status(HttpStatus.OK).body(paciente);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível editar esse paciente!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
