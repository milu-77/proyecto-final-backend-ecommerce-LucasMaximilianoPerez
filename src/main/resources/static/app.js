Vue.createApp({
  data() {
    return {
      botonActivo: 1,
      titulo: "javaadultos-1C2025",
      productos: [],
      carrito: [],
      pedidos: [],
    };
  },
  created() {},
  mounted: function() {
    this.getProductos();
    this.getCarrito();
    this.getPedidos();
  },
  updated: function() {},
  methods: { 
    getProductos: function() {
      axios
        .get(`http://localhost:8080/productos`)
        .then((res) => {
          this.productos = res.data;
          console.log(this.productos);
        })
        .catch((err) => {
          console.error(err);
        });
    },
    accionBoton: function(numeroSeccion) {
      this.botonActivo = numeroSeccion;
    },
    getCarrito: function() {
      axios
        .get(`http://localhost:8080/carritos/1`)
        .then((res) => {
          this.carrito = res.data;
          console.log(this.carrito);
        })
        .catch((err) => {
          console.error(err);
        });
    },
    getPedidos: function() { 
      axios
        .get(`http://localhost:8080/pedidos`)
        .then((res) => {
          this.pedidos = res.data;  
          console.log(this.pedidos);
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
}).mount("#app");