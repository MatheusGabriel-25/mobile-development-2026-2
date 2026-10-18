# SPEC-004 — Nome do Cômodo (Entrada do Usuário, Formulário e Validação)

> **Equipe:** Team 03  
> **Integrantes:** Célia Hiromi (@hiromilly) e Geovanna Gaspar (@gegwspar)  
> **Sprint:** SPRINT 04 — User Input, Forms & Validation  
> **Status:** Validado  
> **Documento da Sprint:** [`SPRINT-04.md`](../../SPRINT-04.md)  

---

## 1. Contexto

**Problema:**  
O **Wiflux** mede a qualidade do sinal Wi-Fi em diferentes ambientes de uma residência ou escritório. Para que a verificação tenha contexto útil ao usuário, é necessário informar em qual cômodo (ex: `"Quarto"`, `"Sala"`, `"Escritório"`) a medição está sendo realizada antes de iniciar a leitura, impedindo medições com campos em branco ou nomes inválidos.

**Usuário / Ator:**  
Estudantes, trabalhadores remotos e usuários domésticos que desejam identificar o cômodo avaliado antes de verificar a intensidade do sinal Wi-Fi.

**Contexto de Uso:**  
Na tela principal (`HomeScreen`), o usuário preenche o campo de texto **"Nome do cômodo"** e toca em **"▶ Iniciar Verificação"**. Se o nome tiver menos de 3 caracteres úteis (desconsiderando espaços nas extremidades), o aplicativo bloqueia a verificação, destaca o campo em vermelho e exibe a mensagem de erro **"Digite pelo menos 3 letras"**. Quando o usuário informa um nome válido (como `"Quarto"`), a verificação é executada normalmente.

---

## 2. Objetivo

Implementar um fluxo controlado de entrada de dados e validação de formulário no **Wiflux** utilizando Jetpack Compose (`OutlinedTextField` e estado de UI), garantindo feedback visual claro para entradas inválidas e execução normal da verificação para entradas válidas, sem comprometer a navegação e as funcionalidades das Sprints anteriores.

---

## 3. Cenários do Usuário (User Scenarios)

### Cenário 1: Tentativa de Verificação com Entrada Inválida
**Dado** que o usuário está na `HomeScreen` e deixou o campo **"Nome do cômodo"** vazio, apenas com espaços (`"   "`) ou com menos de 3 caracteres (`"ab"`),  
**Quando** tocar no botão **"▶ Iniciar Verificação"**,  
**Então** o aplicativo não deve realizar a verificação de sinal (mantendo o estado anterior), deve destacar a borda do campo em estado de erro (`isError = true`) e exibir a mensagem **"Digite pelo menos 3 letras"** abaixo do campo.

### Cenário 2: Limpeza Automática do Erro ao Digitar
**Dado** que o campo **"Nome do cômodo"** está exibindo a mensagem de erro **"Digite pelo menos 3 letras"**,  
**Quando** o usuário voltar a digitar no campo (`onValueChange`),  
**Então** o estado de erro deve ser limpo imediatamente (`roomError = false`).

### Cenário 3: Verificação com Entrada Válida
**Dado** que o usuário digitou um nome válido com pelo menos 3 caracteres úteis (ex: `"Quarto"`),  
**Quando** tocar no botão **"▶ Iniciar Verificação"**,  
**Então** o erro permanece desativado (`roomError = false`), o nível de sinal é verificado e exibido no dial (ex: `-45 dBm` / `"Sinal Forte"`) e o botão **"Ver Detalhes"** é disponibilizado.

---

## 4. Requisitos Funcionais

### FR-01 — Campo Controlado "Nome do cômodo"
A `HomeScreen` deve apresentar um componente `OutlinedTextField` identificado pelo rótulo **"Nome do cômodo"**, cujo valor é armazenado na variável de estado `roomName`.

### FR-02 — Regra de Validação Obrigatória
O campo **"Nome do cômodo"** é obrigatório e deve possuir no mínimo **3 caracteres válidos**, desconsiderando espaços em branco no início e no fim (`roomName.trim().length >= 3`).

### FR-03 — Bloqueio e Feedback Visual de Erro
Se `roomName.trim().length < 3` no momento do clique em **"▶ Iniciar Verificação"**:
- A variável `roomError` deve receber `true`;
- O `OutlinedTextField` deve ativar `isError = roomError` e exibir `supportingText` com a mensagem **"Digite pelo menos 3 letras"**;
- A verificação de sinal não deve ser executada.

### FR-04 — Aceitação de Entrada Válida e Limpeza ao Digitar
- Ao digitar no campo (`onValueChange`), `roomName` é atualizado e `roomError` volta para `false`;
- Se `roomName.trim().length >= 3` ao clicar em **"▶ Iniciar Verificação"**, `roomError` é definido como `false` e a medição de sinal é sorteada e exibida normalmente.

---

## 5. Restrições Técnicas

