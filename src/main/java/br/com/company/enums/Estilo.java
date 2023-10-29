package br.com.company.enums;

import lombok.Getter;

@Getter
public enum Estilo {

  ROCK("Rock"),
  REGGAE("Reggae"),
  SKA("SKA"),
  HEAVYMETAL("Heavy Metal"),
  DEATHMETAL("Death Metal"),
  HARDCORE("Hardcore"),
  PUNKROCK("Punk Rock"),
  OUTROS("Outros");

  private String estilo;

  private Estilo(String estilo) {
    this.estilo = estilo;

  }
}
