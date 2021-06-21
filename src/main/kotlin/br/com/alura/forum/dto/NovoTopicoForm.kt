package br.com.alura.forum.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm (
    @field:NotBlank (message = "Titulo não pode ser em branco")
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres.")
    val titulo: String,
    @field:NotBlank (message = "Mensagem não pode ser em branco")
    val mensagem: String,
    @field:NotNull
    val idCurso: Long,
    @field:NotNull
    val idAutor: Long,
)
