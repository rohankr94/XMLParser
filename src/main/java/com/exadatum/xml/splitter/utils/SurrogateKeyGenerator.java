package com.exadatum.xml.splitter.utils;

import com.exadatum.xml.splitter.exceptions.XMLPasrerException;
import com.exadatum.xml.splitter.processors.XMLProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * gets and sets the surrogate key value.
 */

public class SurrogateKeyGenerator {

    private static final Logger LOG = LoggerFactory
            .getLogger(SurrogateKeyGenerator.class);

    public static int surrogateKey = 0;
    private static String filename;

    /**
     *
     * @param xmlFile
     * @param outputDirectory
     * @throws XMLPasrerException
     *
     * Intitialises the surrogate key value from the surrogate key file.
     *
     *
     */


    public static void initialize(String xmlFile, String outputDirectory) throws XMLPasrerException {
        try {
            LOG.info("Surrogate key successfully initialised");
            String surrogatekeyFileName = FileUtils.getFileName(xmlFile);
            int length = outputDirectory.split("/").length;
            int originalLength = outputDirectory.length() - outputDirectory.split("/")[length - 1].length() - 1;
            outputDirectory = outputDirectory.substring(0, originalLength);
            FileUtils.createDirectory(outputDirectory);
            filename = outputDirectory + Constants.FILE_PATH_SEPERATOR + surrogatekeyFileName + Constants.SURROGATE_KEY_FILE;
            surrogateKey = getSurrogateKey(filename);
        }
        catch(Exception initialisationException){
            LOG.error("Error while initialising surrogate key "+initialisationException);
            throw new XMLPasrerException("Unable to initialize surrogate key for "+filename);
        }
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

    public static int getSurrogateKey(String fileName) throws XMLPasrerException {
        try {
            LOG.info("Surrogate key successfully fetched");
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
        catch(Exception getSurrogateKeyException){
            LOG.error("Error while fetching surrogate key "+getSurrogateKeyException);
            throw new XMLPasrerException("Unable to get surrogate key from file "+fileName);
        }
    }

    /**
     *
     * Updates the surrogate key value in the file.
     *
     */

    public static void updateSurrogateKey() throws XMLPasrerException {
        try {
            LOG.info("Successfully updated the surrogate key");
            File suggogateKeyFile = new File(filename);
            suggogateKeyFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(suggogateKeyFile));
            bw.write(String.valueOf(surrogateKey));
            bw.close();
        }
        catch(Exception updateSurrogateKeyException){
            LOG.error("Error in updaing surrogate key "+updateSurrogateKeyException);
            throw new XMLPasrerException("Unable to update surrogate key to file "+filename);
        }
    }
}
