# SPEC-003 — Navegação Login → Painel do Docente

> **Team:** Team 05  
> **Sprint:** Sprint 03 — Navigation & Multiple Screens  
> **Status:** Draft  
> **Related Sprint:** `SPRINT-03.md`  
> **Base:** `SPEC-001.md` (tela de login) e `SPEC-002.md` (modais interativos)

---

## 1. Context

**Problem:**

Hoje o SARC tem **uma única tela**: o login (`WelcomeScreen`). O botão "Entrar" existe, mas não leva a lugar nenhum, então o professor não tem como chegar ao ponto principal do app: acionar a Coordenação Militar.

**User / Actor:**

O **docente** da Escola Cadidé, que entra no app para acionar a Coordenação Militar.

**Usage Context:**

Logo depois de abrir o aplicativo: o professor toca em "Entrar" e precisa ver o seu painel de trabalho. Quando termina, toca em "Sair" e volta ao login.

---

## 2. Objective

O objetivo desta funcionalidade é transformar o SARC em um aplicativo de **duas telas**, ligando o **Login** ao **Painel do Docente** com **Navigation Compose** (`NavController` + `NavHost`), com ida pelo botão "Entrar" e volta pelo botão "Sair".

---

## 3. User Scenario

**Given** que o professor abriu o aplicativo e está na tela de Login,  
**When** ele toca em **"Entrar"**,  
**Then** o aplicativo mostra o **Painel do Docente**.

**Given** que o professor está no Painel do Docente,  
**When** ele toca em **"Sair"**,  
**Then** o aplicativo volta para a tela de Login.

**Given** que o professor está no Painel do Docente,  
**When** ele usa o **botão voltar do Android**,  
**Then** o aplicativo é fechado e o celular mostra a tela inicial, como em um app de verdade.

---

## 4. Functional Requirements

### FR-01 — Navegação com duas rotas

O aplicativo deve usar um `NavHost` controlado por um `NavController`, com **2 destinos**: `welcome` (Login) e `home` (Painel do Docente). O destino inicial é `welcome`.

### FR-02 — Entrar abre o painel

Ao tocar em **"Entrar"** na tela de Login, o aplicativo deve navegar para a rota `home`. O botão não valida e-mail nem senha nesta Sprint.

### FR-03 — Título do painel

O Painel do Docente deve exibir o título **"Painel do Docente"** e o subtítulo **"Acione a Coordenação em poucos toques"**.

### FR-04 — Legenda dos 4 níveis

O Painel do Docente deve exibir a **legenda dos 4 níveis de prioridade** (nome e cor de cada nível, somente para consulta), usando as cores do tema do SARC.

### FR-05 — Meus acionamentos vazia

O Painel do Docente deve exibir a seção **"Meus acionamentos"** **sem nenhum item**, com a mensagem **"Nenhum acionamento ainda"**. Não há exemplos nem dados de teste.

### FR-06 — Novo acionamento mostra aviso

Ao tocar em **"Novo acionamento"**, o aplicativo deve abrir um aviso com o texto **"O formulário de acionamento chega na Sprint 04"**, que fecha ao toque em um botão.

### FR-07 — Sair volta ao Login; voltar do Android sai do app

- Ao tocar em **"Sair"**, o aplicativo deve voltar à tela de Login.
- Ao usar o **botão voltar do Android** no Painel do Docente, o aplicativo deve **fechar** e mostrar a tela inicial do celular. Ele **não** volta ao Login.

---

## 5. Constraints

### Required Technologies

- Kotlin 2.2.10
- Jetpack Compose com Material Design 3 (Compose BOM 2026.02.01)
- `androidx.navigation:navigation-compose` (única dependência nova)
- Android Studio

### Project Constraints

