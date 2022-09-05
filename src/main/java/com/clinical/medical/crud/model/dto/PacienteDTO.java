package com.clinical.medical.crud.model.dto;

import com.clinical.medical.crud.model.Datas;
import com.clinical.medical.crud.model.Paciente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PacienteDTO {

    @JsonProperty
    private Date dataNascimento;

    @JsonProperty
    private Datas datas;

    public Paciente toConverterPacienteDTO() {
        Paciente paciente = new Paciente();
        paciente.setDataNascimento(this.dataNascimento);
        paciente.setDatas(this.datas);
        return paciente;
    }

}
