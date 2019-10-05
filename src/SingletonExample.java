import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SingletonExample {
    private static SingletonExample singletonExampleInstance = null;
    public static final String COFFEE = "Coffee";
    public static final String TEA = "Tea";
    public static final String WATER = "Water";
    private BufferedReader bufferedReader = null;
    private SingletonExample(){
        try {
            File file = new File("C:\\Users\\hard_\\IdeaProjects\\SingletonDemo\\properties.txt");
            bufferedReader = new BufferedReader(new FileReader(file));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public synchronized static SingletonExample getInstance(){
        if(singletonExampleInstance == null){
            singletonExampleInstance = new SingletonExample();
        }
        return singletonExampleInstance;
    }

    public String getDrink(String drink){
        String readLine = "";
        try {
            while ((readLine = bufferedReader.readLine()) != null){
                if(readLine.equals(drink)){
                    return  drink;
                }
            }
            bufferedReader.close();
        } catch (Exception e){
            return e.getMessage();
        }
        return "The drink " + drink + " does not exist in the list!";
    }
}
