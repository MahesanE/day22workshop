package sg.edu.nus.iss.Exception;


public class Nonsense extends RuntimeException{

    public Nonsense(){

        super();
    }

    public Nonsense(String message){
        super(message);
    }

    public Nonsense(String message, Throwable cause){
        super(message, cause);
    }
}
