
<img loading="lazy" src="https://img.freepik.com/vetores-gratis/colecao-de-personagens-com-bolhas-do-discurso-da-cor_1284-1215.jpg?semt=ais_hybrid" height="400" width="100%"/>
<h1 align="center">
     Projeto Forum Hub
</h1>

  <p align="center">
    <a href="#sobre-o-projeto">Sobre o Projeto</a> |
    <a href="#objetivo-do-projeto">Objetivo do Projeto</a> |
    <a href="#principais-recursos">Principais Recursos</a> |
    <a href="#principais-tecnologias">Principais Tecnologias</a> |
    <a href="#estrutura-do-projeto">Principais Tecnologias</a> |
    <a href="#requisitos-para-rodar-o-projeto">Requisitos para rodar o projeto</a> |

</p>


# 📒Sobre o Projeto
Um fórum é um espaço onde todos os participantes de uma plataforma podem colocar suas perguntas sobre determinados assuntos. Aqui na Alura, os alunos e alunas utilizam o fórum para tirar suas dúvidas sobre os cursos e projetos em que estão participando. Este lugar mágico está cheio de muita aprendizagem e colaboração entre alunos, professores e moderadores.

Já sabemos para que serve o fórum e sabemos sua aparência, mas sabemos como ele funciona por trás dos panos? Isto é, onde se armazenam as informações? Como são tratados os dados para que se relacione um tópico com uma resposta, ou como se relacionam os usuários com as respostas de um tópico?

Este é o nosso desafio, chamado de FórumHub: nele, vamos replicar este processo no nível do back end e, para isso, criaremos uma API REST usando Spring.

Nossa API se concentrará especificamente nos tópicos, e deve permitir aos usuários:

✅ Criar um novo tópico;

✅ Mostrar todos os tópicos criados;

✅ Mostrar um tópico específico;

✅ Atualizar um tópico;

✅ Eliminar um tópico.



# 🎯Objetivo do Projeto

Implementar uma API REST com as seguintes funcionalidades:

- API com rotas implementadas seguindo as melhores práticas do modelo REST;

- Validações realizadas segundo as regras de negócio;

- Implementação de uma base de dados relacional para a persistência da informação;

- Serviço de autenticação/autorização para restringir o acesso à informação.


# ⚒️Principais Recursos

[![](https://img.shields.io/badge/Configuração_do_ambiente_Java-052051)]()
[![](https://img.shields.io/badge/Configuração_Spring_Boot-052051)]()
[![](https://img.shields.io/badge/Autenticação_com_JWT-052051)]()
[![](https://img.shields.io/badge/Aplicação_de_filtro_nas_requisições-052051)]()
[![](https://img.shields.io/badge/Criação_de_topicos-052051)]()
[![](https://img.shields.io/badge/Edição_de_topicos-052051)]()
[![](https://img.shields.io/badge/Exclusao_de_topicos-052051)]()
[![](https://img.shields.io/badge/Pesquisa_de_topicos-052051)]()
[![](https://img.shields.io/badge/Padrao_de_Projeto_MVC-052051)]()
[![](https://img.shields.io/badge/Padrao_de_Projeto_MVC-052051)]()
[![](https://img.shields.io/badge/Consultas_Derevadas-052051)]()
[![](https://img.shields.io/badge/Docker-052051)]()
[![](https://img.shields.io/badge/Migrations-052051)]()




# 💻Principais Tecnologias

[![https://www.java.com/en/download/](https://img.shields.io/badge/@code-Java_V.23-052051)]()
[![https://gutendex.com/](https://img.shields.io/badge/@DB-mysql-083658)]()
[![https://gutendex.com/](https://img.shields.io/badge/@ORM-JPA-083658)]()
[![https://gutendex.com/](https://img.shields.io/badge/@INFRA-FlyWay-083658)]()
[![https://gutendex.com/](https://img.shields.io/badge/@Autenticação-Spring_Security-083658)]()



# 📂Estrutura do Projeto

```
  |-src
     |-br.com.alura.forumhub
        |-controller
        |- domain
        |- exceptions
        |- infra
            |- adapters
            |- filters
            |- repositories
        |- lib
            |- bcrypt
            |- springsecurity
        |- utils
        |- validators
            
            

```

# ✅ Requisitos para rodar o projeto

✔️ Docker

✔️ Java V.23

 

# 🚀Executando o projeto

👣 Rode o comando para a criação do container docker e criação da base de dados
```java
docker compose up -d
```
👣 Rode o projeto Spring Boot

> 💡 Para facilitar o recurso de autenticação, foi criado dois usuarios com as seguintes informações:
>   
> > **Email**: admin@email.com
> >
> >**Senha**: 123456
> 
>  > **Email**: usuario@email.com
> >
>  > **Senha**: 123456
 

