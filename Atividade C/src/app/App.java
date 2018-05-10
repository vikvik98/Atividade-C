package app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Score;

public class App {
	
	static List<Score> pontuacoes = new ArrayList<Score>();
	
	public static void main(String[] args) {
		
		menu();
		
	}
	
	public static void menu(){
		int escolha = Integer.valueOf(JOptionPane.showInputDialog("		MENU \n 1- Jogar \n 2- Cadastrar palavra\n"
				+ " 3- Cadastrar tema\n 4- HighScores\n 5- Sair"));
		
		switch (escolha) {
		case 1:

		case 2:
			
		case 3:
			
		case 4:
			Score score = new Score();
			JOptionPane.showMessageDialog(null,score.exibir_higscores(pontuacoes));
			menu();
			
		case 5:
			
			break;
		default:
			break;
		}
		
	}
}
