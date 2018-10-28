
/**
 *RA: 816114937
 *NOME: Matheus Moura Borges Silva
 */

package usjt.br.pipocamobile;

import java.io.Serializable;
import java.text.Collator;

public class Filme implements Serializable, Comparable {

    private int id;
    private String titulo;
    private String descricao;
    private double popularidade;
    private String diretor;
    private String genero;



    private String iconName;

    public Filme(int id, String titulo, String descricao, double popularidade, String diretor, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.popularidade = popularidade;
        this.diretor = diretor;
        this.genero = genero;
    }

    public Filme(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPopularidade() {
        return popularidade;
    }

    public void setPopularidade(double popularidade) {
        this.popularidade = popularidade;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    @Override
    public int compareTo(Object o) {

        if (o == null || o.getClass() != getClass()){
            return 0;
        } else {
            Filme filme = (Filme) o;
            Collator c = Collator.getInstance();

            c.setStrength(Collator.PRIMARY);

            return c.compare(this.titulo, filme.getTitulo());
        }


    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", popularidade=" + popularidade +
                ", diretor='" + diretor + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
