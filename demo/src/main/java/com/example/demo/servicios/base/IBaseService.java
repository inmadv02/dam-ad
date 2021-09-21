package com.example.demo.servicios.base;

import java.util.List;

public interface IBaseService <T, ID>{

    void delete (T t);

    T save (T t);

    T edit (T t);

    T findById(ID id);

    List<T> findAll();

    void deleteById(ID id);
}
