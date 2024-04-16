package com.corhuila.tienda.IRepository;

import com.corhuila.tienda.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {
}
