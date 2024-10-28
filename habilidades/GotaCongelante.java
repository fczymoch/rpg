
package rpg3.habilidades;

import rpg3.Habilidade;
import rpg3.Personagem;
import rpg3.PrincipeMacaco;

public class GotaCongelante extends Habilidade {
    private static final int DANO_BASE = 25;

    public GotaCongelante() {
        super("Gota Congelante", "Causa dano e pode congelar o oponente.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " lançou " + getNome() + "! Causando " + DANO_BASE + " de dano.");
        alvo.receberDano(DANO_BASE);

        if (((PrincipeMacaco)atacante).random.nextDouble() < 0.3) { // 30% de chance de congelar
            System.out.println(alvo.getNome() + " foi congelado e não pode atacar no próximo turno!");
            //alvo.setCego(true); // Ação de "congelar" representada como cegueira para simplificação
        }
    }
}
