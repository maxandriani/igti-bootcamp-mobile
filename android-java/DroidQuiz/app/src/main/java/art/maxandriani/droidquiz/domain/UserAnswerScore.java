package art.maxandriani.droidquiz.domain;

import androidx.room.Ignore;
import androidx.room.Insert;

import java.io.Serializable;

public class UserAnswerScore implements Serializable {
  public int total;
  public int fail;
  public int success;

  public UserAnswerScore() {}

  @Ignore
  public UserAnswerScore(int total, int success, int fail) {
    this.total   = total;
    this.success = success;
    this.fail    = fail;
  }

  public boolean hasSucceeded() {
    return success > fail;
  }

  public Double successRate() {
    Double t = (total > 0) ? total : 1.0;
    return success / t;
  }

  public Double failRate() {
    Double t = (total > 0) ? total : 1.0;
    return fail / t;
  }

  public Double getRating() {
    return successRate();
  }
}
