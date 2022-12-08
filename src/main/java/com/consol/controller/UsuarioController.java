package com.consol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consol.DTO.UsuarioDTO;
import com.consol.model.Usuario;
import com.consol.service.UsuarioService;

@RestController
@CrossOrigin(origins ="http://localhost:8080/", maxAge = 3600)
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario usuario){

        Usuario usuarioAdd = usuarioService.add(usuario);
        return  ResponseEntity.status(HttpStatus.CREATED).body(usuarioAdd);
    }

    @GetMapping
    public List<Usuario> listaTodosUsuarios(){
        return  usuarioService.listaTodosUsuarios();
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id){
        usuarioService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> alterUsuario(@Valid @PathVariable Long id, @RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.alter(id, usuario));
    }

    @GetMapping("/{id}")
    public Usuario listaUsuarioId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.validaUsuario(id)).getBody();
    }

    @PostMapping("/{login}")
    public ResponseEntity<Object> login(@Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.login(usuarioDTO);
    }

}
