package br.com.alura.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //precisa fazer essa anotação para que o spring encontre essa classe = precisa fazer a importação
public class HelloController {
	
	
	@RequestMapping("/") //informa ao spring que quando chamar a url passada dentro de ( ) o método que ele deve abrir
	@ResponseBody // essa anotação faz com que o spring entenda que deve apenas exibir essa informação do método e não procurar uma pagina (é o comportamento padrão buscar pela pagina)
	public String hello() {
		return "Hello World!";		
	}

}
