package com.kibernumacademy.companyfallback.controller;

import java.time.LocalDate;
import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kibernumacademy.companyfallback.models.Company;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/company-fallback")
@Slf4j
public class CompanyController {
  
  // Vamos a regresar una company por default
  private static final Company DEFAULT_COMPANY = Company
  .builder()
    .id(0L)
    .name("Company not found")
    .founder("Not found")
    .logo("Not found")
    .foundationDate(LocalDate.now())
    .webSites(Collections.emptyList())
  .build();

  // localhost:9797/company-fallback/Facebook
  // localhost:9797/company-fallback/Google
  // localhost:9797/company-fallback/{name}
  @GetMapping("{name}")
  public ResponseEntity<Company> getCompanyByName(@PathVariable String name ) {
    log.info("GET: Buscando la compañia en fallback con nombre: {}", name);
    return ResponseEntity.ok(DEFAULT_COMPANY);
  }
}
