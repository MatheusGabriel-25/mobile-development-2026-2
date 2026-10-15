# SPRINT 04 — User Input, Forms & Validation

## Campo
- **Nome do cômodo** (texto, obrigatório, mínimo 3 caracteres).

## Regra de validação
`roomName.trim().length < 3` → inválido. Implementada no `onClick` do
botão "Iniciar Verificação", em `HomeScreen.kt`.

## Feedback de erro
`roomError = true` faz o campo ficar vermelho (`isError`) e mostra
"Digite pelo menos 3 letras" (`supportingText`). O erro some ao digitar.

## Cenários testados
- Inválido: campo vazio, "ab" e "   " → erro, sem verificação.
- Válido: "Quarto" → verificação realizada e status exibido.
- Regressão: Ver Detalhes e Voltar continuam funcionando.

## Uso de LLM

| Item | Resposta da equipe |
| --- | --- |
| LLM/tool usado | Claude |
| Task supported by the LLM | Auxilio na lógica do sistema |
| Main suggestion received | Usar dois estados (`roomName` e `roomError`) e validar no clique do botão |
| What the team changed manually | O campo do cômodo não pode ficar em branco nem conter menos de 3 caracteres. |
| How the result was validated | Testes manuais no emulador com nome vazio, curto e válido |
