package com.clinical.medical.crud.service;

import com.clinical.medical.crud.model.Medico;
import com.clinical.medical.crud.model.Paciente;
import com.clinical.medical.crud.model.dto.MedicoDTO;
import com.clinical.medical.crud.model.dto.PacienteDTO;
import com.clinical.medical.crud.repository.MedicoRepository;
import com.clinical.medical.crud.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("/pacienteService/")
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private LogService logService;

    public List<Paciente> listPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente savePaciente(PacienteDTO pacienteDTO){
        Paciente paciente = pacienteDTO.toConverterPacienteDTO();
        Paciente existPaciente = getPacienteDataNascimento(pacienteDTO.getDataNascimento());
        if (Objects.isNull(existPaciente)) {
            pacienteRepository.save(paciente);

//            Log log = new Log();
//            log.setTableName("paciente");
//            log.setActionType("insert");
//            log.setNewValue(paciente.toString());
//            logService.saveLog(log);

            return paciente;
        }
        return null;
    }

    public boolean remove(Integer id) {
        Paciente paciente = getPacienteId(id);

//        Log log = new Log();
//        log.setTableName("paciente");
//        log.setActionType("delete");
//        log.setNewValue(paciente.toString());
//        logService.saveLog(log);

        pacienteRepository.deleteById(id);

        return true;
    }

    public Paciente edit(Integer id, PacienteDTO pacienteDTO) {
        Paciente paciente = getPacienteId(id);
        if (!Objects.isNull(paciente)) {

//            Log log = new Log();
//            log.setOldValue(paciente.toString());

            paciente.setDataNascimento(pacienteDTO.getDataNascimento());

//            log.setTableName("paciente");
//            log.setActionType("update");
//            log.setNewValue(paciente.toString());

            pacienteRepository.save(paciente);
//            logService.saveLog(log);

            return paciente;
        }
        return null;
    }

    public Paciente getPacienteDataNascimento(Date dataNascimento){
        return pacienteRepository.findByDataNascimento(dataNascimento);
    }

    public Paciente getPacienteId(Integer id) {
        Optional<Paciente> obj = pacienteRepository.findById(id);
        return obj.orElse(null);
    }
}
