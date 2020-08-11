package art.maxandriani.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button startBtn = findViewById(R.id.btn_start);
    startBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startService(new Intent(getApplicationContext(), HelloService.class));
      }
    });

    Button finishBtn = findViewById(R.id.btn_finish);
    finishBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        stopService(new Intent(getApplicationContext(), HelloService.class));
      }
    });
  }


}