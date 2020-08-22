package art.maxandriani.droidquiz.domain;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface QuestionDao {
  @Insert
  void insert(Question question);
  @Delete
  void delete(Question question);

  @Query("DELETE FROM question")
  void clear();

  @Query("SELECT COUNT(id) FROM question")
  int count();

  @Query("SELECT EXISTS(SELECT q.id" +
    "                     FROM question q" +
    "                LEFT JOIN useranswer ua" +
    "                       ON ua.questionId = q.id" +
    "                    WHERE ua.answer IS NULL" +
    "                    LIMIT 1)")
  boolean hasNext();

  @Query("SELECT q.*" +
    "       FROM question q" +
    "  LEFT JOIN useranswer ua" +
    "         ON ua.questionId = q.id" +
    "      WHERE ua.answer IS NULL" +
    "   ORDER BY RANDOM()" +
    "      LIMIT 1")
  Question getNextRand();
}
