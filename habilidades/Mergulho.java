
package rpg3.habilidades;

import rpg3.Habilidade;
import rpg3.Personagem;
import rpg3.PrincipeMacaco;

public class Mergulho extends Habilidade {
    private static final int DANO_BASE = 20;

    public Mergulho() {
        super("Mergulho", "Bobo se lança em direção ao oponente, causando dano e evitando ataques por um turno.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " usou " + getNome() + "! Causando " + DANO_BASE + " de dano.");
        alvo.receberDano(DANO_BASE);
        //((PrincipeMacaco) atacante).setNegaDano(true); // Impede dano no próximo turno
    }
}
