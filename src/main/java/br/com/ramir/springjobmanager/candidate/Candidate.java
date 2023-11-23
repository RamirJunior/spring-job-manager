package br.com.ramir.springjobmanager.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Candidate {

    private UUID id;
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo login não deve conter espaço.")
    private String username;

    @Email(message = "O campo email deve conter um e-mail válido.")
    private String email;

    @Length(min = 10, max = 100, message = "O campo senha deve conter entre 10 e 100 caracteres")
    private String password;
    private String description;
    private String curriculum;
}
