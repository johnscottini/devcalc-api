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
