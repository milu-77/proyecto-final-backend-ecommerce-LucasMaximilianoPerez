Vue.createApp({
  data() {
    return {
      botonActivo: 1,
      botonProducto:1,
      url:" https://placehold.co/400x400?text=",

      titulo: "java adultos-1C2025",
      productos: [],
      carrito: [],
      pedidos: [],
        nuevoProducto: {
        nombre: 'producto nuevo',
        precio: 0,
        stock: 0,
        descripcion: '',
        url: 'producto+nuevo'
      },
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
         })
        .catch((err) => {
          console.error(err);
        });
    },
    accionBoton: function(numeroSeccion) {
      this.botonActivo = numeroSeccion;
      this.botonProducto = 1;
      this.getProductos();
    },
    accionProducto: function(numeroSeccion) {
      this.botonProducto = numeroSeccion;
      this.getProductos();
    },
    getCarrito: function() {
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
      this.nuevoProducto.url=this.url+this.nuevoProducto.url
      try {
        const response = await axios.post(
          'http://localhost:8080/productos',
          this.nuevoProducto
        );
        console.log( response.data.message);
      } catch (error) {
        console.error('Error:', error.response?.data.message);
      } finally {
        this.loading = false;
      }















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