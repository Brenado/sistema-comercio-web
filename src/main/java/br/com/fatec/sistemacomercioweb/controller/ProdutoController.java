package br.com.fatec.sistemacomercioweb.controller;

import br.com.fatec.sistemacomercioweb.model.Cliente;
import br.com.fatec.sistemacomercioweb.model.Produto;
import br.com.fatec.sistemacomercioweb.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", service.listar());
        return "produtos/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("produto", new Produto());
        return "produtos/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto) {
        service.cadastrar(produto);
        return "redirect:/produtos";
    }

}
