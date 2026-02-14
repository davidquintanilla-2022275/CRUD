Drop database if exists Provedores;
create database Provedores;
use Provedores;

create table Proveedores(
	id_proveedor int auto_increment not null,
	 nombre_proveedor varchar(60) not null,
	 telefono_proveedor int not null,
	 direccion varchar(100) not null,
	 email_proveedor varchar(100) not null,
	 primary key PK_id_proveedor(id_proveedor)
);

create table Empleados(
	id_empleado int auto_increment not null,
	 nombre_empleado varchar(60) not null,
	 apellido_empleado varchar(60) not null,
	 puesto_empleado varchar(20) null,
	 email_empleado varchar(100) not null,
	 primary key PK_id_empleado(id_empleado)
);

create table Repuestos(
	 id_repuesto int auto_increment not null,
	 nombre_repuesto varchar(60) not null,
	 categoria_repuesto varchar(60) not null,
	 precio_compra double not null,
	 precio_venta double not null,
	 id_proveedor int not null,
	 primary key PK_id_repuesto(id_repuesto),
	 constraint FK_repuesto_proveedor foreign key (id_proveedor)
	 references proveedores(id_proveedor) on delete cascade
);

create table Ventas(
	 id_venta int auto_increment not null,
	 fecha_venta date not null,
	 cantidad int not null,
	 total double not null,
	 id_empleado int not null,
	 id_repuesto int not null,
	 primary key PK_id_venta(id_venta),
	 constraint FK_ventas_empleado foreign key (id_empleado)
	 references Empleados(id_empleado) on delete cascade,
	 constraint FK_ventas_repuestos foreign key (id_repuesto)
	 references Repuestos(id_repuesto) on delete cascade
);

-- ===================================================
-- Provedores
-- ===================================================

Delimiter $$
create procedure sp_listar_proveedores()
begin
	select * from Proveedores;
end $$
Delimiter ;

Delimiter $$
create procedure sp_agregar_proveedor(in p_nombre varchar(60),in p_telefono int,in p_direccion varchar(100),in p_email varchar(100))
begin
	insert into Proveedores(nombre_proveedor, telefono_proveedor, direccion, email_proveedor)
	values (p_nombre, p_telefono, p_direccion, p_email);
end $$
Delimiter ;

call sp_agregar_proveedor('AutoPartes Central', 55512345, 'Zona 1, Ciudad', 'contacto@autopartescentral.com');
call sp_agregar_proveedor('Repuestos El Motor', 55523456, 'Zona 5, Ciudad', 'ventas@elmotor.com');
call sp_agregar_proveedor('Distribuidora RPM', 55534567, 'Zona 9, Ciudad', 'rpm@distribuidorarpm.com');
call sp_agregar_proveedor('Auto Repuestos GT', 55545678, 'Zona 12, Ciudad', 'info@autorepuestosgt.com');
call sp_agregar_proveedor('Motores y Más', 55556789, 'Zona 7, Ciudad', 'motoresymas@gmail.com');
call sp_agregar_proveedor('Repuestos López', 55567890, 'Zona 18, Ciudad', 'repuestoslopez@yahoo.com');
call sp_agregar_proveedor('Auto Parts Express', 55578901, 'Zona 3, Ciudad', 'express@autoparts.com');
call sp_agregar_proveedor('Distribuidora El Pistón', 55589012, 'Zona 10, Ciudad', 'elpiston@hotmail.com');
call sp_agregar_proveedor('Repuestos San José', 55590123, 'Zona 6, Ciudad', 'sanjose@repuestos.com');
call sp_agregar_proveedor('Auto Repuestos Modernos', 55501234, 'Zona 11, Ciudad', 'modernos@autorepuestos.com');


Delimiter $$
create procedure sp_eliminar_proveedor(in p_id int)
begin
	delete from Proveedores where id_proveedor = p_id;
end $$
Delimiter ;

Delimiter $$
create procedure sp_actualizar_proveedor(in p_id int,in p_nombre varchar(60),in p_telefono int,in p_direccion varchar(100),in p_email varchar(100))
begin
	update Proveedores
	set nombre_proveedor = p_nombre,
	    telefono_proveedor = p_telefono,
	    direccion = p_direccion,
	    email_proveedor = p_email
	where id_proveedor = p_id;
end $$
Delimiter ;
-- ===================================================
-- Empleados
-- ===================================================

Delimiter $$
create procedure sp_listar_empleados()
begin
	select * from Empleados;
end $$
Delimiter ;

Delimiter $$
create procedure sp_agregar_empleado(in p_nombre varchar(60),in p_apellido varchar(60),in p_puesto varchar(20),in p_email varchar(100))
begin
	insert into Empleados(nombre_empleado, apellido_empleado, puesto_empleado, email_empleado)
	values (p_nombre, p_apellido, p_puesto, p_email);
end $$
Delimiter ;

call sp_agregar_empleado('Carlos', 'Pérez', 'Vendedor', 'carlos.perez@empresa.com');
call sp_agregar_empleado('Ana', 'López', 'Cajera', 'ana.lopez@empresa.com');
call sp_agregar_empleado('Luis', 'García', 'Vendedor', 'luis.garcia@empresa.com');
call sp_agregar_empleado('María', 'Rodríguez', 'Administradora', 'maria.rodriguez@empresa.com');
call sp_agregar_empleado('José', 'Martínez', 'Bodeguero', 'jose.martinez@empresa.com');
call sp_agregar_empleado('Laura', 'Hernández', 'Vendedor', 'laura.hernandez@empresa.com');
call sp_agregar_empleado('Pedro', 'Ramírez', 'Cajero', 'pedro.ramirez@empresa.com');
call sp_agregar_empleado('Sofía', 'Cruz', 'Vendedora', 'sofia.cruz@empresa.com');
call sp_agregar_empleado('Miguel', 'Flores', 'Supervisor', 'miguel.flores@empresa.com');
call sp_agregar_empleado('Daniela', 'Morales', 'Vendedora', 'daniela.morales@empresa.com');

