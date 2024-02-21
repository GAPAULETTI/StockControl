Vue.createApp({
    data() {
        return {
            product : {},
            productId : 0,
            productName: "",
            productDescription: "",
            productPrice: 0,
            productStock: 0,
            image: null,
            errorMsg: null

        }
    },

    methods: {
        getData: function(){
            axios.get(`/api/products`)
                .then((response) =>{
                    this.product = response.data;
                    console.log(this.product)
                }).catch((error)=>{
                    console.log(error)
                    this.errorMsj = error.response.status;
                })

        },
         onImageUpload() {
              let file = this.$refs.uploadImage.files[0];
              this.image = new Image();
              this.image.append("file", file);

          },
        submitForm: function() {
            let config = {
                headers: {
                    'Content-Type' : 'multipart/form-data'
                }
            }
            axios.post(`/api/products?name=${this.productName}&description=${this.productDescription}&price=${this.productPrice}&stock=${this.productStock}&image=${this.image}`,config)
            //axios.post(`/api/products?name=${this.productName}&description=${this.productDescription}&price=${this.productPrice}&stock=${this.productStock}`,config)
            .then(response => {
                console.log(JSON.stringify(response.data));
            }).catch(error => {
                this.errorMsg = error.response.data;
                this.errorToats.show();
                console.log(error)
            })
        },
    },
    mounted: function (){
        this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
        this.getData();
    }
}).mount("#app")