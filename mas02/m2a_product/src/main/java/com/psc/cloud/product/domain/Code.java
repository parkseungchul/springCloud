package com.psc.cloud.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_code")
@ToString
@AllArgsConstructor
public class Code {

    public Code(){
    }

    public Code(Long codeId){
        this.codeId = codeId;
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

    private Boolean enabled;
    private String description;
}
