package com.gastonnicora.pasajes.service;

import com.gastonnicora.pasajes.model.Usuario;
import com.gastonnicora.pasajes.utils.HashPassword;
import com.gastonnicora.pasajes.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    // Crear un nuevo usuario
    public Usuario createUsuario(Usuario usuario) {
        usuario.setPass(HashPassword.hashPassword(usuario.getPass()));
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener usuario por id
    public Usuario getUsuarioByUuid(UUID uuid) {
        return usuarioRepository.findById(uuid).orElse(null);
    }

    // Actualizar usuario
    public Usuario updateUsuario(UUID id, Usuario usuario) {
        Usuario existingUsuario = getUsuarioByUuid(id);
        if (existingUsuario != null) {
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setEmail(usuario.getEmail());
            existingUsuario.setPass(HashPassword.hashPassword(usuario.getPass()));
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setCelular(usuario.getCelular());
            existingUsuario.setCuil(usuario.getCuil());
            existingUsuario.setNacimiento(usuario.getNacimiento());
            existingUsuario.setDni(usuario.getDni());
            
            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }

    // Eliminar usuario
    public boolean deleteUsuario(UUID id) {
        Usuario existingUsuario = getUsuarioByUuid(id);
        if (existingUsuario != null) {
        	existingUsuario.setBorrado(true);
            return true;
        }
        return false;
    }

    // Iniciar sesión (autenticación básica)
    public boolean login(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmailAndBorradoFalse(email);
        if (usuario != null) {
            return HashPassword.checkPassword(password, usuario.getPass());
        }
        return false;
    }
}
