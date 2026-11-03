package br.com.fatec.sistemacomercioweb;

import br.com.fatec.sistemacomercioweb.model.Cliente;
import br.com.fatec.sistemacomercioweb.service.ClienteService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class TesteCliente {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext context = SpringApplication.run(SistemaComercioWebApplication.class,args)) {
            ClienteService service = context.getBean(ClienteService.class);
            Cliente cliente = new Cliente(
                    "Clovis Santos",
                    "10346123523",
                    "10929995599",
                    "p@email.com"
            );
            Cliente clienteSalvo = service.cadastrar(cliente);
            System.out.println("Cliente cadastrado!" + clienteSalvo);

            System.out.println("Listar clientes:");
            for (Cliente c : service.listar()) {
                System.out.println(c);
            }
        }
    }
}
