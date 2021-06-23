package br.com.alura.forum.model

import org.springframework.boot.autoconfigure.domain.EntityScan
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
//@EntityScan(basePackages = {"br.com.alura.forum.model"})
data class Usuario (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String
)
