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

    //Metodo que crea una nueva familia
    public familiaModel saveFamilia(familiaModel familia){
        return familiaRepository.save(familia);
    }


    //Metodo eliminar familia
    public boolean deleteFamilia(Long id){
        try{
            familiaRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    //Metodo actualizar familia
    public familiaModel updateFamiliaById(familiaModel request, Long id){
        familiaModel familia = familiaRepository.findById(id).get();

        familia.setNombre(request.getNombre());
        familia.setDescripcion(request.getDescripcion());

        return familia;
    }
}
