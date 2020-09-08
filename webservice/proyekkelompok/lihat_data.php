<?php

	require_once 'setting_server.php';

	$query = "Select * from pendaftaran";

	$sql = mysqli_query($con, $query);

	$ray = array();

	while ($row = mysqli_fetch_array($sql)) {
		array_push($ray, array(
			"id_kar" => $row ['id'],
			"namalengkap_kar" => $row ['namalengkap'],
			"email_kar" => $row ['email'],
			"umur_kar" => $row ['umur'],
			"tgllahir_kar" => $row ['tgllahir'],
			"alamat_kar" => $row ['alamat'],
			"notlp_kar" => $row ['notlp'],
			"jeniskelamin_kar" => $row ['jeniskelamin'],
			"pendidikan_kar" => $row ['pendidikan'],
			"pengalaman_kar" => $row ['pengalaman'],
			"posisi_kar" => $row ['posisi'],
			"motivasi_kar" => $row ['motivasi'],
		
			

			));
	}

	echo json_encode($ray);
	mysqli_close($con);
?>