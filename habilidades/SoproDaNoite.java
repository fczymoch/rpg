
package rpg3.habilidades;

import rpg3.Habilidade;
import rpg3.Personagem;
import rpg3.PrincipeMacaco;

public class SoproDaNoite extends Habilidade {
    private static final int DANO_BASE = 20;

    public SoproDaNoite() {
        super("Sopro da Noite", "Um ataque que pode cegar o oponente.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
      if (((PrincipeMacaco)atacante).isCego()) {
            System.out.println(atacante.getNome() + " está cego e não consegue atacar!");
            return;
        }

        int dano = DANO_BASE;
        System.out.println(atacante.getNome() + " usou " + getNome() + "! Causando " + dano + " de dano.");
        alvo.receberDano(dano);

        if (((PrincipeMacaco)atacante).random.nextDouble() < 0.3) { // 30% de chance de cegar
            System.out.println(alvo.getNome() + " foi cegado pelo sopro da noite!");
            //alvo.setCego(true);
        }
    }
}
