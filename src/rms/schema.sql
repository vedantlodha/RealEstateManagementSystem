
create table builder(
	name varchar(50),
	builder_id int,
	address varchar(50),
	contact varchar(50),
	email varchar(50),
	constraint pk_builder
	primary key(builder_id)
);

create table project(
	project_id int,
	no_of_flats int,
	etd int ,--Estimated time to delivery in months
	constraint pk_project 
	primary key (project_id)
);

create table engineer(
	name varchar(50),
	engineer_id int,
	project_id int,
	builder_id int,
	salary int,
	email varchar(50),
	primary key(engineer_id),
	foreign key (builder_id) references builder(builder_id),
	foreign key(project_id) references project(project_id)
);



create table unit(
	unit_no int,
	description varchar(50),
	primary key (unit_no)
);



create table flat(
	project_id int,
	flat_no int,
	price int,
	occupied int,
	primary key(project_id,flat_no)
	);



create table manager(
	name varchar(50);
	manager_id int,
	saalary int,
	email varchar(20),
	password varchar(50)
	primary key(manager_id)
);

create table labour(
	name varchar(30),
	labour_id int,
	engineer_id int,
	unit_no int,
	primary key (labour_id)	,
	foreign key (engineer_id) references engineer(engineer_id),
	foreign key (unit_no) references unit(unit_no)
);

create table customer(
	name varchar(50),
	customer_id int,
	project_id int,
	flat_no int,
	pendingDueue int,
	primary key customer_id,
	foreign key (builder_id) references builder (builder_id)
);