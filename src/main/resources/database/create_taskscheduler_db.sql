create table USUARIOS(
ID bigint not null AUTO_INCREMENT,
EMAIL varchar(70) not null,
CONTRASENIA varchar(70) not null,
NOMBRE varchar (70) not null,
APELLIDO varchar (70) not null,
PRIMARY KEY(ID)
);


create table ADMINISTRADORES(
ID bigint not null,
PRIMARY KEY(ID)
);

alter table ADMINISTRADORES add constraint ADM$USR foreign key (ID) references USUARIOS(ID);

create table CATEGORIAS(
ID bigint not null AUTO_INCREMENT,
NOMBRE varchar(60) not null,
PRIMARY KEY(ID)
);

create table ESTADOS_TAREAS(
ID bigint not null,
NOMBRE varchar(60) not null,
PRIMARY KEY(ID)
);

create table TAREAS(
ID bigint not null AUTO_INCREMENT,
TITULO varchar(60) not null,
DESCRIPCION varchar(200) not null,
CATEGORIA_ID bigint not null,
FECHA_ASIGNADA timestamp not null,
ESTADO_ID bigint not null,
PRIMARY KEY(ID)
);

alter table TAREAS add constraint TAR$CAT foreign key (CATEGORIA_ID) references CATEGORIAS(ID);
alter table TAREAS add constraint TAR$EST foreign key (ESTADO_ID) references ESTADOS_TAREAS(ID);

create table USUARIOS_TAREAS(
USUARIO_ID bigint not null,
TAREA_ID bigint not null,
PRIMARY KEY(USUARIO_ID,TAREA_ID)
);
alter table USUARIOS_TAREAS add constraint USRTAR$USR foreign key (USUARIO_ID) references USUARIOS(ID);
alter table USUARIOS_TAREAS add constraint USRTAR$TAR foreign key (TAREA_ID) references TAREAS(ID);


create table PERMISOS(
ID int not null,
NOMBRE varchar(50)not null,
PRIMARY KEY(ID)
);

create table PERMISOS_USUARIOS(
PERMISO_ID int not null,
USUARIO_ID bigint not null,
PRIMARY KEY(PERMISO_ID,USUARIO_ID)
);

alter table PERMISOS_USUARIOS add constraint PUSER$PER foreign key (PERMISO_ID) references PERMISOS(ID);
alter table PERMISOS_USUARIOS add constraint PUSER$USR foreign key (USUARIO_ID) references USUARIOS(ID);
