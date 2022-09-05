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
@Table(name = "datas")
public class Datas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "datas_id")
    private Integer datasId;

    @Column(name = "datas_name", nullable = false)
    private String name;

    @Column(name = "datas_telefone", nullable = false)
    private String telefone;

    @Column(name = "datas_email", nullable = false)
    private String email;

    @Column(name = "datas_endereco", nullable = false)
    private String endereco;
}
