package com.gastonnicora.pasajes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.gastonnicora.pasajes.model.Pasaje;

public interface PasajeRepository extends JpaRepository<Pasaje, Long> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
    // Ejemplo:
    // List<Pasaje> findByOrigen(String origen);
}

