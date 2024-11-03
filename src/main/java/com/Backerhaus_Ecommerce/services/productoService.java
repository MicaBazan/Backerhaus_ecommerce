package com.Backerhaus_Ecommerce.services;


import com.Backerhaus_Ecommerce.models.familiaModel;
import com.Backerhaus_Ecommerce.models.productoModel;
import com.Backerhaus_Ecommerce.repositories.IFamiliaRepository;
import com.Backerhaus_Ecommerce.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


// El service va al Repository para obtener los datos
@Service
public class productoService {

    @Autowired
    IProductoRepository productoRepository;

    @Autowired
    IFamiliaRepository familiaRepository;

    @Autowired
    private familiaService familiaservice;





}
