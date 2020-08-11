package art.maxandriani.hellofilesystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.IOException;

public class HelloSavedUser extends AppCompatActivity {

  private TextView savedDataView;
  private Button backButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hello_saved_user);

    savedDataView = findViewById(R.id.saved_user_data);
    backButton = findViewById(R.id.back_button);

    try {
      FileInputStream fs = openFileInput(MainActivity.DATA_FILE_NAME);
      StringBuffer sb = new StringBuffer();

      int i;
      while((i = fs.read()) != -1) {
        sb.append((char) i);
      }

      fs.close();
      String users = sb.toString();

      savedDataView.setText(users);

    } catch (IOException ex) {
      Toast
        .makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG)
        .show();

      ex.printStackTrace();
    }

    backButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(HelloSavedUser.this, MainActivity.class);
        startActivity(intent);
      }
    });
  }
}