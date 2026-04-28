Create database rosatel;
use rosatel;
Create table categoria(
	id int primary key Auto_increment,
    detalle char(50) unique
);

Create table subcategoria(
	id int primary key Auto_increment,
    idCategoria int not null,
    detalle char(50) unique,
    Foreign key(idCategoria) references categoria(id)
);

Create table producto(
	id int primary key Auto_increment,
    idSubCategoria int not null,    
    nombre char(50) not null,
    descripcion text(300),
    precio decimal(10, 2) not null,
    stock int not null,
    Foreign key(idSubCategoria) references subcategoria(id)
);

Create table color(
	id int primary key Auto_increment,
    detalle char(30)
);

Create table producto_color(
	idProducto int not null,
    idColor int not null,
	Primary key(idProducto, idColor),
    Foreign key(idProducto) references producto(id),
    Foreign key(idColor) references color(id)
);

insert categoria (detalle) VALUES 
	('Flores'), 
	('Peluches'), 
	('Chocolates y Dulces'),
	('Bebidas y Licores');

insert subcategoria (idCategoria, detalle) VALUES 
	(1, 'Cajas de Rosas'), 
	(1, 'Ramos Fúnebres'), 
	(2, 'Osos de Felpa'), 
	(3, 'Bombones de Autor'),
	(4, 'Vinos y Espumantes');

insert color (detalle) VALUES 
	('Rojo'), ('Blanco'), ('Rosado'), ('Azul'), ('Crema');

insert producto (idSubCategoria, nombre, descripcion, precio, stock) VALUES 
	( 1, 'Caja Rosatel Clásica', 'Caja negra con 12 rosas rojas frescas.', 149.90, 100),
	(1, 'Caja Blanca Elegance', 'Caja blanca con 18 rosas rosadas.', 189.00, 40),
	(3, 'Oso Rosatel con Corazón', 'Oso de felpa suave con logo bordado.', 75.00, 25),
	(4, 'Caja de Trufas Mixtas', 'Colección de 12 trufas de chocolate belga.', 55.00, 80),
	(5, 'Champagne Moët & Chandon', 'Botella de 750ml para celebraciones.', 350.00, 15);

-- caja clasica
insert producto_color (idProducto, idColor) VALUES (1, 1), (1, 2);
-- oso
INSERT INTO producto_color (idProducto, idColor) VALUES (3, 5), (3, 3);