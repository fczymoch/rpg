package rpg3.habilidades;

import rpg3.Personagem;

public interface Item {
    void usar(Personagem alvo);
    String getNome();
}

