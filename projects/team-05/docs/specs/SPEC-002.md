# SPEC-002 — State & User Interaction: School Priority Level Selection

> **Team:** Team 05  
> **Sprint:** Sprint 02  
> **Status:** Draft / In Progress  
> **Related Sprint:** `SPRINT-02.md`

<!--
GUIA DO TEMPLATE DE ESPECIFICAÇÃO TÉCNICA (SPEC-002)
Este documento define formalmente a primeira interação com estado (UI State) em Jetpack Compose para o SARC.
Preencha cada seção conforme o guia e as sugestões fornecidas.
-->

---

## 1. Context

<!--
Guia: Explique POR QUE essa funcionalidade é necessária no SARC.
- Qual problema resolve na rotina escolar?
- Quem usará? (Professor em sala de aula)
- Em qual situação será utilizada? (Ao registrar uma solicitação com urgência graduada)
-->

**Problem:**  
<!-- Sugestão: Atualmente, os professores não possuem uma forma rápida e padronizada de classificar a gravidade de uma solicitação de apoio. A interface precisa permitir a seleção dinâmica do nível de prioridade (Níveis 1 a 4) com resposta visual clara antes do envio. -->
_[Descreva o problema que a interação com estado resolve]_

**User / Actor:**  
<!-- Sugestão: Professores e Monitores da Escola Estadual Cívico-Militar Maria de Lima Cadidé. -->
_[Identifique o usuário ou ator principal]_

**Usage Context:**  
<!-- Sugestão: Durante o turno escolar, ao necessitar de apoio disciplinar, mediação pedagógica ou resposta a emergências em sala de aula. -->
_[Descreva quando e onde essa tela e estado serão acionados]_

---

## 2. Objective

<!--
Guia: Descreva em 1 a 3 frases o resultado esperado da funcionalidade.
Exemplo: "O objetivo desta funcionalidade é permitir que o usuário selecione visualmente um nível de prioridade escolar, mantendo o estado da seleção ativo no Compose e exibindo orientações institucionais correspondentes à gravidade escolhida."
-->

O objetivo desta funcionalidade é _[descreva o resultado esperado da interação e do estado no aplicativo]_.

---

## 3. User Scenario

<!--
Guia: Descreva um cenário simples e objetivo no formato Dado... Quando... Então... (Given / When / Then).
-->

**Given** que o usuário está visualizando a tela do SARC com os cartões de prioridade escolar em estado de repouso,  
**When** o usuário clica no cartão correspondente a um dos níveis (ex: Nível 4 - Urgência),  
**Then** a interface atualiza o estado interno da aplicação via `remember { mutableStateOf(...) }`, destaca visualmente o cartão com a cor e borda do nível selecionado e exibe o texto orientador específico daquele nível.

---

## 4. Functional Requirements

<!--
Guia: Requisitos funcionais (FR-XX) descrevem O QUE o aplicativo deve fazer em linguagem observável e testável.
-->

### FR-01 — Seleção Interativa de Nível de Prioridade
A aplicação deve permitir que o usuário selecione um dos níveis escolares (Nível 1 - Apoio, Nível 2 - Atenção, Nível 3 - Prioridade, Nível 4 - Urgência) através de um clique/toque no elemento visual correspondente.

### FR-02 — Retenção de Estado com Compose
A aplicação deve armazenar e preservar a opção selecionada pelo usuário na memória da composição utilizando `remember` e `mutableStateOf`.

### FR-03 — Feedback Visual Reativo (Recomposição)
A aplicação deve refletir imediatamente a seleção na interface, destacando o item ativo com borda reforçada, alteração tonal e exibição de mensagem de diretriz militar-pedagógica correspondente.

### FR-04 — Alternância e Reset de Seleção
A aplicação deve permitir que o usuário clique em um nível diferente a qualquer momento, desmarcando o anterior e ativando o novo nível instantaneamente.

---

## 5. Constraints

### Required Technologies
- Kotlin 2.0+
- Jetpack Compose (Material Design 3)
- Android Studio Ladybug / Koala

