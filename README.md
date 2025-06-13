#  Movies App

Aplicativo Android desenvolvido com 2 telas apenas para listar e exibir detalhes de filmes populares, 
utilizando a API do TMDB (The Movie Database).

---

## Tecnologias Utilizadas

- **Kotlin** – linguagem principal do projeto  
- **Jetpack Compose** – UI declarativa moderna para Android  
- **Koin** – injeção de dependência leve  
- **Navigation Component** – navegação entre telas  
- **Coroutines + Flow** – programação assíncrona  
- **Retrofit + Gson** – requisições HTTP e serialização  
- **Coil** – carregamento de imagens  
- **MockK + JUnit** – testes unitários

---

## Arquitetura

O projeto segue os princípios da **Clean Architecture**, com separação em 3 camadas principais:

- **Presentation** – camada de UI (Fragments + Compose + ViewModels)  
- **Domain** – camada de regras de negócio (Use Cases e Models)  
- **Data** – camada de acesso a dados (Repositories e APIs)

---

## Organização de Camadas

- **presentation**  
  - ViewModels com `StateFlow` para gerenciamento de estado  
  - Telas com Jetpack Compose  
  - Fragmentos com `ComposeView`  
- **domain**  
  - Use Cases com operadores `invoke`  
  - `MoviesResult`  
- **data**  
  - Retrofit + responses  
  - Implementação dos repositórios

---

## Gerenciamento de Dependências

Utilizamos o **Koin** para injeção de dependencia 

---

## Testes

- O **ViewModel** é testado isoladamente com **MockK** para mocks
- Utilizado `StandardTestDispatcher` para controle de execução das corrotinas.
- So foi feito o teste de uma viewmodel para exemplificar, o projeto é apenas um exemplo

---

## Como Rodar o Projeto

1. Clone o repositório  
2. Gere sua chave da API TMDB (https://www.themoviedb.org/settings/api) e adicione no local apropriado  
3. Sincronize o projeto com o Gradle  
4. Rode o app via Android Studio em um emulador ou dispositivo real

---

## Melhorias Futuras

- Paginação de resultados caso realmente seja necessário
- Tela de erro personalizada  para cada tela
- Tela de shimmer personalizado para cada tela
- Dark Mode  
- Cache local com Room na listagem para melhorar a performance
- Testes de UI com Compose Testing e o restante do projeto