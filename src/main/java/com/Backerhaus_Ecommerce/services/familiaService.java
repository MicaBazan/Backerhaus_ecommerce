package com.Backerhaus_Ecommerce.services;


import com.Backerhaus_Ecommerce.models.familiaModel;
import com.Backerhaus_Ecommerce.repositories.IFamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class familiaService {

    @Autowired
    IFamiliaRepository familiaRepository;

    //metodo que va al IURepository: Busca todas las familias
    public ArrayList<familiaModel> getFamilia(){
        return (ArrayList<familiaModel>) familiaRepository.findAll();
    }
}
