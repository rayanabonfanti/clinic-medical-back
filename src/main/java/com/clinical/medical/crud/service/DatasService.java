package com.clinical.medical.crud.service;

import com.clinical.medical.crud.model.Log;
import com.clinical.medical.crud.model.dto.DatasDTO;
import com.clinical.medical.crud.model.Datas;
import com.clinical.medical.crud.repository.DatasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("/datasService/")
public class DatasService {

    @Autowired
    private DatasRepository datasRepository;

    @Autowired
    private LogService logService;

    public List<Datas> listDatas() {
        return datasRepository.findAll();
    }

    public Datas saveDatas(DatasDTO datasDTO){
        Datas datas = datasDTO.toConverterDatasDTO();
        Datas existDatas = getDatasName(datas.getName());
        if (Objects.isNull(existDatas)) {
            datasRepository.save(datas);

//            Log log = new Log();
//            log.setTableName("datas");
//            log.setActionType("insert");
//            log.setNewValue(datas.toString());
//            logService.saveLog(log);

            return datas;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Datas datas = getDatasId(id);

//        Log log = new Log();
//        log.setTableName("datas");
//        log.setActionType("delete");
//        log.setNewValue(datas.toString());
//        logService.saveLog(log);

        datasRepository.deleteById(id);

        return true;
    }

    public Datas edit(Integer id, DatasDTO datasDTO) {
        Datas datas = getDatasId(id);
        if (!Objects.isNull(datas)) {

//            Log log = new Log();
//            log.setOldValue(datas.toString());

            datas.setName(datasDTO.getName());
            datas.setTelefone(datasDTO.getTelefone());
            datas.setEmail(datasDTO.getEmail());
            datas.setEndereco(datasDTO.getEndereco());

//            log.setTableName("datas");
//            log.setActionType("update");
//            log.setNewValue(datas.toString());

            datasRepository.save(datas);
//            logService.saveLog(log);

            return datas;
        }
        return null;
    }

    public Datas getDatasName(String name){
        return datasRepository.findByName(name);
    }

    public Datas getDatasId(Integer id) {
        Optional<Datas> obj = datasRepository.findById(id);
        return obj.orElse(null);
    }

}
