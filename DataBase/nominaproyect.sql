drop database nominaproyect;

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
Tel_Empleado varchar(60) not null,
Ubicacion_Empleado varchar(60) not null,
Sueldo_Empleado float(10,2),
Estado_Empleado varchar(1) not null,
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
Codigo_Puesto int not null,
Nombre_Concepto varchar(100) not null,
Tipo_Concepto varchar(1) not null,
Clase_Concepto varchar(1) not null,
Aplicacion_Concepto int not null,
Valor float not null,
foreign key (Aplicacion_Concepto) references
aplicacion(Codigo_Aplicacion),
foreign key (Codigo_Puesto) references
puestos(Codigo_Puesto)
)engine=Innodb;


create table Nomina
(
Codigo_Nomina int primary key auto_increment,
Fecha_Inicial_Nomina date,
Codigo_Empleado int not null,
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
Cuota_Patronal decimal not null,

foreign key (Codigo_Empleado) references
Empleados(Codigo_Empleado)
)engine=InnoDB;

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
Nombre_Usuario varchar (20) not null primary key,
Contraseña_Usuario varchar(8) not null,
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

create table togglereg(
nombre varchar(10),
clic int not null,
codigo int not null primary key
)engine=InnoDB;



/*INSERTS*/
INSERT INTO puestos values ("0","Vendedor","A");
INSERT INTO puestos values ("0","Gerente","A");
INSERT INTO puestos values ("0","Contador","A");
INSERT INTO puestos values ("0","Auxiliar","A");


INSERT INTO departamentos values ("0","Marketing","A");
INSERT INTO departamentos values ("0","Gerencia","A");
INSERT INTO departamentos values ("0","Contabilidad","A");
INSERT INTO departamentos values ("0","Limpieza","A");


insert into empleados values(0,"Ingeniero","123456","1993-04-25 00:00:00",12345678,"su casa",4000.00,"A","2020-04-25 00:00:00","2","2");
insert into Altas values(0,1,"2020-04-25 00:00:00",2,2);

insert into Usarios VALUES("admin","1234",1);


INSERT INTO excepcion values ("0","N/A","A");
INSERT INTO excepcion values ("0","*","A");
INSERT INTO excepcion values ("0","Vendedor","A");
INSERT INTO excepcion values ("0","Gerente","A");
INSERT INTO excepcion values ("0","Contador","A");
INSERT INTO excepcion values ("0","Auxiliar","A");

insert into Aplicacion values(0,"A gerente",2,"*");

insert into conceptos values(0,2,"Cuota Patronal","%","-",1,12.64);

insert into togglereg VALUES("Claro","0","0");