- **Estado Declarativo no Compose:** Uso de `rememberSaveable` e `mutableStateOf` para gerenciar `roomName` (`String`) e `roomError` (`Boolean`).
- **Componentes Material 3:** Uso de `OutlinedTextField` com `isError`, `supportingText` e `singleLine = true`.
- **Escopo da Sprint 04:** Sem persistência do nome do cômodo em banco de dados local (escopo da Sprint 05) e sem criação de novas telas além de `HomeScreen` e `DetailsScreen`.

---

## 6. Fora do Escopo (Out of Scope)

- Salvar o histórico de cômodos em banco de dados SQLite/Room (Sprint 05).
- Múltiplos formulários ou cadastro de configurações avançadas de rede.
- Leitura de hardware Wi-Fi real via `WifiManager` (Sprint 06).

---

## 7. Critérios de Aceitação

- **AC-01 — Existência da SPEC-004:** O documento `SPEC-004.md` existe em `docs/specs/SPEC-004.md` e define os campos, regras e comportamentos.
- **AC-02 — Fluxo Significativo de Entrada do Usuário:** O campo **"Nome do cômodo"** contextualiza cada verificação de sinal no produto.
- **AC-03 — Uso de Estado de UI:** Os valores de entrada (`roomName`) e de erro (`roomError`) utilizam estado reativo do Compose.
- **AC-04 — Regra de Validação Implementada:** A regra `roomName.trim().length < 3` valida obrigatoriedade e tamanho mínimo.
- **AC-05 — Feedback Visível para Entrada Inválida:** Entradas inválidas deixam o campo vermelho (`isError = true`) e exibem `"Digite pelo menos 3 letras"`.
- **AC-06 — Aceitação de Entrada Válida:** Nomes com 3 ou mais caracteres (ex: `"Quarto"`) permitem a verificação de sinal conforme especificado.
- **AC-07 — Evidências Válida e Inválida Registradas:** Os arquivos `invalid-input.png` e `valid-input.png` estão salvos em `evidence/sprint-04/`.
- **AC-08 — Preservação das Funcionalidades Anteriores:** O dial em `Canvas`, a verificação reativa e a navegação para `DetailsScreen` e retorno (`← Voltar`) continuam funcionando.
- **AC-09 — Compilação e Execução com Sucesso:** O aplicativo compila (`BUILD SUCCESSFUL`) e executa no emulador sem falhas.
- **AC-10 — Domínio da Lógica de Validação:** A equipe sabe explicar o estado do formulário e onde a validação é executada no código.

---

## 8. Rastreabilidade dos Requisitos

| Requisito | Implementado Em (`com.team03.wifi`) | Critério de Aceitação | Evidência |
| :--- | :--- | :--- | :--- |
| **FR-01** | `HomeScreen.kt` (`var roomName`, `OutlinedTextField`) | AC-02, AC-03 | `evidence/sprint-04/valid-input.png` |
| **FR-02** | `HomeScreen.kt` (`if (roomName.trim().length < 3)`) | AC-04 | `evidence/sprint-04/invalid-input.png` |
| **FR-03** | `HomeScreen.kt` (`isError = roomError`, `supportingText`) | AC-05 | `evidence/sprint-04/invalid-input.png` |
| **FR-04** | `HomeScreen.kt` (`onValueChange`, `else { roomError = false; signalStatus = ... }`) | AC-06, AC-08 | `evidence/sprint-04/valid-input.png` |

---

## 9. Procedimento e Resultados da Validação

1. **Cenário Inválido (Campo vazio / menos de 3 letras):** Com o campo vazio (ou digitando `"ab"` / `"   "`), tocar em **"▶ Iniciar Verificação"** $\rightarrow$ o estado continua em `"Aguardando"`, o campo fica vermelho e aparece a mensagem `"Digite pelo menos 3 letras"` (registrado em `invalid-input.png`).
2. **Cenário Válido (`"Quarto"`):** Digitar `"Quarto"` no campo e tocar em **"▶ Iniciar Verificação"** $\rightarrow$ o erro não é exibido, o dial atualiza para `-45 dBm` (`"Sinal Forte"`) e o botão **"Ver Detalhes"** aparece (registrado em `valid-input.png`).
3. **Teste de Regressão (Sprints 01, 02 e 03):** Tocar em **"Ver Detalhes"** abre a `DetailsScreen` com os dados da verificação e tocar em **"← Voltar"** retorna à `HomeScreen` preservando `"Quarto"` e `-45 dBm`.

| 1. Entrada Inválida (`invalid-input.png`) | 2. Entrada Válida (`valid-input.png`) |
| :---: | :---: |
| ![Entrada Inválida](../../evidence/sprint-04/invalid-input.png) | ![Entrada Válida](../../evidence/sprint-04/valid-input.png) |
| Campo em estado de erro com a mensagem `"Digite pelo menos 3 letras"` e medição bloqueada | Campo preenchido com `"Quarto"`, verificação realizada (`-45 dBm`) e botão `"Ver Detalhes"` ativo |
