package com.Backerhaus_Ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Backerhaus_Ecommerce.services.familiaService;
import com.Backerhaus_Ecommerce.models.familiaModel;

import java.util.ArrayList;

@RestController
@RequestMapping("/familia")
public class familiaController {

    @Autowired
    private familiaService familiaservice;

    @GetMapping
    public ArrayList<familiaModel> getFamilia(){
        return this.familiaservice.getFamilia();
    }

    @PostMapping
    public familiaModel saveFamilia(@RequestBody familiaModel familia){
        return this.familiaservice.saveFamilia(familia);
    }


    @DeleteMapping(path = "/{id_familia}")
    public String deleteById(@PathVariable("id_familia") Long id){
        boolean ok = this.familiaservice.deleteFamilia(id);

        if(ok){
            return "Familia eliminada con exito";
        } else {
            return "Error, hubo un problema en eliminar la familia";
        }
    }

    @PutMapping(path = "/{id_familia}")
    public familiaModel updateFamiliaById(@RequestBody familiaModel request, @PathVariable("id_familia") Long id){
        return this.familiaservice.updateFamiliaById(request, id);
    }
}
