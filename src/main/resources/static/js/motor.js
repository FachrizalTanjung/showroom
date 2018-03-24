$(document).ready(function() {
	
	//Menampilkan data untuk di update motor
	$('#idMotor').val(localStorage.getItem("idMotor"));
	$('#bebek').val(localStorage.getItem("bebek"));
	$('#matic').val(localStorage.getItem("matic"));
	$('#sport').val(localStorage.getItem("sport"));
	
	localStorage.clear();
	
	//Jquery untuk simpan motor
	$("#btn-save").click(function(event) {
		inputMotor();
		alert("Berhasil Simpan");
		window.location.reload();
	});

	//Jquery untuk update motor
	$("#btn-update").click(function(event) {
		inputMotor();
		alert("Berhasil Update");
	});

});

//Function Insert atau Update Motor
function inputMotor() {

	var data = {
		"idMotor" : $("#idMotor").val(),
		"bebek" : $("#bebek").val(),
		"matic" : $("#matic").val(),
		"sport" : $("#sport").val()
	}

	var settings = {
		"async" : true,
		"crossDomain" : true,
		"url" : "http://localhost:20000/rest/motor/insertMotor",
		"method" : "POST",
		"headers" : {
			"content-type" : "application/json",
			"cache-control" : "no-cache"
		},
		"processData" : false,
		"data" : JSON.stringify(data)
	}

	$.ajax(settings).done(function(response) {
		
	});
}