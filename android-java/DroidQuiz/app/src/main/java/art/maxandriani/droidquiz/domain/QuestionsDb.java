package art.maxandriani.droidquiz.domain;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {
    Question.class,
    UserAnswer.class
  },
  version = 1,
  exportSchema = false)
public abstract class QuestionsDb extends RoomDatabase {

  public static final String DATABASE_NAME = "questions.db";
  private static QuestionsDb instance;

  protected QuestionsDb() {}

  public static QuestionsDb getInstance(Context context) {
    if (instance == null) {
      instance = Room.databaseBuilder(context.getApplicationContext(), QuestionsDb.class, DATABASE_NAME)
        .build();
    }
    return instance;
  }

  public abstract QuestionDao questionDao();
  public abstract UserAnswerDao userAnswerDao();
}
