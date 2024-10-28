
package rpg3.habilidades;

import rpg3.Habilidade;
import rpg3.Personagem;

public class BananaDeCura extends Habilidade {
    private static final int CURA_BASE = 20;

    public BananaDeCura() {
        super("Banana de Cura", "Uma banana mágica que restaura a vida do usuário.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " comeu " + getNome() + " e recuperou " + CURA_BASE + " pontos de vida.");
        atacante.aumentarVida(CURA_BASE);
    }
}
