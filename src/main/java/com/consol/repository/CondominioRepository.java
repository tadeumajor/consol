package com.consol.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.consol.model.Condominio;


@Repository
public interface CondominioRepository extends CrudRepository<Condominio, Long> {

    Condominio findByCodigo(long codigo);
}

