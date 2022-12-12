CREATE TABLE PESSOA (CPF VARCHAR(255) NOT NULL, DTYPE VARCHAR(31), NOME VARCHAR(255), BAIRRO VARCHAR(255), CIDADE VARCHAR(255), ESTADO VARCHAR(255), RUA VARCHAR(255), TELEFONE INTEGER, CRV VARCHAR(255), ESPECIALIDADE VARCHAR(255), PRIMARY KEY (CPF))
CREATE TABLE CONTRATO (ID  SERIAL NOT NULL, DATA VARCHAR(255), COPARTICIPACAO BOOLEAN, NOME VARCHAR(255), PET_ID INTEGER, PRIMARY KEY (ID))
CREATE TABLE PET (ID  SERIAL NOT NULL, ESPECIE VARCHAR(255), NOME VARCHAR(255), RACA VARCHAR(255), SEXO VARCHAR(255), TUTOR_CPF VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PROCEDIMENTO (CODIGO  SERIAL NOT NULL, DATA VARCHAR(255), DESCRICAO VARCHAR(255), VALOR FLOAT, PET_ID INTEGER, VETERINARIO_CPF VARCHAR(255), PRIMARY KEY (CODIGO))
ALTER TABLE CONTRATO ADD CONSTRAINT FK_CONTRATO_PET_ID FOREIGN KEY (PET_ID) REFERENCES PET (ID)
ALTER TABLE PET ADD CONSTRAINT FK_PET_TUTOR_CPF FOREIGN KEY (TUTOR_CPF) REFERENCES PESSOA (CPF)
ALTER TABLE PROCEDIMENTO ADD CONSTRAINT FK_PROCEDIMENTO_PET_ID FOREIGN KEY (PET_ID) REFERENCES PET (ID)
ALTER TABLE PROCEDIMENTO ADD CONSTRAINT FK_PROCEDIMENTO_VETERINARIO_CPF FOREIGN KEY (VETERINARIO_CPF) REFERENCES PESSOA (CPF)