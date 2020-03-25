import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class BannerWeb {
    public static void main(String args){

        System.out.println("Hello Banner");

        System.out.println("\n");

        System.out.print("Creating the input file...");
        createBannerData();
        System.out.println("done.");

    }

    private static void createBannerData() {
        try (PrintWriter writer = new PrintWriter("input.txt")){ //Try with resources
            writer.println("Almost finished");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error occurred when trying to pull the file");
        }
    }
}
