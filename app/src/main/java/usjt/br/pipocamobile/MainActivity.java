/**
 *RA: 816114937
 *NOME: Matheus Moura Borges Silva
 */

package usjt.br.pipocamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerGeneros;
    public static final String CHAVE = "br.usjt.pipocamobile.txtGenero";
    String genero = "Todos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerGeneros = (Spinner)findViewById(R.id.spinnerGeneros);
        spinnerGeneros.setOnItemSelectedListener(new GeneroSelecionado());
    }

    public void listarFilmes(View view){
        Intent intent = new Intent(this, ListarFilmesActivity.class);
        intent.putExtra(CHAVE, genero);
        startActivity(intent);
    }

    private class GeneroSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            genero = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
