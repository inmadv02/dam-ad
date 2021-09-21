package com.example.demo.servicios;

import com.example.demo.modelo.Prenda;
import com.example.demo.repos.PrendaRepositorio;
import com.example.demo.servicios.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PrendaServicio extends BaseService <Prenda, Long, PrendaRepositorio> {

    public PrendaServicio(PrendaRepositorio repo) {
        super(repo);
    }
}
