package cl.ucn.disc.dsm.mlam.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import cl.ucn.disc.dsm.mlam.news.model.Article;

/**
 * The main activity.
 */
public class MainActivity extends AppCompatActivity {

    private NewsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        NewsAdapter adapter = new NewsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ViewModel
        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        viewModel.getAllNews().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                adapter.setNews(articles);
            }
        });
    }

    /**
     * Refresh the news.
     *
     * @param view
     */
    public void refresh(View view) {

        viewModel.refresh();
    }
}