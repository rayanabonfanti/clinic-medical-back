package com.clinical.medical.crud.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Integer pacienteId;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "datas_id")
    @ToString.Exclude
    private Datas datas;

    //plano_saude_id

}
