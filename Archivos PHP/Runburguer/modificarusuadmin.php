<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");

    $Id_usuario=isset($_POST["id_usuario"])?$_POST["id_usuario"]:'';
    $Nombres=isset($_POST["nombre"])?$_POST["nombre"]:'';
    $Apellidos=isset($_POST["apellido"])?$_POST["apellido"]:'';
    $Usuario=isset($_POST["usuario"])?$_POST["usuario"]:'';
    $Telefono=isset($_POST["telefono"])?$_POST["telefono"]:'';
    $Correo=isset($_POST["correo"])?$_POST["correo"]:'';
    $Id_perfil=isset($_POST["id_perfil"])?$_POST["id_perfil"]:'';
    

    //4. Insertar los datos en la tabla de la Base de Datos
    $inserta = "UPDATE $bd.usuarios SET nombre='$Nombres',apellido='$Apellidos',usuario ='$Usuario',telefono='$Telefono',correo='$Correo',id_perfil='$Id_perfil' WHERE id_usuario='$Id_usuario';";
    $resultado = mysqli_query($con, $inserta);


    mysqli_close($con);
    ?>