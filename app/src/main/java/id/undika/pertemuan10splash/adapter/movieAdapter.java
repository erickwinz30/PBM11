package id.undika.pertemuan10splash.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import id.undika.pertemuan10splash.DetailActivity;
import id.undika.pertemuan10splash.Movie_Detail_Activity;
import id.undika.pertemuan10splash.R;
import id.undika.pertemuan10splash.pojo.pojo_movies;
import androidx.annotation.NonNull;
import androidx.core.app.ComponentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class movieAdapter extends RecyclerView.Adapter<movieAdapter.ViewHolder> {
    private Context context;
    private static ArrayList<pojo_movies> listMovie;



    //cons
    public movieAdapter(Context context) {
        this.context = context;
    }

    public static ArrayList<pojo_movies> getListMovie() {
        return listMovie;
    }

    public static void setListMovie(ArrayList<pojo_movies> listMovie) {
        movieAdapter.listMovie = listMovie;
    }


    @NonNull
    @Override //inflate layout itemlist
    public movieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie, parent, false);
        return new ViewHolder(v);
    }

    //penempatan data pojo ke itemlist
    @Override
    public void onBindViewHolder(@NonNull movieAdapter.ViewHolder holder, int position) {
        pojo_movies pm = getListMovie().get(position);

        holder.titleMovie.setText(pm.getTitle());
        holder.releaseMovie.setText(pm.getRelease_date());
        holder.descMovie.setText(pm.getDesc());
        Glide.with(holder.itemView.getContext()).load(pm.getPoster()).into(holder.posterMovies);
    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    //hubungkan dengan layout xml itemlist
    public class ViewHolder extends RecyclerView.ViewHolder {
        //deklarasi
        private ImageView posterMovies;
        private TextView releaseMovie, descMovie, titleMovie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            posterMovies = itemView.findViewById(R.id.posterMovies);
            releaseMovie = itemView.findViewById(R.id.releaseMovies);
            descMovie = itemView.findViewById(R.id.descMovies);
            titleMovie = itemView.findViewById(R.id.titleMovies);

            //event onClick untuk list (req: buat 1 activity baru -> halaman detail)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //isi yg ditampilkan ke halaman 2 sesuai dengan gambar/dtaa yg dipilih
                    int i = getAdapterPosition();
                    pojo_movies movies = getListMovie().get(i);

                    Intent detailIntent = new Intent(itemView.getContext(), DetailActivity.class);
//                    itemView.getContext().startActivity(movieDetail);
                    //kirim data dari intent ke halama detail (data dari class parcelable)
                    detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, movies);
                    context.startActivity(detailIntent);
//                    context.startActivity(new Intent(itemView.getContext(), DetailActivity.class));
                }
            });
        }
    }
}
