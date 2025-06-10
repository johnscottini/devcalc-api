[![CI](https://github.com/johnscottini/devcalc-api/actions/workflows/ci.yml/badge.svg)](https://github.com/johnscottini/devcalc-api/actions/workflows/ci.yml)

# devcalc-api

The goal of this project is to practice CI/CD pipelines.  
To accomplish that, I created a simple Spring Boot app with math operations and JUnit tests.

## Technologies
- Java 17
- Spring Boot
- Maven
- JUnit 5
- GitHub Actions (CI/CD)

## Running Locally
To execute the application locally:
1. Open the project in your IDE.
2. Select the `Main` class in the run configurations.
3. Start the application and access the API endpoints.

## CI/CD Pipeline (GitHub Actions)

This project includes a CI/CD pipeline configured using **GitHub Actions**.  
The pipeline is defined in the `.github/workflows/ci.yml` file and includes the following jobs:

| Job        | Description                             | Trigger                                     |
|------------|-----------------------------------------|---------------------------------------------|
| Checkout   | Checkout the source code                | On push to `main`, on PR modifying `src/`   |
| Build      | Install Java and build the project      | After checkout                              |
| Test       | Run automated unit tests                | After build                                 |
| Package    | Generate the `.jar` file using Maven    | After test                                  |
| Deploy     | Simulated deploy (logs message only)    | After build and test                        |

### Workflow Triggers
- **Automatic Execution**
    - On push to `main` branch.
    - On pull requests that modify files in the `src/` directory.
- **Manual Execution**
    - The pipeline supports manual runs using the **Run workflow** button in the Actions tab (thanks to `workflow_dispatch`).

### Identificando problemas
- Após realizar uma alteração no workflow, a pipeline enfrentou um problema e não rodou. Pela página de  actinos consegui identificar que o problema está relacionado a um job específico. Como já era de conhecimento qual job especificamente havia parado, foi fácil entrar no workflow e corrigir o problema, removendo a linha que causava o erro proposital.
Outros momentos que usei essa função, foi quando estava configurando o SonarCloud da aplicação para fazer a cobertura e lin do código, e obtive erros pois o workflow que executa o sonar estava configurado incorretamente.

### Diferenças entre execução manual e automática
Acredito que a principal diferença é a forma que é executada, quando a execução é automática, os parâmetros e condicionais de execução do workflow não são aplicados.
Portanto, todo o fluxo é seguido, já que parâmetros só são informados na execução manual. Na execuçao manual o usuário pode definir quais parâmetros serão aplicados por meio da seleção, podendo modificar o workflow executado.

### Etapas Realizadas no TP3

1. **Parâmetros de Execução Manual (workflow_dispatch):**  
   Adicionados parâmetros booleanos para decidir se os testes unitários e a análise do SonarCloud devem ser executados ao rodar manualmente.

2. **Validação de Variável e Abertura de Issue Automática:**  
   O job de `deploy` foi ajustado para verificar se a variável `DEPLOYNAME` está definida.  
   Se estiver ausente, uma issue é aberta automaticamente utilizando a API do GitHub com o token `GITHUB_TOKEN`.

3. **Criado ambiente de deploy dev e prod**
    Foram criados ambientes de development e production, contendo etapas específicas e variáveis de ambiente para cada ambiente

4. **Adicionada nova funcionalidade Square root**
   Foi adicinada nova funcionalidade de Square root, bem como seus testes