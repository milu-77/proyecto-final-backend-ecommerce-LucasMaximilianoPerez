# proyecto-final-backend-ecommerce-LucasMaximilianoPerez

# 🚀 API Endpoints Documentation

## 📌 Base URL
`http://localhost:8080`

## 👥 Usuario Controller

| Método | Endpoint               | Descripción                          |
|--------|------------------------|--------------------------------------|
| `GET`  | `/usuarios/{id}`       | Obtener usuario por ID               |
| `PUT`  | `/usuarios/{id}`       | Actualizar usuario                   |
| `DELETE`| `/usuarios/{id}`      | Eliminar usuario                     |
| `GET`  | `/usuarios`            | Listar todos los usuarios            |
| `POST` | `/usuarios`            | Crear nuevo usuario                  |

## 🛍️ Producto Controller

| Método | Endpoint                     | Descripción                          |
|--------|------------------------------|--------------------------------------|
| `GET`  | `/productos/{id}`            | Obtener producto por ID              |
| `PUT`  | `/productos/{id}`            | Actualizar producto                  |
| `DELETE`| `/productos/{id}`           | Eliminar producto                    |
| `GET`  | `/productos`                 | Listar todos los productos           |
| `POST` | `/productos`                 | Crear nuevo producto                 |
| `GET`  | `/productos/categoria/{id}`  | Productos por categoría              |
| `GET`  | `/productos/buscar`          | Buscar productos                     |

## 📦 Pedido Controller

| Método | Endpoint                   | Descripción                        |
|--------|----------------------------|------------------------------------|
| `GET`  | `/pedidos/{id}`            | Obtener pedido por ID              |
| `PUT`  | `/pedidos/{id}`            | Actualizar pedido                  |
| `DELETE`| `/pedidos/{id}`           | Eliminar pedido                    |
| `GET`  | `/pedidos`                 | Listar todos los pedidos           |
| `POST` | `/pedidos`                 | Crear nuevo pedido                 |
| `GET`  | `/pedidos/usuario/{id}`    | Pedidos por usuario                |

## 🧩 Item Controller

| Método | Endpoint               | Descripción                        |
|--------|------------------------|------------------------------------|
| `GET`  | `/items/{id}`          | Obtener ítem por ID                |
| `PUT`  | `/items/{id}`          | Actualizar ítem                    |
| `DELETE`| `/items/{id}`         | Eliminar ítem                      |
| `GET`  | `/items`               | Listar todos los ítems             |
| `POST` | `/items`               | Crear nuevo ítem                   |
| `GET`  | `/items/pedidos`       | Ítems de pedidos                   |
| `GET`  | `/items/carritos`      | Ítems de carritos                  |

## 🏷️ Categoria Controller

| Método | Endpoint               | Descripción                        |
|--------|------------------------|------------------------------------|
| `GET`  | `/categorias/{id}`     | Obtener categoría por ID           |
| `PUT`  | `/categorias/{id}`     | Actualizar categoría               |
| `DELETE`| `/categorias/{id}`    | Eliminar categoría                 |
| `GET`  | `/categorias`          | Listar todas las categorías        |
| `POST` | `/categorias`          | Crear nueva categoría              |

## 🛒 Carrito Controller

| Método | Endpoint                           | Descripción                      |
|--------|------------------------------------|----------------------------------|
| `GET`  | `/carritos/{id}`                   | Obtener carrito por ID           |
| `PUT`  | `/carritos/{id}`                   | Actualizar carrito               |
| `DELETE`| `/carritos/{id}`                  | Eliminar carrito                 |
| `POST` | `/carritos/{carritoId}/cerrar`     | Cerrar carrito                   |
| `POST` | `/carritos/crear`                  | Crear nuevo carrito              |
| `GET`  | `/carritos`                        | Listar todos los carritos        |
| `GET`  | `/carritos/usuario/{id}`           | Carritos por usuario             |

## 📖 Documentación interactiva

Explora y prueba la API con nuestra interfaz Swagger:

[![Swagger UI](https://img.shields.io/badge/Swagger-UI-%23Clojure?style=flat-square&logo=swagger)](http://localhost:8080/swagger-ui/index.html)

🔗 [Acceder a Swagger UI](http://localhost:8080/swagger-ui/index.html)

### ¿Qué puedes hacer aquí?
✔ Probar endpoints en vivo  
✔ Ver modelos de datos  
✔ Generar código automáticamente  
✔ Descargar documentación en JSON/YAML

*Requisitos:*  
- El servidor debe estar en ejecución (`http://localhost:8080`)
- Navegador moderno (Chrome, Firefox, Edge)
