package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tema {

    private String nome;
    private List<Palavra> palavraList = new ArrayList<>();
    private Palavra palavraSortiada;
    private List<Palavra> auxPalavras = new ArrayList<>();
    private List<Palavra> palavras = new ArrayList<>();
    Random random = new Random();
    int quantidadePalavrasSorteadas = 0;

    public Tema(String nome) {
        this.nome = nome;
        this.sortearQuantidadeDePalavras();
    }

    public void cadastrarPalavra(String palavra){
        Palavra palavra1 = new Palavra(palavra);
        palavraList.add(palavra1);
    }
    
    public List<Palavra> sortearQuantidadeDePalavras(){
    	quantidadePalavrasSorteadas =  (1 + random.nextInt(2));
        if(quantidadePalavrasSorteadas > palavraList.size()){
            quantidadePalavrasSorteadas = palavraList.size();
            for (int i = 0; i < quantidadePalavrasSorteadas; i++){
            	palavras.add(sortearPalavra());
            }
        }
		return palavras;
    }

    public Palavra sortearPalavra(){
    	
        
            int quantidadePalavras = palavraList.size();
            int indexPlavras = random.nextInt(quantidadePalavras);
            if(verificarPalavraSorteada(palavraList.get(indexPlavras))){
            	sortearPalavra();
            }
            palavraSortiada = palavraList.get(indexPlavras);
            //auxPalavras.remove(indexPlavras);
        

        return palavraSortiada;
    }
    
    public boolean verificarPalavraSorteada(Palavra palavra){
    	for(int i = 0; i < auxPalavras.size(); i++){
    		if(auxPalavras.get(i) == palavra){
    			return true;
    		}
    
    	}
    	return false;
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
