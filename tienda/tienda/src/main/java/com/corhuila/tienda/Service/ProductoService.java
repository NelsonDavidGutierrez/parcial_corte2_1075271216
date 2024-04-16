package com.corhuila.tienda.Service;

import com.corhuila.tienda.Entity.Producto;
import com.corhuila.tienda.IRepository.IProductoRepository;
import com.corhuila.tienda.IService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository repository;

    @Override
    public List<Producto> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Producto producto, Long id) {

        Optional<Producto> ps = repository.findById(id);

        //Cargar nuevo objeto
        if (!ps.isEmpty()){

            Producto productoUpdate = ps.get();
            productoUpdate.setNombre(productoUpdate.getNombre());
            productoUpdate.setPrecio(productoUpdate.getPrecio());

            //Actualizar el objeto persona
            repository.save(productoUpdate);
        }else{
            System.out.println("No existe el producto");
        }
    }
}
