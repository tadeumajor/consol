$( document ).ready(function() {
    $("#formLogin").on("submit", function(){
        let email = $("#inputEmail").val();
        let password = $("#inputPassword").val();
        realizarLogin(email, password);
        return false;
    });

    function realizarLogin(email, password) {
        axios.post('http://localhost:8080/usuarios/login', {
            email: email,
            password: password,
            })
            .then(response => { 
                $("#msgLogin").removeAttr("hidden");
                
                if(response.data.status == 200){
                    $("#msgLogin").attr("class", "alert alert-primary");
                    $("#msgLogin").text(response.data.message);
                } else {
                    $("#msgLogin").attr("class", "alert alert-danger");
                    $("#msgLogin").text(response.data.message);
                }
            })
            .catch(erro => {
                $("#msgLogin").removeAttr("hidden");
                $("#msgLogin").text(erro.response.data.message);
            });
    }
});
