# SPRINT 02 — State & User Interaction

## Team Identification

- **Team:** Team 05
- **Project:** SARC (Sistema de Acionamento e Resposta Cívico-Militar)
- **Institution:** Escola Estadual Cívico-Militar Maria de Lima Cadidé
- **Members:**
  - Matheus Gabriel de Morais Barros ([@MatheusGabriel-25](https://github.com/MatheusGabriel-25))
  - Paulo Vitor ([@PAULOSANTOS1309](https://github.com/PAULOSANTOS1309))

---

## 1. Interaction Selection

<!-- Guia: O professor exige a escolha de UMA interação significativa para o produto (ex: selecionar uma opção, alternar favorito, exibir/ocultar informação, incrementar quantidade, mudar filtro ou atualizar mensagem visível). Ela deve fazer sentido para o contexto do SARC da Escola Cadidé. -->

### Selected Feature

<!-- Sugestão: Seleção Interativa de Nível de Prioridade do Acionamento (Níveis 1 a 4) com Feedback Visual e Instrução Operacional Dinâmica. -->
_[Defina aqui o nome da funcionalidade de interação escolhida]_

### Problem Solved

<!-- Sugestão: Na rotina da Escola Cadidé, os professores precisam indicar com clareza a gravidade da situação antes de acionar a equipe. Ao interagir com a interface e selecionar um nível de prioridade, o usuário deve receber confirmação visual imediata do nível escolhido e uma orientação contextual rápida sobre o protocolo militar correspondente. -->
_[Explique qual problema essa interação resolve para o usuário da escola]_

### Meaningful Value for the Product

<!-- Sugestão: Essa interação introduz o primeiro estado dinâmico do SARC, permitindo que a interface reaja à escolha do professor e prepare a carga de dados para o futuro despacho do chamado, evitando acionamentos incorretos. -->
_[Explique por que essa interação agrega valor real ao SARC]_

---

## 2. State & Compose Architecture

<!-- Guia: Explique qual variável de estado foi introduzida no Jetpack Compose, qual evento a modifica, e qual componente visual reage e é recomposto na tela. -->

### State Definition

<!-- Sugestão:
- Variável de estado: `selectedPriorityLevel` gerenciada via `remember { mutableStateOf<Int?>(null) }` (ou Boolean/Enum).
- Tipo do estado: `Int?` (representando 1, 2, 3 ou 4) ou `PriorityLevel?`.
- Valor inicial: `null` (nenhum selecionado) ou `1` (apoio padrão).
-->
- **State variable:** _[Ex: selectedPriorityLevel]_
- **State type:** _[Ex: Int? ou Boolean]_
- **Initial value:** _[Ex: null ou false]_
- **Compose mechanism:** `remember { mutableStateOf(...) }`

### Event -> State -> UI Flow

<!-- Guia: Valide o encadeamento obrigatório exigido pelo professor: Estado Inicial → Ação do Usuário → Atualização do Estado → Resposta Visível na UI. -->

```text
[Estado Inicial: Nenhuma prioridade selecionada ou card em repouso]
      ↓
[Ação do Usuário: Clique em um dos cartões de prioridade (Nível 1, 2, 3 ou 4)]
      ↓
[Manipulador de Evento (onClick): Atualiza selectedPriorityLevel = novoNivel]
      ↓
[Recomposição do Compose: O cartão selecionado ganha destaque visual e exibe mensagem orientadora]
```

### Visual Feedback

<!-- Guia: Descreva como a interface muda visualmente quando o estado é alterado. -->
<!-- Sugestão:
1. O cartão clicado recebe borda destacada com a cor da prioridade e ícone de seleção ativa.
2. Os demais cartões retornam ao estado desmarcado.
3. Surge na parte inferior um banner/card com as instruções de conduta para aquele nível de gravidade.
-->
_[Descreva o que muda na tela após a ação do usuário]_

---

## 3. Scope & Requirements

### Functional Requirements

- **FR-01 — [Seleção de Opção]:** A aplicação deve permitir que o usuário selecione um item/opção na interface através de um toque.
- **FR-02 — [Gerenciamento de Estado]:** A aplicação deve reter a escolha do usuário utilizando `remember` e `mutableStateOf` do Jetpack Compose.
- **FR-03 — [Feedback Visual]:** A aplicação deve alterar visualmente a interface (cores, bordas, ícones ou textos informativos) em resposta à mudança de estado.
- **FR-04 — [Persistência da Interação]:** A interface deve permitir alternar a seleção entre opções a qualquer momento, refletindo imediatamente o novo estado sem reiniciar a tela.

### Non-Functional Requirements

- **NFR-01 — [Performance de Recomposição]:** A mudança de estado deve recompor apenas os elementos necessários da UI sem travamentos ou lentidão perceptível.
- **NFR-02 — [Design System Material 3]:** Os elementos interativos devem utilizar os tokens de cores, elevação e espaçamentos do Material Design 3.
- **NFR-03 — [Compatibilidade e Regressão]:** Todas as funções implementadas na Sprint 01 (campos de texto, diálogos modais e layout) devem continuar funcionando perfeitamente sem falhas.

---

## 4. Acceptance Criteria

<!-- Guia: Critérios oficiais da Sprint 02 definidos pelo curso (AC-01 a AC-10). Marque com [x] conforme forem validados. -->

- [ ] **AC-01** — A especificação técnica `SPEC-002.md` existe e está preenchida no diretório `docs/specs/`.
- [ ] **AC-02** — Uma interação significativa para o produto SARC foi claramente definida.
- [ ] **AC-03** — O código Compose contém pelo menos um valor de estado gerenciado por `remember` e `mutableStateOf`.
- [ ] **AC-04** — Um evento disparado pelo usuário altera o valor do estado.
- [ ] **AC-05** — A interface visual (UI) reage visivelmente à mudança do estado.
- [ ] **AC-06** — O estado inicial e os estados atualizados comportam-se corretamente em múltiplos cliques.
- [ ] **AC-07** — Todas as funcionalidades da Sprint 01 continuam operando sem quebras (sem regressão).
- [ ] **AC-08** — O aplicativo compila e executa no emulador sem falhas ou travamentos (`crashes`).
- [ ] **AC-09** — As evidências visuais de antes e depois da interação estão salvas em `evidence/sprint-02/`.
- [ ] **AC-10** — A equipe compreende e sabe explicar o fluxo de estado `Evento → Estado → Recomposição UI`.

---

## 5. Regression Validation

<!-- Guia: Confirme que as telas e recursos da Sprint 01 continuam íntegros após as mudanças da Sprint 02. -->

1. **Campos de E-mail e Senha:** A digitação, a máscara protetora de senha e o botão de visibilidade continuam funcionando normalmente.
2. **Diálogos Modais da Sprint 01:** Os botões "Sobre o SARC" e "Solicitar Cadastro" continuam abrindo e fechando seus respectivos modais sem erros.
3. **Brasão Institucional:** A identidade visual da Escola Cadidé permanece alinhada e nítida no topo da interface.

---

## 6. Evidence

<!-- Guia: Salve os prints obrigatórios em projects/team-05/evidence/sprint-02/ com os nomes padrão exigidos pelo professor: before-interaction.png e after-interaction.png. -->

### Before Interaction
![Before Interaction](evidence/sprint-02/before-interaction.png)
*Figura 1: Estado inicial da interface antes da interação do usuário.*

### After Interaction
![After Interaction](evidence/sprint-02/after-interaction.png)
*Figura 2: Estado atualizado da interface após a ação do usuário, demonstrando a reação visual da UI.*

---

## 7. AI Usage

<!-- Guia: Documente a utilização de ferramentas de inteligência artificial de acordo com as regras da disciplina. -->

### Tool
Google Antigravity (Gemini).

### Purpose
Auxílio no entendimento do paradigma de estado declarativo em Jetpack Compose (`remember`, `mutableStateOf`, recomposição), estruturação técnica dos documentos da Sprint 02 e sugestão de padrões limpos de manipulação de eventos.

### Generated Content
_[Descreva o que a IA sugeriu ou estruturou para a Sprint 02]_

### Human Changes
_[Descreva o que a equipe de alunos revisou, adaptou e codificou manualmente]_

### Validation
_[Descreva como a equipe testou a solução contra a especificação e no emulador Android Studio]_

### Tabela Síntese (Padrão Oficial do Curso)

| Item | Team response |
| --- | --- |
| LLM/tool used | Google Antigravity (Gemini) |
| Task supported by the LLM | Estruturação da SPEC-002, arquitetura do fluxo Evento → Estado → UI e documentação da Sprint 02 |
| Main suggestion received | _[Ex: Padrão de estado com remember { mutableStateOf(...) } para seleção de prioridades]_ |
| What the team changed manually | _[Ex: Implementação das regras contextuais da Escola Cadidé, estilização Material 3 e testes no emulador]_ |
| How the result was validated | Compilação via Gradle (`./gradlew assembleDebug`) e validação dos critérios AC-01 a AC-10 no emulador Pixel 8 (API 37) |

---

## 8. Deliverables

<!-- Guia: Lista oficial de artefatos que devem constar no Pull Request da Sprint 02. -->

- `projects/team-05/app/` — Código-fonte do projeto Android com o estado implementado
- `projects/team-05/SPRINT-02.md` — Relatório da Sprint 02
- `projects/team-05/docs/specs/SPEC-002.md` — Especificação técnica da interação com estado
- `projects/team-05/evidence/sprint-02/before-interaction.png` — Print do estado inicial (obrigatório)
- `projects/team-05/evidence/sprint-02/after-interaction.png` — Print após a interação com resposta visual (obrigatório)
