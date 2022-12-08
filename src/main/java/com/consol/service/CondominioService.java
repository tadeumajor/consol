package com.consol.service;

import com.consol.model.Condominio;
import com.consol.repository.CondominioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class CondominioService {

    @Autowired
    private CondominioRepository condominioRepository;

    public Condominio add(Condominio condominio) {
        return condominioRepository.save(condominio);

    }

    public void delete(Long id) {
        validaCondominio(id);
        condominioRepository.deleteById(id);
    }

    public Page<Condominio> listaTodosCondominios(Pageable pageable) {
        return condominioRepository.findAll(pageable);
    }

    public Condominio alter(long id, Condominio condominio){
        Condominio condominioAlter = validaCondominio(id);
        BeanUtils.copyProperties(condominio, condominioAlter);
        return condominioRepository.save(condominioAlter);

    }

    public Condominio getCondominioById(long id)
    {
        return condominioRepository.findById(id).get();
    }

    public Condominio validaCondominio(long id) {
        Optional<Condominio> condominioBusca = condominioRepository.findById(id);
        if (condominioBusca.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return condominioBusca.get();
    }

    public Condominio calculavalorInvestimento(long id){

        // considerando media anual da cidade de BH
        double radiacaoSolar = 5.13;

        Condominio condominioBusca =validaCondominio(id);

        double consumoDia = condominioBusca.getConsumoMedioMesKwh()/30;
        double kwPico = consumoDia/radiacaoSolar;

        //conversao de kw para wat
        kwPico = kwPico+1000;
        int placaSolar330 = 330;
        int qtdPaineis = (int) (kwPico/placaSolar330);

        condominioBusca.setQtdPaineis(qtdPaineis);

        //base sendo 1200 painel + 300 por instalacao
        double vlrPainel330 = 1500;
        condominioBusca.setValorPaineis(1200);

        double precoInvesor=0;
        if(kwPico<=2000){
            precoInvesor = 2000;
        } else if(kwPico>2000 && kwPico<=3000){
            precoInvesor=5000;
        } else if(kwPico>3000 && kwPico<=5000){
            precoInvesor=6000;
        } else if(kwPico>5000 && kwPico<=12500){
            precoInvesor=15000;
        } else if(kwPico>12500 && kwPico<=25000){
            precoInvesor=18000;
        } else if(kwPico>25000) {
            precoInvesor = 40000;
        }

        double valorTotal = (qtdPaineis*vlrPainel330) + precoInvesor;
        condominioBusca.setValorAproximado(valorTotal);
        condominioRepository.save(condominioBusca);
        return  condominioBusca;

    }

}

