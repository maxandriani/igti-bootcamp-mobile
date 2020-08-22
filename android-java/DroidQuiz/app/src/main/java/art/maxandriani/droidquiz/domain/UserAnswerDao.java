package art.maxandriani.droidquiz.domain;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserAnswerDao {
  @Insert()
  void insert(UserAnswer ua);

  @Delete()
  void  delete(UserAnswer ua);

  @Query("DELETE FROM useranswer")
  void clear();

  @Query("SELECT (SELECT COUNT(q.id)" +
    "               FROM question q) as total," +
    "            (SELECT COUNT(ua.id)" +
    "               FROM useranswer ua" +
    "               JOIN question q" +
    "                 ON q.id = ua.questionId" +
    "              WHERE ua.answer = q.answer) as success," +
    "            (SELECT COUNT(ua.id)" +
    "               FROM question q" +
    "          LEFT JOIN useranswer ua" +
    "                 ON q.id = ua.questionId" +
    "              WHERE ua.answer != q.answer" +
    "                 OR ua.answer IS NULL) as 'fail'")
  UserAnswerScore computeScore();
}