- `minSdk = 24`, `compileSdk = 37` e `targetSdk = 37` permanecem iguais.
- A navegação usa **apenas** `NavHost`, `NavController` e `composable(...)` com as rotas `welcome` e `home`.
- Ao entrar, a rota `welcome` sai da pilha de telas (`popUpTo`); ao sair, a rota `home` sai da pilha. É isso que faz o voltar do Android fechar o app no painel.
- Cada tela fica em **arquivo próprio**: `WelcomeScreen.kt` (já existe) e `HomeDocenteScreen.kt` (novo).
- O estado do aviso "Novo acionamento" usa `remember { mutableStateOf(...) }`, como na Sprint 02.

### Non-Functional Requirements

- **NFR-01 — Área de toque:** botões com altura mínima de **48 dp**.
- **NFR-02 — Legibilidade:** textos com contraste **≥ 4,5:1** (WCAG) no modo claro.

### Files or Modules That Must Not Be Modified

- Os dois modais da Sprint 02 (lógica e textos), `Theme.kt`, `Color.kt`, `Type.kt` e `AndroidManifest.xml`.
- Pastas de outros times (`projects/team-XX/`) e arquivos da raiz do repositório.

**Arquivos que mudam:** `MainActivity.kt` (passa a conter o `NavHost`), `libs.versions.toml` e `app/build.gradle.kts` (dependência). `WelcomeScreen.kt` já recebe `onLoginClick`, então a princípio não muda.  
**Arquivo novo:** `ui/screens/HomeDocenteScreen.kt`.

---

## 6. Out of Scope

- Login real, validação de e-mail e senha, perfis de Monitor e Gestão.
- **Formulário de acionamento** e sua validação — Sprint 04.
- **Lista de acionamentos preenchida**, salvar dados e banco de dados — Sprints 04 e 05.
- Internet, Supabase e notificações — Sprint 06.
- Mudar os modais da Sprint 02, o tema, as cores ou a fonte.
- Animações de transição entre telas e suporte completo ao modo escuro.

---

## 7. Acceptance Criteria

### AC-01 — Duas rotas
**Given** o app aberto, **When** o código é inspecionado, **Then** existe um `NavHost` com as rotas `welcome` e `home`, e `welcome` é a primeira tela exibida.

### AC-02 — Entrar abre o painel
**Given** a tela de Login, **When** o professor toca em "Entrar" (com ou sem e-mail e senha), **Then** o Painel do Docente é exibido.

### AC-03 — Título do painel
**Given** o Painel do Docente aberto, **When** a tela é exibida, **Then** aparecem "Painel do Docente" e "Acione a Coordenação em poucos toques".

### AC-04 — Legenda dos níveis
**Given** o Painel do Docente aberto, **When** a tela é exibida, **Then** aparecem os 4 níveis, cada um com seu nome e sua cor do tema.

### AC-05 — Lista vazia
**Given** o Painel do Docente aberto, **When** a tela é exibida, **Then** "Meus acionamentos" mostra "Nenhum acionamento ainda" e nenhum item de lista.

### AC-06 — Aviso do novo acionamento
**Given** o Painel do Docente aberto, **When** o professor toca em "Novo acionamento", **Then** o aviso "O formulário de acionamento chega na Sprint 04" aparece e fecha ao toque no botão do aviso.

### AC-07 — Sair e voltar do Android
**Given** o Painel do Docente aberto, **When** o professor toca em "Sair", **Then** o Login é exibido; e **When** ele usa o voltar do Android no painel, **Then** o app fecha e a tela inicial do celular aparece.

### AC-08 — Não-regressão da Sprint 02
**Given** a tela de Login, **When** o professor abre "Sobre o SARC" e "Solicitar Cadastro", **Then** os modais funcionam como na Sprint 02 (cartões expansíveis e guia de 3 etapas).

### AC-09 — Estabilidade
**Given** o app instalado, **When** o professor repete 10 vezes o ciclo Entrar → Sair, **Then** o app compila (`./gradlew assembleDebug`), roda e não fecha sozinho.

### AC-10 — Cores dos níveis
**Given** o Painel do Docente aberto, **When** a legenda é exibida, **Then** as cores são as do tema (verde, amarelo, laranja e vermelho) e os nomes têm contraste ≥ 4,5:1.

---

## 8. Requirement Traceability

*(preenchida depois do código, com as linhas reais)*

