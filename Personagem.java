
package rpg3;

import java.util.ArrayList;
import java.util.Random;

public class Personagem {
    private String nome;  // Encapsulated the attribute
    private int vida;
    protected ArrayList<Habilidade> habilidades = new ArrayList<>();
    public Random random = new Random();  // Keeping random protected so subclasses can access

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    // Getter and Setter methods to protect access to private fields
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void receberDano(int dano) {
        vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void aumentarVida(int pontos) {
        vida += pontos;
    }

    // Method for adding skills (habilidades)
    public void adicionarHabilidade(Habilidade habilidade) {
        getHabilidades().add(habilidade);
    }

    // Use a specific skill by index
    public void usarHabilidade(int indice, Personagem alvo) {
        if (indice < 0 || indice >= getHabilidades().size()) {
            System.out.println("Habilidade inválida!");
            return;
        }
        getHabilidades().get(indice).usar(this, (PrincipeMacaco)alvo);  // Polymorphism in action
    }

    public void mostrarStatus() {
        System.out.println(nome + " - Vida: " + vida);
    }

	public ArrayList<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
}
