package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.*;

public class App {

	static List<Score> pontuacoes = new ArrayList<Score>();
	static List<Tema> temas = new ArrayList<>();

	public static void main(String[] args) {
		temas.add(new Tema("Objeto"));
		temas.add(new Tema("Animal"));
		temas.get(1).cadastrarPalavra("Cachorro");
		temas.get(0).cadastrarPalavra("Colher");
		menu();
	}
	
	public static void menu() {
		int escolha = Integer.valueOf(JOptionPane.showInputDialog("		MENU \n 1- Jogar \n 2- Cadastrar palavra\n"
				+ " 3- Cadastrar tema\n 4- HighScores\n 5- Sair"));

		switch (escolha) {
			case 1:
				Rodada rodada = new Rodada(temas.get(1));
				rodada.iniciarRodada();
				while (true) {
					rodada.palpite(JOptionPane.showInputDialog(null, rodada.getBoneco().getCorpo() + "\n" + rodada.getPalavras() + "\nDigite um palpite: "));
				}

			case 2:
				String mensagem = "";
				for (int i = 0; i < temas.size(); i++) {
					mensagem += (i + 1) + " - " + temas.get(i).getNome() + "\n";
				}

				int opcaoTema = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem + "\n Escolha um tema: "));
				temas.get(opcaoTema - 1).cadastrarPalavra(JOptionPane.showInputDialog(null, "Digite a palavra a ser cadastrada nesse tema: "));
				JOptionPane.showMessageDialog(null, "Palavra adicionada com sucesso!");
				break;

			case 3:

			case 4:
				Score score = new Score();
				JOptionPane.showMessageDialog(null, score.exibir_higscores(pontuacoes));
				menu();

			case 5:

				break;
			default:
				break;
		}
	}
}
