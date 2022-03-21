window.onload=function() {
	GenerarReporteEmpresa();
}

function GenerarReporteEmpresa(){
    $.ajax({
        url: 'http://localhost:8080/ReporteEmpresa/ConsultarTransacciones',
        type: 'GET',
        dataType:'json',
        contentType: "application/json; charset=utf-8",
        success: function(json){

			ReporteEmpresa = document.getElementById("ReporteEmpresa");
        	for(var i in json){	
    			ReporteEmpresa.innerHTML = ReporteEmpresa.innerHTML + "<th>" + json[i].cod + "</th>" 
									    			+ "<th>" + json[i].fecha + "</th>" 
									    			+ "<th>" + json[i].monto + "</th>" 
									    			+ "<th>" + json[i].tipopago + "</th>" 
									    			+ "<th>" + json[i].nombre + "</th>" 
									    			+ "<th>" + json[i].tipocomercio + "</th>" 
									    			+ "<th>" + json[i].distrito + "</th>" 
									    			+ "<th>" + json[i].departamento + "</th>" 
									    			+ "<th>" + json[i].servicio + "</th>" 
    		}
          },
            error: function(xhr, statusText, errorThrown){
                console.log(xhr);
                console.log(statusText);
                console.log(errorThrown);
            }
        });        
console.log("asdfs");
}