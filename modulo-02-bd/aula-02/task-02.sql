ALTER SESSION SET CURRENT_SCHEMA=VEM_SER;

-- Países por ordem decrescente
SELECT * FROM VEM_SER.PAIS ORDER BY NOME DESC;

-- Logradouros e cep que começam com 'a'
SELECT logradouro, cep FROM VEM_SER.ENDERECO WHERE LOWER(logradouro) LIKE 'a%';

-- Selecionando endereços com CEP final '0'
SELECT * FROM VEM_SER.ENDERECO WHERE CEP LIKE '%0';

-- Selecionando endereços com numeros entre 1 e 100
SELECT * FROM VEM_SER.ENDERECO WHERE NUMERO BETWEEN 1 AND 100;

-- Selecionando endereços que começam com 'rua' e ordenando o cep por ordem decrescente
SELECT * FROM VEM_SER.ENDERECO WHERE LOWER(logradouro) LIKE 'rua%' ORDER BY CEP DESC;

-- Selecionando a quantidade de endereços cadastrados na tabela
SELECT COUNT(id_endereco) FROM VEM_SER.ENDERECO; 

-- Selecionando a quantidade de endereços cadastrados e agrupando-os pelo id da cidade
SELECT COUNT(id_endereco), id_cidade FROM VEM_SER.ENDERECO GROUP BY id_cidade;