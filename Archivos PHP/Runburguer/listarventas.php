<?php include_once("conexion.php"); 
//1. Crear conexión a la Base de Datos 
$con=mysqli_connect($host,$usuario,$clave,$bd) or die('Fallo la conexion'); 
mysqli_set_charset($con,"utf8"); 
//2. Tomar los campos provenientes de la tabla 
$consulta = "SELECT * FROM $bd.ventas INNER JOIN productos ON ventas.productos_id_producto = productos.id_producto INNER JOIN usuarios ON ventas.usuario_id_usuario=usuarios.id_usuario INNER JOIN establecimiento ON ventas.establecimiento_id_establecimiento= establecimiento.id_establecimiento;";
 $resultado = mysqli_query($con, $consulta); 
 while($fila = mysqli_fetch_array($resultado)) { 
     $resultado1[] = array_map('utf8_encode', $fila); 
     } 
echo json_encode($resultado1);
 mysqli_close($con); 
 ?>