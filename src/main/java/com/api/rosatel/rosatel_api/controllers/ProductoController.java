package com.api.rosatel.rosatel_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rosatel.rosatel_api.models.ApiResponse;
import com.api.rosatel.rosatel_api.models.Producto;
import com.api.rosatel.rosatel_api.services.ProductoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/rosatel/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Producto>>> getProductos() {
        List<Producto> productos = productoService.getProductoRepository();
        ApiResponse<List<Producto>> response = new ApiResponse<List<Producto>>(
            "success", 
            "Productos obtenidos exitosamente", 
            productos);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Producto>> getMethodName(@PathVariable Integer id) {
        Producto producto = productoService.getProductoById(id);
        ApiResponse<Producto> response = new ApiResponse<Producto>(
            "success", 
            "Producto obtenido exitosamente", 
            producto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/subcategoria/{idSubCategoria}")
    public ResponseEntity<ApiResponse<List<Producto>>> getProductosBySubCategoria(
            @PathVariable Integer idSubCategoria) {
        List<Producto> productos = productoService.getProductosBySubCategoria(idSubCategoria);
        ApiResponse<List<Producto>> response = new ApiResponse<List<Producto>>(
                "success",
                "Productos obtenidos exitosamente",
                productos);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<ApiResponse<List<Producto>>> getProductosByCategoria(
            @PathVariable Integer idCategoria) {
        List<Producto> productos = productoService.getProductosByCategoria(idCategoria);
        ApiResponse<List<Producto>> response = new ApiResponse<List<Producto>>(
                "success",
                "Productos obtenidos exitosamente",
                productos);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Producto>> createProducto(@RequestBody Producto producto) {
        Producto created = productoService.createProducto(producto);
        ApiResponse<Producto> response = new ApiResponse<Producto>(
            "success",
            "Producto creado exitosamente",
            created);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Producto>> updateProducto(
            @PathVariable Integer id,
            @RequestBody Producto producto) {
        Producto updated = productoService.updateProducto(id, producto);
        ApiResponse<Producto> response = new ApiResponse<Producto>(
            "success",
            "Producto actualizado exitosamente",
            updated);
        return ResponseEntity.ok(response);
    }
    
    
}
