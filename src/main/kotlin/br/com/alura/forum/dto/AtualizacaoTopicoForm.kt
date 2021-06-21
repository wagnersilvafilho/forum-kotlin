package br.com.alura.forum.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AtualizacaoTopicoForm(
    @field:NotNull
    val id: Long,
    @field:NotBlank
    @field:Size(min = 5, max = 100)
    val titulo: String,
    @field:NotBlank
    val mensagem: String
)
