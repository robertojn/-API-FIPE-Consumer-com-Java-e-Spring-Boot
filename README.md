# Consumidor de API FIPE com Java e Spring Boot

Este projeto é um aplicativo Java utilizando Spring Boot que consome a API FIPE para consultar informações sobre veículos, como marcas, modelos, anos e preços médios. A aplicação foi desenvolvida como um projeto de linha de comando que interage com o usuário para fornecer dados de veículos a partir da tabela FIPE.

## Objetivo

O objetivo deste projeto é demonstrar o consumo de uma API REST usando Java e Spring Boot, e aplicar boas práticas de programação, como o uso de Streams, Lambdas e serialização/deserialização de dados JSON.

## Origem do Projeto

Este projeto foi desenvolvido como parte de um desafio proposto no curso **"Java: Trabalhando com Lambdas, Streams e Spring Framework"** da [Alura](https://www.alura.com.br). O desafio consistia em consumir uma API externa, manipular os dados utilizando Streams e Lambdas, e apresentá-los de forma organizada em um aplicativo de linha de comando.

## Funcionalidades

- Consulta de marcas, modelos e anos de veículos usando a API FIPE.
- Exibição de preços médios de veículos com base no ano de referência da tabela FIPE.
- Interação com o usuário via linha de comando para escolha de tipo de veículo, marca e modelo.
- Uso de Streams e Lambdas para manipulação eficiente de dados.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- REST API (consumo)
- Jackson para manipulação de JSON
- Maven para gerenciamento de dependências
