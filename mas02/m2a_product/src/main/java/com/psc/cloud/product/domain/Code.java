package com.psc.cloud.product.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_code")
public class Code {

    public Code(){
    }

    public Code(Long parentId, String codeName, boolean enabled, String description ){
        this.parentId = parentId;
        this.codeName = codeName;
        this.enabled = enabled;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code_id")
    private Long codeId;

    @Column(name="parent_id")
    private Long parentId;

    @Column(name="code_name")
    private String codeName;

    private boolean enabled;
    private String description;
}
