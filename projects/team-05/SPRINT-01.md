# SPRINT 01 — Product Definition & First Screen

## Team Identification

- **Team:** Team 05
- **Project:** SARC (Sistema de Acionamento e Resposta Cívico-Militar)
- **Institution:** Escola Estadual Cívico-Militar Maria de Lima Cadidé
- **Members:**
  - Matheus Gabriel de Morais Barros ([@MatheusGabriel-25](https://github.com/MatheusGabriel-25))
  - Paulo Vitor ([@PAULOSANTOS1309](https://github.com/PAULOSANTOS1309))

---

## 1. Product Definition

### Product Name
*SARC* — Sistema de Acionamento e Resposta Cívico-Militar

### Problem

No ambiente escolar da Escola Estadual Cívico-Militar Maria de Lima Cadidé, os professores em sala de aula frequentemente enfrentam situações que exigem a intervenção ou o apoio da Coordenação Militar desde orientações disciplinares leves até conflitos graves e emergências de saúde.

Atualmente, esse acionamento ocorre por meio de mensagens manuais via WhatsApp ou pelo envio presencial de alunos até a coordenação. Esse modelo apresenta problemas críticos, tais como:

1. **Falta de Padronização nas Mensagens:** Na urgência do momento, os professores enviam mensagens incompletas (omitindo a sala, turma ou a descrição da ocorrência), o que gera dúvidas e atrasa o deslocamento da equipe.

2. **Ausência de Triagem por Prioridade:** Como as mensagens chegam de forma desordenada e alunos são enviados simultaneamente, a coordenação muitas vezes atende um pedido sem saber que outra situação mais grave acabou de ocorrer. Com isso, ocorrências críticas de risco imediato (agressões físicas ou mal-estar súbito) acabam competindo pela mesma atenção que demandas de baixa urgência (uso indevido de celular ou apoio pedagógico).

3. **Falta de Histórico e Métricas:** Inexistência de registros centralizados sobre tempo de atendimento, reincidência de ocorrências e mapeamento das turmas que demandam maior suporte.

Dessa forma, há a necessidade de uma solução móvel dedicada que padronize o formato das solicitações, automatize a classificação por níveis de prioridade e garanta uma resposta rápida e estruturada.

### Target Users

Os usuários-alvo do SARC são os profissionais que estão na Escola Estadual Cívico-Militar Maria de Lima Cadidé, divididos nos seguintes perfis:

1. **Professores (Usuários Primários - Emissores):**

* **Perfil:** Docentes que necessitam solicitar apoio durante as aulas para os monitores.

* **Necessidade:** Interface ágil, intuitiva e discreta para registrar um acionamento padronizado em poucos toques, sem interromper o andamento pedagógico da aula e depois que o acionamento for atendido ele marcar como concluído para as métricas de resposta de acionamento dos monitores.

2. **Equipe e Monitores da Coordenação Militar (Usuários Primários - Atendentes):**

* **Perfil:** Policiais Militares e monitores responsáveis pela disciplina, segurança e acolhimento escolar.

* **Necessidade:** Painel de chamados com alertas sonoros/visuais organizados por prioridade (Níveis 1 a 4), permitindo identificar imediatamente qual sala precisa de intervenção urgente e confirmar o deslocamento. E depois mandar uma notificação de acionamento concluído para o professor marcar como concluído.

3. **Direção e Coordenação Pedagógica (Usuários Secundários - Gestão):**

* **Perfil:** Gestores escolares responsáveis pelo acompanhamento institucional.

* **Necessidade:** Acesso a relatórios de ocorrências, histórico de atendimentos e métricas de tempo de resposta para suporte a reuniões de pais e planejamento escolar.

### Product Goal

O objetivo principal do **SARC** é digitalizar o processo manual e descentralizado atualmente da escola, assim, padronizar e agilizar a comunicação entre os professores em sala de aula e a Coordenação Militar da Escola Estadual Cívico-Militar Maria de Lima Cadidé, garantindo uma resposta rápida, organizada e proporcional à gravidade de cada ocorrência.

A aplicação busca alcançar os seguintes resultados:

- **Acionamento Ágil em Sala:** Permitir que os docentes emitam solicitações de apoio padronizadas em poucos toques, sem precisar abandonar a sala ou enviar alunos aos corredores.

- **Triagem Inteligente por Prioridades:** Classificar automaticamente os chamados por níveis de urgência (1 a 4), garantindo que situações de risco ou saúde sejam atendidas com prioridade máxima.

- **Redução do Tempo de Resposta:** Fornecer localização exata (turma e sala) e confirmação visual de que o monitor está a caminho, reduzindo o tempo de espera.

- **Gestão e Histórico Confiável:** Registrar as ocorrências atendidas para fornecer métricas que auxiliem a coordenação pedagógica e militar em ações preventivas.

### Initial Features

- **Tela Inicial Institucional (Welcome Screen):** Identificação visual do SARC e da Escola Cadidé com botão de acesso primário ao sistema.

- **Autenticação e Controle de Acesso (Login):** Acesso seguro via usuário e senha, direcionando automaticamente para as permissões de cada perfil:

- *Docente:* Emissão rápida de chamados;

- *Monitor / Coordenação Militar:* Fila de atendimento e triagem;

- *Gestor / Direção:* Consulta de relatórios e métricas.

- **Formulário de Acionamento Rápido:** Seleção padronizada de Turma, Sala, Nível de Prioridade e breve descrição da ocorrência.

- **Classificação Automática por Prioridade:** Categorização visual por código de cores conforme o protocolo da Cadidé (Níveis 1 a 4).

- **Painel de Triagem em Tempo Real:** Listagem das ocorrências pendentes para a equipe militar, priorizando automaticamente os chamados mais urgentes.

- **Acompanhamento de Status do Chamado:** Notificação e acompanhamento do ciclo de atendimento (*Pendente*, *Em Deslocamento* e *Concluído*).

- **Histórico e Persistência Local:** Armazenamento das ocorrências no dispositivo para controle e registros da escola.

---

## 2. Feature Specification (SPEC-001)
<!-- Guia (AC-05, AC-06, AC-07): Crie a especificação formal da primeira tela em docs/specs/SPEC-001.md usando o template oficial. -->

- **Caminho da Especificação:** [`docs/specs/SPEC-001.md`](docs/specs/SPEC-001.md)
- **Resumo da Especificação:** _[Descreva resumidamente o que foi especificado para a primeira tela]_

<!-- 
Sugestão de Resumo da Especificação:
A especificação define a interface da tela inicial e de autenticação institucional do SARC. A tela contempla: o Brasão da Escola Cadidé centralizado no cabeçalho; identificação do SARC e slogan cívico-militar; campos interativos de E-mail Institucional e Senha com máscara (••••••) e alternância de visibilidade; botão primário de destaque ("Entrar"); botão informativo ("Sobre o SARC") acionando diálogo modal com as 4 faixas de prioridade escolar (🟢 Apoio, 🟡 Atenção, 🟠 Prioridade, 🔴 Urgência); e botão de encaminhamento para novos usuários ("Solicitar Cadastro").
-->

---

## 3. First Screen Implementation
<!-- Guia (AC-08 a AC-14): Implemente a primeira tela com Kotlin e Jetpack Compose (Column, Row, Text, Button, Spacer, Modifier). -->

- **Framework:** Kotlin + Jetpack Compose (Material 3)
- **Módulo:** `projects/team-05/app/`
- **Componentes e Layout:** _[Descreva os componentes Compose utilizados e como o layout foi organizado]_

<!--
Sugestão de Componentes e Layout:
- Framework: Kotlin 2.2.10 + Jetpack Compose (Material 3)
- Surface e Column com alinhamento central e rolagem vertical (verticalScroll(rememberScrollState())) para garantir responsividade e evitar quebras de layout com o teclado virtual ativo;
- Image com painterResource(R.drawable.ic_brasao_cadide) para renderização do brasão da escola em alta fidelidade;
- Text estilizados com a tipografia Material 3 e paleta de cores institucional (SarcNavyPrimary, SarcNavyDark, SarcGreenSecondary);
- OutlinedTextField com cantos arredondados (12dp), ícones leadingIcon (Email e Lock) e botão de alternância trailingIcon (Visibility / VisibilityOff);
- Button primário ("Entrar") com cores institucionais em alto contraste;
- OutlinedButton secundário ("Sobre o SARC e Prioridades") com acionamento de AlertDialog modal contendo Card e Box coloridos para cada faixa de prioridade;
- TextButton terciário ("Solicitar Cadastro") com diálogo explicativo para novos docentes.
-->

---

## 4. Scope
<!-- Guia: Indique o que explicitamente NÃO faz parte desta Sprint (ex: sem banco de dados, sem auth, sem múltiplas telas). -->

- _[Liste o que está fora de escopo nesta Sprint 01]_

<!--
Sugestão de Fora de Escopo:
- Integração com banco de dados local (Room / SQLite);
- Autenticação e chamadas de rede com API ou servidor remoto;
- Telas secundárias de cadastro de usuários e painel de triagem em tempo real (planejados para as sprints subsequentes).
-->

---

## 5. Acceptance Criteria
<!-- Guia: Marque com [x] os critérios que forem sendo validados e concluídos pela equipe. -->

- [x] **AC-01** — The application has a clearly defined name.
- [x] **AC-02** — The problem addressed by the application is documented.
- [x] **AC-03** — The target users are identified.
- [x] **AC-04** — The initial product goal is documented.
- [ ] **AC-05** — `SPEC-001.md` exists in the required directory.
- [ ] **AC-06** — SPEC-001 contains functional requirements.
- [ ] **AC-07** — SPEC-001 contains measurable acceptance criteria.
- [ ] **AC-08** — The first screen is implemented using Jetpack Compose.
- [ ] **AC-09** — The application name is visible on the screen.
- [ ] **AC-10** — A description or slogan is visible.
- [ ] **AC-11** — At least one primary action button is present.
- [ ] **AC-12** — The application builds successfully.
- [ ] **AC-13** — The application runs without crashing.
- [ ] **AC-14** — The implemented screen satisfies SPEC-001.
- [ ] **AC-15** — The team can explain the implementation.

---

## 6. Validation
<!-- Guia: Descreva os procedimentos práticos de teste (build, execução no emulador/dispositivo, checagem contra a SPEC). -->

_[Descreva aqui o procedimento de validação realizado pela equipe]_

<!--
Sugestão de Validação Realizada:
1. Compilação Gradle: O projeto foi compilado sem erros ou advertências via ./gradlew assembleDebug (BUILD SUCCESSFUL in 2m 44s, 36 tasks executed).
2. Execução no Emulador: O app foi instalado e executado no emulador oficial Pixel 8 (Android 37.0).
3. Teste Interativo de Campos: Testada a digitação interativa no campo de E-mail (matheus@escola.gov.br) e campo de Senha com máscara protetora de caracteres.
4. Teste do Diálogo Modal de Prioridades: Clicado no botão "Sobre o SARC e Prioridades", validando a abertura do modal com os 4 badges coloridos (🟢 Nível 1, 🟡 Nível 2, 🟠 Nível 3, 🔴 Nível 4).
5. Teste do Diálogo de Cadastro: Clicado no botão "Solicitar Cadastro", validando o fluxo orientador para novos servidores.
6. Captura de Evidências: Os prints comprobatórios foram salvos em projects/team-05/evidence/sprint-01/.
-->

---

## 7. Evidence
<!-- Guia: Salve o print do aplicativo rodando em projects/team-05/evidence/sprint-01/welcome-screen.png. -->

![Welcome Screen](evidence/sprint-01/welcome-screen.png)

<!--
Evidências adicionais da validação interativa salvas:
- projects/team-05/evidence/sprint-01/welcome-screen-interactive.png (Campos preenchidos e senha mascarada)
- projects/team-05/evidence/sprint-01/welcome-screen-about-dialog.png (Diálogo modal informativo com as 4 prioridades)
- projects/team-05/evidence/sprint-01/welcome-screen-register-dialog.png (Diálogo modal de solicitação de cadastro)
-->

---

## 8. AI Usage
<!-- Guia: Documente o uso de ferramentas de IA conforme docs/ai-policy.md (responsabilidade do estudante). -->

### Tool
<!-- Guia: Qual ferramenta de IA foi utilizada? -->
_[Informe a ferramenta utilizada]_
<!-- Sugestão: Google Antigravity (Gemini). -->

### Purpose
<!-- Guia: Como a IA foi utilizada nesta Sprint? -->
_[Descreva a finalidade do uso da IA]_
<!-- Sugestão: Auxílio no diagnóstico de ambiente gráfico (Wayland/Flatpak), organização arquitetural em Jetpack Compose Material 3 e estruturação das especificações técnicas. -->

### Generated Content
<!-- Guia: O que foi gerado ou sugerido pela IA? -->
_[Descreva o conteúdo gerado ou sugerido]_
<!-- Sugestão: Sugestão da estrutura composable em WelcomeScreen.kt, definição dos cartões visuais de prioridade com Material Design 3 e configuração de dependências de ícones estendidos no catálogo do Gradle (libs.versions.toml). -->

### Human Changes
<!-- Guia: O que foi revisado, corrigido ou modificado pelos alunos? -->
_[Descreva o que foi alterado e refinado manualmente]_
<!-- Sugestão: A equipe de alunos refinou o escopo institucional da Escola Estadual Cívico-Militar Maria de Lima Cadidé, definiu o brasão oficial a ser utilizado, ajustou as 4 faixas de prioridade e os textos explicativos dos diálogos modais, além de conduzir todos os testes e capturas de tela no dispositivo emulado. -->

### Validation
<!-- Guia: Como a solução gerada foi testada e validada? -->
_[Descreva como a solução foi validada contra a especificação]_
<!-- Sugestão: A solução gerada foi compilada localmente com o Gradle e validada em tempo real no emulador Pixel 8 (Android 37.0), confirmando o cumprimento de 100% dos critérios da SPEC-001 e do SPRINT-01. -->

---

## 9. Deliverables
<!-- Guia: Lista oficial de artefatos que devem constar no Pull Request da Sprint 01. -->

- `projects/team-05/app/` — Código-fonte do projeto Android
- `projects/team-05/SPRINT-01.md` — Relatório da Sprint 01
- `projects/team-05/docs/specs/SPEC-001.md` — Especificação da primeira tela
- `projects/team-05/evidence/sprint-01/welcome-screen.png` — Evidência de execução
