package br.com.nortedoacai.webjava.controller;

import br.com.nortedoacai.webjava.domain.filme.DadosCadastroFilme;
import br.com.nortedoacai.webjava.domain.filme.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IAttribute;

import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/AcaidoNorte")
public class acaidonortecontroller {

    private  List<Filme> filmes = new ArrayList<>();

    @GetMapping("/formulario")
    public String carregaPaginaFormulario() {
        return "Acai/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute(attributeName:"lista", filmes);
        return "Acai/listagem";
    }

    @PostMapping
    public String cadastrarfilme(DadosCadastroFilme dados) {
        var filme = new Filme(dados);
        filmes.add(filme);

        System.out.println(filmes);

        return "Acai/formulario";
    }
}
