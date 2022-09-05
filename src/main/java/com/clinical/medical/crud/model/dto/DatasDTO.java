package com.clinical.medical.crud.model.dto;

import com.clinical.medical.crud.model.Datas;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DatasDTO {

    @JsonProperty
    private String name;

    @JsonProperty
    private String telefone;

    @JsonProperty
    private String email;

    @JsonProperty
    private String endereco;

    public Datas toConverterDatasDTO() {
        Datas datas = new Datas();
        datas.setName(this.name);
        datas.setTelefone(this.telefone);
        datas.setEmail(this.email);
        datas.setEndereco(this.endereco);
        return datas;
    }

}
