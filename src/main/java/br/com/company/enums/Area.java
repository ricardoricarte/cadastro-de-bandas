package br.com.company.enums;

import lombok.Getter;

@Getter
public enum Area {

  SEGURANCA("Segurança"),
  GESTAO("Gestão"),
  BACKEND("Backend"),
  FRONTEND("Frontend"),
  TESTES("Testes"),
  INFRAESTRUTURA("Infraestrutura"),
  ESTAGIARIOS("Estagiários"),
  RH("Recursos Humanos");

  private String area;

  private Area(String area) {
    this.area = area;

  }
}
