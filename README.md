# 💻 Desafio Gazin
O desafio proposto consiste na implementação de duas aplicações:

* API Restful que executa as operações CRUD para duas entidades (Desenvolvedor e Nível);
* Aplicação frontend capaz de consumir a API Restful executando os métodos GET, POST, PUT/PATCH e DELETE. 

## 👨‍💻 Desenvolvedor:
- [Allan Chavier Felintro](https://www.linkedin.com/in/allanfelintro/)

## 🛠️ Stack utilizada:

#### Back-end:
<div>
  <img alt="JAVA" src="https://img.shields.io/badge/Java-100000?style=for-the-badge&logo=openjdk&logoColor=white">
  <img alt="SPRING" src="https://img.shields.io/badge/Spring-100000?style=for-the-badge&logo=spring">
  <img alt="H2" src="https://img.shields.io/badge/H2 DATABASE-100000?style=for-the-badge&logo=h2">
</div>

####  Front-end:
<div>
 <img alt="HTML5" src="https://img.shields.io/badge/html5-100000?style=for-the-badge&logo=html5">
 <img alt="CSS3" src="https://img.shields.io/badge/css3-100000?style=for-the-badge&logo=css3&logoColor=blue">
 <img alt="TYPESCRIPT" src="https://img.shields.io/badge/TYPESCRIPT-100000?style=for-the-badge&logo=TYPESCRIPT&logoColor=blue">
 <img alt="ANGULAR" src="https://img.shields.io/badge/ANGULAR-100000?style=for-the-badge&logo=angular&logoColor=red">
</div>

### Pré-requisitos:

* Java 17;
* Maven
* Docker e Docker Compose;
* Node;
* Git;

## Instalação:

Para instalar e executar o projeto, abra os diretórios e execute os comandos descritos no seguinte passo a passo:

1. Clonar o projeto do git em qualquer local: `git clone git@github.com:Felintro/desafio-fullstack.git`
2. Abra o diretório raiz do projeto e acesse a pasta `backend/desafio-fullstack`
3. Execute o comando `docker-compose up` para construir a imagem docker e subir o container do backend;
4. Abra o diretório raiz do projeto e acesse a pasta `frontend/desafio-fullstack`;
5. Execute novamente o comando `docker-compose up` para construir a imagem docker e subir o container do frontend;

- O projeto foi configurado com o recurso Compose do Docker, portanto os comandos acima devem ser suficientes para construir a imagem, o container e executá-lo.
- O frontend poderá ser acessado no endereço: `http://localhost:8081/browser`.
- A api disponibilizada no backend estará disponível no endereço: `http://localhost:8082/`.
- O banco de dados está configurado no endereço `http://localhost:8082/h2-console` e pode ser acessado com as credenciais abaixo:
  - Url: jdbc:h2:mem:gazin;
  - Username: sa;
  - Password: sa;

## ⚙️ Endpoints disponibilizados:

| Método HTTP | Endpoint                    | Descrição                                   | Corpo da requisição | Corpo da resposta                 |
|-------------|-----------------------------|---------------------------------------------|---------------------|-----------------------------------|
| GET         | `/api/niveis`               | Busca e retorna todos os níveis cadastrados | Vazio               | Todos níveis cadastrados          |
| POST        | `/api/niveis`               | Registra um novo nível                      | JSON abaixo         | Nível recém-cadastrado            |
| PATCH       | `/api/niveis/{id}`          | Atualiza um nível existente                 | JSON abaixo         | Nível atualizado                  |
| DELETE      | `/api/niveis/{id}`          | Exclui um nível existente                   | Vazio               | Vazio                             |
| GET         | `/api/desenvolvedores`      | Registra um novo pedido                     | Vazio               | Todos desenvolvedores cadastrados |
| POST        | `/api/desenvolvedores`      | Registra um novo pedido                     | JSON abaixo         | Desenvolvedor recém-cadastrado    |
| PATCH       | `/api/desenvolvedores/{id}` | Registra um novo pedido                     | JSON abaixo         | Desenvolvedor atualizado          |
| DELETE      | `/api/desenvolvedores/{id}` | Cancela um pedido pré-existente             | Vazio               | Vazio                             |

### Corpo da requisição:

* Desenvolvedores:

  ```json
  {
      "nivelId": 1,
      "nome": "Nome do Desenvolvedor",
      "sexo": "M",
      "datanascimento": "1990-01-01",
	  "idade":25,
      "hobby": "Programação"
  }
   ```
  
* Níveis:
 ```json 
{ 
  "nivel": "Nome do Nível"
}
 ```

* O status http das respostas dependerão do resultado da operação do backend, onde erros podem ser retornados em casos de falha.


