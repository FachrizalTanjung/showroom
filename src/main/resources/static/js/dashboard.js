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
		
		
	});

	//Aksi saat klik tombol delete
	$('#tabel-data tbody').on('click', '#btn-delete', function() {
		
		
	});

});