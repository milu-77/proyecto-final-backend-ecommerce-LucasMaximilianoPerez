package com.techlab.ecommerce.model;

public enum EstadoPedido implements Estado {
    PENDIENTE_PAGO,   // Creado pero no pagado
    EN_PREPARACION,   // Pago confirmado, preparando envío
    ENVIADO,          // En camino
    ENTREGADO,        // Completado
    CANCELADO,        // Reembolsado/Anulado
    RECLAMO           // Problema post-entrega
}
