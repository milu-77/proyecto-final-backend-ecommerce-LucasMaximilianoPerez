Vue.createApp({
  data() {
    return {
      botonActivo: 1,
      botonProducto: 1,
      botonCarrito: 1,
      idCarrito: 1,
      idProducto: 2,
      idProductoCarrito: 0,
      idUsuario: 0,
      errorCategorias: true,
      cargandoCategorias: true,
      loading:true,

      url: " https://placehold.co/400x400?text=",

      titulo: "java adultos-1C2025",
      productos: [],
      usuarios: [],
      carritos: [],
      pedidos: [],
      categorias: [],
      productoActual: [],
      nuevoProducto: {
        nombre: "producto nuevo",
        precio: 0,
        stock: 0,
        descripcion: "",
        url: "producto+nuevo",
        categoriaId: 0,
      },
      agregarProductoCarrito: {
        nombre: "",
        precio: 0,
        stock: 0,
      },
      nuevoCarrito: {
        usuario: "",
      },
    };
  },
  created() {},

  watch: {
    // Observador para idProducto
    idProducto(newId, oldId) {
      if (newId && newId !== oldId) {
        this.getProducto(); // Llama a tu función cuando cambia
      }
    },
    idProductoCarrito(newVal, oldVal) {
      console.log("Cambió de", oldVal, "a", newVal);
      this.productoActual =
        this.productos.find((p) => p.id == this.idProductoCarrito) || {};
      this.agregarProductoCarrito.nombre = this.productoActual.nombre;
      this.agregarProductoCarrito.precio = this.productoActual.precio;
    },
    idUsuario(newVal, oldVal) {
      console.log("Cambió de", oldVal, "a", newVal);
      let usuarioActual =
        this.usuarios.find((p) => p.id == this.idUsuario) || {};

      this.nuevoCarrito.usuario = usuarioActual.username;
    },
  },

  mounted: function () {
    this.getProductos();
    this.getCarrito();
    this.getPedidos();
    this.cargarCategorias();
    this.getUsuarios();
  },
  updated: function () {},

  methods: {
    accionBoton: function (numeroSeccion) {
      console.log("numeroSeccion:", numeroSeccion); // Verifica el valor
      this.botonActivo = numeroSeccion;
      this.botonProducto = 1;
      this.getProductos();
    },
    accionProducto: function (numeroSeccion) {
      this.botonProducto = numeroSeccion;
      this.getProductos();
    },
    accioncarrito: function (numeroSeccion) {
      this.botonCarrito = numeroSeccion;
    },
    alerta: function (mensaje) {
      Swal.fire({
        title: "Error!",
        text: mensaje,
        icon: "error",
        confirmButtonText: "Cerrar",
      });
    },
    alertaOk: function (mensaje) {
      Swal.fire({
        title: "OK!",
        text: mensaje,
        icon: "success",
        confirmButtonText: "Cerrar",
      });
    },

    buscarProducto: function () {
      return this.productos.find((item) => item.id === this.idCarrito);
    },
    async getProductos() {
      try {
        const res = await axios.get(`http://localhost:8080/productos`);

        this.productos = res.data;
      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async getCarrito() {
      try {
        const res = await axios.get(`http://localhost:8080/carritos`);

        this.carritos = res.data;
      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async getPedidos() {
      try {
        const res = await axios.get(`http://localhost:8080/pedidos`);

        this.pedidos = res.data;
      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async getProducto() {
      try {
        const res = await axios.get(
          `http://localhost:8080/productos/${this.idProducto}`
        );

        this.nuevoProducto.nombre = res.data.nombre;
        this.nuevoProducto.precio = res.data.precio;
        this.nuevoProducto.stock = res.data.stock;
        this.nuevoProducto.descripcion = res.data.descripcion;
        this.nuevoProducto.url = res.data.url;
      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async agregarProducto() {
      this.loading = true;
      this.nuevoProducto.url = this.url + this.nuevoProducto.url;
      try {
        const res = await axios.post(
          "http://localhost:8080/productos",
          this.nuevoProducto
        );
        this.alertaOk(res.data?.message || 'Operación completada');
       } catch (err) {
        this.alerta(err.response?.data.message);
      } finally {
        this.loading = false;
      }
    },
    async agregarProductoAlCarrito() {
      try {
        const res = await axios.put(
          `http://127.0.0.1:8080/carritos/${this.idCarrito}`,
          this.agregarProductoCarrito
        );
        this.alertaOk(res.data?.message || 'Operación completada');

        this.getCarrito();
      } catch (err) {
        this.alerta(err.response?.data.message);
      } finally {
        this.loading = false;
      }
    },
    async modificarProducto() {
      this.loading = true;
      this.nuevoProducto.url = this.url + this.nuevoProducto.url;
      try {
        const res = await axios.put(
          `http://localhost:8080/productos/${this.idProducto}`,
          this.nuevoProducto
        );
        this.alertaOk(res.data?.message || 'Operación completada');

      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async cargarCategorias() {
      this.loadingCategorias = true;
      try {
        const res = await axios.get("http://localhost:8080/categorias"); // Endpoint de tu API
        this.categorias = res.data;
        this.cargandoCategorias = false;
      } catch (err) {
        this.alerta(err.response?.data.message);
      } finally {
        this.loadingCategorias = false;
      }
    },
    async eliminarProducto() {
      try {
        const res = await axios.delete(
          `http://localhost:8080/productos/${this.idProducto}`
        );

        this.alertaOk(res.data?.message || 'Operación completada');
      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async getUsuarios() {
      try {
        const res = await axios.get(`http://localhost:8080/usuarios`);

        this.usuarios = res.data;
 
      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },

    async cerrarCarrito() {
      try {
        const res = await axios.post(
          `http://127.0.0.1:8080/carritos/${this.idCarrito}/cerrar`
        );
        this.alertaOk(res.data?.message || 'Operación completada');
        this.getCarrito();
        this.getPedidos();

      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async crearCarrito() {
      this.nuevoCarrito;
      try {
        const res = await axios.post(
          `http://127.0.0.1:8080/carritos/crear`,
          this.nuevoCarrito
        );
        this.alertaOk(res.data?.message || 'Operación completada');
        this.getCarrito();
      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
    async cargarPedidos() {
      this.loadingCategorias = true;
      try {
        const res = await axios.get("http://localhost:8080/pedidos"); // Endpoint de tu API
        this.pedidos = res.data;
                this.alerta(err.response?.data.message);

      } catch (err) {
        this.alerta(err.response?.data.message);
      }
    },
  },
}).mount("#app");
