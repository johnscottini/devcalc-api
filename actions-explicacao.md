# A diferença entre Workflow e Action:

Action é a ação executada, um bloco de código que realiza uma tarefa específica.
Ela deve ter um propósito definido e pequeno, não executando múltiplas ações diferentes.

Já o WorkFlow, na verdade é um orquestrador de diversas actions, é um arquivo que automatiza processos, é a pipeline.

Um arquivo Action.yml define uma action personalizada, ele precisa ter algumas informações principais, como: Description, input, output, runs. Por meio do input e output é definido o que a action pode receber ou retornar.

Essa action, como por exemplo a actions/setup-java@v3 do meu workflow, é uma action externa utilizada. 
Os parâmetros para ela são passados através do with, que nesse caso são: java-version, distribution e cache.
E o valor "uses" chama essa action, com a versão dela especificada no caminho (@v3) para garantir que seja a versão correta.