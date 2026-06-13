# Integrantes
```bash
- Aline Steffen Rocha (linestr e Usuario)
- André Leonardo da Silva (andls e ffcand)
- Isadora de Oliveira (1072414468)
- Martin Bernardes da Silva (TryMartin)
```
# Requisitos Funcionais
```bash
-RF01 - O sistema deve permitir que o usuário cadastre novas ferramentas, fornecendo informações como nome, marca e custo.
-RF02 - O sistema deve registrar novos amigos no sistema, incluindo seus nomes, números de telefone e email.
-RF03 - O sistema deve possibilitar o registro de empréstimos, permitindo ao usuário especificar a ferramenta emprestada, o amigo para quem foi emprestada, a data de empréstimo e a data de devolução prevista.
-RF04 - O sistema deve alertar o usuário caso o amigo selecionado possua ferramentas não devolvidas.
-RF05 - O sistema deve gerar relatórios contendo informações detalhadas sobre todas as ferramentas cadastradas, incluindo descrição, marca e custo individual, assim como o custo total das ferramentas.
-RF06 - O sistema deve um relatório que exiba todos os empréstimos atualmente em andamento, mostrando a ferramenta emprestada, o amigo, a data de empréstimo e a data prevista de devolução.
-RF07 - O sistema deve disponibilizar um relatório com os empréstimos que ultrapassaram a data prevista de devolução, contendo informações sobre a ferramenta, o amigo, a data de empréstimo e a data limite de devolução.
-RF08 - O sistema deve obter um relatório abrangente com todos os empréstimos realizados, incluindo informações sobre a ferramenta, o amigo, o status de empréstimo, a data de empréstimo, a data limite de devolução e o amigo que mais realizou empréstimos.
-RF09 - O sistema deve integrar-se à agenda no Google para compartilhar lembretes de eventos via e-mail.
-RF10 - O sistema deve verificar se o amigo selecionado possui ferramentas emprestadas não devolvidas e informar ao usuário, se aplicável.
```
# Requisitos Não Funcionais
```bash
-RNF01 - O sistema deve ser executado localmente no computador de usuário, sem depender de conexão com a internet.
-RNF02 - O sistema deve ser intuitivo e amigável, projetada para usuários com diversos níveis de habilidade técnica.
-RNF03 - O sistema deve garantir a segurança dos dados armazenados, protegendo as informações pessoais e financeiras dos usuários.
-RNF04 - O sistema deve ser eficiente e confiável com a integração no Google Agenda, assegurando o envio correto de lembretes de eventos por e-mail.
-RNF05 - O sistema deve ser compatível com os sistemas operacionais Windows 11.
-RNF06 - O sistema deve ser realizado utilizando a linguagem de programação Java 22.0.1.
-RNF07 - O sistema deve ser conectado a um banco de dados MySQL 8.4.0 para armazenar e gerenciar as informações de forma eficiente.
```
# Regras de Negócio
```bash
-RN01 - Cada ferramenta só pode ser emprestada para um amigo por vez.
-RN02 - O custo de aquisição de uma ferramenta deve ser um valor não negativo.
-RN03 - Todos os campos obrigatórios devem ser preenchidos no cadastro de amigos, ferramentas ou empréstimos.
-RN04 - A data em que a ferramenta deve ser devolvida não pode ser anterior à data em que foi emprestada.
-RN05 - Não é possível excluir o cadastro de um amigo, ferramenta ou empréstimo enquanto houver pendências associadas a eles
```
# Banco de Dados
```bash
- Usuario: myuser
- Senha: myuser
```
