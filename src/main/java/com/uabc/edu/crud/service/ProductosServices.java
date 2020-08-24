package com.uabc.edu.crud.service;

import com.uabc.edu.crud.entity.Producto;
import com.uabc.edu.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductosServices {
    @Autowired
    ProductoRepository repo;

    public Producto registrarProducto(Producto producto) {

        Producto proSaved = repo.save(producto);
        return proSaved;
    }

    //de un listado
    public void editarProducto(long id) {

        Producto producto = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid product Id:" + id));
        //Todo enviar a la vista HTML en objeto a editar un model

    }

    //Este usuario proviene de un formulario en edicion
    public void actualizarProducto(Producto producto) {
        repo.save(producto);
    }


    public void eliminarProducto(long id) {
        Producto producto = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid user Id:" + id));
        repo.delete(producto);
    }

    public List<Producto> obtenerTodosProductos() {
        List<Producto> actualList = new ArrayList<Producto>();
        repo.findAll().forEach(actualList::add);
        return actualList;
    }

    public Producto obtenerProductoPorId(long id) {

        return repo.findById(id).get();

    }


}
