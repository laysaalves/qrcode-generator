# QR Code Generator

Um gerador de QR Code simples, eficiente e modular, desenvolvido com **Spring Boot**, **Java 21**, **MongoDB**, e a biblioteca **Google ZXing** para geração de códigos. O projeto adota arquitetura baseada em **ports & adapters (Hexagonal)**, com uso de **DTOs** para isolamento da entidade de persistência. Ideal para praticar conceitos de arquitetura limpa, persistência com MongoDB e integração de bibliotecas externas em Java.

---

## Features

- **Geração de QR Codes Dinâmicos**: Recebe conteúdo via API REST e retorna a imagem do QR Code.
- **Persistência com MongoDB**: Armazena os dados dos QR Codes gerados de forma escalável e não relacional.
- **Arquitetura Limpa (Hexagonal)**: Separação entre regras de negócio, interfaces e infraestrutura.
- **Camada DTO**: Isolamento entre as entidades de domínio e os dados de transporte.
- **Uso de ZXing**: Biblioteca da Google para geração de QR Codes com alta compatibilidade.

---

## Destaques Técnicos

- Projeto modular com **separação de responsabilidades clara** entre entidade, DTO, serviço, controller, repository e exceções.
- Utilização da biblioteca **Google ZXing** para geração de QR Codes em diversos formatos.
- **MongoDB containerizado via Docker Compose** para facilitar desenvolvimento e testes.
- Aplicação dos princípios da **arquitetura hexagonal** com uso explícito de **ports e adapters**.
- Escrito com **Java 21**, aproveitando novos recursos da linguagem para melhorar legibilidade e performance.
- Implementação de **boas práticas de codificação**.

---

## Tech Stack

- **Java 21**: Última versão estável com recursos modernos.
- **Spring Boot**: Framework robusto e ágil para desenvolvimento web.
- **MongoDB**: Banco de dados NoSQL, ideal para armazenar documentos de forma flexível.
- **Docker + Docker Compose**: Orquestração do ambiente de desenvolvimento com MongoDB.
- **Google ZXing**: Biblioteca para criação de QR Codes.
- **Arquitetura Hexagonal**: Clareza entre camadas e desacoplamento de infraestrutura.
- **DTOs**: Evitam exposição direta da entidade nas interfaces de entrada e saída.

---

## Arquitetura

O projeto foi desenhado com foco em **arquitetura hexagonal (ports & adapters)**, promovendo:

- **Isolamento da lógica de negócio** em serviços e entidades.
- **Interfaces (ports)** para entrada e saída bem definidas.
- **Adapters** para comunicação com o mundo externo (controller, repositórios, etc.).
- **DTOs** para transportar dados entre camadas de forma segura.
- **Baixo acoplamento e alta coesão**, facilitando testes e evolução do código.


### Estrutura de Pastas
```plaintext
src
├── main
│   ├── java
│   │   └── dev.layseiras.qrocode.generator
│   │       ├── controller     # Camada de entrada (REST APIs)
│   │       ├── service        # Regras de negócio (casos de uso)
│   │       ├── dto            # Objetos de transferência de dados
│   │       ├── ports          # Interfaces para entrada e saída (input/output ports)
│   │       ├── adapters       # Implementações das interfaces (input/output adapters)
│   │       ├── repository     # Abstrações e implementações para persistência
│   │       ├── exceptions     # Classes de exceção e tratamentos de erro
│   │       └── entity         # Entidades do domínio
│   └── resources
│       ├── application.yml    # Configurações da aplicação
│       └── docker-compose.yml # Arquivo de orquestração de containers
└── test
    └── java
        └── dev.layseiras.qrocode.generator    # Testes unitários e de integração
   ```
---

## Endpoints da API

### Ideias
- **POST /qrcode**: Gera o QRCODE a para a url do usuário passada no corpo da requisição.

---

## Contribuindo
Você pode contribuir seguindo os passos:
1. Fork do repositório.
2. Crie uma brach para a feature: `git checkout -b feature-name`
3. Commit suas alterações: `git commit -m 'Add new feature'`
4. Dê push para a branch: `git push origin feature-name`
5. Envie um pull request.

---

## Licença
Mais detalhes sobre a licença que protege esse projeto em [MIT License](LICENSE).

---

## Contato
Curtiu? Você pode me mandar um feedback em: [laysa.developer@gmail.com](laysa.developer@gmail.com).