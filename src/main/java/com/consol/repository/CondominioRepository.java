package com.consol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.consol.model.Condominio;


@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Long> {

    Condominio findByCodigo(long codigo);
}

