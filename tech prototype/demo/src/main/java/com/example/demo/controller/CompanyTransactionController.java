package com.example.demo.controller;

import com.example.demo.model.CompanyTransaction;
import com.example.demo.service.CompanyTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
@Validated
@CrossOrigin(origins="*")
public class CompanyTransactionController {
    private final CompanyTransactionService companyTransactionService;

    public CompanyTransactionController(CompanyTransactionService companyTransactionService) {
        this.companyTransactionService = companyTransactionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyTransaction>> getAllData() {
        List<CompanyTransaction> transactions = companyTransactionService.getAllData();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyTransaction> getDataById(@PathVariable Long id) {
        return ResponseEntity.ok(companyTransactionService.getDataById(id));
    }

    @GetMapping("/companies")
    public ResponseEntity<List<String>> getAllCompanies() {
        return ResponseEntity.ok(companyTransactionService.getAllData().stream()
                .map(CompanyTransaction::getCode)
                .distinct()
                .collect(Collectors.toList()));
    }

    @GetMapping("/transactions/{code}")
    public ResponseEntity<List<CompanyTransaction>> getDataByCode(@PathVariable String code) {
        return ResponseEntity.ok(companyTransactionService.getDataByCode(code));
    }

}
