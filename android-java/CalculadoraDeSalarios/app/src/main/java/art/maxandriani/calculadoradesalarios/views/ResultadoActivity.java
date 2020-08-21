package art.maxandriani.calculadoradesalarios.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.text.NumberFormat;

import art.maxandriani.calculadoradesalarios.MainActivity;
import art.maxandriani.calculadoradesalarios.R;
import art.maxandriani.calculadoradesalarios.domain.INSSInputDto;
import art.maxandriani.calculadoradesalarios.domain.INSSRepository;
import art.maxandriani.calculadoradesalarios.domain.IRFFInputDto;
import art.maxandriani.calculadoradesalarios.domain.IRRFRepository;
import art.maxandriani.calculadoradesalarios.infra.MainMenuUtils;

public class ResultadoActivity extends AppCompatActivity {

  public static final String SALARIO_BRUTO_FIELD = "salario_bruto";
  public static final String NUMERO_DEPENDENTES_FIELD = "numero_dependentes";
  public static final String OUTROS_DESCONTOS_FIELD = "outros_descontos";

  TextView salarioBrutoView;
  TextView salarioLiquidoView;
  TextView inssView;
  TextView irrfView;
  TextView outrosDescontosView;
  TextView totalDescontosView;
  TextView percentilDescontosView;

  INSSRepository inssRepository;
  IRRFRepository irrfRepository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_resultado);

    // Get fields
    salarioBrutoView       = findViewById(R.id.result_value_salario_bruto);
    salarioLiquidoView     = findViewById(R.id.result_value_salario_liquido);
    inssView               = findViewById(R.id.result_value_inss);
    irrfView               = findViewById(R.id.result_value_irrf);
    outrosDescontosView    = findViewById(R.id.result_value_outros_descontos);
    totalDescontosView     = findViewById(R.id.result_value_total_descontos);
    percentilDescontosView = findViewById(R.id.result_value_percentil_descontos);

    // init repos
    inssRepository = new INSSRepository();
    irrfRepository = new IRRFRepository();

    // setup behaviours
    setupMenuListener();
    inflateResult();
  }

  /**
   * Add Menu navigation events
   */
  private void setupMenuListener() {
    MaterialToolbar toolbar = findViewById(R.id.toolbar);
    MainMenuUtils.setupMainMenu(toolbar, this);
    toolbar.setNavigationOnClickListener(item -> {
      Intent goToHome = new Intent(ResultadoActivity.this, MainActivity.class);
      startActivity(goToHome);
    });
  }

  private void inflateResult() {
    Intent intent = getIntent();

    // Extract Info
    Double salarioBruto    = intent.getDoubleExtra(SALARIO_BRUTO_FIELD, 0.0);
    int    dependentes     = intent.getIntExtra(NUMERO_DEPENDENTES_FIELD, 0);
    Double outrosDescontos = intent.getDoubleExtra(OUTROS_DESCONTOS_FIELD, 0.0);
    Double inssDesc        = 0.0;
    Double irrfDesc        = 0.0;

    try {
      inssDesc = inssRepository.getINSSBalanceBySalary(new INSSInputDto(salarioBruto));
      irrfDesc = irrfRepository.getIRPFBalanceBySalary(new IRFFInputDto(salarioBruto, dependentes, inssDesc));
    } catch (Exception throwable) {
      Toast.makeText(ResultadoActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
      throwable.printStackTrace();
    }

    // Calc Results
    Double totalDescontos  = (inssDesc + irrfDesc + outrosDescontos);
    Double salarioLiquido  = (salarioBruto - totalDescontos);
    Double percentualDesc  = totalDescontos / salarioBruto;

    // Inflation
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    NumberFormat percentilFormatter = NumberFormat.getPercentInstance();

    salarioBrutoView.setText(currencyFormatter.format(salarioBruto));
    salarioLiquidoView.setText(currencyFormatter.format(salarioLiquido));
    inssView.setText(currencyFormatter.format((-1 * inssDesc)));
    irrfView.setText(currencyFormatter.format((-1 * irrfDesc)));
    outrosDescontosView.setText(currencyFormatter.format((-1 * outrosDescontos)));
    totalDescontosView.setText(currencyFormatter.format((-1 * totalDescontos)));
    percentilDescontosView.setText(percentilFormatter.format(percentualDesc));
  }
}