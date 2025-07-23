Vue.createApp({
  data() {
    return {
      botonActivo: 1,
      botonProducto: 1,
      idProducto:2,
      url: " https://placehold.co/400x400?text=",

      titulo: "java adultos-1C2025",
      productos: [],
      carrito: [],
      pedidos: [],
      nuevoProducto: {
        nombre: "producto nuevo",
        precio: 0,
        stock: 0,
        descripcion: "",
        url: "producto+nuevo",
        categoriaId: 0,
      },
        





      categorias: [],
    };
  },
  created() {},
  
   watch: {
    // Observador para idProducto
    idProducto(newId, oldId) {
      if (newId && newId !== oldId) {
        this.getProducto(); // Llama a tu función cuando cambia
      }
    }
  },
       
    
  mounted: function () {
    this.getProductos();
    this.getCarrito();
    this.getPedidos();
    this.cargarCategorias();
   },
  updated: function () {},
  methods: {
    getProductos: function () {
      axios
        .get(`http://localhost:8080/productos`)
        .then((res) => {
          this.productos = res.data;
        })
        .catch((err) => {
          console.error(err);
        });
    },
    accionBoton: function (numeroSeccion) {
      this.botonActivo = numeroSeccion;
      this.botonProducto = 1;
      this.getProductos();
    },
    accionProducto: function (numeroSeccion) {
      this.botonProducto = numeroSeccion;
      this.getProductos();
    },
    getCarrito: function () {
      axios
        .get(`http://localhost:8080/carritos/1`)
        .then((res) => {
          this.carrito = res.data;
        })
        .catch((err) => {
          console.error(err);
        });
    },
    async agregarProducto() {
      this.loading = true;
      this.nuevoProducto.url = this.url + this.nuevoProducto.url;
      try {
        const response = await axios.post(
          "http://localhost:8080/productos",
          this.nuevoProducto
        );
        console.log(response.data.message);
      } catch (error) {
        console.error("Error:", error.response?.data.message);
      } finally {
        this.loading = false;
      }
    },
    async modificarProducto() {
      this.loading = true;
      this.nuevoProducto.url = this.url + this.nuevoProducto.url;
      try {
        const response = await axios.put(
          `http://localhost:8080/productos/${this.idProducto}`,
          this.nuevoProducto
        );
        console.log(response.data.message);
      } catch (error) {
        console.error("Error:", error.response?.data.message);
      } finally {
        this.loading = false;
      }
    },
    async cargarCategorias() {
      this.loadingCategorias = true;
      try {
        const response = await axios.get("http://localhost:8080/categorias"); // Endpoint de tu API
        this.categorias = response.data;
      } catch (error) {
        console.error("Error cargando categorías:", error);
      } finally {
        this.loadingCategorias = false;
      }
    },

    getPedidos: function () {
      axios
        .get(`http://localhost:8080/pedidos`)
        .then((res) => {
          this.pedidos = res.data;
        })
        .catch((err) => {
          console.error(err);
        });
    },
  async getProducto() 
  {
      await axios
        .get(`http://localhost:8080/productos/${this.idProducto}`)
        .then((res) => {
        
        this.nuevoProducto.nombre=res.data.nombre;
        this.nuevoProducto.precio=res.data.precio;
        this.nuevoProducto.stock=res.data.stock;
        this.nuevoProducto.descripcion=res.data.descripcion;
        this.nuevoProducto.url=res.data.url;

         })
        .catch((err) => {
          console.error("Error:", err.response?.data.message);

        });

    },
    async eliminarProducto() {
      await  axios
        .delete(`http://localhost:8080/productos/${this.idProducto}`)
        .then((res) => {        
        console.log(res.data.message);
         })
        .catch((err) => {
          console.error("Error:", err.response?.data.message);
        });

    },









  },
}).mount("#app");
