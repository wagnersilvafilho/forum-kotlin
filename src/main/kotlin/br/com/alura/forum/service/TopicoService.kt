package br.com.alura.forum.service

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

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

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t -> TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        )}.collect(Collectors.toList());
    }

    fun buscarPorId(id: Long): TopicoView{
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
        return TopicoView(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(dto: NovoTopicoForm) {
        topicos = topicos.plus(Topico(
            id = topicos.size.toLong() + 1,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.idCurso),
            autor = usuarioService.buscarPorId(dto.idAutor)
        ))
    }

}