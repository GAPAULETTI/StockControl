Vue.createApp({
    data(){
        return{
            formData: {
                name: '',
                description: '',
                price: '',
                stock: '',

                image: null
            },
            errorMsg: null,
        }
    },
    methods: {
        handleImageUpload(){
        this.formData.image = this.$refs.uploadImage.files[0];

    },
    submitForm(){
        let formData = new FormData();
        formData.append('name', this.formData.name);
        formData.append('description', this.formData.description);
        formData.append('price', this.formData.price);
        formData.append('stock', this.formData.stock);
        formData.append('image', this.formData.image);

        axios.post('/api/products', formData,{
            headers: {
                'Content-Type' : 'multipart/form-data'
            }
        })
        .then(response => {
            console.log(response.data);
        })
        .catch(error =>{
                this.errorMsg = error.response.data;
                this.errorToats.show();
                console.log(error);
        })
    },
    },
     mounted: function (){
            this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
    }
}).mount("#app")