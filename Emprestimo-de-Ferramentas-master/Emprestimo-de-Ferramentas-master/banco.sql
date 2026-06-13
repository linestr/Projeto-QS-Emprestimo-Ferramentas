-- Criar o banco de dados se não existir
CREATE DATABASE IF NOT EXISTS `database`;

-- Selecionar o banco de dados criado
USE `database`;

-- Remover tabelas se elas existirem
DROP TABLE IF EXISTS `tb_ferramentas`;
DROP TABLE IF EXISTS `tb_emprestimos`;
DROP TABLE IF EXISTS `tb_amigos`;

-- Tabela para armazenar informações sobre amigos
CREATE TABLE IF NOT EXISTS `tb_amigos` (
  `id_amigo` INT NOT NULL AUTO_INCREMENT,  -- Identificador único do amigo
  `nome` VARCHAR(45) NOT NULL,             -- Nome do amigo
  `telefone` VARCHAR(45) NOT NULL,         -- Número de telefone do amigo
  PRIMARY KEY (`id_amigo`)                 -- Definir `id_amigo` como chave primária
) ENGINE = InnoDB;

-- Tabela para armazenar informações sobre empréstimos
CREATE TABLE IF NOT EXISTS `tb_emprestimos` (
  `id_emprestimo` INT NOT NULL AUTO_INCREMENT,  -- Identificador único do empréstimo
  `data_emprestimo` DATE NOT NULL,              -- Data de empréstimo
  `data_devolucao` DATE NOT NULL,               -- Data de devolução prevista
  `entregue` BOOLEAN NOT NULL,                  -- Indicador se o item foi devolvido
  `id_amigo` INT NOT NULL,                      -- ID do amigo relacionado ao empréstimo
  PRIMARY KEY (`id_emprestimo`),                -- Definir `id_emprestimo` como chave primária
  INDEX `fk_tb_emprestimos_tb_amigos_idx` (`id_amigo` ASC),  -- Índice para chave estrangeira
  CONSTRAINT `fk_tb_emprestimos_tb_amigos`       -- Chave estrangeira para `id_amigo`
    FOREIGN KEY (`id_amigo`)
    REFERENCES `tb_amigos` (`id_amigo`)
    ON DELETE NO ACTION                           -- Não excluir amigos relacionados
    ON UPDATE NO ACTION                           -- Não atualizar automaticamente se `id_amigo` for alterado
) ENGINE = InnoDB;

-- Tabela para armazenar informações sobre ferramentas
CREATE TABLE IF NOT EXISTS `tb_ferramentas` (
  `id_ferramenta` INT NOT NULL AUTO_INCREMENT,  -- Identificador único da ferramenta
  `nome` VARCHAR(45) NOT NULL,                  -- Nome da ferramenta
  `marca` VARCHAR(45) NOT NULL,                 -- Marca da ferramenta
  `custo_aquisicao` DOUBLE NOT NULL,            -- Custo de aquisição da ferramenta
  `id_emprestimo` INT,                          -- ID do empréstimo relacionado (pode ser nulo se não emprestado)
  PRIMARY KEY (`id_ferramenta`),                -- Definir `id_ferramenta` como chave primária
  INDEX `fk_tb_ferramentas_tb_emprestimos1_idx` (`id_emprestimo` ASC),  -- Índice para chave estrangeira
  CONSTRAINT `fk_tb_ferramentas_tb_emprestimos1`  -- Chave estrangeira para `id_emprestimo`
    FOREIGN KEY (`id_emprestimo`)
    REFERENCES `tb_emprestimos` (`id_emprestimo`)
    ON DELETE NO ACTION                          -- Não excluir empréstimos relacionados
    ON UPDATE NO ACTION                          -- Não atualizar automaticamente se `id_emprestimo` for alterado
) ENGINE = InnoDB;
