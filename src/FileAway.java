import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileAway {
    public static void main(String[] args) {

        // declare variables
        String fileName = "";
        int wordCount = 0;
        int countLines = 0;
        int characterCount = 0;

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            fileName=selectedFile.getName();
            String s = selectedFile.getAbsolutePath();
            System.out.println();
            System.out.println("          Text File Statistics");
            // System.out.printlns(s);
            System.out.println();
            try
            {
                File file = new File(s);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null)
                {
                    countLines+=1;
                    String[] arr=line.split(" ");
                    wordCount = wordCount + arr.length;
                    characterCount=characterCount+line.length();

                }
                fr.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("The name of the file is: " + fileName);
        System.out.println("The number of lines in the file is: " + countLines);
        System.out.println("The number of words in the file is: " + wordCount);
        System.out.println("The number of characters in the file is: " + characterCount);
    }
}