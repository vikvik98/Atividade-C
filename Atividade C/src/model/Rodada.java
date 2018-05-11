package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Rodada {

    private int contErros;
    private List<Palavra> palavraList;
    private List<Palavra> palavraListAux;
    private Boneco boneco;
    private boolean ganhou;
    private boolean acabou;
    private String erradas;

    public Rodada(Tema tema) {
        this.palavraList = tema.sortearPalavra();
        this.palavraListAux = this.palavraList;
        this.erradas = "";
        this.acabou = false;
        this.contErros = 0;
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

    public void palpite(String palpite) {
        boolean acertou = false;
        for (int i = 0; i < palavraList.size(); i++) {

            if (palpite.length() > 1) {
                if (palpite.length() == palavraList.get(i).getNome().length()){
                    if (palavraList.get(i).verificaPalavra(palpite)) {
                        palavraList.get(i).preencherPalavraEscondida();
                        acertou = true;
                    }
                }else {
                    contErros = 6;
                }
            }else{
                for (int j = 0; j < palavraList.get(i).getNome().length(); j++) {
                    try{
                        if (palavraList.get(i).verificaLetra(palpite.charAt(0), j)){
                            palavraList.get(i).preencherLetraEscondida(palpite.charAt(0), j);
                            acertou = true;
                        }

                    }catch (IllegalArgumentException e){
                        acertou = true;
                        JOptionPane.showMessageDialog(null, "Letra já digitada!");
                    }
                }

                if ( !acertou){
                    if (!erradas.contains(palpite)){
                        erradas += palpite.charAt(0);
                    }

                }

            }

            if (palavraList.get(i).getNome().equals(palavraList.get(i).getPalavraEscondida()) && palavraListAux.get(i) != null){
                palavraListAux.remove(i);
                //remover da lista de palavras pois se nao sempre vai contar.
            }

            if (palavraListAux.size() == 0){
                ganhou = true;
                finalizar();
            }else if (contErros == 5){
                ganhou = false;
                finalizar();
            }

        }

        if (!acertou){
            contErros++;
            boneco.preencherBoneco(contErros);
        }
    }

    private void finalizar() {
        acabou = true;
    }


    public String getPalavras(){
        String retorno = "";
        for (int i = 0; i < palavraList.size(); i++){
            retorno += palavraList.get(i).getPalavraEscondida() + "\n";
        }
        return retorno;
    }

    public boolean isAcabou() {
        return acabou;
    }

    public String getErradas() {
        return erradas;
    }

    public boolean isGanhou() {
        return ganhou;
    }
}
