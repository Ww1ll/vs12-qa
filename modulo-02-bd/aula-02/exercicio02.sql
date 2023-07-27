ALTER SESSION SET CURRENT_SCHEMA=VEM_SER;

CREATE SEQUENCE SEQ_PAIS
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;


CREATE SEQUENCE SEQ_ESTADO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;


CREATE SEQUENCE SEQ_CIDADE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;


CREATE SEQUENCE SEQ_BAIRRO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;


CREATE SEQUENCE SEQ_ENDERECO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

-- Inserindo paises
INSERT INTO VEM_SER.PAIS (id_pais, nome) 
VALUES (SEQ_PAIS.NEXTVAL, 'Brasil');

INSERT INTO VEM_SER.PAIS (id_pais, nome) 
VALUES (SEQ_PAIS.NEXTVAL, 'Noruega');

SELECT * FROM PAIS;

SELECT * FROM ESTADO;

--Inserindo estados
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 1, 'Pará');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 1, 'São Paulo');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 2, 'Oslo');

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome)
VALUES (SEQ_ESTADO.NEXTVAL, 2, 'Nordland');


-- Inserindo cidade
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 1, 'Belém');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 1, 'Altamira');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 2, 'Santos');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 2, 'Araraquara');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 3, 'Ranricia');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 3, 'Viken');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 4, 'Bodo');

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome)
VALUES (SEQ_CIDADE.NEXTVAL, 4, 'Trondelag');


SELECT * FROM ESTADO, CIDADE;

-- Inserindo bairro
INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 1, 1,'Vila Belém');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 1, 1,'Vila Nova Belém');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 2, 1,'Vila Altamira');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 2, 1,'Vila Velha Altamira');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 3, 2,'Vila Santos');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 3, 2,'Vila Nova Santos');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 4, 2,'Jardim Araraqua');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 4, 2,'Velha Araraquara');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 5, 3,'Nynorsk');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 5, 3,'New England');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 6, 3,'Bakklandet');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 6, 3,'Ovre Holmegate');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 7, 4,'Grunerlokka');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 7, 4,'Tjuvholmen Neighbourhood');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 8, 4,'Gamle Laerdalsoeyri');

INSERT INTO VEM_SER.BAIRRO(id_bairro, id_cidade, id_estado, nome)
VALUES (SEQ_BAIRRO.NEXTVAL, 8, 4,'Vulkan');

-- Inserindo Endereco
INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 1, 1,'Rua das Flores',58, 'Sem complemento', '01000-000');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 1, 1, 'Avenida dos Palmares',125, 'Bloco B', '20000-000');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 2, 1, 'Rua das Estrelas', 1010, 'Bloco A', '30030-000');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 2, 1,'Alameda das Águas',222, 'Sem complemento', '9000-025');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 3, 2,'Rua do Sol', 28, 'Casa 5', '30040-003');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 3, 2,'Avenida das Montanhas',320, 'Casa 2', '59010-045');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 4, 2,'Travessa das Rosas',098, 'Bloco Beta', '59000-154');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 4, 2,'Avenida das Árvores',005, 'Bloco 9', '59000-889');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 5, 3,'Rua das Andorinhas',123, 'Bloco A', '5900-321');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 5, 3,'Rua do Lago',560, 'Bloco C', '59000-123');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 6, 3,'Alameda dos Ipês',800, 'Bloco A', '38900-000');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 6, 3,'Travessa das Pedras',1254, 'Sem complemento', '39000-000');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 7, 4,'Rua das Cachoeiras',36, 'Sem complemento', '59000-006');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 7, 4,'Avenida do Mar',2036, 'Bloco A', '59000-005');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 8, 4,'Rua das Colinas',003, 'Sem complemento', '59000-002');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 8, 4, 'Avenida dos Lagos',052, 'Sem complemento', '59000-000');

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 9, 5, 'Havnegata', 12, 'Bloco 2', '7010');

UPDATE VEM_SER.ENDERECO SET cep = '69000-000' WHERE LOGRADOURO = 'Havnegata';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 9, 5, 'Fjordveien', 45, 'Apartamento 5', '0182');

UPDATE VEM_SER.ENDERECO SET cep = '69000-123' WHERE LOGRADOURO = 'Fjordveien';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 10, 5, 'Skogsgata', 22, 'Bloco3', '9008');

UPDATE VEM_SER.ENDERECO SET cep = '69000-120' WHERE LOGRADOURO = 'Skogsgata';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 10, 5, 'Fjellveien', 11, 'Apartamento 4', '5003');

UPDATE VEM_SER.ENDERECO SET cep = '67786-980' WHERE LOGRADOURO = 'Fjellveien';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 11, 6, 'Strandveien', 9, 'Bloco 1', '7001');

UPDATE VEM_SER.ENDERECO SET cep = '67780-900' WHERE LOGRADOURO = 'Strandveien';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 11, 6, 'Gatenavn', 77, 'Bloco 6', '4002');

UPDATE VEM_SER.ENDERECO SET cep = '67780-872' WHERE LOGRADOURO = 'Gatenavn';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 12, 6, 'Sjøveien', 3, 'Apartamento 2A', '6006');

UPDATE VEM_SER.ENDERECO SET cep = '67090-870' WHERE LOGRADOURO = 'Sjøveien';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 12, 6, 'Gårdsgaten', 14, 'Apartamento 3', '8004');

UPDATE VEM_SER.ENDERECO SET cep = '67090-321' WHERE LOGRADOURO = 'Gårdsgaten';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 13, 7, 'Skogveien', 33, 'Bloco 7', '9011');

UPDATE VEM_SER.ENDERECO SET cep = '67090-000' WHERE LOGRADOURO = 'Skogveien';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 13, 7, 'Fjellgata', 8, 'Apartamento 2B', '5001');

UPDATE VEM_SER.ENDERECO SET cep = '67090-598' WHERE LOGRADOURO = 'Fjellgata';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 14, 7, 'Sjøgata', 21, 'Bloco 4', '7003');

UPDATE VEM_SER.ENDERECO SET cep = '67000-980' WHERE LOGRADOURO = 'Sjøgata';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 14, 7, 'Bakkeveien', 16, 'Bloco 8', '4006');

UPDATE VEM_SER.ENDERECO SET cep = '67000-069' WHERE LOGRADOURO = 'Bakkeveien';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 15, 8, 'Fjordgata', 29, 'Apartamento 3A', '6010');

UPDATE VEM_SER.ENDERECO SET cep = '69000-000' WHERE LOGRADOURO = 'Havnegata';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 15, 8, 'Gårdsplassen', 10, 'Bloco 5', '8001');

UPDATE VEM_SER.ENDERECO SET cep = '67000-060' WHERE LOGRADOURO = 'Gårdsplassen';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 16, 8, 'Havnepromenaden', 42, 'Apartamento 9', '0188');

UPDATE VEM_SER.ENDERECO SET cep = '69000-068' WHERE LOGRADOURO = 'Havnepromenaden';

INSERT INTO VEM_SER.ENDERECO(id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep)
VALUES (SEQ_BAIRRO.NEXTVAL, 16, 8, 'Skogsveien', 13, 'Bloco 6B', '9003');

UPDATE VEM_SER.ENDERECO SET cep = '69000-098' WHERE LOGRADOURO = 'Skogsveien';
