/*----------------------------------------------------------------------------
   Problem 3.1.19 in Algorithms book ch. 3.1
   
   Code changes are made from line 79 onward, 
   Two ArrayLists were made to hold the Words and the Counts
   The for loop that was in place to find the highest frequency count was used
   to find the top 10 words in The Tale of Two Cities.
   1. Loop 10 times - for 10 words
   2. Insert the highest frequency word & its count into their respective 
      ArrayLists topWords and topCount
   3. Delete the max word from the table.
   4. The loop restarts without the previous max word, therefore finding the
      next highest frequency word and so on until the loop ends. 
   5. Display the contents of both arrays.

    NOTE- taleTwo.txt is what I named my Tale of Two Cities txt file. It will be
          included in the same GitHub folder.
          
    % java FrequencyCounter 1 < taleTwo.txt
    Top 10 Words used in The Tale of Two Cities:

    Words   Count
 
    the     7515
    and     4751
    of      4071
    to      3458
    a       2830
    in      2447
    his     1911
    was     1675
    that    1663
    I       1451 
*----------------------------------------------------------------------------*/
/**
 *  The {@code FrequencyCounter} class provides a client for 
 *  reading in a sequence of words and printing a word (exceeding
 *  a given length) that occurs most frequently. It is useful as
 *  a test client for various symbol table implementations.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/31elementary">Section 3.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

import java.util.ArrayList; 
 
public class FrequencyCounter {

    // Do not instantiate.
    private FrequencyCounter() { }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }
        
        ArrayList<String> topWords = new ArrayList<>();
        ArrayList<Integer> topCount = new ArrayList<>();
         
        // find a key with the highest frequency count
        String max = "";
        int num = 0;
        
        for(int i = 0; i < 10; i++)
        {
        st.put(max, 0);
           for (String word : st.keys()) 
           {
              if (st.get(word) > st.get(max))
              {            
                 max = word;
                 num = st.get(max);

              }                 
              //StdOut.println(word + " " + st.get(word));
           }
           
           topWords.add(max);
           topCount.add(num);
           st.delete(max);
        }//for loop, 10 times
        
        //StdOut.println(topWords.size());
        
        //ArrayList display
        StdOut.println("Top 10 Words used in The Tale of Two Cities:");
        StdOut.println();
        StdOut.println("Words\tCount");
        StdOut.println();
        
        for(int i = 0; i < topWords.size(); i++)
        {
           System.out.println(topWords.get(i) + "\t" + topCount.get(i));
        }
         
        //THIS CODE WAS PART OF THE ORIGINAL PROGRAM. 
        //StdOut.println(); 
        //StdOut.println("-----------------------");
        //StdOut.println(max + " " + st.get(max));
        //StdOut.println("distinct = " + distinct);
        //StdOut.println("words    = " + words);
    }
}