package com.example.restfulApiJpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sam_table")  // 없어도 클래스명을 테이블명으로 자동 연동 가능(Java의 CamelCase 표기법은 데이터베이스에서 SnakeCase로 변환)
public class SamTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer keyno;
    private String value;

    // Getters and Setters
    public Integer getKeyno() {
        return keyno;
    }

    public void setKeyno(Integer keyno) {
        this.keyno = keyno;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }    
}
