package br.com.ramir.springjobmanager.modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ramir.springjobmanager.modules.company.entities.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
    
}
