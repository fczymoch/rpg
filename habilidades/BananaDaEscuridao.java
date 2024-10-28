
package rpg3.habilidades;

import rpg3.Habilidade;
import rpg3.Personagem;
import rpg3.PrincipeMacaco;

public class BananaDaEscuridao extends Habilidade {
    private static final int DANO_BASE = 30;

    public BananaDaEscuridao() {
        super("Banana da Escuridão", "Uma banana mágica que causa dano e pode cegar o oponente.");
    }

    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int dano = DANO_BASE;
        System.out.println(atacante.getNome() + " lançou " + getNome() + "! Causando " + dano + " de dano.");
        alvo.receberDano(dano);
        
        if (((PrincipeMacaco)atacante).random.nextDouble() < 0.3) { // 30% de chance de cegar o oponente
            System.out.println(alvo.getNome() + " foi cegado e terá dificuldade em acertar o próximo ataque.");
           // alvo.setCego(true);
        }
    }


}
