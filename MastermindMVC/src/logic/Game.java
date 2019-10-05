/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import controllers.ProposedCombinationController;
import controllers.ResumeController;
import controllers.StartController;
import java.util.ArrayList;
import java.util.List;
import views.ConsoleView;
import views.ResumeView;
import views.View;

/**
 *
 * @author Gabri
 */
public class Game {
    private ConsoleView console = new ConsoleView();
    private static final int MAX_LONG = 10;
    private StartController secretCombination;
    private List<ProposedCombinationController> proposedCombinations;
    private List<ResumeController> results;

	public Game() {
		this.clear();
	}

	private void clear() {
		this.secretCombination = new StartController();
		this.proposedCombinations = new ArrayList<ProposedCombinationController>();
		this.results = new ArrayList<ResumeController>();
	}

	public void play() {
		View.Message.TITLE.writeln();
		this.secretCombination.writeln();
		do {
			do {
				ProposedCombinationController proposedCombination = new ProposedCombinationController();
				proposedCombination.read();
				this.proposedCombinations.add(proposedCombination);
				this.results.add(this.secretCombination.getResult(proposedCombination));
				this.writelnS();
			} while (!isFinished());
		} while (this.isResumed());
	}

	private void writelnS() {
		this.console.writeln();
		View.Message.ATTEMPTS.writeln(this.getAttemps());
		this.secretCombination.writeln();
		for (int i = 0; i < this.getAttemps(); i++) {
			this.proposedCombinations.get(i).write();
			this.results.get(i).writeln();
		}
	}

	private boolean isFinished() {
		if (this.results.get(this.getAttemps() - 1).isWinner()) {
			View.Message.WINNER.writeln();
			return true;
		}
		if (this.getAttemps() == MAX_LONG) {
			View.Message.LOOSER.writeln();
			return true;
		}
		return false;
	}

	private int getAttemps() {
		return this.proposedCombinations.size();
	}

	private boolean isResumed() {
		boolean resumed;
		View.Message.RESUME.write();
		resumed = new ResumeView().read();
		if (resumed) {
			this.clear();
		}
		return resumed;
	} 
}
