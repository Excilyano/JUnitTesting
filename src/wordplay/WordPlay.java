package wordplay;

import java.util.Scanner;

import wordplay.bll.LettreManager;
import wordplay.bo.Lettre;

public class WordPlay {
	public static void main(String[] args) {
		System.out.println("Debut de la partie");
		
		LettreManager lm = new LettreManager();
		Lettre[] tirage = lm.pick(7);
		for (Lettre l : tirage) {
			System.out.print("[" + l.getL() + "] ");
		}
		System.out.println();
		
		Scanner scan;
		String saisie = null;
		do {
			System.out.println("Quel mot voulez-vous jouer ?");
			scan = new Scanner(System.in);
			
			saisie = scan.nextLine();
		} while (!lm.isValid(saisie));
		
		scan.close();
		int score = lm.wordValue(saisie);
		System.out.println("Vous avez joué : " + saisie + " pour un total de " + score + " points.");
		
		String botChoice = lm.botChoice();
		int botScore = lm.wordValue(botChoice);
		System.out.println("L'ordinateur a joué : " + botChoice + " pour un total de " + botScore + " points.");
	}
}
