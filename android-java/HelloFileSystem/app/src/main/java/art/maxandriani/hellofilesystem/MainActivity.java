package art.maxandriani.hellofilesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

  public final static String DATA_FILE_NAME = "usuarios";

  private EditText firstNameInput;
  private EditText lastNameInput;
  private Button submitBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    firstNameInput = findViewById(R.id.form_input_first_name);
    lastNameInput = findViewById(R.id.form_input_last_name);
    submitBtn = findViewById(R.id.form_submit_btn);

    submitBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String firstName = firstNameInput.getText().toString();
        String lastName = lastNameInput.getText().toString();

        try {
          FileOutputStream fs = openFileOutput(DATA_FILE_NAME, Context.MODE_PRIVATE);
          fs.write(firstName.getBytes());
          fs.write(lastName.getBytes());
          fs.write("\n".getBytes());
          fs.close();

          Toast
            .makeText(getApplicationContext(), R.string.form_submit_success, Toast.LENGTH_SHORT)
            .show();

          Intent intent = new Intent(MainActivity.this, HelloSavedUser.class);
          startActivity(intent);

        } catch (IOException ex) {
          Toast
            .makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG)
            .show();

          ex.printStackTrace();
        }
      }
    });

  }
}