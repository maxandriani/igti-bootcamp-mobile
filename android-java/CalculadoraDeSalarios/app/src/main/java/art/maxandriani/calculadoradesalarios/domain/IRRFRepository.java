package art.maxandriani.calculadoradesalarios.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class IRRFRepository {

  private ArrayList<TaxRule> rules = new ArrayList(Arrays.asList(
    new TaxRule(0.0, 1903.98, 0.0, 0.0),
    new TaxRule(1903.99, 2826.65, 0.075, 142.8),
    new TaxRule(2826.66, 3751.05, 0.15, 354.8),
    new TaxRule(3751.06, 4664.68, 0.225, 636.13),
    new TaxRule(4664.69, Double.MAX_VALUE, 0.275, 869.36)
    ));

  private Double taxDependente = 189.59;

  public Double getIRPFBalanceBySalary(IRFFInputDto data) throws Exception {
    // TODO Fazer regra...
    // Base de cálculo = salário bruto – contribuição para o INSS – número de dependentes x 189,59
    Double base = data.getSalario() - (data.getInss() + (data.getDependentes() * taxDependente));

    TaxRule rule = rules
      .stream()
      .filter(r -> r.isCompliance(base))
      .findFirst()
      .orElseThrow(() -> new Exception("O salário informado não está em uma regra prevista."));

    return rule.calc(base);
  }

  public ArrayList<TaxRule> getRules() {
    return (ArrayList<TaxRule>) rules.clone();
  }

}
