-- Caio Ueno 743516
--Gabriel Cheban 743535

-- drop database Aeroporto;

-- create database Aeroporto;

-- B O A S P R Á T I C A S
drop table Viaja;
drop table Trabalha;
drop table VooInfos;
drop table Passageiro;
drop table Voo;
drop table Aeronave;
drop table Aeroporto;
drop table Piloto;

create table Piloto(
  cpf char(11) primary key,
  cht char(8) not null,
  func varchar(8) not null,
  nome varchar(100) not null
);

create table Aeroporto(
  codigoAero serial primary key,
  cidade varchar(50) not null,
  estado char(2) not null,
  pais varchar(50) not null,
  nomeAero varchar(100) not null
);

create table Aeronave(
  IDAero serial primary key,
  modelo char(4) not null,
  capacidade integer not null,
  tipo varchar(50) not null
);

-- TRIGGERRRRR qtde passageiros
create table Voo(
  codigo serial primary key,
  IDAero integer not null,
  codAeroOri integer not null,
  codAeroDst integer not null,
  -- ident varchar(30),

  constraint FK_ID foreign key (IDAero) references Aeronave(IDAero),
  constraint FK_codOri foreign key (codAeroOri) references Aeroporto(codigoAero),
  constraint FK_codDes foreign key (codAeroDst) references Aeroporto(codigoAero)
);

-- Depende do voo
create table Passageiro(
  cpf char(11) primary key,
  nome varchar(100) not null,
  passaporte char(8) not null
);

create table VooInfos(
  codigoVoo integer primary key,
  dDecolagem date not null,
  dAterrissagem date not null,
  qtdPass integer not null,

  constraint FK_codiVoo foreign key (codigoVoo) references Voo(codigo)
);

create table Trabalha(
  cpf char(11),
  codigoVoo integer,

  constraint PK_Trabalha primary key (cpf, codigoVoo),
  constraint FK_codVoo foreign key (codigoVoo) references Voo(codigo),
  constraint FK_cpfPi foreign key (cpf) references Piloto(cpf)
);

create table Viaja(
  cpf char(11),
  codigoVoo integer,
  assento char(3) not null,
  IDbagagem char(5) unique,

  constraint PK_Viaja primary key (cpf, codigoVoo),
  constraint FK_cpfPas foreign key (cpf) references Passageiro(cpf),
  constraint FK_codigoVoo foreign key (codigoVoo) references Voo(codigo)
);


--PROCEDURES
-- Todos para inserção em tabelas
create or replace procedure inserirPiloto(char(11), char(8), varchar(8),varchar(100))
LANGUAGE sql
AS $$
    insert into Piloto values ($1,$2,$3,$4);
$$;

create or replace procedure inserirAeroporto(integer, varchar(50), char(2), varchar(50),varchar(100))
LANGUAGE sql
AS $$
    insert into Aeroporto values (DEFAULT,$2,$3,$4,$5);
$$;

create or replace procedure inserirAeronave(integer, char(4), integer, varchar(50))
LANGUAGE sql
AS $$
    insert into Aeronave values (DEFAULT,$2,$3,$4);
$$;

create or replace procedure inserirVoo(integer, integer, integer, integer)
LANGUAGE sql
AS $$
    insert into Voo values (DEFAULT,$2,$3,$4);
$$;

create or replace procedure inserirPassageiro(char(11), varchar(100), varchar(8))
LANGUAGE sql
AS $$
    insert into Passageiro values ($1,$2,$3);
$$;

create or replace procedure inserirVooInfos(integer, date, date, integer)
LANGUAGE sql
AS $$
    insert into VooInfos values ($1,$2,$3,$4);
$$;

create or replace procedure inserirTrabalha(char(11), integer)
LANGUAGE sql
AS $$
    insert into Trabalha values ($1,$2);
$$;

create or replace procedure inserirViaja(char(11), integer, char(3), char(5))
LANGUAGE sql
AS $$
    insert into Viaja values ($1,$2,$3,$4);
$$;


-- FUNÇÕES
create or replace function getCPFPiloto (char(11))
RETURNS varchar(100) as $$
DECLARE
    nom varchar(100);
BEGIN
   SELECT nome into nom FROM Piloto P WHERE P.cpf = $1;
   RETURN nom;
END;
$$ LANGUAGE plpgsql;

create or replace function getDataDec (integer)
RETURNS date as $$
DECLARE
    d date;
BEGIN
   SELECT dDecolagem into d FROM VooInfos V WHERE V.codigoVoo = $1;
   RETURN d;
END;
$$ LANGUAGE plpgsql;

create or replace function getDataAte (integer)
RETURNS date as $$
DECLARE
    d date;
BEGIN
   SELECT dAterrissagem into d FROM VooInfos V WHERE V.codigoVoo = $1;
   RETURN d;
END;
$$ LANGUAGE plpgsql;

create or replace function getVooPiloto (char(11))
RETURNS integer as $$
DECLARE
    CodVoo integer;
BEGIN
   SELECT codigoVoo into CodVoo FROM (VooInfos V NATURAL JOIN Piloto P) AS T WHERE T.cpf = $1;
   RETURN CodVoo;
END;
$$ LANGUAGE plpgsql;



-- TRIGGERS
-- Aumenta a quantidade de passageiros num voo quando eles são inseridos
CREATE OR REPLACE FUNCTION Attqtde() RETURNS TRIGGER AS $triggerPass$
    BEGIN
           UPDATE VooInfos SET qtdPass = qtdPass + 1 WHERE VooInfos.codigoVoo = NEW.codigoVoo;
    RETURN NEW;
    END;

$triggerPass$ LANGUAGE plpgsql;

CREATE TRIGGER triggerPass
AFTER INSERT ON Viaja
    FOR EACH ROW EXECUTE PROCEDURE Attqtde();

-- Deleta os passageiros, pilotos e informações de um voo que foi cancelado
CREATE OR REPLACE FUNCTION CancelaVoo() RETURNS TRIGGER AS $triggerVoo$
    BEGIN
    -- Remover Viaja, Trabalha, VooInfos
           DELETE FROM Viaja WHERE Viaja.codigoVoo = OLD.codigo;
           DELETE FROM Trabalha WHERE Trabalha.codigoVoo = OLD.codigo;
           DELETE FROM VooInfos WHERE VooInfos.codigoVoo = OLD.codigo;
    RETURN OLD;
    END;

$triggerVoo$ LANGUAGE plpgsql;

CREATE TRIGGER triggerVoo
BEFORE DELETE ON Voo
    FOR EACH ROW EXECUTE PROCEDURE CancelaVoo();
