-- Caio Ueno 743516
--Gabriel Cheban 743535

-- 3 Consultas interessantes para o banco de um aeroporto
SELECT cht FROM Trabalha T, Piloto P WHERE T.cpf = P.cpf AND P.func LIKE 'Piloto';
SELECT cpf FROM Viaja V, VooInfos VI WHERE V.codigoVoo = VI.codigoVoo AND dDecolagem = TO_DATE('2014/06/30', 'yyyy/mm/dd');
SELECT codigoVoo FROM VooInfos VI, Voo V WHERE V.codigo = 2 AND V.codigo = VI.codigoVoo;

EXPLAIN ANALYZE SELECT nome, cpf FROM Passageiro WHERE cpf IN
      (SELECT cpf FROM Viaja WHERE codigoVoo =
            (SELECT codigoVoo FROM VooInfos WHERE dDecolagem = TO_DATE('2014/07/26', 'yyyy/mm/dd')));
          -- Planning time: 0.189 ms
          -- Execution time: 0.331 ms
          -- Tempo de planejamento menor do que o de exeução.

-- Criação dos índices
CREATE INDEX IDX_P ON Passageiro (cpf);
CREATE INDEX IDX_V ON Viaja (codigoVoo);
CREATE INDEX IDX_VI ON VooInfos (dDecolagem);


EXPLAIN ANALYZE SELECT nome, cpf FROM Passageiro WHERE cpf IN
      (SELECT cpf FROM Viaja WHERE codigoVoo =
            (SELECT codigoVoo FROM VooInfos WHERE dDecolagem = TO_DATE('2014/07/26', 'yyyy/mm/dd')));
            -- Após a criação dos índices, após algumas vezes, o banco otimiza a busca
            -- Planning time: 0.387 ms
            -- Execution time: 0.122 ms
            -- O tempo de execução diminuiu.


--CURSORES
create or replace function aeroCursor()
	RETURNS text as $$
DECLARE
  saida TEXT DEFAULT '';
  c_aeronaves CURSOR FOR SELECT * FROM Aeronave;
  aeronave Aeronave%ROWTYPE;
BEGIN
   OPEN c_aeronaves;
   LOOP
   FETCH c_aeronaves into aeronave;
      EXIT WHEN not found;
      saida := saida || aeronave.modelo || ',' || aeronave.capacidade || '     ';
   END LOOP;
   CLOSE c_aeronaves;
   RETURN saida;
END;
$$
language plpgsql;

create or replace function pilotoCursor()
	RETURNS text as $$
DECLARE
  saida TEXT DEFAULT '';
  c_pilotos CURSOR FOR SELECT * FROM Piloto;
  piloto Piloto%ROWTYPE;
BEGIN
   OPEN c_pilotos;
   LOOP
   FETCH c_pilotos into piloto;
      EXIT WHEN not found;
      saida := saida || piloto.cht || ',' || piloto.func || '      ';
   END LOOP;
   CLOSE c_pilotos;
   RETURN saida;
END;
$$
language plpgsql;


SELECT pilotoCursor();
