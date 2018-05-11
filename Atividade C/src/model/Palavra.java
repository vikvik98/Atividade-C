package model;

public class Palavra {

    private String nome;
    private char [] palavraEscondida;
    private int contTracos;

    public Palavra(String nome) {
        this.nome = nome;
        this.palavraEscondida = gerarPalavraEscondida();
        this.contTracos = 0;
    }


    public boolean verificaLetra(char letra, int pos) {
        if (palavraEscondida [pos] == '-'){
            return letra == nome.charAt(pos);
        }else if (String.valueOf(letra).toLowerCase().equals(String.valueOf(palavraEscondida[pos]).toLowerCase())) {
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
            if (palavraEscondida [i] == '-'){
                contTracos++;
            }

            if (palavra.toLowerCase().charAt(i) != nome.toLowerCase().charAt(i)){
                acertou = false;
                contTracos = 0;
                break;
            }

        }
        return acertou;
    }

    public void preencherPalavraEscondida(){
        for (int i = 0; i < nome.length(); i++){
            contTracos = 0;
            palavraEscondida [i] = nome.charAt(i);
        }
    }

    public char [] gerarPalavraEscondida(){
        palavraEscondida = new char[nome.length()];
        for (int i = 0; i < this.nome.length(); i++){
            palavraEscondida [i] = '-';
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

    public int getContTracos() {
        return contTracos;
    }
}
