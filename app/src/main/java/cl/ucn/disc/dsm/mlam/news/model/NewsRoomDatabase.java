package cl.ucn.disc.dsm.mlam.news.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * The database.
 */
@Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class NewsRoomDatabase extends RoomDatabase {

    public abstract NewsDao getNewsDao();

    // Singleton
    private static NewsRoomDatabase INSTANCE;

    public static NewsRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (NewsRoomDatabase.class) {

                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NewsRoomDatabase.class, "NewsDB")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}
