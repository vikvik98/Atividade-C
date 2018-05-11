package model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Score {

	private int pontuacao;
	private String nome;
	
	
	//ONDE DEVE FICAR A LISTA DOS MELHORES SCORES SALVOS.
	//static List<Score> pontuacoes = new ArrayList<Score>(); --> ISSO DEVE FICAR NA CLASSE PRINCIPAL(APP)!!!
	
	public Score(int pontuacao, String nome){
		this.nome = nome;
		this.pontuacao = pontuacao;
		
	}
	
	
	public Score() {
		// TODO Auto-generated constructor stub
	}


	public List<Score> rankeado(List<Score> ranking, Score pontuacao){
		
		if(ranking.size() < 9){
			ranking.add(pontuacao);
		}
		
		else{
			
			if(pontuacao.getPontuacao() > ranking.get(9).getPontuacao()){
				ranking.set(9, pontuacao);
				
			}
			
		}
		
		//Ordenar a pontuao do ranking
		if (ranking.size() > 1){
			Score aux;
			
			for(int i = 0; i<ranking.size(); i++){
				for(int j = 0; j<ranking.size()-1; j++){
					if(ranking.get(j).getPontuacao() > ranking.get(j + 1).getPontuacao()){
						aux = ranking.get(j);
						ranking.set(j, ranking.get(j + 1));
						ranking.set(j + 1, aux);
					}
				}
			}
		
		}
		
		return ranking;
		
	}
	
	public String exibir_higscores(List<Score> pontuacoes){
		String listaHighScore = "----HIGHSCORES----\n";
		
			if(pontuacoes.size() > 0){
				System.out.println("entrou");
			
				for(int i = 0; i < pontuacoes.size(); i++){
					listaHighScore += i + "-" + pontuacoes.get(i).getNome() + "	Score: " + pontuacoes.get(i).getPontuacao()+"\n";
				}	
			}
		return listaHighScore;
	}
	
	public int calculaPonto(int tracos){
		int pontos = (tracos * 15) + 100;
		return pontos;
		
	}


	public int getPontuacao() {
		return pontuacao;
	}


	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
}
