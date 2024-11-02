```
# Gerador de Apostas

Este é um projeto Spring Boot para um sistema chamado "Gerador de Apostas". O sistema permite que os usuários gerem números aleatórios para os seguintes jogos de loteria: Mega Sena, Quina e LotoFácil.

## Funcionalidades

- **Mega Sena**: O usuário deve escolher 6 números entre 1 e 60. Pode ainda deixar que o sistema escolha os números para você por meio da Surpresinha.
- **Quina**: O usuário deve escolher 5 números entre 1 e 80. Pode ainda deixar que o sistema escolha os números para você por meio da Surpresinha.
- **LotoFácil**: O usuário marca entre 15 e 20 números, dentre os 25 disponíveis no volante, e fatura prêmio se acertar 11, 12, 13, 14 ou 15 números. Pode ainda deixar que o sistema escolha os números para você por meio da Surpresinha.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Bootstrap

## Pré-requisitos

- Java 11 ou superior
- Maven
- PostgreSQL

## Configuração do Banco de Dados

Certifique-se de que o PostgreSQL está instalado e rodando. Crie um banco de dados chamado `gerador_de_apostas`.

```sql
CREATE DATABASE gerador_de_apostas;
```

Atualize o arquivo `src/main/resources/application.properties` com suas credenciais do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gerador_de_apostas
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Executando a Aplicação

Clone o repositório:

```bash
git clone https://github.com/solozabal/gerador-de-apostas.git
cd gerador-de-apostas
```

Compile e execute a aplicação:

```bash
./mvnw spring-boot:run
```

## Acesse a Aplicação no Navegador

Abra seu navegador e acesse:

```
http://localhost:8080
```

## Estrutura do Projeto

```plaintext
src/main/java/com/example/geradordeapostas/gerador_de_apostas
├── GeradorDeApostasApplication.java       // Classe principal da aplicação.
├── controller/JogoController.java          // Controlador para gerenciar as requisições relacionadas aos jogos.
├── model/Jogo.java                         // Entidade JPA que representa um jogo.
├── repository/JogoRepository.java          // Repositório JPA para a entidade Jogo.
└── service/JogoService.java                // Serviço que contém a lógica de negócio para gerar os números dos jogos.

src/main/resources
├── application.properties                   // Configurações da aplicação.
└── templates/index.html                     // Página inicial da aplicação.
```

## Contribuindo

1. Faça um fork do projeto.
2. Crie uma branch para sua feature:
   ```bash
   git checkout -b feature/nova-feature
   ```
3. Commit suas mudanças:
   ```bash
   git commit -am 'Adiciona nova feature'
   ```
4. Faça o push para a branch:
   ```bash
   git push origin feature/nova-feature
   ```
5. Crie um novo Pull Request.
