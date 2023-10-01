package br.com.company.enums;

import lombok.Getter;

@Getter
public enum Status {

  ATIVO("Ativo"),
  ATESTADO("Atestado"),
  FERIAS("Férias");

  private String status;

  private Status(String status) {
    this.status = status;
  }

}
