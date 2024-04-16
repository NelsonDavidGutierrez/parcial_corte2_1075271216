package com.corhuila.tienda.Service;

import com.corhuila.tienda.Entity.Categoria;
import com.corhuila.tienda.IRepository.ICategoriaRepository;
import com.corhuila.tienda.IService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private ICategoriaRepository repository;

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Categoria categoria, Long id) {

        Optional<Categoria> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){

            Categoria categoriaUpdate = ps.get();
            categoriaUpdate.setNombre(categoriaUpdate.getNombre());
            categoriaUpdate.setDescripcion(categoriaUpdate.getDescripcion());
            categoriaUpdate.setProducto(categoriaUpdate.getProducto());

            //Actualizar el objeto persona
            repository.save(categoriaUpdate);
        }else{
            System.out.println("No existe la categoria");
        }
    }
}
