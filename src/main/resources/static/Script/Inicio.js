function BtnIngresar(){

	var correo = document.getElementById('corrinput').value;
	var pass = document.getElementById('continput').value;
	data = correo + "-" + pass;
	console.log(data);
    $.ajax({ 
        url: 'http://localhost:8080/ValidarUsuario',
        type: 'POST',
        dataType:	"text",
        data: JSON.stringify(data),	
        contentType: "application/json; charset=utf-8",
            error: function(xhr, statusText, errorThrown){
                console.log(xhr)
                console.log(statusText)
                console.log(errorThrown)
            },
            success: function(json){
				console.log(json);
				if (json != ""){
					console.log(json);
					window.open('http://localhost:8080/index', "_self");
				}
          }
    });
}

function BtnActualizar(){
    window.location.href = "ActualizarContrasena.html";
}

function Comparar(){
    var cont1 = document.getElementById("ncontinput1").value;
    var cont2 = document.getElementById("ncontinput2").value;
    console.log(cont1);
    if(cont1 == cont2){
        document.getElementById("helpId").innerHTML = "<small id="+"helpId"+" class="+"form-text text-muted"+">ContraseÃ±as coinciden</small>";
    }else{
        document.getElementById("helpId").innerHTML = "<small id="+"helpId"+" class="+"form-text text-muted"+">ContraseÃ±as no coinciden</small>";
    }
}

function BtnConfirmar(){
    $.ajax({ 
        url: 'http://localhost:8080/api/ValidarUsuario',
        type: 'GET',								
        dataType:	"json",	
        contentType: "application/json; charset=utf-8",
            error: function(xhr, statusText, errorThrown){
                console.log(xhr)
                console.log(statusText)
                console.log(errorThrown)
            },				
            success: function(json){
                var correo = document.getElementById("corrinput").value;
                var pass = document.getElementById("continput").value;
                var ncont1 = document.getElementById("ncontinput1").value;
                var ncont2 = document.getElementById("ncontinput2").value;
                console.log(correo);  		
          }
    });
}

function BtnCancelar(){
    window.location.href = "Inicio.html";
}