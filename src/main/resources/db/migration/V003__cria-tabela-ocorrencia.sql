create table ocorrencia(
    id int not null auto_increment,
    entrega_id int not null,
    descricao text not null,    
    data_registro datetime not null,
    
    primary key (id)  
);

alter table ocorrencia add constraint fk_ocorrencia_entrega
foreign key (entrega_id) references entrega (id)