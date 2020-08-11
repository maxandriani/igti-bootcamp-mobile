package art.maxandriani.calculadoradesalarios.domain;

public class INSSInputDto {

  private Double salario;

  public INSSInputDto(
    Double salario
  ) {
    this.salario = salario;
  }

  public Double getSalario() {
    return salario;
  }

}
