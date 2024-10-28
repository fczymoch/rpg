
package rpg3.habilidades;

import java.util.Random;

import rpg3.Habilidade;
import rpg3.Personagem;

public class BananaRefrescante extends Habilidade {
    private static final int CURA_BASE = 15;
    Random random = new Random();

    public BananaRefrescante() {
        super("Banana Refrescante", "Restaura a saúde do usuário com uma sensação refrescante.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " comeu " + getNome() + " e recuperou " + CURA_BASE + " pontos de vida.");
        atacante.aumentarVida(CURA_BASE);
        if(random.nextInt(11) == 1) {
        	System.out.println("Voce ativou o poder secreto da Banana refrescante e matou seu inimigo com usa refrescancia");
        	alvo.receberDano(999);
        	
        }
    }
}
