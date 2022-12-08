package com.consol.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.consol.DTO.UsuarioDTO;
import com.consol.model.Usuario;
import com.consol.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity<Boolean> login(UsuarioDTO usuario){

        Usuario usuarioBusca = (Usuario) usuarioRepository.findByEmail(usuario.getEmail());

        if(usuario.getEmail().equals(usuarioBusca.getEmail()) && usuario.getPassword().equals(usuarioBusca.getPassword())){
            usuarioBusca.setLog(true);
            usuarioRepository.save(usuarioBusca);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }  
    }
    
    public Usuario add(Usuario usuario) {
        return usuarioRepository.save(usuario);
        
    }

    public void delete(Long id) {
        validaUsuario(id);
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listaTodosUsuarios(){
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario alter(long id, Usuario usuario){
        Usuario usuarioAlter = validaUsuario(id);
        BeanUtils.copyProperties(usuario, usuarioAlter);
        return usuarioRepository.save(usuarioAlter);

    }

    public Usuario getUsuarioById(long id){
        return usuarioRepository.findById(id).get();
    }

    public Usuario validaUsuario(long id) {
        Optional<Usuario> usuarioBusca = usuarioRepository.findById(id);
        if (usuarioBusca.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return usuarioBusca.get();
    }

}
