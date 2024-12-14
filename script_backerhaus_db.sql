CREATE DATABASE backerhaus_db;

USE backerhaus_db;

create table rol (
	id_rol int auto_increment primary key,
    tipo_rol varchar(20) NOT NULL
);


create table persona (
	id_persona int auto_increment primary key,
    nombre varchar(50) not null,
    email varchar(50) not null unique,
    telefono varchar(20),
    contraseña varchar(50) not null,
    estado boolean default true
);


create table persona_rol (
	id_persona int not null,
    id_rol int not null,
    primary key (id_persona, id_rol),
    foreign key (id_persona) references persona(id_persona),
    foreign key (id_rol) references rol(id_rol)
);



create table estado_cuenta (
	id_estado_cuenta int auto_increment primary key,
    nombre varchar(20) not null
);


create table cliente (
	id_cliente int primary key,
    id_persona int not null,
    nombre_empresa varchar(50),
    id_estado_cuenta int not null,
    foreign key (id_persona) references persona(id_persona),
    foreign key (id_estado_cuenta) references estado_cuenta(id_estado_cuenta)
);



create table tipo_transaccion (
	id_tipo_transaccion int auto_increment primary key,
    tipo_transaccion varchar(30)
);



create table cuenta_corriente(
	id_cuenta_corriente int auto_increment primary key,
    id_cliente int not null,
    fecha_transaccion datetime,
    id_tipo_transaccion int not null,
    monto decimal(10,2) not null,
    saldo_acumulado decimal(10, 2),
    detalle_transaccion varchar(255),
    foreign key (id_cliente) references cliente(id_cliente),
    foreign key (id_tipo_transaccion) references tipo_transaccion(id_tipo_transaccion)
);



create table direccion (
	id_direccion int auto_increment primary key,
    id_cliente int not null,
    calle varchar(40) not null,
    ciudad varchar(30) NOT NULL,
    codigo_postal varchar(10) not null,
    telefono varchar(15),
    estado boolean default true,
    foreign key (id_cliente) references cliente(id_cliente)
);


create  table familia (
	id_familia int auto_increment primary key,
    nombre varchar(50) not null,
    descripcion varchar(255)
);


create table producto(
	id_producto int primary key,
    nombre varchar(50) not null,
    descripcion varchar(255),
    precio decimal(10, 2) not null,
    imagen varchar(255),
    cantidad_minima int,
    id_familia int,
    foreign key (id_familia) references familia(id_familia)
);


create table carrito (
	id_carrito int primary key,
    id_cliente int not null,
    estado varchar(15),
    total decimal(10, 2) default 0.0,
    foreign key (id_cliente) references cliente(id_cliente)
);


create table carrito_producto (
	id_carrito int not null,
    id_producto int not null,
    cantidad int not null,
    primary key (id_carrito, id_producto),
    foreign key (id_carrito) references carrito(id_carrito),
    foreign key (id_producto) references producto(id_producto)
);



create table estado_envio (
	id_estado_envio int auto_increment primary key,
    estado varchar(15) not null
);


create table estado_pago (
	id_estado_pago int auto_increment primary key,
    estado varchar(15) not null
);


create table estado_pedido (
	id_estado_pedido int auto_increment primary key,
    estado varchar(15) not null
);


create table pedido (
	id_pedido int auto_increment primary key,
    id_cliente int not null,
    fecha_pedido datetime not null default current_timestamp,
    /*fecha_entrega datetime,*/
    id_estado_pago int,
    id_estado_envio int,
    id_estado_pedido int,
    total decimal(10, 2) not null,
    es_excepcional boolean default false,
    id_direccion int,
    nombre_encargado_pedido varchar(50) not null,
    foreign key (id_cliente) references cliente(id_cliente),
    foreign key (id_estado_pago) references estado_pago(id_estado_pago),
    foreign key (id_estado_envio) references estado_envio(id_estado_envio),
    foreign key (id_estado_pedido) references estado_pedido(id_estado_pedido),
    foreign key (id_direccion) references direccion(id_direccion)
);



create table accion_auditoria (
	id_accion int auto_increment primary key,
    accion varchar(20) not null
);


create table auditoria (
	id_auditoria int auto_increment primary key,
    id_cliente int not null,
    id_pedido int not null,
    fecha_hora datetime not null default current_timestamp,
    id_accion int,
    detalle varchar(100),
    foreign key (id_cliente) references cliente(id_cliente),
    foreign key (id_pedido) references pedido(id_pedido),
    foreign key (id_accion) references accion_auditoria(id_accion)
);



create table pedido_producto (
	id_pedido int not null,
    id_producto int not null,
    cantidad int not null,
    precio_unitario decimal(10, 2),
    primary key (id_pedido, id_producto),
    foreign key (id_pedido) references pedido(id_pedido),
    foreign key (id_producto) references producto(id_producto)
);

