package com.prav.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prav.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
