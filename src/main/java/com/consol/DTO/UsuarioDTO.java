package com.consol.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;

    @NotBlank(message = "Email não pode ser nulo ou vazio.")
    @Email(message ="Email inválido, gentileza conferir")
    private String email;

    @NotBlank(message = "Senha não pode ser nulo ou vazio.")
    private String password;
    
}
