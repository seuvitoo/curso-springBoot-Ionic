package br.dev.seuvito.backendloja;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.entities.Cidade;
import br.dev.seuvito.backendloja.entities.Estado;
import br.dev.seuvito.backendloja.entities.Produto;
import br.dev.seuvito.backendloja.repositories.CategoriaRepository;
import br.dev.seuvito.backendloja.repositories.CidadeRepository;
import br.dev.seuvito.backendloja.repositories.EstadoRepository;
import br.dev.seuvito.backendloja.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BackendLojaApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    public static void main(String[] args) {
        SpringApplication.run(BackendLojaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escritorio");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        Estado e1 = new Estado(null, "São Paulo");
        Estado e2 = new Estado(null, "Minas Gerais");

        Cidade c1 = new Cidade(null, "Uberlandia", e2);
        Cidade c2 = new Cidade(null, "Campinas", e1);
        Cidade c3 = new Cidade(null, "Itapevi", e1);

        e1.getCidades().addAll(Arrays.asList(c2, c3));
        e2.getCidades().addAll(Arrays.asList(c1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        estadoRepository.saveAll(Arrays.asList(e1, e2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
