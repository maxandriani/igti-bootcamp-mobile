package art.maxandriani.droidquiz.views;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;

import art.maxandriani.droidquiz.R;
import art.maxandriani.droidquiz.workers.SeedDatabaseWorker;

public class SplashActivity extends AppCompatActivity {

  private boolean canIGo = false;
  private AnimatorSet animation;
  private ImageView logo;
  private ImageView owl;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    logo = findViewById(R.id.logo);
    owl  = findViewById(R.id.owl);

    buildAnimations();
    seedDatabase();
  }

  @Override
  protected void onStart() {
    animation.start();
    super.onStart();
  }

  @Override
  protected void onPause() {
    animation.cancel();
    super.onPause();
  }

  @Override
  protected void onRestart() {
    canIGo = true;
    super.onRestart();
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (canIGo == true) {
      goToGame();
    }
    return super.onTouchEvent(event);
  }

  private void seedDatabase() {
    new Thread(new SeedDatabaseWorker(this, () -> {
      canIGo = true;
      if (!animation.isRunning()) {
        this.goToGame();
      }
    })).start();
  }

  private void goToGame() {
    if (canIGo) {
      canIGo = false;
      Intent goToGame = new Intent(this, StartQuizActivity.class);
      startActivity(goToGame);
    }
  }

  private void buildAnimations() {
    animation = new AnimatorSet();
    animation
      .playTogether(
        createLogoAnimation(),
        createOwlAnimation());
    animation.addListener(new AnimatorListenerAdapter() {
      @Override
      public void onAnimationCancel(Animator animation) {
        goToGame();
      }

      @Override
      public void onAnimationEnd(Animator animation) {
        goToGame();
      }
    });
  }

  private AnimatorSet createLogoAnimation() {
    AnimatorSet animator = new AnimatorSet();
    animator
      .playTogether(
        ObjectAnimator.ofFloat(logo, View.TRANSLATION_Y, -100f, 0f),
        ObjectAnimator.ofFloat(logo, ImageView.ALPHA, 0f, 1f));
    animator.setInterpolator(new AccelerateInterpolator());
    animator.setDuration(800);
    return animator;
  };

  private AnimatorSet createOwlAnimation() {
    AnimatorSet animator = new AnimatorSet();

    animator.playSequentially(
      animateOwlLookup(),
      new AnimatorSet().setDuration(1500),
      animateOwlShake(),
      new AnimatorSet().setDuration(1500),
      animateOwlLookup(),
      new AnimatorSet().setDuration(1000),
      animateOwlLookup(),
      new AnimatorSet().setDuration(1000),
      animateOwlShake()
    );

    animation.start();

    return animator;
  }

  private ObjectAnimator animateOwlLookup() {
    ObjectAnimator animate = ObjectAnimator
      .ofFloat(owl, ImageView.TRANSLATION_Y, 250f, 150f, 140f, 150f, 140f, 200f, 250f, 250f);
    animate.setDuration(1500);
    return animate;
  }

  private ObjectAnimator animateOwlShake() {
    ObjectAnimator animator = ObjectAnimator.ofFloat(owl, ImageView.TRANSLATION_Y, 250f, 20f, 20f, 20f, 0f, 20f, 0f, 20f, 60f, 250f);
    animator.setDuration(1500);
    return animator;
  }

}