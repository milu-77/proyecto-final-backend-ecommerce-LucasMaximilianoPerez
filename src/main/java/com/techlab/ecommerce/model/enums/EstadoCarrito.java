package com.techlab.ecommerce.model.enums;

public enum EstadoCarrito implements Estado {
    ACTIVO,         // El usuario puede modificarlo
    PENDIENTE_PAGO, // Checkout iniciado pero no confirmado
    ABANDONADO,     // Inactivo por mucho tiempo (ej: >24h)
    CONVERTIDO      // Cuando se transforma en pedido (histórico)
    }
