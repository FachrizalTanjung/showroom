$(document).ready(function() {
	
	//Menampilkan data untuk di update
	$('#idCustomer').val(localStorage.getItem("idCustomer"));
	$('#namaCustomer').val(localStorage.getItem("namaCustomer"));
	$('#tempatLahir').val(localStorage.getItem("tempatLahir"));
	$('#tanggalLahir').val(localStorage.getItem("tanggalLahir"));
	$('#pekerjaan').val(localStorage.getItem("pekerjaan"));
	$('#alamat').val(localStorage.getItem("alamat"));
	
	localStorage.clear();
	
	//Jquery untuk simpan customer
	$("#btn-save").click(function(event) {
		inputCustomer();
		alert("Berhasil Simpan");
		window.location.reload();
	});

	//Jquery untuk update customer
	$("#btn-update").click(function(event) {
		inputCustomer();
		alert("Berhasil Update");
	});

});

//Function Insert atau Update Customer
function inputCustomer() {

	var data = {
		"idCustomer" : $("#idCustomer").val(),
		"namaCustomer" : $("#namaCustomer").val(),
		"tempatLahir" : $("#tempatLahir").val(),
		"tanggalLahir" : $("#tanggalLahir").val(),
		"pekerjaan" : $("#pekerjaan").val(),
		"alamat" : $("#alamat").val()
	}

	var settings = {
		"async" : true,
		"crossDomain" : true,
		"url" : "http://localhost:8082/rest/customer/insert",
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