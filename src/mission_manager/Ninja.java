package mission_manager;

public class Ninja {

    public String nome;
    public int idade;
    private Missao missao;

    public Ninja (String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String setMissao (Missao new_mission) {
        if(!new_mission.isStarter() && !isOldEnough(this.idade)){
            return String.format("Missões de nível %s são muito perigosas para ninjas com menos de 15 anos.", new_mission.nivel);
        }

        this.missao = new_mission;
        return String.format("Missão: %s atribuída ao ninja: %s", new_mission.nome_da_missao, this.nome);
    }

    private boolean isOldEnough (int age) {
        return age >= 15;
    }

    public String getMission() {
        if (this.missao != null) {
            return this.missao.nome_da_missao;
        }
        return "Nenhuma missão atribuida.";

    }
}
