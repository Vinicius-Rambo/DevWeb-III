package com.atv.lista1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/atividade2")
public class Requisicoes {

  @GetMapping("/requisicao")
  @ResponseBody
  public String requisicao(HttpServletRequest request){

    String metodo = request.getMethod();
    String URI = request.getRequestURI();
    String URL = request.getRequestURL().toString(); //Ele monta a URL.
    String protocolo = request.getProtocol();
    
    String resultado = metodo + " " + URI + " " + URL + " " + protocolo;
    
    return resultado;
  }

  @GetMapping("/cabecalhos")
  @ResponseBody
  public String cabecalhos(HttpServletRequest request) {
     
    String host = request.getHeader("host");
    String agent = request.getHeader("user-agent");

    return host + "<br>" + agent;
  }
  
  @GetMapping("/bebidas/{type}")
  @ResponseBody
  public String bebidas(@PathVariable String type) {
      return "A bebida escolhida foi: " + type;
  }
  


}
