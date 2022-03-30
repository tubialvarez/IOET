package data;
import java.util.*;
//import java.util.function.Function;
import java.io.File;
import java.io.FileNotFoundException;

import service.Util;



public class Data {
    public ArrayList texto() {
        System.out.println("Ingrese el PATH del documento .txt");
        String path;
        Scanner dir = new Scanner(System.in);
        path = dir.next();
        Util util = new Util();
        ArrayList<String> datos = new ArrayList();
        File doc =  new File(path);
        try { 
            Scanner scan = new Scanner(doc);
            while(scan.hasNextLine()){
                datos.add(scan.nextLine().toString());
            }
        } catch (FileNotFoundException e) {
        }
        return datos;
    }
}
