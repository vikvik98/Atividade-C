package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tema {

    private String nome;
    private List<Palavra> palavraList = new ArrayList<>();
    private List<Palavra> palavrasSortiadas = new ArrayList<>();

    public Tema(String nome) {
        this.nome = nome;
    }

    public void cadastrarPalavra(String palavra){
        Palavra palavra1 = new Palavra(palavra);
        palavraList.add(palavra1);
    }

    public List<Palavra> sortearPalavra(){
        Random random = new Random();
        List<Palavra> auxPalavras = palavraList;
        int quantidadePalavrasSorteadas =  (1 + random.nextInt(2));
        if(quantidadePalavrasSorteadas > auxPalavras.size()){
            quantidadePalavrasSorteadas = auxPalavras.size();
        }
        for(int i = 0; i < quantidadePalavrasSorteadas; i++){
            int quantidadePalavras = auxPalavras.size();
            int indexPlavras = random.nextInt(quantidadePalavras);
            palavrasSortiadas.add(auxPalavras.get(indexPlavras));
            auxPalavras.remove(indexPlavras);
        }

        return palavrasSortiadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Palavra> getPalavraList() {
        return palavraList;
    }

    public void setPalavraList(List<Palavra> palavraList) {
        this.palavraList = palavraList;
    }
}
