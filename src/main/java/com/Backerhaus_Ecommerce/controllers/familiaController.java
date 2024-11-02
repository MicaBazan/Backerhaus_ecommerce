package com.Backerhaus_Ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Backerhaus_Ecommerce.services.familiaService;
import com.Backerhaus_Ecommerce.models.familiaModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/familia")
public class familiaController {

    @Autowired
    private familiaService familiaservice;

    @GetMapping
    public ArrayList<familiaModel> getFamilia(){
        return this.familiaservice.getFamilia();
    }

    @GetMapping(path = "/{id_familia}")
    public ResponseEntity<familiaModel> getFamiliaById(@PathVariable("id_familia") Long id){
        Optional<familiaModel> familia = familiaservice.getFamiliaById((id));

        if(familia.isPresent()){
            return new ResponseEntity<>(familia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<familiaModel> getFamiliaByNombre(@RequestParam("nombre") String nombre){
        return familiaservice.getFamiliaByNombre(nombre);
    }


    @PostMapping(path = "/saveFamilia")
    public familiaModel saveFamilia(@RequestBody familiaModel familia){
        return this.familiaservice.saveFamilia(familia);
    }


    @DeleteMapping(path = "/deleteFamilia/{id_familia}")
    public String deleteById(@PathVariable("id_familia") Long id){
        boolean ok = this.familiaservice.deleteFamilia(id);

        if(ok){
            return "Familia eliminada con exito";
        } else {
            return "Error, hubo un problema en eliminar la familia";
        }
    }

    @PutMapping(path = "/updateFamilia/{id_familia}")
    public familiaModel updateFamiliaById(@RequestBody familiaModel request, @PathVariable("id_familia") Long id){
        return this.familiaservice.updateFamiliaById(request, id);
    }
}
