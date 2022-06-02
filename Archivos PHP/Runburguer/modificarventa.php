<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $Id_venta=isset($_POST["id_venta"])?$_POST["id_venta"]:'';
    $Fecha_venta=isset($_POST["fecha_venta"])?$_POST["fecha_venta"]:'';
    $Cantidad_vendida=isset($_POST["cantidad_vendida"])?$_POST["cantidad_vendida"]:'';
    $Medio_de_pago=isset($_POST["medio_de_pago"])?$_POST["medio_de_pago"]:'';
    $Productos_id_producto=isset($_POST["productos_id_producto"])?$_POST["productos_id_producto"]:'';
    $Usuarios_id_usuario=isset($_POST["usuario_id_usuario"])?$_POST["usuario_id_usuario"]:'';
    $Establecimiento_id_establecimiento=isset($_POST["establecimiento_id_establecimiento"])?$_POST["establecimiento_id_establecimiento"]:'';
    

    //4. Insertar los datos en la tabla de la Base de Datos
    $inserta = "UPDATE $bd.ventas SET fecha_venta='$Fecha_venta',cantidad_vendida='$Cantidad_vendida',medio_de_pago='$Medio_de_pago',productos_id_producto='$Productos_id_producto',usuario_id_usuario='$Usuarios_id_usuario',establecimiento_id_establecimiento=' $Establecimiento_id_establecimiento' WHERE id_venta='$Id_venta';";
    $resultado = mysqli_query($con, $inserta);


    mysqli_close($con);
    ?>