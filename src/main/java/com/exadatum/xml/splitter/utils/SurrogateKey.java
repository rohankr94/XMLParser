package com.exadatum.xml.splitter.utils;

import java.io.*;
import java.util.Properties;

public class SurrogateKey {

    public int getSk(String[] args) throws IOException {
        int sk = 0;
        FileReader readProperty = new FileReader(args[0]);
        Properties getFile = new Properties();
        getFile.load(readProperty);
        String loc = getFile.getProperty("SurrogateFilelocation");
        String line;
        readProperty.close();
        File F = new File(loc);
        if(F.exists() && !F.isDirectory()){
            BufferedReader br = new BufferedReader(new FileReader(loc));
            while((line = br.readLine()) != null){
                sk = Integer.parseInt(line);
            }
            br.close();
        }
        else{
            F.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(loc));
            bw.write(sk);
            bw.close();
        }

        return sk;
    }

    public static void putSk(int sk,String[] args) throws IOException {


        FileReader readProperty = new FileReader(args[0]);
        Properties getFile = new Properties();
        getFile.load(readProperty);
        String loc = getFile.getProperty("SurrogateFilelocation");
        File F = new File(loc);
        F.delete();
        F.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(loc));
        bw.write(String.valueOf(sk));
        bw.close();
    }
}
