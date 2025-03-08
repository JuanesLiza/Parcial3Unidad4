package com.ejemplo.pedidos.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private String id; // Identificador único del pedido
    private String descripcion; // Descripción del producto en el pedido
    private double precio; // Precio del producto en el pedido
}