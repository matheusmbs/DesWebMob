/**
 *RA: 816114937
 *NOME: Matheus Moura Borges Silva
 */

package usjt.br.pipocamobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetalheFilmeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);
        TextView txtNome = (TextView)findViewById(R.id.txtNome);
        TextView txtDiretor = (TextView)findViewById(R.id.txtDiretor);
        TextView txtPopularidade = (TextView)findViewById(R.id.txtPopularidade);
        TextView txtGenero = (TextView)findViewById(R.id.txtGenero);
        TextView txtDescricao = (TextView)findViewById(R.id.txtDescricao);

        Intent intent = getIntent();
        Filme  filme = (Filme)intent.getSerializableExtra(ListarFilmesActivity.FILME);
        txtNome.setText("Filme: " + filme.getTitulo());
        txtDiretor.setText("Diretor: " + filme.getDiretor());
        txtPopularidade.setText("Popularidade: " + filme.getPopularidade());
        txtGenero.setText("Genero: " + filme.getGenero());
        txtDescricao.setText(filme.getDescricao());

    }

}
