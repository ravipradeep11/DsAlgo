package com.ds.stringmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


public class BoggleSolverTest {

 static List<String> goodWords, badWords, dictionary;
 static BoggleSolver boggleSolver = new BoggleSolver();
 public static void main(String[] args) {
		// TODO Auto-generated method stub

boggleSolver = new BoggleSolver();
try {
	setUp();
	testSolver();
	//earDown();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
 

 /**
  * @throws Exception
  *
  * Description: create the dictionaries.
  */

 public static void setUp() throws Exception {
   goodWords = Arrays.asList("readied", "reaved", "randie", "navaid",
           "larned", "errand", "envied", "endive", "earned", "darnel",
           "darned", "dandle", "daidle", "adread", "vexed", "veena",
           "varna", "varan", "vaned", "reran", "reave", "raved",
           "ranee", "narre", "naled", "lande", "evade", "erned",
           "eland", "eaved", "eaned", "drear", "dread", "drave",
           "dived", "divan", "denar", "darre", "darer", "arear",
           "aread", "alane", "aland", "adrad", "vied", "vide", "vare",
           "vara", "vane", "vade", "rear", "rean", "read", "rave",
           "rare", "rand", "rana", "rale", "rade", "need", "nave",
           "nare", "nard", "nala", "nada", "lend", "leed", "larn",
           "lare", "lane", "land", "lana", "idle", "idee", "exed",
           "erne", "elan", "eide", "eevn", "eave", "earn", "eard",
           "drad", "dive", "diva", "died", "deva", "deid", "deev",
           "deen", "darn", "dare", "dada", "avid", "arna", "area",
           "arar", "anal", "alee", "alar", "alan", "aide", "vie",
           "vid", "via", "vex", "vee", "var", "van", "vae", "ran",
           "rad", "nee", "ned", "nae", "lex", "lee", "led", "lar",
           "ide", "err", "ern", "era", "end", "eld", "een", "eel",
           "ear", "ean", "div", "die", "did", "dex", "dev", "den",
           "del", "dei", "dee", "dan", "dae", "dad", "ave", "ava",
           "are", "ard", "ane", "and", "ana", "ale", "ala", "aid",
           "ade", "aal","ravi");

   badWords = Arrays.
           asList("amazon", "forest", "dangerous", "lovely", "resistible");

   dictionary = new ArrayList<String>();
   dictionary.addAll(goodWords);
   dictionary.addAll(badWords);
 }

 /**
  * @throws Exception
  *
  * Description: Destroy all resources after use.
  */

 public static void tearDown() throws Exception {
   goodWords = badWords = null;
   boggleSolver = null;
 }

 /**
  * Test of solver method, of class BoggleSolver.
  */

 public static void testSolver() {
   System.out.println("solver");
   char[][] board = {{'a', 'l', 'e', 'x'},
                     {'a', 'n', 'd', 'e'},
                     {'r', 'a', 'k', 'i'},
                     {'e', 'r', 'd', 'a'}
   };

   Set<String> result = boggleSolver.solver(goodWords, board);
  // assertEquals(result.size(), goodWords.size());
   for (String g : goodWords) {
     if (!result.contains(g)) {
       System.out.println("Boggle solver fails to find " + g);
     }
   }
   for (String b : badWords) {
     if (result.contains(b)) {
    	 System.out.println("Boggle solver should not have found " + b);
     }
   }
 }
}