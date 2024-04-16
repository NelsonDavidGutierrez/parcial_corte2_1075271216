package com.corhuila.tienda.Controller;

import com.corhuila.tienda.Entity.Producto;
import com.corhuila.tienda.IService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/producto")
@Controller
public class ProductoController {

    //Inyectar el servicio
    @Autowired
    private IProductoService service;

    @GetMapping()
    public List<Producto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Producto save(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Producto producto, @PathVariable Long id) {
        service.update(producto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
