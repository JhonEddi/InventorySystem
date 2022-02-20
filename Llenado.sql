--Llenado Tabla Cargo
insert into cargo values (1, 'Asesor de Ventas');
insert into cargo values (2, 'Administrador');
insert into cargo values (3, 'Soporte');

--Llenado Tabla Usuarios
insert into usuario values (1075, 'Malagon', 23, '02/20/2021', 'Jhon', 2);
insert into usuario values (2, 'Prueba2', 30, '01/29/2021', 'Usuario2', 2);
insert into usuario values (3, 'Prueba3', 26, '01/10/2021', 'Usuario3', 1);
insert into usuario values (4, 'Prueba4', 28, '12/26/2021', 'Usuario4', 1);
insert into usuario values (5, 'Prueba5', 24, '12/12/2021', 'Usuario5', 3);
insert into usuario values (6, 'Prueba6', 20, '02/14/2021', 'Usuario6', 3);

--Llenado Tabla Mercancia
--Mercancia para Usuario 1(Jhon)
insert into mercancia values ('Mercancia1', 12, '03/21/2021', 1075);
insert into mercancia values ('Mercancia2', 23, '04/22/2021', 1075);
insert into mercancia values ('Mercancia3', 45, '05/23/2021', 1075);
--Mercancia para Usuario 2
insert into mercancia values ('Mercancia4', 10, '01/29/2021', 2);
insert into mercancia values ('Mercancia5', 3, '02/21/2021', 2);
insert into mercancia values ('Mercancia6', 8, '03/29/2021', 2);
--Mercancia para Usuario 3
insert into mercancia values ('Mercancia7', 13, '02/11/2021', 3);
insert into mercancia values ('Mercancia8', 14, '03/12/2021', 3);
insert into mercancia values ('Mercancia9', 16, '04/13/2021', 3);
--Mercancia para Usuario 4
insert into mercancia values ('Mercancia10', 22, '12/29/2021', 4);
insert into mercancia values ('Mercancia11', 4, '01/01/2022', 4);
insert into mercancia values ('Mercancia12', 0, '02/21/2022', 4);
--Mercancia para Usuario 5
insert into mercancia values ('Mercancia13', 13, '12/25/2021', 5);
insert into mercancia values ('Mercancia14', 16, '01/20/2022', 5);
insert into mercancia values ('Mercancia15', 1, '02/01/2022', 5);
--Mercancia para Usuario 6
insert into mercancia values ('Mercancia16', 25, '06/21/2021', 6);
insert into mercancia values ('Mercancia17', 10, '07/22/2021', 6);
insert into mercancia values ('Mercancia18', 11, '08/05/2021', 6);

--Llenado de Tabla Registro
insert into registro values ();