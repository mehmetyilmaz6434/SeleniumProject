package tests;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class Day09_FileExistTest {
    /*
    Given
        Create a file on desktop
    When
        Copy the path of file
    Then
        Assert if the file exists
    */
    //"C:\Users\MEHMET\Desktop\File.txt.txt"
    @Test
    public void isExistTest(){



        String userHome=System.getProperty("user.home");//==> takes us to  "C:\Users\MEHMET"     userHome = "C:\Users\MEHMET"
        //Give the user folder.Bu kod bizi bilgisayarımızdaki doyalara götürecektir.Bu yüzden "C:\Users\MEHMET" yazmamıza gerek kalmıyor.
        System.out.println("userHome = "+userHome);

        String userDir=System.getProperty("user.dir");// C:\Users\MEHMET\IdeaProjects\seleniumNew  gives us the path of the current folder.
        System.out.println("userDir = "+userDir);

        //Assert if the file exists

        //this is the file text on my desktop.   //shift and right button ==> copy the path
        boolean isExist=Files.exists(Paths.get(userHome+"\\Desktop\\File.txt.txt"));////Writing the path dynamically, so it will work on other computers.
        //Files is class. exist() method is working with Paths.get(). //exist() methods returns boolean.
        System.out.println(Files.exists(Paths.get(userDir+"\\src\\test\\java\\tests\\File.txt")));//This will check if it is exist or not.
        assertTrue(isExist);
    }
}
