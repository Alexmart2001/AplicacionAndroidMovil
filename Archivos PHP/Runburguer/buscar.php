<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $Usuario=isset($_GET["usuario"])?$_GET["usuario"]:'';
   
    $busca = "SELECT * FROM $bd.usuarios INNER JOIN perfiles ON usuarios.id_perfil=perfiles.id_perfil WHERE usuario = '$Usuario' ";
    $resultado = mysqli_query($con, $busca);

    while($row = $resultado->fetch_assoc()){
        $array []= array_map('utf8_encode',$row);
        
    }
    echo json_encode($array);

    mysqli_close($con);
    ?>