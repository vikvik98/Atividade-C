package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import jdk.nashorn.internal.scripts.JO;
import model.*;

public class App {

	static List<Score> pontuacoes = new ArrayList<Score>();
	static List<Tema> temas = new ArrayList<>();

	public static void main(String[] args) {
		temas.add(new Tema("Objeto"));
		temas.add(new Tema("Animal"));
		temas.get(1).cadastrarPalavra("Cachorro");
		temas.get(1).cadastrarPalavra("Gato");
		temas.get(1).cadastrarPalavra("Rato");
		temas.get(0).cadastrarPalavra("Colher");
		temas.get(0).cadastrarPalavra("Mesa");
		temas.get(0).cadastrarPalavra("Cadeira");
		menu();
	}
	
	public static void menu() {
		int escolha = Integer.valueOf(JOptionPane.showInputDialog("		MENU \n 1- Jogar \n 2- Cadastrar palavra\n"
				+ " 3- Cadastrar tema\n 4- HighScores\n 5- Sair"));

		switch (escolha) {
			case 1:
				Random random = new Random();
				int num = random.nextInt(temas.size());
				Rodada rodada = new Rodada(temas.get(num));
				rodada.iniciarRodada();
				JOptionPane.showMessageDialog(null,rodada.getTema());

				while (!rodada.isAcabou()){
					rodada.palpite(JOptionPane.showInputDialog(null, rodada.getBoneco().getCorpo() + "\n" + rodada.getErradas() + "\n" + rodada.getPalavras() + "\nDigite um palpite: "));
				}
				if (rodada.isGanhou()){
					JOptionPane.showMessageDialog(null, "Parabéns, voce venceu!");
				}else{
					JOptionPane.showMessageDialog(null, "Infelizmente voce perdeu!");
				}
				Score score = new Score(rodada.getScore(),JOptionPane.showInputDialog(null,"Digite seu nome: "));
				score.rankeado(pontuacoes,score);
				menu();
				break;

			case 2:
				String mensagem = "";
				for (int i = 0; i < temas.size(); i++) {
					mensagem += (i + 1) + " - " + temas.get(i).getNome() + "\n";
				}

				int opcaoTema = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem + "\n Escolha um tema: "));
				temas.get(opcaoTema - 1).cadastrarPalavra(JOptionPane.showInputDialog(null, "Digite a palavra a ser cadastrada nesse tema: "));
				JOptionPane.showMessageDialog(null, "Palavra adicionada com sucesso!");
				menu();
				break;

			case 3:
				Tema tema = new Tema(JOptionPane.showInputDialog(null, "Digite o nome do novo tema: "));
				temas.add(tema);
				menu();
				break;

			case 4:
				Score x = new Score();
				JOptionPane.showMessageDialog(null, x.exibir_higscores(pontuacoes));
				menu();

			case 5:

				break;
			default:
				break;
		}
	}
}
