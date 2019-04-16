create table especialidade(
id_esp number(10) not null,
desc_esp varchar2(100) not null,
constraint esp_pk primary key (id_esp)
);

create sequence seq_esp
increment by 1
start with 1;

insert into especialidade(id_esp,desc_esp)
values(SEQ_ESP.NEXTVAL,'Cardiologia');

insert into especialidade(id_esp, desc_esp)
values(seq_esp.nextval,'Angiologia');

insert into especialidade(id_esp, desc_esp)
values(seq_esp.nextval,'Intestinologia');

insert into especialidade(id_esp, desc_esp)
values(seq_esp.nextval,'Barrigologia');

create table pessoa(
cpf varchar2(14) not null,
nome varchar2(100) not null,
sexo char(1) not null,
telefone varchar2(20),
dt_nascimento date,
constraint pessoa_pk primary key(cpf)
);

create table medico(
cpf varchar2(14) not null,
especialidade number(10) not null,
constraint pessoa_fk foreign key (cpf) references pessoa (cpf) on cascade,
constraint esp_fk foreign key (especialidade) references especialidade (id_esp)
);

create table enfermeiro(
cpf varchar2(14) not null,
carga_horaria number(10) not null,
constraint enf_fk foreign key (cpf) references pessoa (cpf) on cascade
);

create table auxAdm(
cpf varchar2(14) not null,
salario number(9,2) not null,
constraint auxAdm_fk foreign key (cpf) references pessoa (cpf) on cascade
);