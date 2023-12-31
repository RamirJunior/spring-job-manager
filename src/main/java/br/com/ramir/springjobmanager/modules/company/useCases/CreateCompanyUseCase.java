package br.com.ramir.springjobmanager.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.ramir.springjobmanager.exceptions.UserFoundException;
import br.com.ramir.springjobmanager.modules.company.entities.Company;
import br.com.ramir.springjobmanager.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Company execute(Company company) {

        this.companyRepository
                .findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        var password = passwordEncoder.encode(company.getPassword());
        company.setPassword(password);

        return this.companyRepository.save(company);
    }
}
