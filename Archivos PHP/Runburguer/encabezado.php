<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $user=isset($_GET["id_usuario"])?$_GET["id_usuario"]:'';
   
    $busca = "SELECT $bd.nombre, $bd.apellido FROM $bd.usuarios WHERE id_usuario = '$user' ";
    $resultado = mysqli_query($con, $busca);

    while($row = $resultado->fetch_assoc()){
        $array []= array_map('utf8_encode',$row);
        
    }
    echo json_encode($array);

    mysqli_close($con);
    ?>