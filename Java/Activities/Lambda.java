package Activity;
import java.util.ArrayList;
import java.util.List;

public class Lambda{
    public static void main(String[] args) {
        
        List<String> list=new ArrayList<String>();
        
        list.add("Rick");
        list.add("Negan");
        list.add("Daryl");
        list.add("Glenn");
        list.add("Carl");
        
        list.forEach( 
            
            (names)->System.out.println(names)
        );
    }
}
