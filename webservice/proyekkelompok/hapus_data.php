<?php 
$id_kar= $_POST['id_kar'];
	require_once ('setting_server.php');

		$sql ="DELETE from pendaftaran where id = $id_kar;";
		if(mysqli_query($con,$sql)){
			echo "Berhasil";

		}else
		echo "gagal";
	
?>