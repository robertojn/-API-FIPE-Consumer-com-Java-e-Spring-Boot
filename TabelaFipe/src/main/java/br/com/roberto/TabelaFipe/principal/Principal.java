package br.com.roberto.TabelaFipe.principal;

import br.com.roberto.TabelaFipe.model.Dados;
import br.com.roberto.TabelaFipe.model.Modelos;
import br.com.roberto.TabelaFipe.model.Veiculo;
import br.com.roberto.TabelaFipe.services.ConsumoApi;
import br.com.roberto.TabelaFipe.services.ConverterDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();

    private ConverterDados converte = new ConverterDados();


    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";


    public void exibeMenu()
    {
        var menu = """
                #####OPÇÕES#####
                
               Carros
               Motos
               Caminhões               
               Digite uma das opções para consulta:
                """;

        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if(opcao.toLowerCase().contains("carr"))
        {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        }else
        {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
        var marcas = converte.obterLista(json, Dados.class);
        marcas.stream()
                        .sorted(Comparator.comparing(Dados::codigo))
                                .forEach(System.out::println);


        System.out.println("informe o código da marca para consulta: ");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = converte.obterDados(json, Modelos.class);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do carro a ser buscado");
        var nomeVeiculos = leitura.nextLine();

        List<Dados> modelosFiltros = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculos.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        modelosFiltros.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo para buscar os valores de avaliação: ");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Dados> anos = converte.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();


        for (int i = 0; i < anos.size(); i++)
        {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = converte.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliação por ano: ");
        veiculos.forEach(System.out::println);

    }

}
