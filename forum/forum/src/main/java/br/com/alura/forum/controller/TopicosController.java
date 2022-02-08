package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController // ao usar o @RestController o compilador já entende que a classe INTEIRA com os seu métodos vai ter o @ResponseBody por padrão 
public class TopicosController {
	
	//Injetando a interface para usar seus métodos
	@Autowired
	private TopicoRepository topicoRepository;
	
//	Por padrão, o Spring considera que o retorno do método é o nome da ppg que ele deve carregar,
//	mas ao utilizar a anotação @ResponseBody, indicamos que o retorno do método deve ser serializado e devolvido no corpo da resposta.
	
	@RequestMapping("/topicos")//dizendo qual a rota na url que vai executar esse método
	//@ResponseBody // dizendo que é para apresentar apenas uma lista
	public  List<TopicoDto> lista(String nomeCurso){
		
		//Topico topico = new Topico("Dúvida","Dúvida com Spring", new Curso("Spring","Progamação"));
		//return TopicoDto.converter(Arrays.asList(topico, topico, topico));// Arrays.asList() devolve uma lista de vários objetos encaminhados dentro do (...).
		if(nomeCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();			
			return TopicoDto.converter(topicos);
		}else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);			
			return TopicoDto.converter(topicos);
			//Nesse exemplo, a variável que precisou ser consultada era uma variável de um relacionamento na classe Topico (Dentro da classe existe "Curso curso")
			//para acessar uma variável de um relacionamenot usou findByCursoNome onde Curso é o relacionamento e Nome o nome da variável de consulta.
			
		}
		
	}

}
