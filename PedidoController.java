package com.ejemplo.pedidos.controller;
import com.ejemplo.pedidos.model.Pedido;
import com.ejemplo.pedidos.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Locale;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired // Inyección automática del servicio de pedidos
    private PedidoService pedidoService;

    @Autowired // Inyección automática del servicio de internacionalización de mensajes
    private MessageSource messageSource;

    @GetMapping
    public Flux<Pedido> listarPedidos() {
        return pedidoService.obtenerPedidos(); // Retorna los pedidos almacenados
    }

    @PostMapping
    public Mono<String> crearPedido(@RequestBody Pedido pedido, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return pedidoService.crearPedido(pedido) // Crea el pedido y devuelve el mensaje traducido
                .map(p -> messageSource.getMessage("pedido.creado", null, locale));
    }
}
