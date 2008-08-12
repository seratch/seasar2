insert into ADDRESS (ID, CITY) values (1, 'aaa');
insert into ADDRESS (ID, CITY) values (2, 'bbb');
insert into ADDRESS (ID, CITY) values (3, 'ccc');
insert into BIG_DECIMAL_ENTITY (BIG_DECIMAL_PROPERTY) values (10.123456789);
insert into BIG_INTEGER_ENTITY (BIG_INTEGER_PROPERTY) values (123456789123456789);
insert into BOOLEAN_ENTITY (BOOLEAN_PROPERTY) values (1);
--insert into BYTE_ARRAY_ENTITY (BYTE_ARRAY_PROPERTY, BLOB_PROPERTY) values ('aaa', 'bbb');
insert into BYTE_ENTITY (BYTE_PROPERTY) values (1);
insert into CALENDAR_ENTITY (DATE_PROPERTY, TIME_PROPERTY, TIMESTAMP_PROPERTY) values ('2005-02-14', '12:11:10', '2005-02-14 12:11:10.123456');
insert into CHARACTER_ENTITY (CHARACTER_PROPERTY) values ('a');
insert into DATE_ENTITY (DATE_PROPERTY, TIME_PROPERTY, TIMESTAMP_PROPERTY) values ('2005-02-14', '12:11:10', '2005-02-14 12:11:10.123456');
insert into DEPARTMENT (ID, NAME) values (1, 'aaa');
insert into DOUBLE_ENTITY (DOUBLE1_PROPERTY) values (123.456);
insert into EMPLOYEE (ID, FIRST_NAME, LAST_NAME, DEPARTMENT_ID, ADDRESS_ID) values (1, 'aaa', 'bbb', 1, 1);
insert into ENUM_ENTITY (ENUM_PROPERTY) values(0);
insert into FLOAT_ENTITY (FLOAT_PROPERTY) values (123.456);
insert into INTEGER_ENTITY (INTEGER_PROPERTY) values (123456789);
insert into LONG_ENTITY (LONG_PROPERTY) values (123456789123456789);
--insert into SERIALIZABLE_ENTITY ('aaa', 'bbb');
insert into SHORT_ENTITY (SHORT_PROPERTY) values (12345);
insert into SQL_DATE_ENTITY (SQL_DATE_PROPERTY) values ('2005-02-14');
insert into STRING_ENTITY (STRING_PROPERTY, CLOB_PROPERTY) values ('aaa', 'bbb');
insert into TIME_ENTITY (TIME_PROPERTY) values ('12:11:10');
insert into TIMESTAMP_ENTITY (TIMESTAMP_PROPERTY) values ('2005-02-14 12:11:10.123456');