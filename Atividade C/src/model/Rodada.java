package model;

public class Rodada {

    private Palavra palavra;
    private StringBuilder palavraEscondida;

    public Rodada(Palavra frase) {
        this.palavra = frase;
        this.palavraEscondida = palavra.gerarPalavraEscondida();
    }

    public boolean palpite(String palpite){
        if (palpite.length() > 1){
            //TODO: palpite tem que ter mesmo tamanho que palavra;
            if (palavra.verificaPalavra(palpite)){
                return true;
            }
        }else{
            if (palavra.verificaLetra(palpite.charAt(0))){
                for (int i = 0; i < palavra.getNome().length(); i++){
                    if (palpite.charAt(0) == palavra.getNome().charAt(i)){
                        palavraEscondida = palavra.gerarPalavraEscondida(palavraEscondida,palpite.charAt(0),i);
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
