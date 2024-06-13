# App To Do - Back-End

Este é o back-end do aplicativo de lista de tarefas (App To Do) desenvolvido em Java utilizando Spring Boot. O back-end permite aos usuários ler, adicionar, editar, excluir e marcar tarefas como concluídas. O banco de dados utilizado é o MariaDB.

front-end: https://github.com/filipecajado/app-to-do-front-end

## Funcionalidades

- **Adicionar Tarefa**: Permite adicionar uma nova tarefa à lista.
- **Editar Tarefa**: Permite editar a descrição de uma tarefa existente.
- **Excluir Tarefa**: Permite remover uma tarefa da lista.
- **Excluir todas as tarefas**: Permite remover todas as tarefas da lista.
- **Marcar Tarefa como Concluída**: Permite marcar/desmarcar uma tarefa como concluída.
- **Listar Tarefas**: Permite visualizar todas as tarefas.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **MariaDB**

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu ambiente de desenvolvimento:

- Java Development Kit (JDK)
- Maven
- MariaDB

## Configuração do Banco de Dados

Certifique-se de que o MariaDB está instalado e em execução. Crie um banco de dados chamado `apptodo`:

```sql
CREATE DATABASE apptodo;
