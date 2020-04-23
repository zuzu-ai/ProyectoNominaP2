create database nominaproyect;
use nominaproyect;
drop database nominaproyect;
select * from Puestos;
create table Puestos(
Codigo_Puesto int primary key auto_increment,
Nombre_Puesto varchar(60) not null,
Estado_Puesto varchar(1) not null
)engine=InnoDB;

create table Departamentos
(
Codigo_Departamento int primary key auto_increment,
Nombre_Departamento varchar(60) not null,
Estado_Departamento varchar(1) not null
)engine=InnoDB;

create table Empleados
(
Codigo_Empleado int primary key auto_increment,
Nombre_Empleado varchar(60) not null,
Dpi_Empleado varchar(15) not null,
Fecha_Nacimiento datetime not null,
Tel_Empleado int not null,
Ubicacion_Empleado varchar(60) not null,
Sueldo_Empleado float(10,2),
Estado_Empledo varchar(1) not null,
Fecha_Inicio datetime not null,
Codigo_Puesto int not null,
Codigo_Departamento int not null,


foreign key (Codigo_Puesto) references
Puestos(Codigo_Puesto),
foreign key (Codigo_Departamento) references
Departamentos(Codigo_Departamento)
)engine=InnoDB;

create table Aplicacion(
Codigo_Aplicacion varchar(1) primary key,
Codigo_Puesto int not null,
Excepcion varchar(5),
foreign key (Codigo_Puesto) references
Puestos(Codigo_Puesto)
)engine=Innodb;

create table Conceptos(
Codigo_Concepto varchar(5) primary key,
Nombre_Concepto varchar(10) not null,
Tipo_Concepto varchar(1) not null,
Clase_Concepto varchar(1) not null,
Aplicacion_Concepto varchar(1) not null,
Valor int not null,
foreign key (Aplicacion_Concepto) references
aplicacion(Codigo_Aplicacion)
)engine=Innodb;

create table NominaEncabezado
(
Codigo_Nomina varchar(5) primary key,
Fecha_Inicial_Nomina date,
Fecha_Final_Nomina date
)engine=InnoDB;

create table Nomina_Descripcion
(
Codigo_Nomina varchar(5) not null,
Codigo_Empleado int not null,
Codigo_Concepto varchar(5) not null,
Valor_NominaD float(10),

foreign key (Codigo_Nomina) references
NominaEncabezado(Codigo_Nomina),
foreign key (Codigo_Empleado) references
Empleados(Codigo_Empleado),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto)
)engine=InnoDB;

create table Tipo_Porcentaje(
Codigo_Concepto varchar(5) primary key,
Nombre_Porcentaje varchar(60) not null,
Valor float(10),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto)
)engine=Innodb;

create table Tipo_Cuota(
Codigo_Concepto varchar(1) primary key,
Nombre_Cuota varchar(60) not null,
Valor float(10),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto)
)engine=Innodb;

create table tipo_Tabla(
Codigo_Concepto varchar(5) primary key,
Rango_V1 float(10),
Rango_V2 float(10),
Valor varchar(1),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto)
)engine=Innodb;



create table Reporte_Direccion(
Reporte_Direccion_Id varchar(128) primary key not null
, Reporte_Direccion_Zona1 decimal(2,2) not null
, Reporte_Direccion_Zona2 decimal(2,2) not null
, Reporte_Direccion_Zona3 decimal(2,2) not null
, Reporte_Direccion_Zona4 decimal(2,2) not null
, Reporte_Direccion_Zona5 decimal(2,2) not null
, Reporte_Direccion_Zona6 decimal(2,2) not null
, Reporte_Direccion_Zona7 decimal(2,2) not null
, Reporte_Direccion_Zona8 decimal(2,2) not null
, Reporte_Direccion_Zona9 decimal(2,2) not null
, Reporte_Direccion_Zona10 decimal(2,2) not null
, Reporte_Direccion_Zona11 decimal(2,2) not null
, Reporte_Direccion_Zona12 decimal(2,2) not null
, Reporte_Direccion_Zona13 decimal(2,2) not null
, Reporte_Direccion_Zona14 decimal(2,2) not null
, Reporte_Direccion_Zona15 decimal(2,2) not null
, Reporte_Direccion_Zona16 decimal(2,2) not null
, Reporte_Direccion_Zona17 decimal(2,2) not null
, Reporte_Direccion_Zona18 decimal(2,2) not null
, Reporte_Direccion_Zona19 decimal(2,2) not null
, Reporte_Direccion_Zona21 decimal(2,2) not null
, Reporte_Direccion_Zona24 decimal(2,2) not null
, Reporte_Direccion_Zona25 decimal(2,2) not null


)engine = InnoDB;

create table Reporte_Departamento(
Reporte_Departamentos_Id varchar(128) primary key not null
, Reporte_Departamento1 decimal(2,2) not null
, Reporte_Departamento2 decimal(2,2) not null

)engine = InnoDB;

create table Reporte_Puesto(
Reporte_Puesto_Id varchar(128) primary key not null
, Reporte_Puesto1 decimal(2,2) not null
, Reporte_Puesto2 decimal(2,2) not null
)engine = InnoDB;
create table Reporte_Altas(
Altas_Id varchar(128) primary key
, Altas_Enero double(2,2) not null
, Altas_febrero decimal(2,2) not null
, Altas_Marzo decimal(2,2) not null
, Altas_Abril decimal(2,2) not null
, Altas_Mayo decimal(2,2) not null
, Altas_Junio decimal(2,2) not null
, Altas_Julio decimal(2,2) not null
, Altas_Agosto decimal(2,2) not null
, Altas_Septiembre decimal(2,2) not null
, Altas_Octubre decimal(2,2) not null
, Altas_Noviembre decimal(2,2) not null
, Altas_Diciembre decimal(2,2) not null
, Altas_Actuales int not null
)engine = Innodb;

insert into Altas values(uuid(),12.20,10.12,14.36,15.24,18.25,36.24,19.36,14.25,18.82,17.71,13.25,18,52,1523);

create table Reporte_Bajas(
Bajas_Id varchar(128) primary key not null
, Bajas_Enero double(2,2) not null
, Bajas_febrero decimal(2,2) not null
, Bajas_Marzo decimal(2,2) not null
, Bajas_Abril decimal(2,2) not null
, Bajas_Mayo decimal(2,2) not null
, Bajas_Junio decimal(2,2) not null
, Bajas_Julio decimal(2,2) not null
, Bajas_Agosto decimal(2,2) not null
, Bajas_Septiembre decimal(2,2) not null
, Bajas_Octubre decimal(2,2) not null
, Bajas_Noviembre decimal(2,2) not null
, Bajas_Diciembre decimal(2,2) not null
, Bajas_Actuales int not null
)engine = InnoDB;

create table Altas
(
Codigo_Altas int primary key auto_increment,
Codigo_Empleado int not null,
Fecha datetime not null,
Codigo_Dep int not null,
Codigo_Pue int not null,
foreign key (Codigo_Empleado) references
Empleados(Codigo_Empleado)
)engine=InnoDB;


create table Bajas
(
Codigo_Bajas int primary key auto_increment,
Codigo_Altas int not null,
Fecha datetime not null,
Codigo_Dep int not null,
Codigo_Pue int not null,
foreign key (Codigo_Altas) references
Altas(Codigo_Altas)
)engine=InnoDB;

select * from Departamentos;
select * from Empleados;
select * from Altas;