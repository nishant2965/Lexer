import java.util.HashMap;

import edu.ufl.cise.plc.IToken;

public class Token implements IToken {

    private Kind kind;
    private String input;

    int lexemmelength;
    static int done;
    static int finalState;

    public enum State {
        Start,
        Final,
        Int_ident,
        Ident_ident
    }

    @Override
    public Kind getKind() {
        return kind;
    }

    @Override
    public String getText() {
        return input;
    }

    public Lexer(){
        int tok;

        done = 0;
        state = 0;
        finalState = -1;

        while(done != 0){
            step();
            setFinal();
        }
        if(finalState<0){

        }
    }

    HashMap<Kind, string> rsrvd = new HashMap<>(); // hashmap for the reserved words of the programming language, we
                                                   // will use this after we have the identifier and we will compare it
                                                   // with the hashmap.

    // rsrvd.put(TYPE, 'int'), somehow create a hashmap of all the reserved words
    // like this

    public step(){
        int ch = getchar(); //Can i find some other way to iterate over the complete code, for loop ? - too tacky plus conditions will make it difficult
                            //while loop? 
        switch(state){ //implementing the DFA, this switch statement is to define the states of the DFA
            case start:
                switch(ch){ //this switch case works on the characters of the string.
                    case 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                    'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', '$', '_':
                    //return identifier or save it somewhere to let the program know, save it in array list ? umm how about 
                    //we save it like ('string','token') but this will have to be done in the end of the execution of the dfa
                    //let's do it like this, create an array list(string name, token kind)
                    //where as soon as we hit the final state we add it into the array list. and array list can be named tokens? 
                    moveToState(Ident_ident,ch);
                    break;
                    default:
                    done =1;
                }
            case Int_ident:
                switch(ch){
                case 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z', '$', '_',
                '1','2','3','4','5','6','7','8','9':
                if(ch==' '){ //have to figure out a way to stop this DFA, should we create a final state?
                break;
                }
                else{
                moveTostate(Ident_ident,ch);
                }
                break;
            }
            case 2;
                if(ch == '>')
                moveTostate(3, ch);
                else{
                    done = 1;
                }
        }
    }

}
