package art.maxandriani.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TextView text = findViewById(R.id.layout_text);
    final EditText input = findViewById(R.id.layout_name);

    Button button = findViewById(R.id.layout_button);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String value = input.getText().toString();
        text.setText(value);
      }
    });


  }
}