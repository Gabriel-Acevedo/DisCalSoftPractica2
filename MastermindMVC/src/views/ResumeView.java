/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author Gabri
 */
public class ResumeView extends ConsoleView{
    
    private ConsoleView console = new ConsoleView();
    private static final char AFIRMATIVE = 'y';

    private static final char NEGATIVE = 'n';
	
    private static final String QUESTION = "? ("+ResumeView.AFIRMATIVE+"/"+ResumeView.NEGATIVE+"): ";

    private static final String MESSAGE = "The value must be '" + ResumeView.AFIRMATIVE + "' or '"+ ResumeView.NEGATIVE + "'";

    public boolean read() {
        char answer;
	boolean ok;
	do {
        	answer = this.console.readChar(ResumeView.QUESTION);
		ok = ResumeView.isAfirmative(answer) || ResumeView.isNegative(answer);
		if (!ok) {
			this.console.writeln(ResumeView.MESSAGE);
		}
	} while (!ok);
	return ResumeView.isAfirmative(answer);
    }

    private static boolean isAfirmative(char answer) {
	return Character.toLowerCase(answer) == ResumeView.AFIRMATIVE;
    }

    private static boolean isNegative(char answer) {
    	return Character.toLowerCase(answer) == ResumeView.NEGATIVE;
    }
    
}