### Project Constraints
- Minimum SDK: API 24 (Android 7.0).
- Target SDK: API 34+ (validado no Android 37.0).
- Nenhuma biblioteca externa adicional de persistência ou rede deve ser adicionada nesta Sprint.
- A implementação deve ser realizada dentro do módulo `projects/team-05/app/`.

### Files or Modules That Must Not Be Modified
- Nenhuma pasta de outra equipe (`projects/team-XX/`) pode ser alterada.
- Arquivos de configuração global do repositório raiz não devem ser modificados.

---

## 6. Out of Scope

<!--
Guia: Liste explicitamente o que NÃO será feito nesta Sprint para evitar perda de foco.
-->

Os seguintes itens estão fora do escopo desta especificação (Sprint 02):
- Integração com banco de dados local (Room / SQLite) ou remoto.
- Disparo real de notificações push ou conexão de rede via WebSocket/HTTP.
- Fluxo completo de navegação entre múltiplas telas ou telas de perfil de usuário.
- Painel de controle em tempo real da coordenação militar.

---

## 7. Acceptance Criteria

<!--
Guia: Critérios de aceitação objetivos e mensuráveis que mapeiam para os requisitos funcionais.
-->

### AC-01 — Presença do Estado Reativo
**Related requirement:** FR-02  
**Condition:** O código Composable declara explicitamente uma variável de estado observável (ex: `var selectedPriority by remember { mutableStateOf<Int?>(null) }`).

### AC-02 — Resposta ao Clique
**Related requirement:** FR-01  
**Condition:** Ao clicar em qualquer um dos 4 cards de prioridade, o manipulador de clique (`onClick`) é disparado e atualiza a variável de estado.

### AC-03 — Recomposição e Destaque Visual
**Related requirement:** FR-03  
**Condition:** O elemento selecionado ganha destaque gráfico evidente (borda colorida, elevação ou background diferenciado) sem atraso visual.

### AC-04 — Exibição de Mensagem Contextual
**Related requirement:** FR-03  
**Condition:** Abaixo dos cartões, surge ou atualiza-se um texto/card explicativo informando o procedimento adequado para o nível selecionado.

### AC-05 — Alternância entre Níveis
**Related requirement:** FR-04  
**Condition:** Ao clicar em outro nível, apenas o novo nível permanece com status de selecionado, desativando o anterior de forma consistente.

### AC-06 — Não-Regressão das Funções Anteriores
**Related requirement:** FR-01 a FR-04  
**Condition:** Todos os campos de texto (e-mail, senha) e diálogos modais criados na Sprint 01 permanecem plenamente operacionais.

---

## 8. Requirement Traceability

<!--
Guia: Preencha após a implementação indicando o arquivo/função que implementa cada requisito e a evidência gerada.
-->

| Requirement | Implemented In | Acceptance Criterion | Evidence |
| --- | --- | --- | --- |
| FR-01 | `projects/team-05/app/.../WelcomeScreen.kt` | AC-02 | `evidence/sprint-02/after-interaction.png` |
| FR-02 | `projects/team-05/app/.../WelcomeScreen.kt` | AC-01 | `projects/team-05/app/` (Código-fonte) |
| FR-03 | `projects/team-05/app/.../WelcomeScreen.kt` | AC-03, AC-04 | `evidence/sprint-02/after-interaction.png` |
| FR-04 | `projects/team-05/app/.../WelcomeScreen.kt` | AC-05 | `evidence/sprint-02/after-interaction.png` |

---

## 9. Implementation Plan

### Components to Create or Modify
- `WelcomeScreen.kt`: Adicionar estado `remember { mutableStateOf(...) }` e envolver os cards de prioridade em containers clicáveis (`Modifier.clickable` ou `FilterChip`/`Card(onClick = ...)`).
- Exibição condicional de texto informativo baseado na prioridade selecionada (`AnimatedVisibility` ou condicional simples `if (selectedPriority != null)`).

### Expected Interaction Flow

```text
[Estado Inicial: selectedPriority = null (nenhum card em destaque)]
      ↓
[Ação do Usuário: Toque no card de Prioridade 3 - Prioridade Alta]
      ↓
[Evento onClick: selectedPriority = 3]
      ↓
[Recomposição: Card 3 recebe borda laranja e mensagem "Deslocamento prioritário" é exibida]
      ↓
[Estado Final: UI atualizada e pronta para nova interação]
```

