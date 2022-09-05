package com.clinical.medical.crud.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Integer medicoId;

    @Column(name = "medico_crm", nullable = false)
    private Integer medicoCRM;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "datas_id")
    @ToString.Exclude
    private Datas datas;

    //especialidade_id
}
