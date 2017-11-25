package br.com.cwi.restapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.cwi.restapplication.Constants.ExtraConstants;
import br.com.cwi.restapplication.Models.MovieModel;
import br.com.cwi.restapplication.Services.MovieService;
import br.com.cwi.restapplication.Services.NetworkService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviewDetailActivity extends AppCompatActivity implements Callback<MovieModel> {

    private MovieService movieService;

    private TextView tvDetails;
    private ImageView imvPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moview_detail);

        setUpRetrofit();
        init();
    }

    private void setUpRetrofit() {
        movieService = NetworkService.getInstance().getMovieService();
    }

    private void init() {

        String id = (String) getIntent().getExtras().get(ExtraConstants.ID);
        movieService.searchMoviesById(id).enqueue(this);
        tvDetails = findViewById(R.id.tv_movie_plot);
        imvPost = findViewById(R.id.imv_poster);
    }

    @Override
    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
        if (response.body().getResponse().equalsIgnoreCase("True")) {
            initComponent(response.body());
        }
    }

    @Override
    public void onFailure(Call<MovieModel> call, Throwable t) {
        Log.e("erro", t.getMessage());
    }

    private void initComponent(MovieModel movieModel) {
        this.tvDetails.setText(movieModel.getPlot());
        Picasso.with(this)
                .load(movieModel.getPoster())
                .into(imvPost);
    }
}
