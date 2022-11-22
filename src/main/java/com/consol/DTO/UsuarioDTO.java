package com.consol.DTO;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

private Long id;
private String nome;

@Email(message ="Email inválido, gentileza conferir")
private String email;

private String password;
    
}
