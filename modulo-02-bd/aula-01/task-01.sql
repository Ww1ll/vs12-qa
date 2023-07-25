CREATE TABLE VEM_SER.ESTUDANTE (
	id NUMBER NOT NULL,
	nome CHAR(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) NOT NULL UNIQUE,
	ativo CHAR(1) CHECK (ativo = 'S' OR ativo = 'N'),
	PRIMARY KEY (id)
);


CREATE SEQUENCE seq_estudante
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'william', TO_DATE('05-06-1995', 'dd-mm-yyyy'), 5897425410, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'larissa', TO_DATE('05-10-1995', 'dd-mm-yyyy'), 6645061082, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'tom', TO_DATE('05-08-1995', 'dd-mm-yyyy'), 6982914072, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'rafaela', TO_DATE('10-01-1985', 'dd-mm-yyyy'), 4137620513, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'ted', TO_DATE('05-07-1965', 'dd-mm-yyyy'), 9545398229, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'alexandre', TO_DATE('30-06-2002', 'dd-mm-yyyy'), 3330853246, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'maria', TO_DATE('27-08-2001', 'dd-mm-yyyy'), 9430583838, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'joao', TO_DATE('25-06-1995', 'dd-mm-yyyy'), 5601315348, 'N');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'patrick', TO_DATE('04-06-1991', 'dd-mm-yyyy'), 8869929991, 'S');

INSERT INTO VEM_SER.ESTUDANTE (id, nome, data_nascimento, nr_matricula, ativo)
VALUES (seq_estudante.NEXTVAL, 'barbara', TO_DATE('03-09-1995', 'dd-mm-yyyy'), 4775089857, 'S');

SELECT * FROM VEM_SER.ESTUDANTE;






