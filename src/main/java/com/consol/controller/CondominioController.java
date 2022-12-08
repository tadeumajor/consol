package com.consol.controller;

import com.consol.model.Condominio;
import com.consol.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin(origins ="http://localhost:8080/", maxAge = 3600)
@RequestMapping("/condominios")
public class CondominioController {
    @Autowired
    private CondominioService condominioService;

    @PostMapping
    public ResponseEntity<Condominio> addCondominio(@Valid @RequestBody Condominio condominio){
        Condominio condominioAdd = condominioService.add(condominio);
        return ResponseEntity.status(HttpStatus.CREATED).body(condominioAdd);
    }

    @GetMapping
    public ResponseEntity<Page<Condominio>>  listaTodosCondominios(@PageableDefault(page=0, size=10, sort="id", direction = Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(condominioService.listaTodosCondominios(pageable));
    }

    @GetMapping("/{id}")
    public  Condominio condominioId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(condominioService.getCondominioById(id)).getBody();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Condominio> editarCondominio(@Valid @PathVariable Long id, @RequestBody Condominio condominio){

        return ResponseEntity.ok(condominioService.alter(id,condominio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCondominio(@PathVariable Long id){

        condominioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Condominio deletado com sucesso.");
    }

    @PostMapping("/{id}")
    public ResponseEntity<Condominio> calculaValorEnergia(@PathVariable Long id){

        Condominio condominioAdd = condominioService.validaCondominio(id);
        condominioAdd = condominioService.calculavalorInvestimento(id);
       return ResponseEntity.status(HttpStatus.OK).body(condominioAdd);

    }


}
