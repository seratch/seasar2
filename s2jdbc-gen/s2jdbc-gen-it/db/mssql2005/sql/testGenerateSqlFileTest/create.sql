create table department(department_id int not null primary key, department_no int not null unique,department_name varchar(20),location varchar(20) default 'tokyo', version int);
create table address(address_id int not null primary key, street varchar(20), version int);
create table employee(employee_id int not null primary key, employee_no int not null ,employee_name varchar(20),manager_id int,hiredate datetime,salary decimal(7,2),department_id int,address_id int, version int, constraint fk_department_id foreign key(department_id) references department(department_id), constraint fk_address_id foreign key(address_id) references address(address_id));