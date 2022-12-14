## **Projeto Clínica Médica**
API de criação de contas de pacientes e médicos para acesso de planos de saúde e fazer consultas médicas agendadas. O objetivo da aplicação é criar consultar agendadas no Ambiente sendo disponibilizado para visualização.

## **Sistema**
- Pré-requisitos
-	Instalação
-	Executando a Instalação
-	Executando os testes
-	Membros do Time

## **Pré-requisito**
-	**Java 1.8 ou +**<br>
É necessário instalar o JDK na máquina e fazer as devidas configurações nas variáveis do ambiente.
-	**GIT**<br>
Instalar versionamento de GIT, pode ser o tortoise, git bash ou usar o próprio CMD.
-	**Maven**<br>
Instalar o maven e fazer as devidas configurações nas variáveis do ambiente. 
-	**Database**<br>
Instale e configure o h2-console para usufruir do banco de dados da API, também instale o MYSQL para usar a modelagem de dados que está em arquivo nesse projeto.

## **Instalação**
-	Baixe o repositório como um zip ou faça um clone<br>
-	Descompacte os arquivos em um diretório<br>
-	Navegue até o diretório raiz onde possui o arquivo pom.xml<br>
-	Execute o comando mvn clean install<br>
OBS: Quando iniciar o projeto, clique no pom.xml e clique no ícone "add as maven project", posteriormente vá ao terminal e dê o comando do mvn clean install, para que após isso possa usar o maven com o comando também "mvn package", entre outros.

## **Executando a Aplicação**
-	Após rodar o comando do Maven<br>
-	Navegue até o diretório src/main que chegue até o arquivo "AppClinicaMedicaApplication" e faça o debug para rodar a aplicação<br>
- Após isso, pode executar "http://localhost:8080/h2-console" e digitar o caminho, o usuário e a senha para acessar o database.

## **Executando os Testes**
-	Execute o comando mvn compile test<br>
-	Após isso, navegue até o diretório src/test que chegue até o arquivo "TestDatasController" e rode para testar todos os métodos

## **Tecnologias Utilizadas**
-	Java 11
-	Spring Boot
-	Spring Boot JPA
-	H2 Database
-	Maven

## **Padrões de Nomenclatura**
-	**controller:** contém as classes de controle da API Rest.
-	**service:** contém as classes de serviço da API Rest.
-	**repository:** contém as classes de repositórios com o banco de dados.
-	**model:** contém as classes de entidades e DTO com integração com o banco de dados.
-	**configuration:** contém as classes de configuração em geral, também de spring security.
-	**test:** contém as classes dividas em pastas com todos os testes da main.

## **Documentação**
https://docs.google.com/document/d/1HfxP9Vkh3sEEFQQwe3ey4GYFAnKpOuGe/edit?usp=sharing&ouid=115083074598686078110&rtpof=true&sd=true

## **Membros do Time**
-	Rayana Ribeiro Bonfanti
