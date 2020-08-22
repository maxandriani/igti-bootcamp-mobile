package art.maxandriani.droidquiz.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import art.maxandriani.droidquiz.R;
import art.maxandriani.droidquiz.domain.Question;
import art.maxandriani.droidquiz.domain.QuestionsDb;

public class StartQuizActivity extends AppCompatActivity {

  private Button btnStart;
  private ProgressBar progressBar;
  private ImageView logo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_start_quiz);

    btnStart    = findViewById(R.id.btn_start);
    progressBar = findViewById(R.id.progressBar);
    logo        = findViewById(R.id.logo);

    addStartBtnClickListener();
    finishLoading();
  }

  private void addStartBtnClickListener() {
    btnStart.setOnClickListener(view -> {
      Toast.makeText(this, R.string.start_welcome_message, Toast.LENGTH_SHORT);
      startLoading();
      clearEnvironment();
    });
  }

  private void startLoading() {
    btnStart.setEnabled(false);
    btnStart.setVisibility(View.GONE);
    progressBar.setVisibility(View.VISIBLE);
  }

  private void finishLoading() {
    btnStart.setEnabled(true);
    btnStart.setVisibility(View.VISIBLE);
    progressBar.setVisibility(View.GONE);
  }

  private void goToGame() {
    Intent goToGame = new Intent(this, QuestionActivity.class);
    startActivity(goToGame);
  }

  private void clearEnvironment() {
    final QuestionsDb db = QuestionsDb.getInstance(this);

    new Thread(() -> {
      db.userAnswerDao().clear();
      runOnUiThread(() -> {
        finishLoading();
        goToGame();
      });
    }).start();
  }
}