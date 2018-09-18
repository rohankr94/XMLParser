package com.exadatum.xml.splitter.utils;

import java.io.*;

/**
 * gets and sets the surrogate key value.
 */


public class SurrogateKeyGenerator {

    /**
     *
     * @param fileName
     * @return surrogate key value
     * Checks if file exists then return surrogate key value from it.
     * else creates the file.
     *
     */

    public int getSk(String fileName) throws IOException {
        int sk = 0;
        String line;
        File F = new File(fileName);
        if(F.exists() && !F.isDirectory()){
            BufferedReader br = new BufferedReader(new FileReader(F));
            while((line = br.readLine()) != null){
                sk = Integer.parseInt(line);
            }
            br.close();
        }
        else{
            F.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(Integer.toString(sk));
            bw.close();
        }

        return sk;
    }

    /**
     *
     * @param sk
     * @param fileName
     * Writes the surrogate key value to the file.
     */

    public void putSk(int sk, String fileName) throws IOException {

        File F = new File(fileName);
        F.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(F));
        bw.write(String.valueOf(sk));
        bw.close();
    }
}
