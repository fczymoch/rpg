package rpg3.habilidades;

import rpg3.Personagem;

public abstract class BananaMagica implements Item {
    private int dano;

    public BananaMagica(int dano) {
        this.dano = dano;
    }

    public void usar(Personagem alvo) {
        alvo.receberDano(dano);
        System.out.println("A banana mágica causa " + dano + " de dano em " + alvo.getNome() + "!");
    }

    @Override
    public String getNome() {
        return "Banana Mágica";
    }
}

