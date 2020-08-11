package art.maxandriani.calculadoradesalarios.domain;

public class TaxRule {

  private Double min;
  private Double max;
  private Double tax;
  private Double discount;
  private Double maxTax = Double.MAX_VALUE;

  public TaxRule(
    Double min,
    Double max,
    Double tax,
    Double discount
  ) {
    this.min = min;
    this.max = max;
    this.tax = tax;
    this.discount = discount;
  }

  public TaxRule(
    Double min,
    Double max,
    Double tax,
    Double discount,
    Double maxTax
  ) {
    this(min, max, tax, discount);
    this.maxTax = maxTax;
  }

  public boolean isCompliance(Double salary) {
    return (salary >= min && salary <= max);
  }

  public Double getTax() {
    return tax;
  }

  public Double getDiscount() {
    return discount;
  }

  public Double calc(Double salary) {
    Double value = (salary * tax) - discount;
    return (value > maxTax)
      ? maxTax
      : value;
  }

}
