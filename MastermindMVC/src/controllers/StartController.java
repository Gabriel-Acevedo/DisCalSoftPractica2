/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 *
 * @author Gabri
 */
public class StartController extends Controller{
    
    public StartController() {
		for(Color color : Color.values()){
			this.colors.add(color);
		}
		Random random = new Random(System.currentTimeMillis());
		final int erased = colors.size() - Controller.getWidth();
		for (int i = 0; i < erased; i++) {
			this.colors.remove(random.nextInt(this.colors.size()));
		}
		Collections.shuffle(this.colors);
	}

    public ResumeController getResult(ProposedCombinationController proposedCombination) {
		int blacks = 0;
		for (int i=0; i<this.colors.size(); i++) {
			if (proposedCombination.contains(this.colors.get(i), i)) {
				blacks++;
			}
		}
		int whites = 0;
		for (Color color : this.colors) {
			if (proposedCombination.contains(color)) {
				whites++;
			}
		}
		return new ResumeController(blacks, whites - blacks);
	}

	public void writeln() {
		for (int i = 0; i < this.colors.size(); i++) {
			Message.SECRET.write();
		}
		Message.NEW_LINE.write();
	}

}
