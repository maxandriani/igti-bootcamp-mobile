package art.maxandriani.droidquiz.domain;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserAnswer implements Serializable {
  @PrimaryKey(autoGenerate = true)
  public int id;
  @ForeignKey(entity = Question.class, parentColumns = "id", childColumns = "questionId", onDelete = ForeignKey.CASCADE)
  public int questionId;
  public boolean answer;

  public UserAnswer() {}

  @Ignore
  public UserAnswer(Question question, boolean answer) {
    this.questionId = question.id;
    this.answer     = answer;
  }
}
