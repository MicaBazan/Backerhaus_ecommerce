package com.Backerhaus_Ecommerce.services;


import com.Backerhaus_Ecommerce.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productoService {

    @Autowired
    IProductoRepository productoRepository;
}
