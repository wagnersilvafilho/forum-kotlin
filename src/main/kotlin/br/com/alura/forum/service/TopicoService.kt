package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoDto
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico> = ArrayList(), private val cursoService: CursoService, val usuarioService: UsuarioService){

//    init {
//        val topico = Topico(
//            id = 1,
//            titulo = "Duvida Kotlin",
//            mensagem = "Programacao",
//            curso = Curso(
//                id = 1,
//                nome = "Kotlin",
//                categoria = "Programacao",
//            ),
//            autor = Usuario(
//                id = 1,
//                nome = "Wagner Filho",
//                email = "wagner@zup.com.br",
//            )
//        )
//        val topico2 = Topico(
//            id = 2,
//            titulo = "Duvida Java",
//            mensagem = "Programacao",
//            curso = Curso(
//                id = 2,
//                nome = "Java",
//                categoria = "Programacao",
//            ),
//            autor = Usuario(
//                id = 2,
//                nome = "Fabio Lucas",
//                email = "fabio@zup.com.br",
//            )
//        )
//        val topico3 = Topico(
//            id = 3,
//            titulo = "Duvida NodeJS",
//            mensagem = "Programacao",
//            curso = Curso(
//                id = 3,
//                nome = "NodeJS",
//                categoria = "Programacao",
//            ),
//            autor = Usuario(
//                id = 3,
//                nome = "Kaio Nascimento",
//                email = "kaio@zup.com.br",
//            )
//        )
//        topicos = Arrays.asList(topico, topico2, topico3)
//    }

    fun listar(): List<Topico> {
        return topicos;
    }

    fun buscarPorId(id: Long): Topico{
        return topicos.stream().filter({
            t -> t.id == id
        }).findFirst().get()
    }

    fun cadastrar(dto: NovoTopicoDto) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.idCurso),
            autor = usuarioService.buscarPorId(dto.idAutor)
        ))
    }

}