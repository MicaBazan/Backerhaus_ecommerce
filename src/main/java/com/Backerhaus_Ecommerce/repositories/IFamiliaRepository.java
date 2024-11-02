package com.Backerhaus_Ecommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Backerhaus_Ecommerce.models.familiaModel;

import java.util.List;


//Clase que permite tener query a una base de datos
@Repository
public interface IFamiliaRepository extends JpaRepository<familiaModel, Long> {

    List<familiaModel> findByNombre(String nombre);
}
