package art.maxandriani.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  public final static String HELLO_MESSAGE = "art.maxandriani.intents.HELLO_MESSAGE";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onCallIntent(View view) {
    Intent messageIntent = new Intent(this, HelloActivity.class);
    messageIntent.putExtra(HELLO_MESSAGE, "Hello Max :) ❤");
    startActivity(messageIntent);
  }

  public void onCallImplicitIntent(View view) {
    Intent messageIntent = new Intent();
    messageIntent.setAction(HelloActivity.HELLO_ACTION);
    messageIntent.putExtra(HELLO_MESSAGE, "Hello Stranger 😎");
    startActivity(messageIntent);
  }
}