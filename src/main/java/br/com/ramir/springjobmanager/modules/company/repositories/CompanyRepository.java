package br.com.ramir.springjobmanager.modules.company.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ramir.springjobmanager.modules.company.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID>{
    Optional<Company> findByUsernameOrEmail(String username, String email);
    Optional<Company> findByUsername(String username);
}
