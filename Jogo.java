
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
        
        


        System.out.println();
    	System.out.println();
    	System.out.println();
    	System.out.println("*********************************************************");
        System.out.println("Bem vindo ao Jogo do Duelo das bananas escolha o seu lado e lute até o fim");
        System.out.println("*********************************************************");
        System.out.println();
    	System.out.println();
    	System.out.println();

    	System.out.println("Em tempos antigos, nas profundezas da Floresta Perfeita, viviam dois príncipes macacos, filhos do Rei Mico, soberano das Terras Férteis. Essas terras eram o paraíso dos primatas, com árvores frutíferas sempre carregadas, riachos cristalinos e sombra refrescante. No entanto, além da fronteira das montanhas, existiam as Planícies Áridas, um lugar seco e desolado, habitado apenas pelo vento e pelo calor insuportável.");
        try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Com a idade avançada do Rei Mico, chegou o momento de decidir quem entre seus dois filhos seria o próximo a governar. A escolha, no entanto, não seria simples, pois ambos os príncipes eram igualmente valentes e astutos. Então, o velho rei, em sua sabedoria, decretou uma competição única e tradicional em seu reino: o *Duelo das Bananas*. Nesse desafio, os dois príncipes deveriam enfrentar-se jogando bananas mágicas, concedidas pela Árvore Ancestral, em uma batalha épica pela coroa.");
        try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Aquele que demonstrasse melhor habilidade e estratégia nas arenas do Reino das Bananas seria coroado o novo Rei das Terras Férteis, governando a Floresta Perfeita e suas abundantes riquezas. O perdedor, por sua vez, seria exilado para as Planícies Áridas, condenado a vagar por um território sem vida e sem glória.");
        try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Assim, começa a jornada dos dois príncipes, entre os galhos e cipós da floresta, atirando bananas encantadas um no outro, em uma batalha pelo destino de seus futuros. Quem será o vencedor e quem será excomungado para as terras esquecidas? O destino da Floresta Perfeita está nas mãos (ou patas!) desses dois herdeiros da coroa.");
        try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Que a melhor banana vença!");
        try {
			Thread.sleep(7000);
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
