<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");


    $Nombreproducto=isset($_POST["nombre_producto"])?$_POST["nombre_producto"]:'';
    $Descripcionproducto=isset($_POST["descripcion_producto"])?$_POST["descripcion_producto"]:'';
    $Valorproducto=isset($_POST["valor_producto"])?$_POST["valor_producto"]:'';
    $Establecimiento_id_establecimiento=isset($_POST["establecimiento_id_establecimiento"])?$_POST["establecimiento_id_establecimiento"]:'';
   
    //4. Insertar los datos en la tabla de la Base de Datos
    $inserta = "INSERT INTO $bd.productos (nombre_producto,descripcion_producto,valor_producto,establecimiento_id_establecimiento)VALUES
     ('$Nombreproducto','$Descripcionproducto','$Valorproducto','$Establecimiento_id_establecimiento');";
    $resultado = mysqli_query($con, $inserta);
    echo json_encode($resultado);

    mysqli_close($con);
    ?>