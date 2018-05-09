package model;

public class Palavra {

    private String nome;

    public Palavra(String nome) {
        this.nome = nome;
    }

    public boolean verificaLetra(char letra){
        for (int i = 0; i < nome.length(); i++){
            if (letra == nome.charAt(i)){
                return true;
            }
        }
        return false;
    }

    public boolean verificaPalavra(String palavra){
        boolean acertou = true;
        for (int i = 0; i < nome.length(); i++){
            if (palavra.charAt(i) != nome.charAt(i)){
                acertou = false;
                break;
            }
        }
        return acertou;
    }

    public StringBuilder gerarPalavraEscondida(){
        StringBuilder palavraEscondida = new StringBuilder();
        for (int i = 0; i < this.nome.length(); i++){
            palavraEscondida.append('-');
        }
        return palavraEscondida;
    }

    public StringBuilder gerarPalavraEscondida(StringBuilder palavra, char letra, int posicao){
        StringBuilder palavraEscondida = new StringBuilder();
        for (int i = 0; i < palavra.length(); i++){
            if (i == posicao) {
                palavraEscondida.append(letra);
            }else{
                palavraEscondida.append(palavraEscondida.charAt(i));
            }
        }
        return palavraEscondida;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
