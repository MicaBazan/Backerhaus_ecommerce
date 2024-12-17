package com.Backerhaus_Ecommerce.repositories;

import com.Backerhaus_Ecommerce.models.personaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonaRepository extends JpaRepository<personaModel, Long> {

    Optional<personaModel> findByEmail(String email);
}
