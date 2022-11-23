package com.consol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.consol.model.Condominio;
import com.consol.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Iterable<Usuario> findByCondominio(Condominio condominio);
    
    Usuario findByrg(String rg);
    
    Usuario findByEmail(String email);

}

