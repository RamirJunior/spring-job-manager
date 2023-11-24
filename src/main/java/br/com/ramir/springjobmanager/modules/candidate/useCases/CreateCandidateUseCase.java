package br.com.ramir.springjobmanager.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ramir.springjobmanager.exceptions.UserFoundException;
import br.com.ramir.springjobmanager.modules.candidate.Candidate;
import br.com.ramir.springjobmanager.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate execute(Candidate candidate) {

        this.candidateRepository
                .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidate);
    }
}
