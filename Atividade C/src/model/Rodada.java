package model;

import java.util.ArrayList;
import java.util.List;

public class Rodada {

    private Palavra palavra;
    private StringBuilder palavraEscondida;
    private int contErros = 0;
    private Tema tema;
    private List<Palavra> palavraList ;

    public Rodada(Palavra frase, Tema tema) {
        this.palavra = frase;
        this.palavraEscondida = palavra.gerarPalavraEscondida();
        this.tema = tema;
        palavraList = tema.sortearPalavra();
    }


    public boolean palpite(String palpite){

        if (palpite.length() > 1){
            if (palavra.verificaPalavra(palpite)){
                return true;
            }else{
                contErros = 5;
            }
        }else{
            if (palavra.verificaLetra(palpite.charAt(0))){
                for (int i = 0; i < palavra.getNome().length(); i++){
                    if (palpite.charAt(0) == palavra.getNome().charAt(i)){
                        palavraEscondida = palavra.gerarPalavraEscondida(palavraEscondida,palpite.charAt(0),i);
                        return true;
                    }
                }
            }else{
                contErros++;
            }
        }
        return false;
    }


}
