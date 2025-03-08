package com.ejemplo.pedidos.Service;
import com.ejemplo.pedidos.model.Pedido;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private List<Pedido> pedidos = new ArrayList<>(); // Lista que almacena los pedidos en memoria

    public Flux<Pedido> obtenerPedidos() {
        return Flux.fromIterable(pedidos); // Retorna la lista de pedidos como un flujo reactivo
    }

    public Mono<Pedido> crearPedido(Pedido pedido) {
        pedido.setId(UUID.randomUUID().toString()); // Genera un ID único para el pedido
        pedidos.add(pedido); // Agrega el pedido a la lista
        return Mono.just(pedido); // Retorna el pedido envuelto en un Mono
    }

}
