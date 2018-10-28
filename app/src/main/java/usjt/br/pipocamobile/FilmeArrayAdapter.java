package usjt.br.pipocamobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmeArrayAdapter extends ArrayAdapter<Filme> {

    private Map<String, Bitmap> bitmaps = new HashMap<>();
    public FilmeArrayAdapter (Context context, List<Filme> filme){
        super(context, -1, filme);
    }


    private static class ViewHolder {
        ImageView conditionImageView;
        TextView tituloTextView;
        TextView descricaoTextView;
        TextView diretorView;
        TextView popularidadeTextView;
        TextView generoTextView;
    }

    @SuppressLint("StringFormatInvalid")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        Filme filme = null;
        filme = getItem(filme);
        View raiz = null;
        ViewHolder viewHolder = null;
        Context context = getContext();
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            raiz = inflater.inflate(R.layout.activity_listar_filmes, parent, false);
            viewHolder = new ViewHolder();
            raiz.setTag(viewHolder);
            viewHolder.tituloTextView = raiz.findViewById(R.id.txtNome);
            viewHolder.descricaoTextView = raiz.findViewById(R.id.txtDiretor);
            viewHolder.diretorView = raiz.findViewById(R.id.txtDiretor);
            viewHolder.popularidadeTextView = raiz.findViewById(R.id.txtGenero);
        }
        else{
            raiz = convertView;
            viewHolder = (ViewHolder) raiz.getTag();
        }
        viewHolder.tituloTextView.setText(context.getString(R.string.titulo, filme.getTitulo()));
        return raiz;

    }

    private class ImageGetter extends AsyncTask<String, Void, Bitmap> {

        private ImageView imageView;
        private Map <String, Bitmap> bitmaps;

        public ImageGetter (ImageView imageView, Map <String, Bitmap> bitmaps){
            this.imageView = imageView;
            this.bitmaps = bitmaps;
        }

        @Override
        protected Bitmap doInBackground(String... urlS) {
            try{
                URL url = new URL(urlS[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                Bitmap figura = BitmapFactory.decodeStream(inputStream);
                bitmaps.put(urlS[0], figura);
                return figura;
            }
            catch (IOException e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap figura) {
            imageView.setImageBitmap(figura);
        }
    }
}
