package spring.rambo.greetings_spring;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;



@Controller //Notação de que pode ser acessada pela URL.
@RequestMapping({"/" , "/saudacao"})//Maping com duas rotas "" e "saudacao"
public class saudacoesController{

    @GetMapping //notação do Mapping dos tipo Get.
    @ResponseBody //Anotação para indicar que deve retornar no corpo da mensagem.
    public String saudacao(){ //padrão, do url/saudacao
        return "Olá Spring";
    }
    
    @GetMapping("/data") //No final vai ficar url/saudacao/data, serve para entregar como se fosse um get dentro do get. 
    @ResponseBody 
    public String data(){
        return LocalDateTime.now().toString();
    }
    
    @GetMapping("/headers")
    @ResponseBody
    //HttpServletRequest request: Pega todas as informações da requisição.
    public String headers(HttpServletRequest request){ //Todas as informações da requisição
        
        String header = request.getHeader("user-agent"); //Retorna o que o usuario digita.
        String info = request.getParameter("info"); //Retorna um paramentro, vindo de url/headeres?info={Texto retornado}
        
        //return "cabeçalho retornado foi: " + header;

        return "A informação é: " + info;
    }
    


}
