/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import views.ResumeView;

/**
 *
 * @author Gabri
 */
public class ResumeController extends Controller{
    
    	private int blacks = 0;

	private int whites = 0;

	ResumeController(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;
		this.blacks = blacks;
		this.whites = whites;
	}

	public boolean isWinner() {
		return this.blacks == Controller.getWidth();
	}

	public void writeln() {
		Message.RESULT.writeln(this.blacks, this.whites);
	}
           
}
