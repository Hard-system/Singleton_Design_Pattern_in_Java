import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SearchText {
    private static SearchText instanceSearchText = null;
    public static final String COFFEE = "Coffee";
    public static final String TEA = "Tea";
    public static final String WATER = "Water";
    private BufferedReader bufferedReader = null;

    private SearchText(){
        try {
            File f = new File("C:\\Users\\hard_\\IdeaProjects\\SingletonDemo\\properties.txt");
            bufferedReader = new BufferedReader(new FileReader(f));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public  synchronized static SearchText getInstance(){
        if(instanceSearchText == null){
            instanceSearchText = new SearchText();
        }
        return instanceSearchText;
    }

    public  String findDrink(String drink){
        String readLine = "";
        try{
            while ((readLine = bufferedReader.readLine()) != null){
                if(readLine.equals(drink)){
                    return  drink;
                }
            }
            bufferedReader.close();
        }catch (Exception e){
            return e.getMessage();
        }
        return "The drink " + drink + " does not exist in the file!";
    }


}
