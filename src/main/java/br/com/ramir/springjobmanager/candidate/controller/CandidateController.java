package br.com.ramir.springjobmanager.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramir.springjobmanager.candidate.Candidate;
import br.com.ramir.springjobmanager.candidate.CandidateRepository;
import br.com.ramir.springjobmanager.exceptions.UserFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;
    
    @PostMapping("/")
    public Candidate create(@Valid @RequestBody Candidate candidate){

        this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
        .ifPresent(user -> {
            throw new UserFoundException();
        });
        return this.candidateRepository.save(candidate);
    }
}
