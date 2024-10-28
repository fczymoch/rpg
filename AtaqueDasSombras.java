
package rpg3;

import rpg3.Habilidade;
import rpg3.Personagem;

public class AtaqueDasSombras extends Habilidade {
    private static final int DANO_BASE = 25;

    public AtaqueDasSombras() {
        super("Ataque das Sombras", "Um ataque poderoso que causa dano ao alvo.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        if (((PrincipeMacaco)atacante).isCego()) {
            System.out.println(atacante.getNome() + " está cego e não consegue atacar!");
            return;
        }

        int dano = DANO_BASE;
        if (((PrincipeMacaco)atacante).random.nextDouble() < 0.2) { // 20% de chance de dano crítico
            dano *= 2;
            System.out.println("Crítico! " + atacante.getNome() + " causou dano crítico!");
        }
        
        System.out.println(atacante.getNome() + " usou " + getNome() + "! Causando " + dano + " de dano.");
        alvo.receberDano(dano);
    }
}
