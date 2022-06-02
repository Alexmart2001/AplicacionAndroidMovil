<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $Nombreproducto=isset($_GET["nombre_producto"])?$_GET["nombre_producto"]:'';
   
    $busca = "SELECT * FROM $bd.productos INNER JOIN establecimiento ON productos.establecimiento_id_establecimiento=establecimiento.id_establecimiento WHERE nombre_producto = '$Nombreproducto' ";
    $resultado = mysqli_query($con, $busca);

    while($row = $resultado->fetch_assoc()){
        $array []= array_map('utf8_encode',$row);
        
    }
    echo json_encode($array);

    mysqli_close($con);
    ?>