package br.com.ramir.springjobmanager.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramir.springjobmanager.modules.company.entities.Company;
import br.com.ramir.springjobmanager.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;
    
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Company company){
        try {

            var result = this.createCompanyUseCase.execute(company);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
