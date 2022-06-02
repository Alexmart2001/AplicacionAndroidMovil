<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $Fechaventa=isset($_GET["fecha_venta"])?$_GET["fecha_venta"]:'';
   
    $eliminar = "DELETE FROM $bd.ventas WHERE fecha_venta='$Fechaventa';";
    $resultado = mysqli_query($con, $eliminar);
    mysqli_close($con);
    ?>
