package com.team05.sarc.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.team05.sarc.R
import com.team05.sarc.ui.theme.PriorityGreen
import com.team05.sarc.ui.theme.PriorityOrange
import com.team05.sarc.ui.theme.PriorityRed
import com.team05.sarc.ui.theme.PriorityYellow
import com.team05.sarc.ui.theme.SARCTheme
import com.team05.sarc.ui.theme.SarcGreenSecondary
import com.team05.sarc.ui.theme.SarcNavyDark
import com.team05.sarc.ui.theme.SarcNavyPrimary

/**
 * Tela Inicial / Login Institucional do SARC.
 * Atende aos requisitos da especificação SPEC-001 (FR-01 a FR-05 e AC-01 a AC-07).
 */
@Composable
fun WelcomeScreen(
    onLoginClick: (String, String) -> Unit = { _, _ -> },
    onRegisterClick: () -> Unit = {}
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    var showAboutDialog by remember { mutableStateOf(false) }
    var showRegisterDialog by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // ==========================================
            // CABEÇALHO INSTITUCIONAL (FR-01, AC-01)
            // ==========================================
            Image(
                painter = painterResource(id = R.drawable.ic_brasao_cadide),
                contentDescription = "Brasão da Escola Cadidé",
                modifier = Modifier.size(110.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "SARC",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = SarcNavyPrimary,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Escola Estadual Cívico-Militar\nMaria de Lima Cadidé",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = SarcNavyDark,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Sistema de Acionamento e Resposta Cívico-Militar",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // ==========================================
            // FORMULÁRIO DE LOGIN (FR-02, AC-02)
            // ==========================================
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail Institucional") },
                placeholder = { Text("ex: docente@escola.gov.br") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Ícone de E-mail",
                        tint = SarcNavyPrimary
                    )
                },
                singleLine = true,
                keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Senha") },
                placeholder = { Text("Digite sua senha") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Ícone de Senha",
                        tint = SarcNavyPrimary
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = if (passwordVisible) "Ocultar senha" else "Exibir senha",
                            tint = SarcNavyPrimary
                        )
                    }
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // ==========================================
            // BOTÃO PRIMÁRIO: ENTRAR (FR-03, AC-03)
            // ==========================================
            Button(
                onClick = { onLoginClick(email, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = SarcNavyPrimary)
            ) {
                Text(
                    text = "Entrar",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ==========================================
            // BOTÃO INFORMATIVO: SOBRE O SARC (FR-04, AC-04)
            // ==========================================
            OutlinedButton(
                onClick = { showAboutDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, SarcNavyPrimary)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Informações do SARC",
                        tint = SarcNavyPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Sobre o SARC e Prioridades",
                        color = SarcNavyPrimary,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ==========================================
            // BOTÃO DE CADASTRO: SOLICITAR ACESSO (FR-05, AC-05)
            // ==========================================
            TextButton(
                onClick = {
                    showRegisterDialog = true
                    onRegisterClick()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.PersonAdd,
                        contentDescription = null,
                        tint = SarcGreenSecondary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Não possui acesso? Solicitar Cadastro",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = SarcGreenSecondary
                    )
                }
            }
        }
    }

    // ==========================================
    // DIÁLOGO MODAL: SOBRE O SARC (FR-04, AC-04)
    // ==========================================
    if (showAboutDialog) {
        AlertDialog(
            onDismissRequest = { showAboutDialog = false },
            icon = {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = null,
                    tint = SarcNavyPrimary,
                    modifier = Modifier.size(32.dp)
                )
            },
            title = {
                Text(
                    text = "Sobre o SARC",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = SarcNavyPrimary,
                    textAlign = TextAlign.Center
                )
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "O SARC é o canal oficial de acionamento ágil e comunicação interna entre os professores e a Coordenação Militar da Escola Cadidé, garantindo suporte rápido e padronizado em ambiente escolar.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalDivider()
                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Faixas de Prioridade Escolar:",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = SarcNavyPrimary
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    PriorityBadge(
                        level = "Nível 1 - Apoio Pedagógico",
                        description = "Mediação de conflitos leves em sala de aula, assistência preventiva e suporte de rotina.",
                        color = PriorityGreen
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    PriorityBadge(
                        level = "Nível 2 - Atenção Disciplinar",
                        description = "Descumprimento reiterado de normas, condutas inadequadas e advertências formais.",
                        color = PriorityYellow
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    PriorityBadge(
                        level = "Nível 3 - Prioridade Operacional",
                        description = "Situações de desordem ou resistência que exigem presença militar imediata.",
                        color = PriorityOrange
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    PriorityBadge(
                        level = "Nível 4 - Urgência Crítica",
                        description = "Risco à integridade física, ameaça direta, emergências de saúde ou segurança.",
                        color = PriorityRed
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showAboutDialog = false }) {
                    Text(
                        text = "Entendido",
                        fontWeight = FontWeight.Bold,
                        color = SarcNavyPrimary
                    )
                }
            }
        )
    }

    // ==========================================
    // DIÁLOGO MODAL: SOLICITAÇÃO DE CADASTRO (FR-05, AC-05)
    // ==========================================
    if (showRegisterDialog) {
        AlertDialog(
            onDismissRequest = { showRegisterDialog = false },
            icon = {
                Icon(
                    imageVector = Icons.Default.PersonAdd,
                    contentDescription = null,
                    tint = SarcGreenSecondary,
                    modifier = Modifier.size(32.dp)
                )
            },
            title = {
                Text(
                    text = "Solicitação de Cadastro",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = SarcNavyPrimary,
                    textAlign = TextAlign.Center
                )
            },
            text = {
                Column {
                    Text(
                        text = "O acesso ao SARC é restrito a servidores e docentes credenciados da Escola Estadual Cívico-Militar Maria de Lima Cadidé.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Novas solicitações passarão por processo de homologação junto à Direção Escolar e Coordenação Militar.\n\nO formulário completo de solicitação será liberado nas próximas sprints.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showRegisterDialog = false }) {
                    Text(
                        text = "Fechar",
                        fontWeight = FontWeight.Bold,
                        color = SarcNavyPrimary
                    )
                }
            }
        )
    }
}

/**
 * Componente visual reutilizável para cada uma das 4 Faixas de Prioridade Escolar.
 */
@Composable
private fun PriorityBadge(
    level: String,
    description: String,
    color: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.12f)),
        border = BorderStroke(1.dp, color.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(color)
                    .align(Alignment.Top)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = level,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = color
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    SARCTheme {
        WelcomeScreen()
    }
}
