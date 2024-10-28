
package rpg3.habilidades;

import java.util.Random;

import rpg3.Habilidade;
import rpg3.Personagem;
import rpg3.PrincipeMacaco;

public class LuzDaLua extends Habilidade {
	Random random = new Random();
    private static final int DANO_BASE = 10;

    public LuzDaLua() {
        super("Luz da Lua", "Um ataque que causa dano e regenera parte da vida de Kiko.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        if (((PrincipeMacaco)atacante).isCego()) {
            System.out.println(atacante.getNome() + " está cego e não consegue atacar!");
            return;
        }

        System.out.println(atacante.getNome() + " usou " + getNome() + "! Causando " + DANO_BASE + " de dano.");
        alvo.receberDano(DANO_BASE);
        int cura = random.nextInt(21);
        atacante.aumentarVida(cura);
        System.out.println(atacante.getNome() + " recuperou " + cura + " de vida com a Luz da Lua!");
    }
}
