package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Topico;

public class TopicoDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	
	//O objetivo desse construtor é receber um parametro do tipo TOPICO e pegar apenas os dados que são desejados. 
	public TopicoDto(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		
	}
	
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getMensagem() {
		return mensagem;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<TopicoDto> converter(List<Topico> topicos) {
		
		return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
		//.map(TopicoDto::new) = Para cada TOPICO vindo da lista que precisa ser convertida, é chamado o contrutor do TOPICODTO e enviado o topico vigente como paramentro
		//.collect(Collectors.toList())= pega o retorno do MAP e transforma em uma lista. 
		
		//Essas linhas de código (java 8) reduz a seguinte codificação: Para converter uma lista de TOPICOS em TOPICOSDTO seria necessário criar
		//um FOR para ler a primeira lista com os TOPICOS e para cada topico seria feita uma chamada no construtor do TOPICOSDTO, esses retornos seriam jogados em outra lista
		//do tipo DTO e então retornado a lista de DTO convertida.
	}
	
	
	
}
