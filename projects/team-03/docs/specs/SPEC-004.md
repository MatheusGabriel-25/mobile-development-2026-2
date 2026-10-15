# SPEC-004 — Nome do Cômodo (Entrada e Validação)

## Context
O Wi-Fi Mapper mede o sinal em diferentes cômodos. Para isso, o usuário
precisa informar em qual cômodo está antes de verificar.

## Task
Adicionar um campo de texto "Nome do cômodo" na tela inicial, com validação
antes de iniciar a verificação.

## Functional Requirements
- FR-01: A tela inicial deve ter um campo de texto "Nome do cômodo".
- FR-02: O campo é obrigatório e deve ter no mínimo 3 caracteres (sem
  contar espaços nas pontas).
- FR-03: Se o nome for inválido ao tocar em "Iniciar Verificação", deve
  aparecer a mensagem "Digite pelo menos 3 letras" e a verificação não
  deve ser realizada.
- FR-04: Se o nome for válido, a verificação de sinal é realizada
  normalmente.

## Constraints
- Sem persistência do nome em banco de dados.
- Sem novas telas.

## Acceptance Criteria
- AC-01 — O campo de texto existe e guarda o valor em estado de UI.
- AC-02 — Campo vazio ou com menos de 3 caracteres mostra erro visível.
- AC-03 — Nome válido permite a verificação.
- AC-04 — O erro desaparece quando o usuário volta a digitar.
- AC-05 — Funcionalidades das Sprints anteriores continuam funcionando.

## Validation
1. Campo vazio + botão: erro aparece (print `invalid-input.png`).
2. Digitar "Sala" + botão: resultado do sinal aparece (print `valid-input.png`).
3. Testar "al" (2 letras): deu erro.
4. Testar "   " (só espaços): deu erro.
5. Teste de navegação para Detalhes e volta.

## AI Usage
Ver tabela em SPRINT-04.md.

## Out of Scope
- Salvar o nome do cômodo; múltiplos campos; histórico.

## Deliverables
- app/, SPRINT-04.md, SPEC-004.md
- evidence/sprint-04/valid-input.png e invalid-input.png
