package rpg3.habilidades;

import rpg3.Habilidade;
import rpg3.Personagem;

public class Diluvio extends Habilidade {
    private static final int DANO_BASE = 35;

    public Diluvio() {
        super("Dilúvio", "Um ataque que causa muito  dano");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " usou " + getNome() + "! Causando " + DANO_BASE + " de dano.");
        alvo.receberDano(DANO_BASE);

    }
}