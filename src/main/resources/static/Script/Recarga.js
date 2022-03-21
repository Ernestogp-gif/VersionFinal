function BtnRecargar(){
	var monto = document.getElementById('rec').value;
	var ruc = "12876543928";//document.getElementById('').value;
	var data = monto + "-" + ruc;
	console.log(data);
	$.ajax({
	url: 'http://localhost:8080/Recarga/ConfirmarRecarga',
	type: 'POST',
	dataType:'text',
	data: JSON.stringify(data),
	contentType: "application/json; charset=utf-8",
	success: function(json){
		document.getElementById('Saldo').innerText = json;
      },
      	    error: function(xhr, statusText, errorThrown){
			console.log(xhr);
			console.log(statusText);
			console.log(errorThrown);
			console.warn(xhr.responseText)
        }
	});
}


window.onload = TraerSaldo();

function TraerSaldo(){
	
	var data = "12876543928";//document.getElementById('').value;
	$.ajax({
	url: 'http://localhost:8080/api/Saldo',
	type: 'POST',
	dataType:'text',
	data: JSON.stringify(data),
	contentType: "application/json; charset=utf-8",
	success: function(json){
		document.getElementById('Saldo').innerText = json;
      },
      	    error: function(xhr, statusText, errorThrown){
			console.log(xhr);
			console.log(statusText);
			console.log(errorThrown);
			console.warn(xhr.responseText)
        }
	});
}



