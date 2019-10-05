/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import views.ConsoleView;



/**
 *
 * @author Gabri
 */
public class Controller extends ConsoleView{

	protected static final int WIDTH = 4;

        protected static final int MAX_LONG = 10;

        protected ConsoleView console = new ConsoleView();
        
	protected List<Color> colors;
	
	protected Controller (){
		this.colors = new ArrayList<Color>();
	}
	
	static int getWidth() {
		return Controller.WIDTH;
	}
        
        
        
        
}
