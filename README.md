# Calculadora de Sub-redes IPv4

Uma aplicação em Java desenvolvida para calcular informações de uma sub-rede IPv4 a partir de um endereço IP e um prefixo CIDR.

## Objetivo

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais de:

- Programação Orientada a Objetos (POO)
- Manipulação de Strings
- Operações Bitwise
- Redes de Computadores
- Tratamento de Exceções
- Organização de código em camadas

## Funcionalidades

- Validação de endereços IPv4
- Validação de CIDR
- Conversão de IPv4 para Long
- Conversão de Long para IPv4
- Cálculo da máscara de rede
- Descoberta do endereço de rede
- Descoberta do endereço de broadcast
- Cálculo do primeiro host válido
- Cálculo do último host válido
- Cálculo da quantidade de hosts disponíveis
- Identificação do tipo da rede (Privada ou Pública)
- Exibição da representação binária da rede
- Tratamento especial para redes /31 e /32


## Exemplo de Uso

Entrada:

```text
192.168.1.50/26
```

Saída:

```text
Rede: 192.168.1.0
Broadcast: 192.168.1.63
Primeiro Host: 192.168.1.1
Último Host: 192.168.1.62
Hosts: 62
Tipo da Rede: Privada
Binário da Rede: 11000000.10101000.00000001.00000000
```

## Tecnologias Utilizadas

- Java 26
- Git
- GitHub

## Conceitos Aplicados

Durante o desenvolvimento foram utilizados conceitos como:

- Conversão de IPv4 para Long
- Conversão de Long para IPv4
- Conversão para representação binária
- Deslocamento de Bits (`<<` e `>>`)
- Máscara de sub-rede
- Broadcast
- Cálculo de hosts
- Validação de dados de entrada
- Encapsulamento
- Separação de responsabilidades

## Autor

Desenvolvido por Davi Mancuso como projeto de estudo para praticar Java e conceitos de Redes de Computadores.
