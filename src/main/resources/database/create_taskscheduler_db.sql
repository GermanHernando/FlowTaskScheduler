create table USERS_ARTIFACTS(
ID bigint not null AUTO_INCREMENT,
EMAIL varchar(70) not null UNIQUE,
CONTRASENIA varchar(30) not null,
NOMBRE varchar (70) not null,
APELLIDO varchar (70) not null,
PRIMARY KEY(ID)
);

create table USUARIOS(
ID bigint not null,
PRIMARY KEY(ID)
);
alter table USUARIOS add constraint USR$USAR foreign key (ID) references USERS_ARTIFACTS(ID);

create table ADMINISTRADORES(
ID bigint not null,
PRIMARY KEY(ID)
);
alter table ADMINISTRADORES add constraint ADM$USAR foreign key (ID) references USERS_ARTIFACTS(ID);

create table LISTAS_ADMINISTRADORES_Y_USUARIOS(
ADMIN_ID bigint not null,
USUARIO_ID bigint not null,
PRIMARY KEY(ADMIN_ID,USUARIO_ID)
);
alter table LISTAS_ADMINISTRADORES_Y_USUARIOS add constraint LAYU$USR foreign key (USUARIO_ID) references USUARIOS(ID);
alter table LISTAS_ADMINISTRADORES_Y_USUARIOS add constraint LAYU$ADM foreign key (ADMIN_ID) references ADMINISTRADORES(ID);


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

create table ITEMS_ARTIFACTS(
ID bigint not null AUTO_INCREMENT,
TITULO varchar(60) not null,
DESCRIPCION varchar(200) not null,
CATEGORIA_ID bigint not null,
PRIMARY KEY(ID)
);
alter table ITEMS_ARTIFACTS add constraint ITAR$CAT foreign key (CATEGORIA_ID) references CATEGORIAS(ID);

create table PLANTILLAS(
ID bigint not null,
PRIMARY KEY(ID)
);
alter table PLANTILLAS add constraint PLANT$ITAR foreign key (ID) references ITEMS_ARTIFACTS(ID);

create table TAREAS(
ID bigint not null,
FECHA_ASIGNADA timestamp not null,
ESTADO_ID bigint not null,
PRIMARY KEY(ID)
);
alter table TAREAS add constraint TAR$ITAR foreign key (ID) references ITEMS_ARTIFACTS(ID);
alter table TAREAS add constraint TAR$EST foreign key (ESTADO_ID) references ESTADOS_TAREAS(ID);

create table USUARIOS_TAREAS(
USUARIO_ID bigint not null,  
TAREA_ID bigint not null, 
PRIMARY KEY(USUARIO_ID,TAREA_ID)
);
alter table USUARIOS_TAREAS add constraint USRTAR$USR foreign key (USUARIO_ID) references USUARIOS(ID);
alter table USUARIOS_TAREAS add constraint USRTAR$TAR foreign key (TAREA_ID) references TAREAS(ID);


create table PLANTILLAS_GUARDADAS_ADMIN(
ADMIN_ID bigint not null,
PLANTILLA_ID bigint not null,
PRIMARY KEY(ADMIN_ID,PLANTILLA_ID)
);
alter table PLANTILLAS_GUARDADAS_ADMIN add constraint PGA$ADM foreign key (ADMIN_ID) references ADMINISTRADORES(ID);
alter table PLANTILLAS_GUARDADAS_ADMIN add constraint PGA$PLANT foreign key (PLANTILLA_ID) references PLANTILLAS(ID);

create table PERMISOS(
ID int not null,
NOMBRE varchar(50)not null,
PRIMARY KEY(ID)
);

create table PERMISOS_USUARIOS(
PERMISO_ID int not null,
USERS_ARTIFACTS_ID bigint not null,
PRIMARY KEY(PERMISO_ID,USERS_ARTIFACTS_ID)
);

alter table PERMISOS_USUARIOS add constraint PUSER$PER foreign key (PERMISO_ID) references PERMISOS(ID);
alter table PERMISOS_USUARIOS add constraint PUSER$USART foreign key (USERS_ARTIFACTS_ID) references USERS_ARTIFACTS(ID);
