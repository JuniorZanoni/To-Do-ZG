# To-Do ZG

Projeto desenvolvido para conclusão do módulo de Java do Acelera ZG.

To-Do ZG é uma aplicação desenvolvida em Java com objetivo de gerenciar uma lista de tarefas.

## Funcionalidades do projeto

Indique quais são as funcionalidades e comportamentos do App

- `Adicionar tarefas`: Criar tarefa com nome, descrição, prioridade, status e categoria.
    - `Prioridade`: A prioridade vai de 1 a 5, onde 5 significa mais importante.
    - `Status`: Pode-se escolher 3 status, que são "A fazer", "Fazendo" ou "Feito"
    - `Categoria`: Toda tarefa precisa de uma categoria, que é disponibilizada em lista, para selecionar.
- `Editar ou apagar tarefas`: Pode-se editar ou apagar qualquer campo das tarefas.
- `Listar e filtrar tarefas`: Pode-se listar todas tarefas e também filtrar por, categoria, prioridade, status ou data (data de criação ou conclusão).
- `Adicionar categoria`: Cria categorias para agrupar as tarefas.
- `Painel de tarefas`: Painel que exibe quantas tarefas cada um dos status tem.
- `Persistência de arquivos`: Todas tarefas e categorias são salvas localmente em formado CSV.


![](https://imageup.me/images/9969c7f9-e5f3-4c0c-94bc-9bb729272da0.png)


## Tecnologias utilizadas

- `Java`


## Abrir e rodar o projeto

**Executar pelo terminal**
- Tenha no mínimo o Java 8 instalado.
- Clone esse repositório
- Navegue pelo terminal até a raíz do repositório
- Execute o comando -> java -jar ./To-Do-ZG.jar

**Executar pela IDE**
- Tenha no mínimo o Java 8 instalado.
- Clone esse repositório
- A classe responsável por iniciar a aplicação é MenuPrincipal encontrada dentro do package menus

## Comentários

**O projeto foi divido em 3 packages**
- `menus`: Todos os menus da aplicação e regras de negócio.
- `tasks`: Tudo que envolve a criação e gerenciamento das tarefas.
- `utils`: Package com utilitários em comum nas classes.
- `data`: Package com tudo que envolve a persistência e carregamento de arquivos.

**Optei por utilizar o formado CSV, salvei cada tarefa em uma linha e seus campos são separados por vírgula.**