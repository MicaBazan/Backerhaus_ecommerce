package com.Backerhaus_Ecommerce.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Backerhaus_Ecommerce.models.productoModel;


@Repository
public interface IProductoRepository extends JpaRepository<productoModel, Long> {

}
