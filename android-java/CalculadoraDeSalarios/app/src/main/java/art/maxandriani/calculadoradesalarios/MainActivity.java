package art.maxandriani.calculadoradesalarios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.util.AndroidException;
import android.view.MotionEvent;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputEditText;

import javax.xml.transform.Result;

import art.maxandriani.calculadoradesalarios.infra.KeyboardUtils;
import art.maxandriani.calculadoradesalarios.infra.MainMenuUtils;
import art.maxandriani.calculadoradesalarios.views.ResultadoActivity;

public class MainActivity extends AppCompatActivity {

  private Button calcularBtn;
  private TextInputEditText salarioBrutoInput;
  private TextInputEditText numeroDependentesInput;
  private TextInputEditText outrosDescontosInput;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Load properties
    calcularBtn = findViewById(R.id.main_form_submit_btn);
    salarioBrutoInput = findViewById(R.id.main_form_input_salario_bruto);
    numeroDependentesInput = findViewById(R.id.main_form_input_dependentes);
    outrosDescontosInput = findViewById(R.id.main_form_input_descontos);

    // Setup view behaviour
    setupKeyboardListener();
    setupMenuListener();
    setupFormSubmit();
  }

  /**
   * Auto hide keyboard when touch anything...
   */
  private void setupKeyboardListener() {
    KeyboardUtils.attachHideSoftKeyboardListener(findViewById(R.id.main_activity_container), this);
  }

  /**
   * Add Menu navigation events
   */
  private void setupMenuListener() {
    MaterialToolbar toolbar = findViewById(R.id.toolbar);
    MainMenuUtils.setupMainMenu(toolbar, this);
  }

  /**
   * Extrai e valida o valor do salário com base em uma string;
   * @param salarioStr
   * @return
   * @throws Exception
   */
  private Double coerceSalario(String salarioStr) throws Exception {
    if (salarioStr.isEmpty()) {
      throw new Exception(getString(R.string.main_validation_empty_salary));
    }

    Double salario = Double.parseDouble(salarioStr);

    if (salario <= 0.0) {
      throw new Exception(getString(R.string.main_validation_minus_salary));
    }

    return salario;
  }

  /**
   * Extrai e valida o valor do número de dependentes com base em uma string numérica.
   * @param dependentesStr
   * @return
   * @throws Exception
   */
  private int coerceDependentes(String dependentesStr) throws Exception {
    if (dependentesStr.isEmpty()) {
      return 0;
    }

    int dependentes = Integer.parseInt(dependentesStr);

    if (dependentes < 0) {
      throw new Exception(getString(R.string.main_validation_minus_dependentes));
    }

    return dependentes;
  }

  private Double coerceDescontos(String descontosStr) throws Exception {
    if (descontosStr.isEmpty()) {
      return 0.0;
    }

    Double descontos = Double.parseDouble(descontosStr);

    if (descontos < 0.0) {
      throw new Exception(getString(R.string.main_validation_minus_desconto));
    }

    return descontos;
  }


  private void setupFormSubmit() {
    calcularBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        try {
          // TODO Corrigir variações de Locale no futuro 😂
          Double salario     = coerceSalario(salarioBrutoInput.getText().toString());
          int    dependentes = coerceDependentes(numeroDependentesInput.getText().toString());
          Double descontos   = coerceDescontos(outrosDescontosInput.getText().toString());

          Intent goToResult = new Intent(MainActivity.this, ResultadoActivity.class)
            .putExtra(ResultadoActivity.SALARIO_BRUTO_FIELD, salario)
            .putExtra(ResultadoActivity.NUMERO_DEPENDENTES_FIELD, dependentes)
            .putExtra(ResultadoActivity.OUTROS_DESCONTOS_FIELD, descontos);

          startActivity(goToResult);

        } catch (Exception ex) {
          Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
          ex.printStackTrace();
        }
      }
    });
  }
}