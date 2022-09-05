package com.clinical.medical.crud.controller;

import com.clinical.medical.crud.model.Datas;
import com.clinical.medical.crud.model.Medico;
import com.clinical.medical.crud.model.dto.DatasDTO;
import com.clinical.medical.crud.model.dto.MedicoDTO;
import com.clinical.medical.crud.service.DatasService;
import com.clinical.medical.crud.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/medico/")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping()
    public ResponseEntity<?> list() {
        try {
            List<Medico> listMedico = medicoService.listMedicos();
            if (!listMedico.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(listMedico);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foram encontrados registros de médicos!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody MedicoDTO medicoDTO) {
        try {
            Medico medicoSave = medicoService.saveMedico(medicoDTO);
            if (!Objects.isNull(medicoSave)) {
                return ResponseEntity.status(HttpStatus.OK).body(medicoSave);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nao foi possivel cadastrar médico!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        try {
            boolean removed = medicoService.remove(id);
            if (removed) {
                return ResponseEntity.status(HttpStatus.OK).body(removed);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível remover médico!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody MedicoDTO medicoDTO) {
        try {
            Medico medico = medicoService.edit(id, medicoDTO);
            if (!Objects.isNull(medico)) {
                return ResponseEntity.status(HttpStatus.OK).body(medico);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível editar esse médico!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
