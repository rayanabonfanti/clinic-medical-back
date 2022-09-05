package com.clinical.medical.crud.model.dto;

import com.clinical.medical.crud.model.Datas;
import com.clinical.medical.crud.model.Medico;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicoDTO {

    @JsonProperty
    private Integer medico_crm;

    @JsonProperty
    private Datas datas;

    public Medico toConverterMedicoDTO() {
        Medico medico = new Medico();
        medico.setMedicoCRM(this.medico_crm);
        medico.setDatas(this.datas);
        return medico;
    }

}