Delimiter $$
create procedure sp_eliminar_empleado(in p_id int)
begin
	delete from Empleados where id_empleado = p_id;
end $$
Delimiter ;

Delimiter $$
create procedure sp_actualizar_empleado(in p_id int,in p_nombre varchar(60),in p_apellido varchar(60),in p_puesto varchar(20),in p_email varchar(100))
begin
	update Empleados
	set nombre_empleado = p_nombre,
	    apellido_empleado = p_apellido,
	    puesto_empleado = p_puesto,
	    email_empleado = p_email
	where id_empleado = p_id;
end $$
Delimiter ;
-- ===================================================
-- Repuestos
-- ===================================================
Delimiter $$
create procedure sp_listar_repuestos()
begin
	select * from Repuestos;
end $$
Delimiter ;

Delimiter $$
create procedure sp_agregar_repuesto(in p_nombre varchar(60),in p_categoria varchar(60),in p_precio_compra double,in p_precio_venta double,in p_id_proveedor int)
BEGIN
	insert into Repuestos(nombre_repuesto, categoria_repuesto, precio_compra, precio_venta, id_proveedor)values (p_nombre, p_categoria, p_precio_compra, p_precio_venta, p_id_proveedor);
end $$
Delimiter ;

call sp_agregar_repuesto('Filtro de Aceite', 'Motor', 25.00, 40.00, 1);
call sp_agregar_repuesto('Bujía', 'Encendido', 15.00, 30.00, 2);
call sp_agregar_repuesto('Pastillas de Freno', 'Frenos', 80.00, 120.00, 3);
call sp_agregar_repuesto('Amortiguador', 'Suspensión', 150.00, 220.00, 4);
call sp_agregar_repuesto('Batería 12V', 'Eléctrico', 300.00, 420.00, 5);
call sp_agregar_repuesto('Correa de Distribución', 'Motor', 90.00, 150.00, 6);
call sp_agregar_repuesto('Radiador', 'Enfriamiento', 350.00, 520.00, 7);
call sp_agregar_repuesto('Alternador', 'Eléctrico', 400.00, 600.00, 8);
call sp_agregar_repuesto('Disco de Freno', 'Frenos', 110.00, 180.00, 9);
call sp_agregar_repuesto('Filtro de Aire', 'Motor', 20.00, 35.00, 10);


Delimiter $$
create procedure sp_eliminar_repuesto(in p_id int)
begin
	delete from Repuestos where id_repuesto = p_id;
end $$
Delimiter ;

Delimiter $$
create procedure sp_actualizar_repuesto(in p_id int,in p_nombre varchar(60),in p_categoria varchar(60),in p_precio_compra double,in p_precio_venta double,in p_id_proveedor int)
begin
	update Repuestos
	set nombre_repuesto = p_nombre,
	    categoria_repuesto = p_categoria,
	    precio_compra = p_precio_compra,
	    precio_venta = p_precio_venta,
	    id_proveedor = p_id_proveedor
	where id_repuesto = p_id;
end $$
Delimiter ;
-- ===================================================
-- Ventas
-- ===================================================
Delimiter $$
create procedure sp_listar_ventas()
begin
	select * from Ventas;
end $$
Delimiter ;

Delimiter $$
create procedure sp_agregar_venta(in p_fecha date,in p_cantidad int,in p_total double,in p_id_empleado int,in p_id_repuesto int)
begin
	insert into Ventas(fecha_venta, cantidad, total, id_empleado, id_repuesto) values (p_fecha, p_cantidad, p_total, p_id_empleado, p_id_repuesto);
end $$
Delimiter ;

call sp_agregar_venta('2026-01-10', 2, 80.00, 1, 1);
call sp_agregar_venta('2026-01-11', 4, 120.00, 2, 2);
call sp_agregar_venta('2026-01-12', 1, 120.00, 3, 3);
call sp_agregar_venta('2026-01-13', 2, 440.00, 4, 4);
call sp_agregar_venta('2026-01-14', 1, 420.00, 5, 5);
call sp_agregar_venta('2026-01-15', 3, 450.00, 6, 6);
call sp_agregar_venta('2026-01-16', 1, 520.00, 7, 7);
call sp_agregar_venta('2026-01-17', 2, 1200.00, 8, 8);
call sp_agregar_venta('2026-01-18', 2, 360.00, 9, 9);
call sp_agregar_venta('2026-01-19', 5, 175.00, 10, 10);


Delimiter $$
create procedure sp_eliminar_venta(in p_id int)
begin
	delete from Ventas where id_venta = p_id;
end $$
Delimiter ;

Delimiter $$
create procedure sp_actualizar_venta(in p_id int,in p_fecha date,in p_cantidad int,in p_total double,in p_id_empleado int,in p_id_repuesto int)
begin
	update Ventas
	set fecha_venta = p_fecha,
	    cantidad = p_cantidad,
	    total = p_total,
	    id_empleado = p_id_empleado,
	    id_repuesto = p_id_repuesto
	where id_venta = p_id;
end $$
delimiter ;

USE Provedores;
SELECT * FROM Empleados;
SELECT * FROM empleados WHERE id_empleado = 8;

