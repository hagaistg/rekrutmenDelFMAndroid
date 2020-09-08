<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		// $id_mhs = $_POST['id_mhs'];
		$namalengkap_kar = $_POST['namalengkap_kar'];
		$email_kar = $_POST ['email_kar'];
		$umur_kar = $_POST['umur_kar'];
		$tgllahir_kar = $_POST ['tgllahir_kar'];
		$alamat_kar = $_POST['alamat_kar'];
		$notlpl_kar = $_POST ['notlpl_kar '];
		$jeniskelamin_kar = $_POST['jeniskelamin_kar'];
		$pendidikan_kar = $_POST ['pendidikan_kar'];
		$pengalaman_kar = $_POST['pengalaman_kar'];
		$posisi_kar = $_POST ['posisi_kar'];
		$motivasi_kar = $_POST['motivasi_kar '];
		

	require_once ('setting_server.php');

		$sql ="INSERT INTO pendaftaran (namalengkap,email,umur,tgllahir,alamat,notlp,jeniskelamin,pendidikan,pengalaman,posisi,motivasi ) VALUES ('$namalengkap_kar', '$email_kar',
		'$umur_kar','$tgllahir_kar','$alamat_kar','$notlpl_kar','$jeniskelamin_kar', '$pendidikan_kar','$pengalaman_kar','$posisi_kar', '$motivasi_kar')";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	}
	?>