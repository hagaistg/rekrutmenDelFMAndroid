<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		// $id_mhs = $_POST['id_mhs'];
		$nama_kar = $_POST['nama_kar'];
		$email_kar = $_POST ['email_kar'];
		$username_kar = $_POST['username_kar'];
		$password_kar = $_POST ['password_kar'];
		

	require_once ('setting_server.php');

		$sql ="INSERT INTO user (nama,email,username,password,role ) VALUES ('$nama_kar', '$email_kar',
		'$username_kar','$password_kar','2')";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	}
	?>