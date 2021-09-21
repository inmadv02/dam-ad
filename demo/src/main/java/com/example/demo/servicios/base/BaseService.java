package com.example.demo.servicios.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class BaseService <T, ID, R extends JpaRepository<T, ID>> implements IBaseService <T, ID> {

    @Autowired
    protected R repositorio;

    public BaseService(R repo){
        this.repositorio = repo;

    }

    public void delete (T t){
        repositorio.delete(t);
    }

    public T save (T t){
        return repositorio.save(t);
    }

    @Override
    public T edit(T t) {
        return repositorio.save(t);
    }

    @Override
    public List<T> findAll() {
        return repositorio.findAll();
    }

    @Override
    public T findById(ID id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void deleteById(ID id) {

    }
}
