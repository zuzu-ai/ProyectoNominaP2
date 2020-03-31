create database nominaproyect;
use nominaproyect;

create table Puestos
(
Codigo_Puesto varchar(5) primary key,
Nombre_Puesto varchar(60) not null,
Estado_Puesto varchar(1) not null
)engine=InnoDB;

create table Departamentos
(
Codigo_Departamento varchar(5) primary key,
Nombre_Departamento varchar(60) not null,
Estado_Departamento varchar(1) not null
)engine=InnoDB;

create table Empleados
(
Codigo_Empleado varchar(5) primary key,
Nombre_Empleado varchar(60) not null,
Cui_Empleado varchar(15) not null,
Codigo_Puesto varchar(5) not null,
Codigo_Departamento varchar(5) not null,
Sueldo_Empleado float(10),
Estado_Empledo varchar(1) not null,

foreign key (Codigo_Puesto) references
Puestos(Codigo_Puesto),
foreign key (Codigo_Departamento) references
Departamentos(Codigo_Departamento)
)engine=InnoDB;

create table Aplicacion(
Codigo_Aplicacion varchar(1) primary key,
Codigo_Puesto varchar(5) not null,
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
Codigo_Empleado varchar(5) not null,
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
Tipo_Clase varchar(1) not null,
Valor float(10),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto),
foreign key (Tipo_Clase) references
Conceptos(Clase_Concepto)
)engine=Innodb;

create table Tipo_Cuota(
Codigo_Concepto varchar(1) primary key,
Nombre_Cuota varchar(60) not null,
Tipo_Clase varchar(1) not null,
Valor float(10),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto),
foreign key (Tipo_Clase) references
Conceptos(Clase_Concepto)
)engine=Innodb;

create table tipo_Tabla(
Codigo_Concepto varchar(5) primary key,
Rango_V1 float(10),
Rango_V2 float(10),
Valor varchar(1),
foreign key (Codigo_Concepto) references
Conceptos(Clase_Concepto)
)engine=Innodb;

drop database nominaproyect;