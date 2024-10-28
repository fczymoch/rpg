
package rpg3;

import java.util.Scanner;

public class Jogo {
    private PrincipeMacaco jogador;
    private PrincipeMacaco oponente;
    private int turnos = 0;

    public Jogo() {
        escolhaPersonagem();
        oponente = jogador.getNome().equals("Kiko") ? 
                new PrincipeMacaco("Bobo", 100, "Príncipe das Águas") : 
                new PrincipeMacaco("Kiko", 100, "Príncipe das Sombras");
    }

    private void escolhaPersonagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Escolha seu personagem:");
        System.out.println("1. Kiko, Príncipe das Sombras - Habilidades: Ataque das Sombras, Evasão Sombria, Banana da Escuridão, Fúria das Sombras, Recarga Sombria.");
        System.out.println("2. Bobo, Príncipe das Águas - Habilidades: Onda Curativa, Banana Aquática, Dilúvio, Escudo de Água, Sopro Vital.");

        int escolha = scanner.nextInt();
        if (escolha == 1) {
            jogador = new PrincipeMacaco("Kiko", 100, "Príncipe das Sombras");
        } else if (escolha == 2) {
            jogador = new PrincipeMacaco("Bobo", 100, "Príncipe das Águas");
        } else {
            System.out.println("Escolha inválida, personagem padrão selecionado: Kiko");
            jogador = new PrincipeMacaco("Kiko", 100, "Príncipe das Sombras");
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        while (jogador.getVida() > 0 && oponente.getVida() > 0) {
            System.out.println("\nTurno " + (++turnos) + "!");
            System.out.println("Vida de " + jogador.getNome() + ": " + jogador.getVida());
            System.out.println("Vida de " + oponente.getNome() + ": " + oponente.getVida());

            // Jogador escolhe a habilidade
            System.out.println("Escolha uma habilidade:");
            jogador.listarHabilidades();

            int escolha;
            while (true) {
                try {
                    System.out.print("Digite o número da habilidade: ");
                    escolha = Integer.parseInt(scanner.nextLine()) - 1;
                    if (escolha >= 0 && escolha < jogador.getHabilidades().size()) {
                        break;
                    } else {
                        System.out.println("Escolha inválida. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número.");
                }
            }

            // O jogador usa a habilidade escolhida
            jogador.usarHabilidade(escolha, oponente);

            // O oponente usa uma habilidade aleatória
            oponente.habilidadeAleatoria(jogador);

            // Exibir status após o turno
            jogador.mostrarStatus();
            oponente.mostrarStatus();
            
            try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }

        // Final do jogo
        if (jogador.getVida() > 0) {
        	System.out.println();
        	System.out.println();
        	System.out.println();
        	System.out.println("*********************************************************");
            System.out.println(jogador.getNome() + " venceu após " + turnos + " turnos!");
            System.out.println("*********************************************************");
        } else {
        	System.out.println();
        	System.out.println();
        	System.out.println();
        	System.out.println("*********************************************************");
            System.out.println(jogador.getNome() + " venceu após " + turnos + " turnos!");
            System.out.println("*********************************************************");
        }
        
        scanner.close();
    }
}