| Requirement | Implementação | AC | Evidência |
| --- | --- | --- | --- |
| FR-01 | `MainActivity.kt` — `NavHost` | AC-01 | `screen-a.png` |
| FR-02 | `MainActivity.kt` — `onLoginClick` navega | AC-02 | `screen-a.png`, `screen-b.png` |
| FR-03 | `HomeDocenteScreen.kt` | AC-03 | `screen-b.png` |
| FR-04 | `HomeDocenteScreen.kt` | AC-04, AC-10 | `screen-b.png` |
| FR-05 | `HomeDocenteScreen.kt` | AC-05 | `screen-b.png` |
| FR-06 | `HomeDocenteScreen.kt` | AC-06 | `home-aviso.png` |
| FR-07 | `MainActivity.kt` + `HomeDocenteScreen.kt` | AC-07 | `home-sair.png` |

---

## 9. Implementation Plan

### Components to Create or Modify

1. **`libs.versions.toml` e `app/build.gradle.kts`:** adicionar `navigation-compose`.
2. **`MainActivity.kt`:** criar o `NavController` (`rememberNavController()`) e o `NavHost(startDestination = "welcome")`.
   - `composable("welcome")` → `WelcomeScreen(onLoginClick = { _, _ -> navController.navigate("home") { popUpTo("welcome") { inclusive = true } } })`
   - `composable("home")` → `HomeDocenteScreen(onSair = { navController.navigate("welcome") { popUpTo("home") { inclusive = true } } })`
3. **`HomeDocenteScreen.kt` (novo):** título e subtítulo, botão "Novo acionamento" com aviso, legenda dos 4 níveis, seção "Meus acionamentos" vazia e botão "Sair".

### Expected Interaction Flow

```text
Abrir o app → [welcome]
   → "Entrar" → navigate("home") com popUpTo("welcome") → [home]  (pilha: só home)
[home] → "Sair"          → navigate("welcome") com popUpTo("home") → [welcome]
[home] → voltar Android  → pilha tem 1 tela → o app fecha → tela inicial do celular
[home] → "Novo acionamento" → showAviso = true → aviso → botão fecha → showAviso = false
```

### Data or State Required

| Estado | Tipo | Valor inicial | Onde é criado | Muda quando |
| --- | --- | --- | --- | --- |
| `navController` | `NavHostController` | rota `welcome` | `MainActivity.kt` | "Entrar" e "Sair" |
| `showAviso` | `Boolean` | `false` | `HomeDocenteScreen.kt` | toque em "Novo acionamento" ou no botão do aviso |

Os estados da Sprint 01 e da Sprint 02 permanecem sem alteração.

---

## 10. Validation Plan

*(a executar depois do código)*

1. Compilar com `./gradlew assembleDebug`.
2. Rodar no emulador Pixel 8 (API 37).
3. Fluxo: abrir → Login → "Entrar" → Painel → "Sair" → Login (`screen-a.png`, `screen-b.png`).
4. No Painel, usar o voltar do Android e confirmar que o app fecha.
5. Tocar em "Novo acionamento" e conferir o aviso.
6. Abrir os dois modais do Login e conferir que a Sprint 02 continua igual.
7. Repetir Entrar → Sair 10 vezes sem travar.

## 11. Validation Results

*(PASS só do que for testado)*

## 12. Evidence

Em `projects/team-05/evidence/sprint-03/`: `screen-a.png` (Login), `screen-b.png` (Painel), `home-aviso.png`, `home-sair.png`, e um print dos modais da Sprint 02.

## 13. AI-Assisted Development

- **Tool:** Claude (Claude Code).
- **How AI Was Used:** entender a Sprint, refinar a SPEC e sugerir o `NavHost`.
- **Human Review and Changes:** o Matheus definiu o escopo (só a Home do Docente), decidiu que o voltar do Android fecha o app e que a lista de acionamentos fica vazia.
- *(restante preenchido no fim da Sprint)*

## 16. Specification Status

Draft — aprovada pelo Matheus para iniciar a Sprint 03.
