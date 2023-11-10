package br.com.almeida.producerservice.controllers;

import br.com.almeida.producerservice.services.ProductService;
import br.com.almeida.producerservice.services.StringService;
import dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) {
        service.createProduct(dto);
        return ResponseEntity.status(CREATED).build();
    }

}
