
import java.util.Arrays;


/**
 * The class ArrayBag implements an array-based bag.
 *
 * @author (Laura Aurora Penza)
 */
public class ArrayBag
{
    /**
     * Default constructor. Initial bag capacity is 1.
     *
     */
    public ArrayBag()
    {
        SIZE = 1;                     //Setting the initals capacity to 1
        bag = new String[SIZE];       //Declaring the array
        length = 0;                  //Creates an empty list
    }

    /**
     * Adds new element to the bag. If the array used to store the bag items is
     * full, it will be expanded by doubling its size. If the array is not full,
     * the method will take O(1) time.
     * 
     * Source: List ADT COP3530 slides from Prof. A. Hernandez
     * COP3530 slides-List ADT and arraylists. Program 11_01, slide 19
     *
     * @param s new element to be added to the bag.
     */
    public void add(String s)
    {
      //Will check if the size and number of elements in the list are the same,
      //If so, the array will double and be copied into a new array called "bag."
      //The String will be added to the end of the array and the length will be incremented.
      if(length == SIZE)                        
      {
          SIZE = 2*SIZE;
          bag = Arrays.copyOf(bag, SIZE);
      }
        bag[length] = s;                                                        
        length++;
    }

    /**
     * Determines the number of occurrences in the bag of a given element.
     * The method takes O(length) time.
     *
     *
     * @param s given element
     * @return number of times the given element occurs in the bag.
     */
    public int count(String s)                                                                    
    {
      int count = 0;                        //Counter
      for(int i = 0; i < length; i++)       //Runs through through the array once
      {
        if(bag[i].equals(s))                //Will check if the current index contains the String s
            count++;                        //If it does, the counter will be incremented
      }
        return count;                       //Returns how many instances of the String are in the bag
    }

    /**
     * Determines if bag is empty. The method takes O(1) time.
     *
     * @return true if bag contain no elements, false otherwise.
     */
    public boolean isEmpty()
    {
        return length == 0;
    }

    /**
     * Removes all occurrences of a given element. The method will take O(1) time
     * in removing each occurrence of the given element.
     * 
     * This will continue to loop through the array until all desired values have been
     * removed. 
     *
     * @param s element to be removed.
     */
    public void remove(String s)
    {
      int i = 0;                //Initializing
      while(i < length)         //while i is always less then the length of the array
      {
          if(bag[i].equals(s))      //if the current element equals s 
          {
             bag[i] = bag[length - 1];      //The current element will get the value of the last
             length--;                      //Decrement the array
          }
          else
              i++;                          //Else, move towards the next element
      }    
    }

    /**
     * Constructs a String description of the bag.
     *
     * @return String containing the bag elements.
     */
    public String toString()
    {
        String str = "";

        for (int i=0; i<length-1; i++)
        {
            str += bag[i] + ", ";
        }

        if (length != 0) return "Bag: {" + str + bag[length-1] + "}";
        else return "Bag: {" + str + "}";
    }


    private String[] bag;   //array that stores the bag elements
    private int length;     //number of elements in the bag
    private int SIZE;       //bag capacity
}