package br.com.ramir.springjobmanager.modules.company.useCases;

import br.com.ramir.springjobmanager.modules.company.dto.AuthCompanyDto;
import br.com.ramir.springjobmanager.modules.company.repositories.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDto authCompanyDto) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario/senha incorretos"));

        var passwordMatches = this.passwordEncoder.matches(authCompanyDto.getPassword(),company.getPassword());

        if (!passwordMatches)
            throw new AuthenticationException();

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        return JWT.create()
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withIssuer("Javagas")
                .withSubject(company.getId().toString())
                .sign(algorithm);
    }


}
