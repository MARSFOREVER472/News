package cl.ucn.disc.dsm.mlam.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import cl.ucn.disc.dsm.mlam.news.model.Article;

/**
 * The news adapter for the recycler view.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private LayoutInflater inflater;
    private List<Article> articles;

    /**
     * constructor
     *
     * @param context
     */
    public NewsAdapter(Context context) {

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = inflater.inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        if (articles != null) {
            Article article = articles.get(position);
            Picasso.get().load(article.getImageUrl()).into(holder.imageView);
            holder.titleView.setText(article.getTitle());
            holder.descriptionView.setText(article.getDescription());
            holder.publishedAtView.setText(article.getPublishedAt());
            holder.authorView.setText(article.getAuthor());
            holder.sourceView.setText(article.getSource());
            holder.sourceUrl = article.getUrl();

        } else {

            holder.titleView.setText("Error al cargar las noticias");
        }
    }

    @Override
    public int getItemCount() {
        if (articles != null) {

            return articles.size();

        } else {

            return 0;
        }
    }

    public void setNews(List<Article> articles) {

        this.articles = articles;
        notifyDataSetChanged();
    }

    /**
     * View holder for the article.
     */
    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView titleView;
        private TextView descriptionView;
        private TextView publishedAtView;
        private TextView authorView;
        private TextView sourceView;
        private String sourceUrl;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Make an intent to open the web browser.
                    Uri webPage = Uri.parse(sourceUrl);
                    Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
                    if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                        v.getContext().startActivity(intent);
                    }
                }
            });
            imageView = itemView.findViewById(R.id.item_img);
            titleView = itemView.findViewById(R.id.item_title);
            descriptionView = itemView.findViewById(R.id.item_description);
            publishedAtView = itemView.findViewById(R.id.item_publishedAt);
            authorView = itemView.findViewById(R.id.item_author);
            sourceView = itemView.findViewById(R.id.item_source);
        }
    }
}
