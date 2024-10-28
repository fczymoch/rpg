
package rpg3;

public abstract class Habilidade {
    private String nome;  // Encapsulated attribute
    private String descricao;

    public Habilidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    // Abstract method that will be implemented by specific skills (polymorphism)
    public abstract void usar(Personagem atacante, Personagem alvo);
}
