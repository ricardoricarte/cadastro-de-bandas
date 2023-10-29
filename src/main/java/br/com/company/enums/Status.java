package br.com.company.enums;

import lombok.Getter;

@Getter
public enum Status {

  ATIVA("Ativa"),
  HIATO("Hiato"),
  DISSOLVIDA("Dissolvida");

  private String status;

  private Status(String status) {
    this.status = status;
  }

}
