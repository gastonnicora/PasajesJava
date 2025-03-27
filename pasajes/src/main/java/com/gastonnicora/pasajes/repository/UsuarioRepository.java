package com.gastonnicora.pasajes.repository;

import com.gastonnicora.pasajes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	
	Usuario findByEmailAndBorradoFalse(String email);
	
	Usuario findByUuid(UUID uuid);

}
