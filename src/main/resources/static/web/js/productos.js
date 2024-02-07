Vue.createApp({
    data(){
    return {
            productsInfo: {},
            productList: [],
            errorToats: null,
            errorMsg: null,
    }

    },
    methods: {
        getData: function(){
            axios.get("/api/products")
                .then((response) => {
                    this.productsInfo = response.data;
                    console.log(response.data)


                })
                .catch((error)=> {
                    this.errorMsg = error.response.data;
                    this.errorToats.show();
                })
               }
        },
        mounted: function(){
            this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
            this.getData();
        }

}).mount('#products')