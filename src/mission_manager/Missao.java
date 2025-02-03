package mission_manager;

import mission_manager.types.MissionLevel;

public class Missao {

    String nome_da_missao;
    MissionLevel nivel;
    boolean concluida;

    public Missao (String nome_da_missao, MissionLevel nivel, boolean concluida){
        this.nome_da_missao = nome_da_missao;
        this.nivel = nivel;
        this.concluida = concluida;
    }

    public boolean isStarter(){
        return (nivel == MissionLevel.D || nivel == MissionLevel.C);
    }
}
