package com.corhuila.tienda.IService;

import com.corhuila.tienda.Entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    void update(Producto producto, Long id);
    void delete(Long id);
}
