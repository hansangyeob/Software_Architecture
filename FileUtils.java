package librarySystem;

import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public void saveEnrolmentToFile(StudentEnrolment se){
        try{
            FileWriter fileWriter = new FileWriter("studentEnrolment.csv");
            fileWriter.write(se.toString());

        }catch (IOException e){
            System.out.println("Error occurred while writing customer to the file.");
            e.printStackTrace();
        }

        System.out.println("saved! ");
    }

}
