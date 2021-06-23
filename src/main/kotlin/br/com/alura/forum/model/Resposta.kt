package br.com.alura.forum.model

import org.springframework.boot.autoconfigure.domain.EntityScan
import java.time.LocalDateTime
import javax.persistence.*

@Entity
//@EntityScan(basePackages = {"br.com.alura.forum.model"})
data class Resposta (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val autor: Usuario,
    @ManyToOne
    val topico: Topico,
    val solucao: Boolean
)
