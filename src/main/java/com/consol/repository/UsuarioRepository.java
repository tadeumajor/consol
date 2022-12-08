package com.consol.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consol.model.Condominio;
import com.consol.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Iterable<Usuario> findByCondominio(Condominio condominio);
    
    Usuario findByCpf(String cpf);
    
    Usuario findByEmail(String email);

}