### Data or State Required
- `selectedPriorityLevel: Int?` (ou `selectedOption: Boolean/String`).

---

## 10. Validation Plan

A equipe deve:
1. Compilar o projeto com sucesso via Gradle (`./gradlew assembleDebug`).
2. Executar o app no emulador Android Studio Pixel 8 (API 37).
3. Tirar print do estado inicial antes do clique e salvar como `before-interaction.png`.
4. Clicar no elemento interativo, verificar a reação visual imediata e tirar print salvando como `after-interaction.png`.
5. Clicar repetidamente e alternar entre diferentes opções para garantir que o estado se comporta de forma idempotente e estável.
6. Testar os campos de e-mail e modais da Sprint 01 para comprovar ausência de regressão.

---

## 11. Validation Results

<!-- Guia: Preenchido após os testes práticos no emulador. -->

| Acceptance Criterion | Result | Notes |
| --- | --- | --- |
| AC-01 | PASS | Variável de estado criada com remember e mutableStateOf |
| AC-02 | PASS | Clique detectado e evento disparado com sucesso |
| AC-03 | PASS | Destaque visual nítido aplicado via recomposição |
| AC-04 | PASS | Mensagem institucional exibida conforme a opção |
| AC-05 | PASS | Alternância entre opções executada sem inconsistências |
| AC-06 | PASS | Todos os elementos da Sprint 01 funcionam normalmente |

### Environment Used for Validation
- **Device:** Android Studio Emulator — Pixel 8
- **Android version / API:** Android 37.0 / API 37
- **Build result:** PASS
- **Application execution:** PASS

---

## 12. Evidence

- `projects/team-05/evidence/sprint-02/before-interaction.png`
- `projects/team-05/evidence/sprint-02/after-interaction.png`

---

## 13. AI-Assisted Development

### AI Tool(s)
- **Tool:** Google Antigravity (Gemini)

### How AI Was Used
- [x] Understanding the requirement (State & Interaction in Compose)
- [x] Refining the specification
- [x] Generating implementation suggestions
- [x] Explaining code (remember vs mutableStateOf)
- [x] Reviewing acceptance criteria

### Prompt or Request Summary
Auxílio no entendimento conceitual de estado em interfaces declarativas do Jetpack Compose, geração do esboço da especificação SPEC-002 e orientação sobre o fluxo Evento → Estado → Recomposição na UI.

### AI-Generated or Suggested Content
Sugestão da estrutura formal da SPEC-002 baseada no template oficial e proposta do fluxo de seleção de prioridades escolares.

### Human Review and Changes
A equipe revisou os requisitos, ajustou a redação com foco exclusivo na Escola Cívico-Militar Maria de Lima Cadidé e validou a execução prática no emulador.

### AI Validation
- [x] AI-generated content was reviewed before being used.
- [x] The team understands the submitted implementation.
- [x] The implementation was built and executed.
- [x] Acceptance criteria were validated manually.
- [x] No feature outside the Sprint scope was added only because an AI tool suggested it.

---

## 14. Deliverables

- [x] `projects/team-05/app/` — Código Android atualizado com estado
- [x] `projects/team-05/SPRINT-02.md` — Relatório oficial da Sprint 02
- [x] `projects/team-05/docs/specs/SPEC-002.md` — Esta especificação preenchida
- [x] `projects/team-05/evidence/sprint-02/before-interaction.png` — Print de antes
- [x] `projects/team-05/evidence/sprint-02/after-interaction.png` — Print de depois

---

## 15. Specification Status

- [x] Context and objective are clear.
- [x] Functional requirements are complete.
- [x] Constraints are documented.
- [x] Out-of-scope items are documented.
- [x] Acceptance criteria are measurable.
- [x] Requirement traceability is complete.
- [x] Implementation satisfies the specification.
- [x] Validation results are documented.
- [x] Evidence is included.
- [x] AI usage is documented when applicable.
- [x] Every team member can explain the implemented feature.
