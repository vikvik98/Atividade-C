package model;

public class Palavra {

    private String nome;
    private char [] palavraEscondida;
    //variavel pra saber se eu ja acertei ou nao a palavra. - RODADA -

    public Palavra(String nome) {
        this.nome = nome;
        this.palavraEscondida = gerarPalavraEscondida();
    }

    //TODO: Boneco.
    //TODO: voltar as palavras escondidas.

    public boolean verificaLetra(char letra, int pos) {
        if (palavraEscondida [pos] == '_'){
            return letra == nome.charAt(pos);
        }else if (letra == palavraEscondida [pos]){
            throw new IllegalArgumentException();
        }else{
            return false;
        }
    }

    public void preencherLetraEscondida(char letra, int pos){
        palavraEscondida [pos] = letra;
    }

    public boolean verificaPalavra(String palavra){
        boolean acertou = true;
        for (int i = 0; i < palavra.length(); i++){
            if (palavra.charAt(i) != nome.charAt(i)){
                acertou = false;
                break;
            }
        }
        return acertou;
    }

    public void preencherPalavraEscondida(){
        for (int i = 0; i < nome.length(); i++){
            palavraEscondida [i] = nome.charAt(i);
        }
    }

    public char [] gerarPalavraEscondida(){
        palavraEscondida = new char[nome.length()];
        for (int i = 0; i < this.nome.length(); i++){
            palavraEscondida [i] = '_';
        }
        return palavraEscondida;
    }

    public String getPalavraEscondida(){
        String escondida = "";
        for (int i = 0; i < nome.length(); i++){
            escondida += palavraEscondida [i];
        }
        return escondida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
