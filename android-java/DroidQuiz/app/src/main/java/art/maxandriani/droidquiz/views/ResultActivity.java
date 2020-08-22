package art.maxandriani.droidquiz.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.number.NumberFormatter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.NumberFormat;

import art.maxandriani.droidquiz.R;
import art.maxandriani.droidquiz.domain.UserAnswerScore;

public class ResultActivity extends AppCompatActivity {

  public static final String RESULT_SCORE = "result_score";

  private ProgressBar progressBar;
  private CardView resultCard;
  private TextView scoreTextView;
  private TextView messageTextView;
  private Button backBtn;

  private UserAnswerScore score;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    extractScore();

    if (score.hasSucceeded()) {
      setTheme(R.style.AppTheme_Success);
    } else {
      setTheme(R.style.AppTheme_Fail);
    }

    setContentView(R.layout.activity_result);

    progressBar     = findViewById(R.id.result_progress_bar);
    resultCard      = findViewById(R.id.result_card);
    scoreTextView   = findViewById(R.id.result_score);
    messageTextView = findViewById(R.id.result_text);
    backBtn         = findViewById(R.id.result_back_btn);

    startLoading();
    addBackButtonClickListener();
  }

  @Override
  protected void onStart() {
    startLoading();
    computeUiScore();
    super.onStart();
  }

  private void addBackButtonClickListener() {
    backBtn.setOnClickListener(view -> { backToStart(); });
  }

  private void backToStart() {
    Intent backToStart = new Intent(this, StartQuizActivity.class);
    backToStart.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(backToStart);
  }

  @Override
  public void onBackPressed() {
    backToStart();
  }

  private void extractScore() {
    Intent intent = getIntent();
    score = (UserAnswerScore) intent.getSerializableExtra(RESULT_SCORE);
  }

  private void startLoading() {
    progressBar.setVisibility(View.VISIBLE);
    resultCard.setVisibility(View.GONE);
  }

  private void finishLoading() {
    progressBar.setVisibility(View.GONE);
    resultCard.setVisibility(View.VISIBLE);
  }

  private void computeUiScore() {
    NumberFormat percentFormatter = NumberFormat.getPercentInstance();
    scoreTextView.setText(percentFormatter.format(score.getRating()));

    if (score.hasSucceeded()) {
      messageTextView.setText(R.string.result_bood_message);
    } else {
      messageTextView.setText(R.string.result_bad_message);
    }

    finishLoading();
  }

}