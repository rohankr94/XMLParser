package com.exadatum.xml.splitter.utils;

import java.io.*;

/**
 * gets and sets the surrogate key value.
 */


public class SurrogateKeyGenerator {

    public static int surrogateKey = 0;
    private static String filename;


    public static void intitialize(String xmlFile, String outputDirectory) throws IOException {
        String surrogatekeyFileName = FileUtils.getFileName(xmlFile);
        filename = outputDirectory + Constants.FILE_SEPERATOR + surrogatekeyFileName + Constants.SURROGATE_KEY_FILE;
        surrogateKey = getSurrogateKey(filename);
    }

    public int getSurrogateKey() {
        return surrogateKey;
    }

    /**
     * @param fileName
     * @return surrogate key value
     * Checks if file exists then return surrogate key value from it.
     * else creates the file.
     */

    public static int getSurrogateKey(String fileName) throws IOException {
        int surrogateKey = 0;
        String line;
        File suggogateKeyFile = new File(fileName);
        if (suggogateKeyFile.exists() && !suggogateKeyFile.isDirectory()) {
            BufferedReader br = new BufferedReader(new FileReader(suggogateKeyFile));
            while ((line = br.readLine()) != null) {
                surrogateKey = Integer.parseInt(line);
            }
            br.close();
        } else {
            suggogateKeyFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(Integer.toString(surrogateKey));
            bw.close();
        }
        return surrogateKey;
    }

    /**
     * @param surrogateKey
     * @param fileName     Writes the surrogate key value to the file.
     */

    public static void updateSurrogateKey() throws IOException {

        File suggogateKeyFile = new File(filename);
        suggogateKeyFile.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(suggogateKeyFile));
        bw.write(String.valueOf(surrogateKey));
        bw.close();
    }
}
