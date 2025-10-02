package com.prav.BancodeDadosPID.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prav.BancodeDadosPID.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
