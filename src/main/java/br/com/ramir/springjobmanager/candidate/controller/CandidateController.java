package br.com.ramir.springjobmanager.candidate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramir.springjobmanager.candidate.Candidate;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    @PostMapping("/")
    public void create(@Valid @RequestBody Candidate candidate){
        System.out.println("Candidato");
        System.out.println(candidate.getEmail());
    }
}