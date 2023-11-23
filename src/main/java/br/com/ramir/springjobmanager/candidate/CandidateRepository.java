package br.com.ramir.springjobmanager.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, UUID>{
    
    Optional<Candidate> findByUsernameOrEmail(String username, String email);
}
