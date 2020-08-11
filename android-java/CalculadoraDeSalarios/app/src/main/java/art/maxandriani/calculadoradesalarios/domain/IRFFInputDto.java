package art.maxandriani.calculadoradesalarios.domain;

public class IRFFInputDto {

  private Double salario;
  private int    dependentes;
  private Double inss;

  public IRFFInputDto(
    Double salario,
    int dependentes,
    Double inss
  ) {
    this.salario = salario;
    this.dependentes = dependentes;
    this.inss = inss;
  }

  public Double getSalario() {
    return salario;
  }

  public int getDependentes() {
    return dependentes;
  }

  public Double getInss() {
    return inss;
  }
}
