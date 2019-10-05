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
public interface View {
    
    enum Color {
            RED('r'), 
            BLUE('b'), 
            YELLOW('y'), 
            GREEN('g'), 
            ORANGE('o'), 
            PURPLE('p');

            private char initial;

            private Color(char initial) {
                    this.initial = initial;
            }

            public static String allInitials() {
                    String result = "";
                    for(Color color: Color.values()) {
                            result += color.initial;
                    }
                    return result;
            }

            public static Color getInstance(int code) {
                    assert 0 <= code && code < Color.length();
                    return Color.values()[code];
            }

            public static Color getInstance(char character) {
                    for (Color color : Color.values()) {
                            if (color.initial == character) {
                                    return color;
                            }
                    }
                    return null;
            }

            static int length() {
                    return Color.values().length;
            }

            public void write() {
                    new ConsoleView().write(this.initial);
            }
        }
    
    
     enum Message {
            ATTEMPTS("#attempts attempt(s): "), 
            SECRET("*"), 
            RESUME("Do you want to continue"), 
            RESULT(" --> #blacks blacks and #whites whites"), 
            PROPOSED_COMBINATION("Propose a combination: "), 
            TITLE("----- MASTERMIND -----"), 
            WINNER("You've won!!! ;-)"), 
            LOOSER("You've lost!!! :-("),
            NEW_LINE("\n");

            private String message;

            static private ConsoleView console; 
            static {
                    Message.console = new ConsoleView();
            }

            private Message(String message) {
                    this.message = message;
            }

            public void write() {
                    Message.console.write(this.message);
            }

            public void writeln() {
                    Message.console.writeln(this.message);
            }

            public void writeln(int attempts) {
                    Message.console.writeln(this.message.replaceAll("#attempts", "" + attempts));
            }

            public void writeln(int blacks, int whites) {
                    Message.console.writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
            }
        }
        
       enum Error {
            DUPLICATED("Repeated colors"),
            WRONG_CHARACTERS("Wrong colors, they must be: " + Color.allInitials()),
            WRONG_LENGTH("Wrong proposed combination length");

            private String message;

            private Error(String message) {
                    this.message = message;
            }

            public void writeln() {
                    new ConsoleView().writeln(this.message);		
            }
            
        }
           
}
