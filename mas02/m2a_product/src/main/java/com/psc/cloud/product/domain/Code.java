package com.psc.cloud.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_code")
@AllArgsConstructor
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code_id")
    private Long codeId;

    @Column(name="code_name")
    private String codeName;

    private boolean enabled;
    private String description;
}
