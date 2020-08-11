package art.maxandriani.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

  public static String HELLO_ACTION = "art.maxandriani.action.HELLO_ACTION";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hello);

    Intent intent = getIntent();
    String helloMessage = intent.getStringExtra(MainActivity.HELLO_MESSAGE);

    TextView helloLabel = findViewById(R.id.textView);
    helloLabel.setText(helloMessage);
  }
}