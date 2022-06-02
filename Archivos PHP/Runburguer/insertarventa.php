<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");


    $Fechaventa=isset($_POST["fecha_venta"])?$_POST["fecha_venta"]:'';
    $Cantidadvendida=isset($_POST["cantidad_vendida"])?$_POST["cantidad_vendida"]:'';
    $Mediodepago=isset($_POST["medio_de_pago"])?$_POST["medio_de_pago"]:'';
    $Establecimiento_id_establecimiento=isset($_POST["establecimiento_id_establecimiento"])?$_POST["establecimiento_id_establecimiento"]:'';
   
    //4. Insertar los datos en la tabla de la Base de Datos
    $inserta = "INSERT INTO $bd.ventas (fecha_venta,cantidad_vendida,medio_de_pago,establecimiento_id_establecimiento)VALUES
     ('$Fechaventa','$Cantidadvendida','$Mediodepago','$Establecimiento_id_establecimiento');";
    $resultado = mysqli_query($con, $inserta);
    echo json_encode($resultado);

    mysqli_close($con);
    ?>