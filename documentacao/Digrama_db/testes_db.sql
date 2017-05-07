-- PERMISÃO
INSERT INTO `permissoes` (`id_permissoes`, `nome_permissoes`, `permissoes`, `data_criacao_permissoes`, `situacao_permissoes`) VALUES (NULL, 'Admin', 'Todos', CURRENT_TIMESTAMP, '1');

-- LOJA
INSERT INTO `lojas` (`id_lojas`, `nome_lojas`, `tipo_lojas`, `cep_lojas`, `logradouro_lojas`, `numero_lojas`, `bairro_lojas`, `cidade_lojas`, `estado_lojas`) VALUES (NULL, 'Matriz', '1', '04918110', 'Rua1', 'Numero1', 'Bairro1', 'Cidade1', 'E1');

-- USUARIO
INSERT INTO `usuarios` (`id_usuarios`, `nome_usuarios`, `sobrenome_usuarios`, `cpf_usuarios`, `data_nascimento_usuarios`, `sexo_usuarios`, `telefone_usuarios`, `celular_usuarios`, `email_usuarios`, `nome_login_usuarios`, `senha_usuarios`, `imagem_usuarios`, `nivel_usuarios`, `status_usuarios`, `data_cadastro_usuarios`, `deletado_usuarios`, `fk_id_permissao`, `fk_id_loja`) VALUES (NULL, 'Usuario1', 'Sobrenome Usuario1', 'cpf1', '1993-04-02', 'M', 'tel1', 'cel1', 'mail1', 'user1', '123456', NULL, '1', '1', CURRENT_TIMESTAMP, '0', '1', '1');

-- PRODUTO
INSERT INTO `produtos` (`id_produtos`, `nome_produto`, `marca_produto`, `descricao_produto`, `preco_compra_produto`, `preco_venda_produto`, `margem_venda_produto`, `estoque_produto`, `estoque_minimo_produto`, `status_produto`, `deletado_produto`) VALUES (NULL, 'Produto1', 'Marca1', 'Descrição1', '10', '15', NULL, '10', '5', '1', '0');

-- CLIENTE
INSERT INTO `clientes` (`id_clientes`, `nome_clientes`, `sobrenome_clientes`, `cpf_cnpj_clientes`, `sexo_clientes`, `telefone_clientes`, `celular_clientes`, `email_clientes`, `cep_clientes`, `logradouro_clientes`, `numero_clientes`, `bairro_clientes`, `cidade_clientes`, `estado_clientes`, `complemento_clientes`, `data_cadastro_clientes`, `deletado_clientes`) VALUES (NULL, 'Cliente1', 'Sobrenome Cliente1', 'cpf1', 'F', 'tel1', 'cel1', 'mail1', '00000000', 'rua1', 'numero1', 'Bairro1', 'Cidade', 'E1', 'Complemento1', CURRENT_TIMESTAMP, '0');

-- VENDA
INSERT INTO `vendas` (`id_vendas`, `metodo_pagamento`, `valor_total`, `data_hora_vendas`, `desconto_vendas`, `fk_id_cliente`, `fk_id_usuario`) VALUES (NULL, 'Dinheiro', '45', CURRENT_TIMESTAMP, NULL, '1', '1');

-- ITEM DE VENDA
INSERT INTO `itens_de_vendas` (`id_idv`, `quantidade_idv`, `fk_id_venda`, `fk_id_produto`) VALUES (NULL, '3', '1', '1');

-- CONSULTA TODAS VENDA
SELECT
  `vendas`.`id_vendas`,
  `usuarios`.`nome_usuarios`,
  `vendas`.`metodo_pagamento`,
  `vendas`.`data_hora_vendas`,
  `vendas`.`valor_total`,
  `produtos`.`nome_produto`,
  `itens_de_vendas`.`quantidade_idv`,
  `produtos`.`preco_venda_produto`
FROM
  `produtos`
LEFT JOIN
  `itens_de_vendas` ON `itens_de_vendas`.`fk_id_produto` = `produtos`.`id_produtos`
LEFT JOIN
  `vendas` ON `itens_de_vendas`.`fk_id_venda` = `vendas`.`id_vendas`
LEFT JOIN
  `usuarios` ON `vendas`.`id_vendas` = `usuarios`.`id_usuarios`

-- OBTEM POR ALGUMA CLAUSULA
-- WHERE
-- `vendas`.`id_vendas` = 1 --              ID DA VENDA
-- `usuarios`.`id_usuarios` = 1 --          ID DO USUÁRIO
-- `usuarios`.`fk_id_loja` = 1 --             ID DA LOJA