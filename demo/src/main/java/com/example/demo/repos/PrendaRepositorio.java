package com.example.demo.repos;

import com.example.demo.modelo.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrendaRepositorio extends JpaRepository <Prenda, Long> {
}
