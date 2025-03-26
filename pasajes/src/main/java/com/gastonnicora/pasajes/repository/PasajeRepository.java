package com.gastonnicora.pasajes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.gastonnicora.pasajes.model.PasajeModel;

public interface PasajeRepository extends JpaRepository<PasajeModel, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
    // Ejemplo:
    // List<Pasaje> findByOrigen(String origen);
}

