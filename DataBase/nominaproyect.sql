create database nominaproyect;
use nominaproyect;

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
Codigo_Aplicacion int primary key auto_increment,
Nombre_Aplicacion varchar(60) not null,
Codigo_Puesto int not null,
Excepcion varchar(5),
foreign key (Codigo_Puesto) references
Puestos(Codigo_Puesto)
)engine=Innodb;

create table Conceptos(
Codigo_Concepto int primary key auto_increment,
Codigo_Empleado int not null,
Nombre_Concepto varchar(10) not null,
Tipo_Concepto varchar(1) not null,
Clase_Concepto varchar(1) not null,
Aplicacion_Concepto int not null,
Valor int not null,
foreign key (Aplicacion_Concepto) references
aplicacion(Codigo_Aplicacion),
foreign key (Codigo_Empleado) references
empleados(Codigo_Empleado)
)engine=Innodb;

create table Nomina
(
Codigo_Nomina int primary key auto_increment,
Fecha_Inicial_Nomina date,
Codigo_Empleado int not null,
Codigo_Concepto int not null,
SueldoL decimal not null,
SueldoBase decimal not null,
Comisiones decimal not null,
Bonificaciones decimal not null,
Incentivo decimal not null,
Devengado decimal not null,
Igss decimal not null,
Isr decimal not null,
Anticipos decimal not null,
DescuentosJ decimal not null,
OtrosDescuentos decimal not null,
TotalDesucentos decimal not null,

foreign key (Codigo_Empleado) references
Empleados(Codigo_Empleado),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto)
)engine=InnoDB;

create table Tipo_Porcentaje(
Codigo_Concepto int primary key auto_increment,
Nombre_Porcentaje varchar(60) not null,
Valor float(10),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto)
)engine=Innodb;

create table Tipo_Cuota(
Codigo_Concepto int primary key auto_increment,
Nombre_Cuota varchar(60) not null,
Valor float(10),
foreign key (Codigo_Concepto) references
Conceptos(Codigo_Concepto)
)engine=Innodb;

create table tipo_Tabla(
Codigo_Concepto int primary key auto_increment,
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

create table Usarios
(
Nombre_Usuario varchar (20) primary key,
Contraseña_Usuario int not null,
Codigo_Usuario int not null,

foreign key (Codigo_Usuario) references Empleados(Codigo_Empleado)
)engine= InnoDB;

create table Bitacora(
CodigoBitacora int primary key auto_increment,
Usuario varchar(20) not null,
Descripcion varchar(200),
fecha varchar(60) not null,
hora varchar(60) not null,

foreign key (Usuario) references
Usarios(Nombre_Usuario)
)engine=InnoDB;

create table Excepcion(
CodigoExcepcion int primary key auto_increment,
NombreExcpecion varchar(60) not null,
EstadoExcepcion varchar(1) not null
)engine=InnoDB;



/*INSERTS*/
INSERT INTO puestos values ("0","Vendedor","T");
INSERT INTO puestos values ("0","Gerente","T");
INSERT INTO puestos values ("0","Contador","T");
INSERT INTO puestos values ("0","Auxiliar","T");


INSERT INTO departamentos values ("0","Marketing","T");
INSERT INTO departamentos values ("0","Gerencia","T");
INSERT INTO departamentos values ("0","Contabilidad","T");
INSERT INTO departamentos values ("0","Limpieza","T");


insert into Usarios VALUES("zuzu-ai","123456",1);
insert into Usarios VALUES("kievkevin13","123456",2);
insert into Usarios VALUES("ashly2015","123456",3);
insert into Usarios VALUES("dgarciam2001","123456",4);


INSERT INTO excepcion values ("0","N/A","T");
INSERT INTO excepcion values ("0","*","T");
INSERT INTO excepcion values ("0","Vendedor","T");
INSERT INTO excepcion values ("0","Gerente","T");
INSERT INTO excepcion values ("0","Contador","T");
INSERT INTO excepcion values ("0","Auxiliar","T");

/*SELECTS*/
select * from conceptos;

select * from empleados;

select * from usarios;

select * from excepcion;

select * from bitacora;


drop database nominaproyect;

