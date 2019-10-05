/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Gabri
 */
public class ProposedCombinationController extends Controller{    
    
    public void write() {
		for (Color color : this.colors) {
			color.write();
		}
	}

	public void read() {
		Error error;
		do {
			error = null;
			Message.PROPOSED_COMBINATION.write();
			String characters = this.console.readString();
			if (characters.length() != Controller.getWidth()) {
				error = Error.WRONG_LENGTH;
			} else {
				for (int i = 0; i < characters.length(); i++) {
					Color color = Color.getInstance(characters.charAt(i));
					if (color == null) {
						error = Error.WRONG_CHARACTERS;
					} else {
						for(int j=0; j< this.colors.size(); j++){
							if (color == this.colors.get(j)){
								error = Error.DUPLICATED;
							}
						}
						this.colors.add(color);
					}
				}
			}
			if (error != null) {
				error.writeln();
				while (!this.colors.isEmpty()){
					this.colors.remove(0);
				}
			}
		} while (error != null);
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}  
}
