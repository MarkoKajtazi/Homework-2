package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "CompanyTransaction")
@NoArgsConstructor
@AllArgsConstructor
public class CompanyTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COMPANY_CODE", nullable = false)
    private String code;

    @Column(name = "TRANSACTION_DATE", nullable = false)
    private Date date;

    @Column(name = "TRANSACTION_AMOUNT", nullable = false)
    private float amount;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Date getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
