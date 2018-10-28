/**
 *RA: 816114937
 *NOME: Matheus Moura Borges Silva
 */

package usjt.br.pipocamobile;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerGeneros;
    public static final String CHAVE = "br.usjt.pipocamobile.txtGenero";
    String genero = "Todos";
    private FilmeArrayAdapter adapter;
    private List<Filme> filmeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerGeneros = (Spinner)findViewById(R.id.spinnerGeneros);
        spinnerGeneros.setOnItemSelectedListener(new GeneroSelecionado());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String genero = genero;
                /*new Thread(new Runnable(){
                    @Override
                    public void run() {
                }).start();*/
                WebServiceClient client = new WebServiceClient();
                client.execute(genero);



            }
        });
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


    private class WebServiceClient extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... filme) {
            try{
                URL url = createURL(filme[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String linha = null;
                StringBuilder stringBuilder = new StringBuilder ("");
                while ((linha = reader.readLine()) != null){
                    stringBuilder.append(linha);
                }
                return stringBuilder.toString();
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
        @Override
        protected void onPostExecute(String json) {
            //Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();
            try {
                filmeList.clear();
                Gson gson = new Gson();
                FilmesData filme = gson.fromJson(json, FilmeData.class);
                for (FilmeData data : filme.getList()) {
                    filmeList.add(new Filme(data));
                }
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private URL createURL (String filme){
        try{
            String baseURL = getString(R.string.web_service_url);
            String urlString = baseURL + URLEncoder.encode(filme, "UTF-8");
            urlString += genero;
            return new URL(urlString);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
