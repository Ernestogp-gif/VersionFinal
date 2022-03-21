window.onload=function() {
	GenerarReporteRecargas()
}


function GenerarReporteRecargas(){

    $.ajax({
        url: 'http://localhost:8080/Reportes/ConsultarRecargas',
        type: 'GET',
        dataType:'json',
        contentType: "application/json; charset=utf-8",
        success: function(json){
			TblCuerpoRecarga = document.getElementById("TblCuerpoRecarga");
        	for(var i in json){	
    			TblCuerpoRecarga.innerHTML = TblCuerpoRecarga.innerHTML + "<th>" + json[i].fecha + "</th>" 
									    			+ "<th>" + json[i].codigo + "</th>" 
									    			+ "<th>" + json[i].monto + "</th>" 
    		}
          },
                  error: function(xhr, statusText, errorThrown){
                console.log(xhr);
                console.log(statusText);
                console.log(errorThrown);
            }
        });
}



function GenerarReporteRecargaxfechas(){
	
	var fecha1 = document.getElementById('fecini').value;
	var fecha2 = document.getElementById('fecfin').value;
		fecha1 = fecha1.replace('-','/');
	fecha1 = fecha1.substring(8,10) + "m" + fecha1.substring(5,7) + "m" + fecha1.substring(0,4);
	fecha2 = fecha2.replace('-','/');
	fecha2 = fecha2.substring(8,10) + "m" + fecha2.substring(5,7) + "m" + fecha2.substring(0,4);
	var data = fecha1+"-"+fecha2
    $.ajax({
        url: 'http://localhost:8080/Reportes/ConsultarRecargasxfecha',
        type: 'POST',
        dataType:'json',
        data: data,
        contentType: "application/json; charset=utf-8",
        success: function(json){
			
			TblCuerpoRecarga = document.getElementById("TblCuerpoRecarga");
			TblCuerpoRecarga.innerHTML = "";
        	for(var i in json){	
    			TblCuerpoRecarga.innerHTML = TblCuerpoRecarga.innerHTML + "<th>" + json[i].fecha + "</th>" 
									    			+ "<th>" + json[i].codigo + "</th>" 
									    			+ "<th>" + json[i].monto + "</th>" 
				
    		}
          },
                  error: function(xhr, statusText, errorThrown){
                console.log(xhr);
                console.log(statusText);
                console.log(errorThrown);
            }
        });
}

