package com.backEnd.Tecnolo.repository;

import com.backEnd.Tecnolo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Usuario_Repository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndNome(String email, String nome);
}
