package com.clinical.medical.crud.controller;

import com.clinical.medical.crud.model.dto.DatasDTO;
import com.clinical.medical.crud.model.Datas;
import com.clinical.medical.crud.service.DatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/datas/")
public class DatasController {

    @Autowired
    private DatasService datasService;

    @GetMapping()
    public ResponseEntity<?> list() {
        try {
            List<Datas> listDatas = datasService.listDatas();
            if (!listDatas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(listDatas);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não foram encontrados registros de dados!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Integer id) {
        try {
            boolean removed = datasService.remove(id);
            if (removed) {
                return ResponseEntity.status(HttpStatus.OK).body(removed);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível remover dados!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Integer id, @RequestBody DatasDTO datasDTO) {
        try {
            Datas datas = datasService.edit(id, datasDTO);
            if (!Objects.isNull(datas)) {
                return ResponseEntity.status(HttpStatus.OK).body(datas);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível editar esses dados!");
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody DatasDTO datasDTO) {
        try {
            Datas datasSave = datasService.saveDatas(datasDTO);
            if (!Objects.isNull(datasSave)) {
                return ResponseEntity.status(HttpStatus.OK).body(datasSave);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nao foi possivel cadastrar dados!");
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
