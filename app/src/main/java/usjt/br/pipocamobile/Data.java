/**
 *RA: 816114937
 *NOME: Matheus Moura Borges Silva
 */

package usjt.br.pipocamobile;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {

    public static ArrayList<String> listarTitulos(ArrayList<Filme> filmes){
        ArrayList<String> titulos = new ArrayList<>();
        for (Filme filme : filmes) {
            titulos.add(filme.getTitulo());
        }
        return titulos;
    }

    public static ArrayList<Filme> listarFilmes(String genero) {
        Filme[] lista;
        ArrayList<Filme> filmes = new ArrayList<>();

        for (Filme filme : todosFilmes()) {
            if (filme.getGenero().equals(genero) || genero.equals("Todos")) {
                filmes.add(filme);
            }
        }
        //converte para vetor para poder ordenar usando o sort da classe Arrays
        lista = filmes.toArray(new Filme[0]);
        //ordena baseado no compareTo sobrescrito na classe Pais
        //para funcionar, a classe pais precisa implementar a interface Comparable
        Arrays.sort(lista);
        //transforma de novo em ArrayList
        filmes = new ArrayList<>();
        for(int i = 0; i < lista.length; i++) {
            filmes.add(lista[i]);
        }
        return filmes;
    }

    private static ArrayList<Filme> todosFilmes() {
        ArrayList<Filme> filmes = new ArrayList<>();
        Filme filme;

        filme = new Filme();
        filme.setDescricao("Venom é um filme de ação, ficção científica, suspense e aventura estadunidense de 2018, baseado no personagem da Marvel Comics de mesmo nome, dirigido por Ruben Fleischer e escrito por Scott Rosenberg, Jeff Pinkner, Kelly Marcel e Will Beall. Será o primeiro título no Universo Marvel da Sony.");
        filme.setDiretor("Ruben Fleischer");
        filme.setPopularidade(3);
        filme.setTitulo("Venom");
        filme.setGenero("Ação");
        filmes.add(filme);

        filme = new Filme();
        filme.setDescricao("Homem de Ferro, Thor, Hulk e os Vingadores se unem para combater seu inimigo mais poderoso, o maligno Thanos. Em uma missão para coletar todas as seis pedras infinitas, Thanos planeja usá-las para infligir sua vontade maléfica sobre a realidade.");
        filme.setDiretor("Anthony Russo, Joe Russo");
        filme.setPopularidade(5);
        filme.setTitulo("Vingadores: Guerra Infinita");
        filme.setGenero("Ação");
        filmes.add(filme);

        filme = new Filme();
        filme.setDescricao("César e seu grupo são forçados a entrar em uma guerra contra um exército de soldados liderados por um impiedoso coronel. Depois que vários macacos perdem suas vidas no conflito, César luta contra seus instintos e parte em busca de vingança. Dessa jornada, o futuro do planeta poderá estar em jogo.");
        filme.setDiretor("Matt Reeves");
        filme.setPopularidade(4);
        filme.setTitulo("Planeta dos Macacos: A Guerra");
        filme.setGenero("Ação");
        filmes.add(filme);

        filme = new Filme();
        filme.setDescricao("A jovem cantora Ally ascende ao estrelato enquanto seu parceiro Jackson Maine, um renomado artista de longa carreira, cai no esquecimento por problemas com o álcool. Os momentos opostos acabam por minar o relacionamento amoroso dos dois.");
        filme.setDiretor("Bradley Cooper");
        filme.setPopularidade(3);
        filme.setTitulo("Nasce Uma Estrela");
        filme.setGenero("Drama");
        filmes.add(filme);

        filme = new Filme();
        filme.setDescricao("A estudante de literatura Anastasia Steele, de 21 anos, entrevista o jovem bilionário Christian Grey, como um favor a sua colega de quarto Kate Kavanagh. Ela vê nele um homem atraente e brilhante, e ele fica igualmente fascinado por ela. Embora seja sexualmente inexperiente, Anastasia mergulha de cabeça nessa relação e descobre os prazeres do sadomasoquismo, tornando-se o objeto de submissão do enigmático Grey.");
        filme.setDiretor("Sam Taylor-Wood");
        filme.setPopularidade(5);
        filme.setTitulo("Cinquenta Tons de Cinza");
        filme.setGenero("Drama");
        filmes.add(filme);

        filme = new Filme();
        filme.setDescricao("David Kim se desespera quando sua filha de 16 anos desaparece e as investigações policiais não levam a lugar nenhum. Decidido a descobrir o paradeiro da filha, ele usa o computador da menina para vasculhar suas fotos e vídeos em busca de pistas.");
        filme.setDiretor("Aneesh Chaganty");
        filme.setPopularidade(2);
        filme.setTitulo("Buscando...");
        filme.setGenero("Drama");
        filmes.add(filme);


        filme = new Filme();
        filme.setDescricao("O supersoldado Cable vem do futuro com a missão de assassinar o jovem mutante Russel e o mercenário Deadpool precisa aprender o que é ser herói de verdade para salvá-lo. Para isso, ele recruta seu velho amigo Colossus e forma o novo grupo X-Force, sempre com o apoio do fiel escudeiro Dopinder.");
        filme.setDiretor("David Leitch");
        filme.setPopularidade(5);
        filme.setTitulo("Deadpool 2");
        filme.setGenero("Comédia");
        filmes.add(filme);

        filme = new Filme();
        filme.setDescricao("Quatro famílias consideradas de classe média baixa alugam uma casa de praia, mas acabam encontrando problemas por lá.");
        filme.setDiretor("Roberto Santucci");
        filme.setPopularidade(2);
        filme.setTitulo("Os Farofeiros");
        filme.setGenero("Comédia");
        filmes.add(filme);

        filme = new Filme();
        filme.setDescricao("Tudo por um Popstar é um filme brasileiro baseado no livro de mesmo nome da escritora Thalita Rebouças. O filme tem lançamento previsto para o dia 11 de outubro de 2018, sendo protagonizado por Maisa Silva, Mel Maia e Klara Castanho.");
        filme.setDiretor("Bruno Garotti");
        filme.setPopularidade(3);
        filme.setTitulo("Tudo por um Popstar");
        filme.setGenero("Comédia");
        filmes.add(filme);

        return filmes;
    }
}
