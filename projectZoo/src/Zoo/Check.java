package Zoo;

public class Check {

    public boolean firstLetterIsUp(String name){
        if(!Character.isUpperCase(name.codePointAt(0))){
            return false;
        }
            return true;
    }

}
