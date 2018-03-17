$(document).ready(function() {
	var table = $('#tabel-data').DataTable({
		ajax : {
			url : 'rest/customer/all',
			dataSrc : ''
		},
		columns : [ {
			data : 'idCustomer'
		}, {
			data : 'namaCustomer'
		}, {
			data : 'tempatLahir'
		}, {
			data : 'tanggalLahir'
		}, {
			data : 'pekerjaan'
		}, {
			data : 'alamat'
		}, {
			data : null,
			render : function(data, type, row, meta) {
				return '<a id="btn-update" class="btn btn-primary">Ubah</a>&nbsp;<a id="btn-delete" class="btn btn-danger">Hapus</a>';
			}
		} ]
	});
	
	//Aksi saat klik tombol update
	$('#tabel-data tbody').on('click', '#btn-update', function() {
		var data = table.row($(this).parents('tr')).data();
		
		localStorage.clear();
		
		//Menyimpan data untuk update
		localStorage.setItem("idCustomer",data.idCustomer);
		localStorage.setItem("namaCustomer",data.namaCustomer);
		localStorage.setItem("tempatLahir",data.tempatLahir);
		localStorage.setItem("tanggalLahir",data.tanggalLahir);
		localStorage.setItem("pekerjaan",data.pekerjaan);
		localStorage.setItem("alamat",data.alamat);
		
		//Pindah ke url update
		window.location.href = '/update';
	});

	//Aksi saat klik tombol delete
	$('#tabel-data tbody').on('click', '#btn-delete', function() {
		
		var data = table.row($(this).parents('tr')).data();
		//variable konfirmasi
		var msg = confirm("Apakah anda ingin menghapus data?");
		if(msg == true){
			var settings = {
					"async" : true,
					"crossDomain" : true,
					"url" : "/rest/customer/delete",
					"method" : "POST",
					"headers" : {
						"content-type" : "application/json",
						"cache-control" : "no-cache"
					},
					"processData" : false,
					"data" : data.idCustomer
				}

				$.ajax(settings).done(function(response) {
					//Refresh DataTables
					table.ajax.reload();
				});
		}
	});

});