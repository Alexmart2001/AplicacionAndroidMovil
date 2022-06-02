<?php
    include_once("conexion.php");
    $con = mysqli_connect($host, $usuario, $clave, $bd) or die('Fallo la conexion');
    mysqli_set_charset($con, "utf-8");


    $Nombre=isset($_POST["nombre"])?$_POST["nombre"]:'';
    $Apellido=isset($_POST["apellido"])?$_POST["apellido"]:'';
    $Correo=isset($_POST["correo"])?$_POST["correo"]:'';
    $Telefono=isset($_POST["telefono"])?$_POST["telefono"]:'';
    $Usuario=isset($_POST["usuario"])?$_POST["usuario"]:'';
    $Contrasena=isset($_POST["contrasena"])?$_POST["contrasena"]:'';
    $Id_perfil=isset($_POST["id_perfil"])?$_POST["id_perfil"]:'';

    //4. Insertar los datos en la tabla de la Base de Datos
    $inserta = "INSERT INTO $bd.usuarios (nombre,apellido,correo,telefono,usuario,contrasena,id_perfil)VALUES
     ('$Nombre','$Apellido','$Correo','$Telefono','$Usuario','$Contrasena','$Id_perfil');";
    $resultado = mysqli_query($con, $inserta);
    echo json_encode($resultado);

    mysqli_close($con);
    ?>