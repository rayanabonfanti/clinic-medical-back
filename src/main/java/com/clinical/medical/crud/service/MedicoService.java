package com.clinical.medical.crud.service;

import com.clinical.medical.crud.model.Datas;
import com.clinical.medical.crud.model.Medico;
import com.clinical.medical.crud.model.dto.DatasDTO;
import com.clinical.medical.crud.model.dto.MedicoDTO;
import com.clinical.medical.crud.repository.DatasRepository;
import com.clinical.medical.crud.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("/medicoService/")
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private LogService logService;

    public List<Medico> listMedicos() {
        return medicoRepository.findAll();
    }

    public Medico saveMedico(MedicoDTO medicoDTO){
        Medico medico = medicoDTO.toConverterMedicoDTO();
        Medico existMedico = getMedicoName(medico.getMedicoCRM());
        if (Objects.isNull(existMedico)) {
            medicoRepository.save(medico);

//            Log log = new Log();
//            log.setTableName("medico");
//            log.setActionType("insert");
//            log.setNewValue(medico.toString());
//            logService.saveLog(log);

            return medico;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Medico medico = getMedicoId(id);

//        Log log = new Log();
//        log.setTableName("medico");
//        log.setActionType("delete");
//        log.setNewValue(medico.toString());
//        logService.saveLog(log);

        medicoRepository.deleteById(id);

        return true;
    }

    public Medico edit(Integer id, MedicoDTO medicoDTO) {
        Medico medico = getMedicoId(id);
        if (!Objects.isNull(medico)) {

//            Log log = new Log();
//            log.setOldValue(medico.toString());

            medico.setMedicoCRM(medicoDTO.getMedico_crm());

//            log.setTableName("medico");
//            log.setActionType("update");
//            log.setNewValue(medico.toString());

            medicoRepository.save(medico);
//            logService.saveLog(log);

            return medico;
        }
        return null;
    }

    public Medico getMedicoName(Integer CRM){
        return medicoRepository.findByMedicoCRM(CRM);
    }

    public Medico getMedicoId(Integer id) {
        Optional<Medico> obj = medicoRepository.findById(id);
        return obj.orElse(null);
    }

}
