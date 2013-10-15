/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplsearch;

import java.io.*;

/**
 *
 * @author rob.vanoeveren
 */
public class JavaApplSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String stringSearch = "wsdl:operation";
            int LengthSearch = stringSearch.length();
            // Open the file c:\test.txt as a buffered reader
            BufferedReader bf = new BufferedReader(new FileReader("webservice.txt"));
            int indexfound = 0;
            // Start a line count and declare a string to hold our current line.
            int linecount = 0;
                String line;

            // Let the user know what we are searching for
            System.out.println("Searching for " + stringSearch + " in file...");
/*
            // Loop through each line, stashing the line into our line variable.
            while (( line = bf.readLine()) != null){
                int endIndex = line.length();
                // Increment the count and find the index of the word
                linecount++;
                int indexfound = line.indexOf(stringSearch);

                // If greater than -1, means we found the word
                if (indexfound > -1) {
                    System.out.println("Word was found at position " + indexfound + " on line " + linecount);
                    while((indexfound + LengthSearch + 1) < endIndex) {
                        if(indexfound > 37399) {
                            System.out.println("wacht");
                        }
                        indexfound = line.indexOf(stringSearch, (indexfound + LengthSearch + 1));
                        if(indexfound == -1) {
                            System.out.println("Oops made an mistake!!");
                        }
                        else {
                            System.out.println("Word was found at position " + indexfound + " on line " + linecount);
                            
                        }
                    }  
                }
            }
*/
            // Loop through each line, stashing the line into our line variable.
            while (( line = bf.readLine()) != null){
                indexfound = 0;
                // Increment the count and find the index of the word
                linecount++;
                
                do {
                    indexfound = line.indexOf(stringSearch, indexfound);
                    if(indexfound == -1) {
                        System.out.println("End line " + linecount + " !!");
                    }
                    else {
                        System.out.println("Word was found at position " + indexfound + " on line " + linecount);
                        // Increment indexfound with search string length
                        indexfound = indexfound + LengthSearch;
                    }
                } while (indexfound > -1);
            }
            
            // Close the file after done searching
            bf.close();
        }
        catch (IOException e) {
            System.out.println("IO Error Occurred: " + e.toString());
        }
    }
}
