/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileclone;

import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class FileClone {
    
    public static void main(String[] args) throws IOException{
        
        String dir, name, est;
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert file's location (directory):");
        dir = sc.nextLine();
        System.out.println("Insert file's name:");
        name = sc.nextLine();
        System.out.println("Insert file extension (no dot):");
        est = sc.nextLine();
        System.out.println("Number of clones:");
        num = parseInt(sc.nextLine());
        
        File file = new File(dir + "/" + name + "." + est);
        Path path = file.toPath();
        
        long startTime = System.currentTimeMillis();
        
        System.out.println("Start time: " + startTime);
        
        for(int i = 0; i < num; i++){
            File file2 = new File(dir + "/" + name + (i+1) + "." + est);
            Path path2 = file2.toPath();
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("End time: " + endTime);
        
        System.out.println("Elapsed time: " + (endTime - startTime)/1000.0 + " Sec.");
    }
}