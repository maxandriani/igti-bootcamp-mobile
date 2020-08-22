package art.maxandriani.droidquiz.domain;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Question implements Serializable {
  @PrimaryKey(autoGenerate = true)
  public int id;
  public String question;
  public boolean answer;

  public Question() {}

  @Ignore
  public Question(String question, boolean answer) {
    this.question = question;
    this.answer   = answer;
  }
}
