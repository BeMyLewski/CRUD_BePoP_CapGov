# Sistema de Agendamento de Consultorias

## 📖 Descrição

Este é um projeto de uma aplicação web desenvolvida em Java para o gerenciamento de agendamentos de consultorias. A aplicação permite cadastrar, consultar, editar e remover agendamentos, utilizando uma interface rica construída com PrimeFaces.

O sistema utiliza o Hibernate para a persistência de dados em um banco de dados MySQL.

---

## ✨ Funcionalidades

- **Cadastro de Consultorias:** Formulário para agendar uma nova consultoria, associada a um CNPJ e nome de empresa.
- **Consulta por CNPJ:** Tela para buscar todos os agendamentos realizados para um CNPJ específico.
- **Edição de Agendamentos:** Possibilidade de alterar os dados de uma consultoria já marcada através de um diálogo (pop-up).
- **Remoção de Agendamentos:** Exclusão de agendamentos.
- **Regras de Negócio no Calendário:**
  - Limitação de horário para agendamentos (apenas em horário comercial, das 8h às 18h).
  - Limitação de reserva com antecedência de 38 horas

---

## 🛠️ Tecnologias Utilizadas

- **Backend:**
  - Java 8
  - JavaServer Faces (JSF) 2.2 - Framework para construção de interfaces web componentizadas.
  - Hibernate ORM 5.6.15.Final - Framework para mapeamento objeto-relacional e persistência de dados.
- **Frontend:**
  - PrimeFaces 13.0.9 - Biblioteca de componentes ricos para JSF.
  - XHTML, HTML5, CSS.
- **Banco de Dados:**
  - MySQL 8
- **Gerenciamento de Dependências e Build:**
  - Apache Maven
- **Servidor de Aplicação:**
  - Apache Tomcat 8.5

---

## ⚙️ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [JDK 1.8 (Java 8)](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [MySQL Server 8](https://dev.mysql.com/downloads/mysql/)
- Um Servidor de Aplicação compatível [Apache Tomcat 8.5](https://tomcat.apache.org/tomcat-8.5-doc/building.html)
- Uma IDE de sua preferência (ex: Eclipse IDE for Enterprise Java and Web Developers).

---

## 🚀 Configuração e Instalação

**1. Crie o Banco de Dados:**

Primeiro, você precisa criar o banco de dados no seu MySQL. O Hibernate cuidará de criar as tabelas, mas não o banco.

```sql
CREATE DATABASE consultorias;
```

**2. Configure a Conexão:**

Abra o arquivo `src/main/resources/hibernate.cfg.xml` e ajuste as propriedades de conexão com o seu ambiente:

```xml
<!-- ... -->
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/consultorias?useSSL=false&serverTimezone=UTC</property>
<property name="hibernate.connection.username">SEU_USUARIO_MYSQL</property>
<property name="hibernate.connection.password">SUA_SENHA_MYSQL</property>
<!-- ... -->
```

---

## ▶️ Como Executar

**1. Usando a IDE (Ex: Eclipse):**
   - Configure o Apache Tomcat na aba "Servers" da sua IDE.
   - Clique com o botão direito no projeto -> "Run As" -> "Run on Server".
   - Selecione o servidor Tomcat configurado.
   - A IDE irá fazer o deploy automaticamente e abrir o navegador na página inicial (`index.xhtml`).

---

## 📂 Estrutura do Projeto

O projeto segue uma estrutura de pacotes padrão para aplicações Java web:

- **`com.bepop.bean`**: Contém os Managed Beans (Controllers do JSF) que fazem a ponte entre as telas e a lógica de negócio.
- **`com.bepop.dao`**: Contém as classes DAO (Data Access Object), responsáveis por toda a comunicação com o banco de dados via Hibernate.
- **`com.bepop.model`**: Contém as classes de Entidade (Models) que mapeiam as tabelas do banco de dados.
- **`com.bepop.util`**: Contém classes utilitárias, como a `HibernateUtil` para gerenciar a `SessionFactory`.
- **`src/main/resources`**: Onde ficam os arquivos de configuração, como o `hibernate.cfg.xml`.
- **`src/main/webapp`**: Contém as páginas web (`.xhtml`) e o descritor de implantação (`web.xml`).
