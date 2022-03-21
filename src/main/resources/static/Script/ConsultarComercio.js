window.onload=function() {
	GenerarReportePagos();
}

function GenerarReportePagos(){

    $.ajax({
        url: 'http://localhost:8080/Reportes/ConsultarPagos',
        type: 'GET',
        dataType:'json',
        contentType: "application/json; charset=utf-8",
        success: function(json){
			TblCuerpo = document.getElementById("TblCuerpo");
        	for(var i in json){	
    			TblCuerpo.innerHTML = TblCuerpo.innerHTML + "<th>" + json[i].fecha + "</th>" 
									    			+ "<th>" + json[i].cod + "</th>" 
									    			+ "<th>" + json[i].servicio + "</th>" 
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



function GenerarReportePagosxfechas(){
	
	var fecha1 = document.getElementById('fecini').value;
	var fecha2 = document.getElementById('fecfin').value;
	console.log(fecha1);
		fecha1 = fecha1.replace('-','/');
	fecha1 = fecha1.substring(8,10) + "m" + fecha1.substring(5,7) + "m" + fecha1.substring(0,4);
	fecha2 = fecha2.replace('-','/');
	fecha2 = fecha2.substring(8,10) + "m" + fecha2.substring(5,7) + "m" + fecha2.substring(0,4);
	var data = fecha1+"-"+fecha2
	console.log(fecha1+"-"+fecha2);
    $.ajax({
        url: 'http://localhost:8080/Reportes/ConsultarPagosxfecha',
        type: 'POST',
        dataType:'json',
        data: data,
        contentType: "application/json; charset=utf-8",
        success: function(json){
			
			TblCuerpo = document.getElementById("TblCuerpo");
			TblCuerpo.innerHTML = "";
        	for(var i in json){	
    			TblCuerpo.innerHTML = TblCuerpo.innerHTML + "<th>" + json[i].fecha + "</th>" 
									    			+ "<th>" + json[i].cod + "</th>" 
									    			+ "<th>" + json[i].servicio + "</th>" 
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


function GenerarReportePagosxServicio(){
	var selectElement = document.getElementById('Seleccion');

	var text = selectElement.options[selectElement.selectedIndex].innerText;
	
	console.log(text);
	var data = text;
	$.ajax({ 
	url: 'http://localhost:8080/Reportes/ConsultarPagosxServicio',
	type: 'POST',
	dataType:'json',
	data: data,
	contentType: "application/json; charset=utf-8",
	success: function(json){
			console.log(json);
			TblCuerpo = document.getElementById("TblCuerpo");
			TblCuerpo.innerHTML = "";
        	for(var i in json){	
    			TblCuerpo.innerHTML = TblCuerpo.innerHTML + "<th>" + json[i].fecha + "</th>" 
									    			+ "<th>" + json[i].cod + "</th>" 
									    			+ "<th>" + json[i].servicio + "</th>" 
									    			+ "<th>" + json[i].monto + "</th>" 
				
    		}
		
      },
      	    error: function(xhr, statusText, errorThrown){
			console.log(xhr)
        }	
	});	
}







