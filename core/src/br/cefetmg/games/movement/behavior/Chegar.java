/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author aluno
 */
public class Chegar extends AlgoritmoMovimentacao{
    private static final char NOME = 'c';
    
    public Chegar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }
    
    protected Chegar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }
    
    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 alvo = new Vector3(super.alvo.getObjetivo());
        output.velocidade = alvo.sub(agente.posicao);
        
        if(output.velocidade.len()<30f){
            return new Direcionamento();
        }
        
        if(output.velocidade.len()>maxVelocidade){
            output.velocidade.nor().scl(maxVelocidade);
            agente.olharNaDirecaoDaVelocidade(alvo);
        }
        
        return output;
    }
    @Override
    public int getTeclaParaAtivacao() {
        return Input.Keys.C;
    }
}
