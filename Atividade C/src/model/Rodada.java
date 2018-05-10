package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Rodada {

    private int contErros = 0;
    private List<Palavra> palavraList;
    private int contEnd;

    public Rodada(Tema tema) {
        this.palavraList = tema.sortearPalavra();
    }

    public void palpite(String palpite) {
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
                        }else{
                            contErros++;
                        }
                    }catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, "Letra já digitada!");
                    }
                }
            }

            //TODO: toda vez vai contar quando der um palpite
            if (palavraList.get(i).getNome().equals(palavraList.get(i).getPalavraEscondida())){
                contEnd++;
            }

            //TODO: oq fazer quando finalizar a rodada,
//            if (contEnd == palavraList.size()){
//
//            }
        }
    }
}
