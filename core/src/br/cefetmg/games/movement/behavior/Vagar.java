package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import static java.lang.Math.random;

/**
 * Movimenta o agente em uma direção aleatória, vagando pelo cenário.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Vagar extends AlgoritmoMovimentacao {

    private static final char NOME = 'w';
    private float maxAngular = (float)(Math.PI * 2);

    public Vagar() {
        super(NOME);
    }

    public Vagar(float tangencial, float angular) {
        super(NOME);
        maxVelocidade = tangencial;
        maxAngular = angular;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();

        // calcula que direção tomar (configura um objeto Direcionamento 
        // e o retorna)
        // ...
        // super.alvo já contém a posição do alvo
        // agente (parâmetro) é a pose do agente que estamos guiando
        // ...
        output.velocidade = agente.getOrientacaoComoVetor().scl(maxVelocidade);
        output.rotacao = (random()-random())*maxAngular;
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.W;
    }
}
