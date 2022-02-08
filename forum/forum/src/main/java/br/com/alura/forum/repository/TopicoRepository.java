package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCurso_Nome(String nomeCurso);
	//Foi declarado uma assinatura de método chamando o relacionamento primerio "findByCurso" e para EVITAR PROBLEMAS COM VARIÁVEIS DE MESMO NOME DENTRO DA CLASSE PRINCIPAL (SEM SER A RELACIONADA, QUE É ONDE TEM A VARIÁVEL DESEJADA PARA CONSULTA), usou o "_" (esse é o cara mais importante) + "nome" (nome da variável desejada)
}
