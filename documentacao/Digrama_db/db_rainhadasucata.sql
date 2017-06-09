-- phpMyAdmin SQL Dump
-- version 4.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 09/06/2017 às 15:00
-- Versão do servidor: 5.5.52-0+deb7u1
-- Versão do PHP: 5.6.26-1~dotdeb+zts+7.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `rainhadasucata`
--

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`rainhadasucata`@`%%` PROCEDURE `relatorio_por_data` (IN `dataInicial` DATE, IN `dataFim` DATE)  NO SQL
SELECT vendas.id_vendas, clientes.nome_clientes, vendas.valor_total, vendas.data_hora_vendas FROM itens_de_vendas
INNER JOIN clientes
INNER JOIN produtos
INNER JOIN vendas
ON itens_de_vendas.fk_id_produto =  produtos.id_produtos AND itens_de_vendas.fk_id_venda = vendas.id_vendas AND vendas.fk_id_cliente = clientes.id_clientes
WHERE vendas.data_hora_vendas  BETWEEN dataInicial AND dataFim
GROUP BY vendas.id_vendas$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `ci_sessions`
--

CREATE TABLE `ci_sessions` (
  `id_session` varchar(40) NOT NULL DEFAULT '0',
  `ip_address` varchar(45) NOT NULL DEFAULT '0',
  `user_agent` varchar(120) NOT NULL,
  `last_activity` int(10) UNSIGNED NOT NULL DEFAULT '0',
  `user_data` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

CREATE TABLE `clientes` (
  `id_clientes` int(11) NOT NULL,
  `nome_clientes` varchar(90) NOT NULL,
  `cpf_clientes` varchar(20) NOT NULL,
  `data_nascimento_clientes` date DEFAULT NULL,
  `sexo_clientes` varchar(1) NOT NULL,
  `telefone_clientes` varchar(20) NOT NULL,
  `celular_clientes` varchar(20) DEFAULT NULL,
  `email_clientes` varchar(90) DEFAULT NULL,
  `cep_clientes` varchar(20) NOT NULL,
  `logradouro_clientes` varchar(80) NOT NULL,
  `numero_clientes` varchar(25) DEFAULT NULL,
  `bairro_clientes` varchar(60) NOT NULL,
  `cidade_clientes` varchar(60) NOT NULL,
  `estado_clientes` varchar(2) NOT NULL,
  `complemento_clientes` varchar(210) DEFAULT NULL,
  `data_cadastro_clientes` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletado_clientes` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `clientes`
--

INSERT INTO `clientes` (`id_clientes`, `nome_clientes`, `cpf_clientes`, `data_nascimento_clientes`, `sexo_clientes`, `telefone_clientes`, `celular_clientes`, `email_clientes`, `cep_clientes`, `logradouro_clientes`, `numero_clientes`, `bairro_clientes`, `cidade_clientes`, `estado_clientes`, `complemento_clientes`, `data_cadastro_clientes`, `deletado_clientes`) VALUES
(1, 'Barbara Amaral do Nascimento', '391.123.258-64', '2017-05-03', 'F', '(11) 5511-1111', '(11) 11111-1111', 'bah.amaral@bol.com.br', '19061-547', 'Rua Augusta Grotto da Silva', '215', 'Jardim Cambuy', 'Presidente Prudente', 'SP', '', '2017-05-31 15:38:05', 1),
(45, 'Fabio Junior', '122.218.128-80', '2017-05-04', 'M', '(11) 1111-1111', '(99) 99999-9999', 'fabio.jr@email.com', '89219-520', 'Rua Rui Barbosa', '992', 'Zona Industrial Norte', 'Joinville', 'SP', '', '2017-06-02 22:45:43', 1),
(46, 'Marcio', '411.439.358-70', '2017-05-01', 'M', '(11) 5515-2677', '(11) 95166-9431', 'marcio@trademarketing.digital', '04918-110', 'Rua HÃ?Â©lio Jacy Gouveia Schiefler', '42', 'Jardim Souza', 'SÃ?Â£o Paulo', 'AC', 'eeeeeeee', '2017-06-02 23:03:04', 1),
(47, 'Evelyn Camargo de Oliveira', '411.439.358-70', '1996-04-05', 'F', '(55) 5555-5555', '(99) 99999-9999', 'ecamargo@bol.com', '04918-110', 'Rua HÃ©lio Jacy Gouveia Schiefler', '42', 'Jardim Souza', 'SÃ£o Paulo', 'SP', 'Casa 4', '2017-05-31 15:34:02', 1),
(48, 'Everton Roberto', '411.439.358-70', '2017-05-02', 'M', '(11) 1111-1111', '(11) 11111-1111', 'everton_roliveira@outlook.com', '04918-110', 'Rua HÃ?Â©lio Jacy Gouveia Schiefler', '45', 'Jardim Souza', 'SÃ?Â£o Paulo', 'AC', '44444', '2017-05-31 17:52:23', 1),
(49, 'Fabio jr Ribeiro', '122.218.096-02', '0000-00-00', 'F', '(11) 1111-1122', '(22) 22222-2222', 'fabiojrribeiro@live.com', '04880-045', 'Rua Projetada', '55', 'R. Campo Belo', 'Sao Paulo', 'AC', 'ad', '2017-06-03 00:26:36', 1),
(50, 'Danilo Ramos', '402.471.418-01', '0000-00-00', 'M', '(11) 1111-1111', '(11) 11111-1111', 'danio.davanzzo@me.com', '09910-580', 'Rua São João (Jd Recanto)', '111111', 'Centro', 'Diadema', 'SP', '', '2017-06-03 03:04:38', 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente_tem_usuario`
--

CREATE TABLE `cliente_tem_usuario` (
  `data_hora_ctu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fk_id_clientes` int(11) NOT NULL,
  `fk_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para tabela `itens_de_vendas`
--

CREATE TABLE `itens_de_vendas` (
  `id_idv` int(11) NOT NULL,
  `quantidade_idv` int(11) DEFAULT NULL,
  `fk_id_venda` int(11) NOT NULL,
  `fk_id_produto` int(11) NOT NULL,
  `subtotal_idv` double(19,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=big5;

--
-- Gatilhos `itens_de_vendas`
--
DELIMITER $$
CREATE TRIGGER `Decrementa_estoque` BEFORE INSERT ON `itens_de_vendas` FOR EACH ROW BEGIN
    DECLARE estoque, saida int;

    SELECT produtos.estoque_produtos INTO estoque  FROM produtos
    WHERE produtos.id_produtos = New.fk_id_produto;
    SELECT New.quantidade_idv INTO saida;
    if  saida <= estoque
    THEN 
    UPDATE produtos SET produtos.estoque_produtos = estoque - New.quantidade_idv
    WHERE produtos.id_produtos = New.fk_id_produto LIMIT 1;
    ELSE
    signal sqlstate '45000' set message_text = 'Produto zerado';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `lojas`
--

CREATE TABLE `lojas` (
  `id_lojas` int(11) NOT NULL,
  `nome_lojas` varchar(100) NOT NULL,
  `cnpj_lojas` varchar(25) NOT NULL,
  `telefone_lojas` varchar(20) NOT NULL,
  `email_lojas` varchar(90) NOT NULL,
  `cep_lojas` varchar(15) NOT NULL,
  `logradouro_lojas` varchar(70) NOT NULL,
  `numero_lojas` varchar(20) DEFAULT NULL,
  `bairro_lojas` varchar(50) NOT NULL,
  `cidade_lojas` varchar(50) NOT NULL,
  `estado_lojas` varchar(2) NOT NULL,
  `deletado_lojas` tinyint(1) DEFAULT NULL,
  `data_cadastro_lojas` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `lojas`
--

INSERT INTO `lojas` (`id_lojas`, `nome_lojas`, `cnpj_lojas`, `telefone_lojas`, `email_lojas`, `cep_lojas`, `logradouro_lojas`, `numero_lojas`, `bairro_lojas`, `cidade_lojas`, `estado_lojas`, `deletado_lojas`, `data_cadastro_lojas`) VALUES
(1, 'Matriz', '1', '', '', '14390970', 'Avenida Francisco Antônio Mafra', '10', 'Centro', 'Santo Antônio da Alegria', 'SP', 1, NULL),
(2, 'Rainha Rio', '41.143.900/055', '(11) 5515-0000', 'joao@outlook.com.br', '22041-080', 'Rua Anita Garibaldi', '35', 'Copacabana', 'Rio de Janeiro', 'RJ', 0, '2017-05-31 05:26:46'),
(3, 'Rainha SP', '411.439.000-88', '(11)5515-2677', 'everton@outlook.com', '049181-10', 'Rua Hélio Jacy Gouveia', '42', 'Jardim São Francisco', 'São Paulo', 'SP', 0, '2017-05-31 14:38:36');

-- --------------------------------------------------------

--
-- Estrutura para tabela `permissoes`
--

CREATE TABLE `permissoes` (
  `id_permissoes` int(11) NOT NULL,
  `nome_permissoes` varchar(80) NOT NULL,
  `permissoes_selecionadas` text NOT NULL,
  `data_criacao_permissoes` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `situacao_permissoes` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `permissoes`
--

INSERT INTO `permissoes` (`id_permissoes`, `nome_permissoes`, `permissoes_selecionadas`, `data_criacao_permissoes`, `situacao_permissoes`) VALUES
(1, 'Admin', 'Todos', '2017-05-06 01:23:09', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

CREATE TABLE `produtos` (
  `id_produtos` int(11) NOT NULL,
  `nome_produtos` varchar(80) NOT NULL,
  `marca_produtos` varchar(45) DEFAULT NULL,
  `descricao_produtos` text,
  `preco_compra_produtos` decimal(10,2) DEFAULT NULL,
  `preco_venda_produtos` decimal(10,2) NOT NULL,
  `margem_venda_produtos` decimal(10,2) DEFAULT NULL,
  `estoque_produtos` int(11) NOT NULL,
  `estoque_minimo_produtos` int(11) DEFAULT NULL,
  `status_produtos` tinyint(1) NOT NULL DEFAULT '1',
  `deletado_produtos` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `produtos`
--

INSERT INTO `produtos` (`id_produtos`, `nome_produtos`, `marca_produtos`, `descricao_produtos`, `preco_compra_produtos`, `preco_venda_produtos`, `margem_venda_produtos`, `estoque_produtos`, `estoque_minimo_produtos`, `status_produtos`, `deletado_produtos`) VALUES
(1, 'Oleo de Freio', 'Rainha da Sucataa', 'Produto da Rainha', 25.00, 55.50, 0.00, 10, 6, 1, 0),
(2, 'Pneu', 'Pireli', 'Pneu Para aro 20', 10.00, 15.00, 0.00, 0, 2, 0, 0),
(3, 'Disco de Freio', 'Própria', 'Disco de Freio', 0.50, 2.00, 0.00, 6, 3, 1, 0),
(4, 'Disco sei la', 'queijo', 'sdsdsfds', 10.00, 20.00, 0.00, 11, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto_tem_usuario`
--

CREATE TABLE `produto_tem_usuario` (
  `data_hora_ptu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fk_id_produto` int(11) NOT NULL,
  `fk_id_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `produto_tem_usuario`
--

INSERT INTO `produto_tem_usuario` (`data_hora_ptu`, `fk_id_produto`, `fk_id_usuario`) VALUES
('2017-05-06 01:34:15', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura stand-in para view `relatorio`
--
CREATE TABLE `relatorio` (
`id_venda` int(11)
,`nome_cliente` varchar(90)
,`id_usuario` int(11)
,`nome_usuario` varchar(80)
,`id_loja` int(11)
,`nome_loja` varchar(100)
,`data_hora` timestamp
,`metodo_pagamento` varchar(20)
,`valor_total_venda` double(19,2)
,`nome_produto` varchar(80)
,`quantidade_produto` int(11)
,`subtotal_produto` double(19,2)
);

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuarios` int(11) NOT NULL,
  `nome_usuarios` varchar(80) NOT NULL,
  `cpf_usuarios` varchar(20) NOT NULL,
  `data_nascimento_usuarios` date NOT NULL,
  `sexo_usuarios` char(1) NOT NULL,
  `telefone_usuarios` varchar(20) NOT NULL,
  `celular_usuarios` varchar(20) DEFAULT NULL,
  `email_usuarios` varchar(90) NOT NULL,
  `cep_usuarios` varchar(20) DEFAULT NULL,
  `logradouro_usuarios` varchar(80) DEFAULT NULL,
  `numero_usuarios` varchar(15) DEFAULT NULL,
  `bairro_usuarios` varchar(60) DEFAULT NULL,
  `cidade_usuarios` varchar(60) DEFAULT NULL,
  `Estado_usuarios` varchar(2) DEFAULT NULL,
  `Complemento_usuarios` varchar(210) DEFAULT NULL,
  `nome_login_usuarios` varchar(90) NOT NULL,
  `senha_usuarios` varchar(30) NOT NULL,
  `imagem_usuarios` varchar(255) DEFAULT NULL,
  `nivel_usuarios` int(11) DEFAULT NULL,
  `status_usuarios` tinyint(1) NOT NULL,
  `data_cadastro_usuarios` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deletado_usuarios` tinyint(1) NOT NULL DEFAULT '0',
  `fk_id_permissao` int(11) NOT NULL,
  `fk_id_loja` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `usuarios`
--

INSERT INTO `usuarios` (`id_usuarios`, `nome_usuarios`, `cpf_usuarios`, `data_nascimento_usuarios`, `sexo_usuarios`, `telefone_usuarios`, `celular_usuarios`, `email_usuarios`, `cep_usuarios`, `logradouro_usuarios`, `numero_usuarios`, `bairro_usuarios`, `cidade_usuarios`, `Estado_usuarios`, `Complemento_usuarios`, `nome_login_usuarios`, `senha_usuarios`, `imagem_usuarios`, `nivel_usuarios`, `status_usuarios`, `data_cadastro_usuarios`, `deletado_usuarios`, `fk_id_permissao`, `fk_id_loja`) VALUES
(1, 'Iago Ricardo', '410.656.818-79', '2017-05-02', 'M', '(11) 4552-6168', '(11) 99999-9999', 'iago@trademarketing.digital', '06340-340', 'Rua HÃ©rcules Abruzzesse', '500', 'Parque Santa Teresa', 'CarapicuÃ­ba', 'SP', 'Casa 4', 'iago', '123456', NULL, 1, 1, '2017-06-02 23:02:58', 1, 1, 1),
(31, 'Everton Robeto', '411.439.358-70', '2017-05-06', 'M', '(11) 5515-2677', '(11) 95166-9431', 'everton_roliveira@outlook.com', '04918-110', 'Rua HÃ©lio Jacy Gouveia Schiefler', '42', 'Jardim Souza', 'SÃ£o Paulo', 'SP', '', 'everton', '123456', NULL, NULL, 1, '2017-05-31 01:19:10', 0, 1, 1),
(32, 'Marcio Gimenes', '411.439.358-70', '2017-05-05', 'M', '(45) 5267-6798', '(88) 88888-8888', 'marcio@trademarketing.digital', '06454-020', 'Avenida Cauaxi', '290', 'Alphaville Industrial', 'Barueri', 'AC', '', 'wmv', '123', NULL, NULL, 0, '2017-06-02 23:04:45', 1, 1, 1),
(34, 'Barbara Amaral do Nascimento', '411.439.358-70', '2012-04-01', 'M', '(11) 1111-1111', '(99) 99999-9999', 'bah.amaral@bol.com.br', '04918-110', 'Rua HÃ©lio Jacy Gouveia Schiefler', '54', 'Jardim Souza', 'SÃ£o Paulo', 'SP', '', 'bah.amaral', '123', NULL, NULL, 0, '2017-05-31 17:36:30', 0, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

CREATE TABLE `vendas` (
  `id_vendas` int(11) NOT NULL,
  `data_hora_vendas` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `metodo_pagamento` varchar(20) NOT NULL,
  `desconto_vendas` double(19,2) DEFAULT NULL,
  `fk_id_cliente` int(11) NOT NULL,
  `fk_id_usuario` int(11) NOT NULL,
  `valor_total` double(19,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura para view `relatorio`
--
DROP TABLE IF EXISTS `relatorio`;

CREATE ALGORITHM=UNDEFINED DEFINER=`rainhadasucata`@`%%` SQL SECURITY DEFINER VIEW `relatorio`  AS  select `vendas`.`id_vendas` AS `id_venda`,`clientes`.`nome_clientes` AS `nome_cliente`,`usuarios`.`id_usuarios` AS `id_usuario`,`usuarios`.`nome_usuarios` AS `nome_usuario`,`usuarios`.`fk_id_loja` AS `id_loja`,`lojas`.`nome_lojas` AS `nome_loja`,`vendas`.`data_hora_vendas` AS `data_hora`,`vendas`.`metodo_pagamento` AS `metodo_pagamento`,`vendas`.`valor_total` AS `valor_total_venda`,`produtos`.`nome_produtos` AS `nome_produto`,`itens_de_vendas`.`quantidade_idv` AS `quantidade_produto`,`itens_de_vendas`.`subtotal_idv` AS `subtotal_produto` from (((((`produtos` join `itens_de_vendas` on((`produtos`.`id_produtos` = `itens_de_vendas`.`fk_id_produto`))) join `vendas` on((`produtos`.`id_produtos` = `itens_de_vendas`.`fk_id_produto`))) join `clientes` on((`vendas`.`fk_id_cliente` = `clientes`.`id_clientes`))) join `usuarios` on((`vendas`.`fk_id_usuario` = `usuarios`.`id_usuarios`))) join `lojas` on((`usuarios`.`fk_id_loja` = `lojas`.`id_lojas`))) ;

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `ci_sessions`
--
ALTER TABLE `ci_sessions`
  ADD PRIMARY KEY (`id_session`),
  ADD KEY `last_activity_idx` (`last_activity`);

--
-- Índices de tabela `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_clientes`),
  ADD UNIQUE KEY `id_clientes_UNIQUE` (`id_clientes`);

--
-- Índices de tabela `cliente_tem_usuario`
--
ALTER TABLE `cliente_tem_usuario`
  ADD PRIMARY KEY (`data_hora_ctu`,`fk_id_clientes`,`fk_id_usuario`),
  ADD KEY `fk_clientes_has_usuarios_usuarios1_idx` (`fk_id_usuario`),
  ADD KEY `fk_clientes_has_usuarios_clientes1_idx` (`fk_id_clientes`);

--
-- Índices de tabela `itens_de_vendas`
--
ALTER TABLE `itens_de_vendas`
  ADD PRIMARY KEY (`id_idv`),
  ADD KEY `fk_id_venda` (`fk_id_venda`),
  ADD KEY `fk_id_produto` (`fk_id_produto`) USING BTREE;

--
-- Índices de tabela `lojas`
--
ALTER TABLE `lojas`
  ADD PRIMARY KEY (`id_lojas`),
  ADD UNIQUE KEY `id_lojas_UNIQUE` (`id_lojas`);

--
-- Índices de tabela `permissoes`
--
ALTER TABLE `permissoes`
  ADD PRIMARY KEY (`id_permissoes`),
  ADD UNIQUE KEY `id_permissoes_UNIQUE` (`id_permissoes`);

--
-- Índices de tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id_produtos`);

--
-- Índices de tabela `produto_tem_usuario`
--
ALTER TABLE `produto_tem_usuario`
  ADD PRIMARY KEY (`data_hora_ptu`,`fk_id_produto`,`fk_id_usuario`),
  ADD KEY `fk_produtos_has_usuarios_usuarios1_idx` (`fk_id_usuario`),
  ADD KEY `fk_produtos_has_usuarios_produtos1_idx` (`fk_id_produto`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuarios`),
  ADD UNIQUE KEY `nomeUsuario_UNIQUE` (`nome_login_usuarios`),
  ADD UNIQUE KEY `id_usuarios_UNIQUE` (`id_usuarios`),
  ADD KEY `fk_usuarios_permissoes1_idx` (`fk_id_permissao`),
  ADD KEY `fk_usuarios_Lojas1_idx` (`fk_id_loja`),
  ADD KEY `nome_login_usuarios` (`nome_login_usuarios`);

--
-- Índices de tabela `vendas`
--
ALTER TABLE `vendas`
  ADD PRIMARY KEY (`id_vendas`),
  ADD UNIQUE KEY `id_vendas_UNIQUE` (`id_vendas`),
  ADD KEY `fk_vendas_clientes1` (`fk_id_cliente`),
  ADD KEY `fk_vendas_usuarios1` (`fk_id_usuario`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_clientes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT de tabela `itens_de_vendas`
--
ALTER TABLE `itens_de_vendas`
  MODIFY `id_idv` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `lojas`
--
ALTER TABLE `lojas`
  MODIFY `id_lojas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de tabela `permissoes`
--
ALTER TABLE `permissoes`
  MODIFY `id_permissoes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id_produtos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuarios` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT de tabela `vendas`
--
ALTER TABLE `vendas`
  MODIFY `id_vendas` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `cliente_tem_usuario`
--
ALTER TABLE `cliente_tem_usuario`
  ADD CONSTRAINT `fk_clientes_has_usuarios_clientes1` FOREIGN KEY (`fk_id_clientes`) REFERENCES `clientes` (`id_clientes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_clientes_has_usuarios_usuarios1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuarios` (`id_usuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `itens_de_vendas`
--
ALTER TABLE `itens_de_vendas`
  ADD CONSTRAINT `fk_itens_de_vendas_produtos1` FOREIGN KEY (`fk_id_produto`) REFERENCES `produtos` (`id_produtos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_itens_de_vendas_vendas1` FOREIGN KEY (`fk_id_venda`) REFERENCES `vendas` (`id_vendas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `produto_tem_usuario`
--
ALTER TABLE `produto_tem_usuario`
  ADD CONSTRAINT `fk_produtos_has_usuarios_produtos1` FOREIGN KEY (`fk_id_produto`) REFERENCES `produtos` (`id_produtos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produtos_has_usuarios_usuarios1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuarios` (`id_usuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_Lojas1` FOREIGN KEY (`fk_id_loja`) REFERENCES `lojas` (`id_lojas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuarios_permissoes1` FOREIGN KEY (`fk_id_permissao`) REFERENCES `permissoes` (`id_permissoes`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `vendas`
--
ALTER TABLE `vendas`
  ADD CONSTRAINT `fk_vendas_clientes1` FOREIGN KEY (`fk_id_cliente`) REFERENCES `clientes` (`id_clientes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_vendas_usuarios1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuarios` (`id_usuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
