<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $usuario=isset($_POST["id_usuario"])?$_POST["id_usuario"]:'';
    $Nombres=isset($_POST["nombre"])?$_POST["nombre"]:'';
    $usuarioo=isset($_POST["usuario"])?$_POST["usuario"]: '';
    $contra=isset($_POST["contrasena"])?$_POST["contrasena"]: '';
    $Apellidos=isset($_POST["apellido"])?$_POST["apellido"]:'';
    $Telefono=isset($_POST["telefono"])?$_POST["telefono"]:'';
    $Correo=isset($_POST["correo"])?$_POST["correo"]:'';
    

    //4. Insertar los datos en la tabla de la Base de Datos
    $actualizacion = "UPDATE $bd.usuarios SET nombre='$Nombres',apellido='$Apellidos',telefono='$Telefono',correo='$Correo', contrasena = '$contra', usuario = '$usuarioo' WHERE id_usuario='$usuario';";
    $resultado = mysqli_query($con, $actualizacion);
    echo json_encode($resultado);


    mysqli_close($con);
    ?>