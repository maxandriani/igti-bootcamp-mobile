package art.maxandriani.calculadoradesalarios.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class INSSRepository {

  ArrayList<TaxRule> rules = new ArrayList(Arrays.asList(
    new TaxRule(0.0, 1045.0, 0.075, 0.0),
    new TaxRule(1045.01, 2089.6, 0.09, 15.67),
    new TaxRule(2089.61, 3134.4, 0.12, 78.36),
    new TaxRule(3134.41, 6101.06, 0.14, 141.05),
    new TaxRule(6101.07, Double.MAX_VALUE, 0.14, 141.05)));

  public Double getINSSBalanceBySalary(final INSSInputDto data) throws Exception {
    TaxRule rule = rules
      .stream()
      .filter(r -> r.isCompliance(data.getSalario()))
      .findFirst()
      .orElseThrow(() -> new Exception("O salário informado não está em uma regra prevista."));

    return rule.calc(data.getSalario());
  }

  public ArrayList<TaxRule> getRules() {
    return (ArrayList<TaxRule>) rules.clone();
  }

}
