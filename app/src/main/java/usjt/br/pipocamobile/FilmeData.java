
/**
 *RA: 816114937
 *NOME: Matheus Moura Borges Silva
 */
package usjt.br.pipocamobile;

import java.util.List;

public class FilmeData {
    private FilmeDataDetail main;
    private List<ImageDetail> filme;

    public List<ImageDetail> getFilme() {
        return filme;
    }

    public void setFilme(List<ImageDetail> filme) {
        this.filme = filme;
    }



    public FilmeDataDetail getMain() {
        return main;
    }

    public void setMain(FilmeDataDetail main) {
        this.main = main;
    }
}
