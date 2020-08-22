package art.maxandriani.droidquiz.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import art.maxandriani.droidquiz.R;
import art.maxandriani.droidquiz.domain.Question;
import art.maxandriani.droidquiz.domain.QuestionsDb;
import art.maxandriani.droidquiz.domain.UserAnswer;
import art.maxandriani.droidquiz.domain.UserAnswerScore;

public class QuestionActivity extends AppCompatActivity {

  private ProgressBar progressBar;
  private CardView questionCardView;
  private TextView questionTextView;
  private Button yesBtn;
  private Button noBtn;

  private Question question;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    progressBar      = findViewById(R.id.question_progress_bar);
    questionCardView = findViewById(R.id.question_card);
    questionTextView = findViewById(R.id.question_text);
    yesBtn           = findViewById(R.id.question_yes_btn);
    noBtn            = findViewById(R.id.question_no_btn);

    addAnswerClickListener();
    startLoading();
  }

  @Override
  protected void onStart() {
    nextQuestion();
    super.onStart();
  }

  private void startLoading() {
    progressBar.setVisibility(ProgressBar.VISIBLE);
    questionCardView.setVisibility(CardView.GONE);
  }

  private void finishLoading() {
    progressBar.setVisibility(ProgressBar.GONE);
    questionCardView.setVisibility(CardView.VISIBLE);
  }

  private void disableButtons() {
    yesBtn.setEnabled(false);
    noBtn.setEnabled(false);
  }

  private void ennableButtons() {
    yesBtn.setEnabled(true);
    noBtn.setEnabled(true);
  }

  private void addAnswerClickListener() {
    yesBtn.setOnClickListener(view -> { answer(true); });
    noBtn.setOnClickListener(view -> { answer(false); });
  }

  private void answer(boolean answer) {
    disableButtons();

    UserAnswer ua = new UserAnswer(question, answer);
    Toast.makeText(this, (ua.answer == question.answer)
      ? R.string.question_success
      : R.string.question_fail, Toast.LENGTH_SHORT).show();

    startLoading();

    final Context ctx = this;

    // Save
    new Thread(() -> {
      QuestionsDb db = QuestionsDb.getInstance(ctx);
      db.userAnswerDao().insert(ua);
      runOnUiThread(() -> { nextQuestion(); });
    }).start();
  }

  private void nextQuestion() {
    final Context ctx = this;

    new Thread(() -> {
      QuestionsDb db = QuestionsDb.getInstance(ctx);
      boolean hasNext = db.questionDao().hasNext();

      if (hasNext) {
        question = db.questionDao().getNextRand();
        runOnUiThread(() -> {
          updateQuestionUi(question);
          finishLoading();
        });
      } else {
        finishGame();
      }
    }).start();
  }

  private void updateQuestionUi(Question question) {
    questionTextView.setText(question.question);
    ennableButtons();
  }

  private void finishGame() {
    final Context ctx = this;
    new Thread(() -> {
      QuestionsDb db = QuestionsDb.getInstance(ctx);
      UserAnswerScore score = db.userAnswerDao().computeScore();
      Intent goToResult = new Intent(ctx, ResultActivity.class);
      goToResult.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      goToResult.putExtra(ResultActivity.RESULT_SCORE, score);

      runOnUiThread(() -> {
        startActivity(goToResult);
        finish();
      });
    }).start();
  }
}