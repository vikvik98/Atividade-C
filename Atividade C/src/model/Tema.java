package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tema {

    private String nome;
    private List<Palavra> palavraList = new ArrayList();

    public Tema(String nome) {
        this.nome = nome;
    }

    public void cadastrarPalavra(String palavra){
        Palavra palavra1 = new Palavra(palavra);
        palavraList.add(palavra1);
    }

    public Palavra sortearPalavra(){
        int quantidadePalavras = palavraList.size();
        Random random = new Random();
        int indexPlavras = random.nextInt(quantidadePalavras);
        return palavraList.get(indexPlavras);
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
