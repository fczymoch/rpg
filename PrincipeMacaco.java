
package rpg3;

import rpg3.habilidades.BananaDaEscuridao;
import rpg3.habilidades.BananaDeCura;
import rpg3.habilidades.BananaMagica;
import rpg3.habilidades.BananaRefrescante;
import rpg3.habilidades.Diluvio;
import rpg3.habilidades.GotaCongelante;
import rpg3.habilidades.LuzDaLua;
import rpg3.habilidades.Mergulho;
import rpg3.habilidades.SoproDaNoite;

public class PrincipeMacaco extends Personagem {
    private String titulo;  // Added encapsulation for title
    private boolean cego = false;  // Status flags
    private boolean negaDano = false;

    public PrincipeMacaco(String nome, int vida, String titulo) {
        super(nome, vida);
        this.titulo = titulo;
        adicionarHabilidades();
    }

    // Getter and Setter methods for encapsulation
    public String getTitulo() {
        return titulo;
    }

    // Example of skill - Banana da Escuridão
    public void bananaDaEscuridao(Personagem alvo) {
        int dano = 30;
        System.out.println(getNome() + " lançou a Banana da Escuridão! Causando " + dano + " de dano.");
        alvo.receberDano(dano);
        if (random.nextDouble() < 0.3) {
            System.out.println(alvo.getNome() + " foi cegado e terá dificuldade em acertar o próximo ataque.");
            //alvo.setCego(true);
        }
    }

    @Override
    public void receberDano(int dano) {
        if (negaDano) {
            System.out.println(getNome() + " negou o dano do próximo ataque!");
            negaDano = false;
        } else {
            super.receberDano(dano);
        }
    }

    public void negarDano() {
        System.out.println(getNome() + " está preparado para negar o dano do próximo ataque!");
        negaDano = true;
    }

    public void cura(int pontos) {
        System.out.println(getNome() + " usou cura! Recuperou " + pontos + " pontos de vida.");
        aumentarVida(pontos);
    }

    // Additional methods to set and get status effects (blindness and damage negation)
    public void setCego(boolean cego) {
        this.cego = cego;
    }

    public boolean isCego() {
        return cego;
    }

    public boolean isNegandoDano() {
        return negaDano;
    }

    public void mostrarStatus() {
        super.mostrarStatus();
        System.out.println("Título: " + titulo);
        if (cego) {
            System.out.println(getNome() + " está cego!");
        }
        if (negaDano) {
            System.out.println(getNome() + " está preparado para negar dano!");
        }
    }
    
    public void listarHabilidades() {
        System.out.println(getNome() + " (" + titulo + ") possui as seguintes habilidades:");
        for (int i = 0; i < getHabilidades().size(); i++) {
            Habilidade habilidade = getHabilidades().get(i);
            System.out.println((i + 1) + ". " + habilidade.getNome() + " - " + habilidade.getDescricao());
        }
    }

    // Método para o oponente usar uma habilidade aleatória
    public void habilidadeAleatoria(Personagem alvo) {
        int indice = random.nextInt(getHabilidades().size());
        Habilidade habilidadeAleatoria = getHabilidades().get(indice);
        System.out.println(getNome() + " usou " + habilidadeAleatoria.getNome() + "!");
        habilidadeAleatoria.usar(this, alvo);
    }

    private void adicionarHabilidades() {
        if (titulo.equals("Príncipe das Sombras")) {
            habilidades.add(new BananaDaEscuridao());
            habilidades.add(new BananaDeCura()); // Habilidade de cura
            habilidades.add(new SoproDaNoite());
            habilidades.add(new LuzDaLua());
        } else if (titulo.equals("Príncipe das Águas")) {
            habilidades.add(new Mergulho());
            habilidades.add(new GotaCongelante());
            habilidades.add(new BananaRefrescante()); // Habilidade de cura
            habilidades.add(new Diluvio());
        }
    }
}
