package mission_manager;

import mission_manager.types.MissionLevel;

import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


public class manager {


    private static int getUserOption(int max_option) throws IOException {
        DataInputStream r = new DataInputStream(System.in);
        String consoleInput;

        while (true) {
            System.out.print("- Digite uma opção numérica: ");
            consoleInput = r.readLine();

            if (consoleInput.matches("\\d+")) {
                int userOption = Integer.parseInt(consoleInput);
                if(userOption <= max_option) {
                    return userOption;
                }
                System.out.println("Entrada inválida! Opção não encontrada.");
            } else {
                System.out.println("Entrada inválida! Por favor, digite apenas números.");
            }
        }
    }

    public static void main(String[] args) throws IOException {


        // Ninjas
        Ninja[] ninjas = new Ninja[3];

        ninjas[0] = new Ninja("Naruto", 17);
        ninjas[1] = new Ninja("Shikamaru", 17);
        ninjas[2] = new Ninja("Sarada", 12);

        // Missões disponíveis
        Missao[] missoes = new Missao[5];

        missoes[0] = new Missao("Escolta do Comerciante de Chá", MissionLevel.D, false);
        missoes[1] = new Missao("Recuperação do Pergaminho Roubado", MissionLevel.C, false);
        missoes[2] = new Missao("Proteção da Ponte Tenchi", MissionLevel.A, false);
        missoes[3] = new Missao("Investigação do Desaparecimento na Floresta da Morte", MissionLevel.B, false);
        missoes[4] = new Missao("Neutralização do Ninja Renegado Akuma", MissionLevel.S, false);

        int option;
        do {
            printMenu();
            option = getUserOption(2);
            switch (option) {
                case 1:
                    printNinjas(ninjas, false);
                    break;
                case 2:
                    mission_assignment_flux(missoes, ninjas);
                    break;
                case 0:
                    System.out.println("Encerrando aplicação ...");
                    break;
                default:
                    System.out.println("Entrada inválida! Opção não encontrada.");
                    break;
            }
        } while (option != 0);


    }

    private static void printMenu() {
        System.out.println("- Menu -");
        System.out.println("1 - ver ninjas");
        System.out.println("2 - atribuir missão");
    }

    private static void printNinja(Ninja ninja) {
        System.out.printf("Ninja: %s | Idade: %d | Missão: %s%n", ninja.nome, ninja.idade, ninja.getMission());
    }

    private static void printNinjas(Ninja[] ninjas, boolean selectable) {
        if(selectable) {
            for (int i = 0; i < ninjas.length; i++) {
                Ninja ninja = ninjas[i];
                System.out.printf("%d - Ninja: %s | Idade: %d | Missão: %s%n", (i + 1), ninja.nome, ninja.idade, ninja.getMission());
            }
        } else {
            for (Ninja ninja : ninjas) {
                System.out.printf("Ninja: %s | Idade: %d | Missão: %s%n", ninja.nome, ninja.idade, ninja.getMission());
            }
        }
    }

    private static void printMission(Missao missao) {
        System.out.printf("Missão: %s | Nível: %s%n", missao.nome_da_missao, missao.nivel);
    }

    private static void printMissions(Missao[] missoes, boolean selectable) {
        if(selectable){
            for (int i = 0; i < missoes.length; i++) {
                Missao missao = missoes[i];
                System.out.printf("%d - Missão: %s | Nível: %s%n", (i + 1), missao.nome_da_missao, missao.nivel);
            }
        } else {
            for (Missao missao : missoes){
                System.out.printf("Missão: %s | Nível: %s%n", missao.nome_da_missao, missao.nivel);
            }
        }
    }

    private static void mission_assignment_flux(Missao[] missoes, Ninja[] ninjas) throws IOException {
        System.out.println("- Selecione uma missão - ");
        printMissions(missoes, true);
        int missao_selecionada = getUserOption(missoes.length) - 1;

        System.out.println("- Selecione um ninja - ");
        printMission(missoes[missao_selecionada]);
        printNinjas(ninjas, true);

        int ninja_selecionado = getUserOption(ninjas.length) - 1;

        String message = ninjas[ninja_selecionado].setMissao(missoes[missao_selecionada]);
        System.out.println(message);
    }
}
