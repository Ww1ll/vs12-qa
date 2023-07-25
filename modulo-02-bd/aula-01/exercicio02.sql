CREATE SEQUENCE SEQ_PESSOA
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_PET
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO VEM_SER.PESSOA (id_pessoa, id_pet, nome, data_nascimento, telefone, idade, altura, cpf, email ) 
VALUES (SEQ_PESSOA.NEXTVAL, SEQ_PET.NEXTVAL, 'William', TO_DATE('05-05-1995', 'dd-mm-yyyy'), '(11)8965-2541', 59, 1.78, '58796358712', 'william@teste.com');

INSERT INTO VEM_SER.PESSOA (id_pessoa, id_pet, nome, data_nascimento, telefone, idade, altura, cpf, email ) 
VALUES (SEQ_PESSOA.NEXTVAL, SEQ_PET.NEXTVAL, 'Larissa', TO_DATE('05-05-1998', 'dd-mm-yyyy'), '(11)8069-2541', 58, 1.62, '89790658712', 'larissa@teste.com');

INSERT INTO VEM_SER.PESSOA (id_pessoa, id_pet, nome, data_nascimento, telefone, idade, altura, cpf, email )
 VALUES (SEQ_PESSOA.NEXTVAL, SEQ_PET.NEXTVAL, 'Tom', TO_DATE('05-05-1989', 'dd-mm-yyyy'), '(11)9865-2000', 13, 1.86, '58702535871', 'tom@teste.com');

INSERT INTO VEM_SER.PESSOA (id_pessoa, id_pet, nome, data_nascimento, telefone, idade, altura, cpf, email )
VALUES (SEQ_PESSOA.NEXTVAL, SEQ_PET.NEXTVAL, 'Rafaela', TO_DATE('05-05-2000', 'dd-mm-yyyy'), '(11)8503-2541', 20, 1.93, '58796359801', 'rafaela@teste.com');

SELECT * FROM VEM_SER.PESSOA;

UPDATE VEM_SER.PESSOA SET idade = idade + 1;

DELETE FROM VEM_SER.PESSOA WHERE id_pessoa = 4;

SELECT * FROM VEM_SER.PESSOA;