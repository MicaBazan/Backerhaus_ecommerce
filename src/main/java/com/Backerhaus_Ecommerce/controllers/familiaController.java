package com.Backerhaus_Ecommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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



}
