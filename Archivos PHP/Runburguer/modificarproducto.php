<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $IDproducto=isset($_POST["id_producto"])?$_POST["id_producto"]:'';
    $Nombreproducto=isset($_POST["nombre_producto"])?$_POST["nombre_producto"]:'';
    $Descripcionproducto=isset($_POST["descripcion_producto"])?$_POST["descripcion_producto"]:'';
    $Valorproducto=isset($_POST["valor_producto"])?$_POST["valor_producto"]:'';
    $Establecimiento_id_establecimiento=isset($_POST["establecimiento_id_establecimiento"])?$_POST["establecimiento_id_establecimiento"]:'';
    

    //4. Insertar los datos en la tabla de la Base de Datos
    $inserta = "UPDATE $bd.productos SET nombre_producto='$Nombreproducto',descripcion_producto='$Descripcionproducto',
    valor_producto ='$Valorproducto',establecimiento_id_establecimiento='$Establecimiento_id_establecimiento'WHERE id_producto='$IDproducto';";
    $resultado = mysqli_query($con, $inserta);


    mysqli_close($con);
    ?>