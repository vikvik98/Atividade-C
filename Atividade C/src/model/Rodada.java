package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Rodada {

    private int contErros = 0;
    private List<Palavra> palavraList;
    private List<Palavra> palavraListAux;
    private Boneco boneco;
    private int contEnd;

    public Rodada(Tema tema) {
        this.palavraList = tema.sortearPalavra();
        this.palavraListAux = this.palavraList;
    }

    public Boneco getBoneco() {
        return boneco;
    }

    public void iniciarRodada(){
        for (Palavra aPalavraList : palavraList) {
            aPalavraList.gerarPalavraEscondida();
        }
        boneco = new Boneco();
        boneco.preencherBoneco(contErros);
    }

    public int getContEnd() {
        return contEnd;
    }

    public void palpite(String palpite) {
        boolean acertou = false;
        for (int i = 0; i < palavraList.size(); i++) {

            if (palpite.length() > 1) {
                if (palpite.length() == palavraList.get(i).getNome().length()){
                    if (palavraList.get(i).verificaPalavra(palpite)) {
                        palavraList.get(i).preencherPalavraEscondida();
                    }
                }else {
                    contErros = 5;
                }
            }else{
                for (int j = 0; j < palavraList.get(i).getNome().length(); j++) {
                    try{
                        if (palavraList.get(i).verificaLetra(palpite.charAt(0), j)){
                            palavraList.get(i).preencherLetraEscondida(palpite.charAt(0), j);
                            acertou = true;
                        }else{
                            acertou = false;
                            contErros++;
                        }
                    }catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, "Letra já digitada!");
                    }
                }
            }

            //TODO: toda vez vai contar quando der um palpite
            if (palavraList.get(i).getNome().equals(palavraList.get(i).getPalavraEscondida()) && palavraListAux.get(i) != null){
                palavraListAux.remove(i);
                //remover da lista de palavras pois se nao sempre vai contar.
                contEnd++;
            }

            //TODO: oq fazer quando finalizar a rodada,
//            if (contEnd == palavraList.size()){
//
//            }
        }

        if (!acertou){
            contErros++;
            boneco.preencherBoneco(contErros);
        }
    }

    public String getPalavras(){
        String retorno = "";
        for (int i = 0; i < palavraList.size(); i++){
            retorno += palavraList.get(i).getPalavraEscondida();
        }
        return retorno;
    }
}
