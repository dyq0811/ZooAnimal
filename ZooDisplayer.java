/**
 * The class that holds the Zoo Animal Displayer.
 * @author Yingqi Ding (hw07, hw03), 2018-04-28
 *
 * @author Starr Wang (hw03), 2018-04-06
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ZooDisplayer
{
   private SortedList<ZooAnimal> animalList;

   /** Constructs a new ZooDisplayer containing the animals in the file at
       filePath.  If filePath is null, constructs an empty ZooDisplayer.
       @param filePath path to the file from which to load zoo animals
    */
   public ZooDisplayer(String filePath)
   {
      animalList = new SortedLinkedList();
      loadZoo(filePath);
      if (animalList.isEmpty())
      {
         System.err.println("The file is empty :(");
      }
   }

   public ZooDisplayer()
   {
      animalList = new SortedLinkedList();
      System.out.println("Empty zoo is created! File name is null or cannot find file.");
   }

   /** Read the file, use each line of the file to create a ZooAnimal instance,
       and create an arrayList that contains all the instances.
       @param filePath the name of the file
    */
   private void loadZoo(String filePath)
   {
      File inputFile = new File(filePath);
      Scanner scanner = null;

      try
      {
         scanner = new Scanner(inputFile);
      }
      catch (FileNotFoundException e)
      {
         System.err.println("Please correct the file name. Catch exception: " + e.getMessage());
         System.exit(1);
      }

      //Next, use scanner to read through each line of the file. 
      //Use numbersOfLines to keep track of the numbers of line in the file, 
      //Use animalList to keep track of the instances created 
      //Use the textLine to store all the lines in the file 
      int numberOfLines = 0;
      List<String> textList = new ArrayList<String>();

      while (scanner.hasNextLine())
      {
         numberOfLines++;
         String line = scanner.nextLine();

         //If the new line is not identical as any of the previous line, use the elements  
         //in the new line to create a zooAnimal instance and add it to the animalList
         if (textList.contains(line) == false)
         {
            textList.add(line);
            String[] array = line.split(",");
            ZooAnimal animal = new ZooAnimal(array[0],array[1],Integer.valueOf(array[2]),array[3]);
            animalList.add(animal);
         }
      }
      System.out.println("\nNumber of lines of the file: " + numberOfLines);
      scanner.close();

      //If the file is empty, tell the user that the file is empty and exit the program. 
      if (numberOfLines == 0)
      {
         animalList = new SortedLinkedList();
         System.out.println("Empty zoo is created! The file is null.");
      }
      return;
   }

   // /**
   //   * Sort the arrayList in the alphabetic order. 
   //   * @param animalList  the arrayList that contains all the ZooAnimal instance. 
   //   * @return the sorted arrayList in the alphabetic order. 
   //   */
   // public static void sortAnimals(List<ZooAnimal> animalList)
   // {
   //    boolean change = true;
   //    ZooAnimal temp;
   //    while (change)
   //    {  
   //       //If there is not change made, we skip the while loop and finish sorting.
   //       change = false; 
   //       for (int i = 1; i < animalList.size(); i++)
   //       {  
   //          //First, get the consecutive ZooAnimal instances from the list
   //          //and the species, name and birth year of these two instances.
   //          ZooAnimal a1 = animalList.get(i);
   //          ZooAnimal a2 = animalList.get(i-1);

   //          if (a1.compareTo(a2) < 0)
   //          {
   //             temp = animalList.get(i);
   //             animalList.set(i, animalList.get(i-1));
   //             animalList.set(i-1, temp);
   //             change = true;
   //          }
   //       }
   //    }
   // }

   // /**
   //   * Compare two ZooAnimal instances. 
   //   * @param two ZooAnimal instances a1 and a2
   //   * @return -1 if a1 < a2, 0 if a1 = a2, 1 if a1 > a2.
   //   */
   // private static int compareTo(ZooAnimal a1, ZooAnimal a2)
   // {
   //    int spNum = a1.getSpecies().compareTo(a2.getSpecies());
   //    int nameNum = a1.getName().compareTo(a2.getName());
   //    int yearNum = a1.getBirthYear() - a2.getBirthYear();

   //    //Then zoo animals are alphabetized by animal species, 
   //    //then name in case of identical species, 
   //    //and then year of birth in case of identical names 
   //    if(spNum == 0 && nameNum == 0 && yearNum == 0)
   //    {
   //       return 0;
   //    }
   //    else if (spNum < 0 || spNum == 0 && nameNum < 0
   //             || spNum == 0 && nameNum == 0 && yearNum > 0)
   //    {
   //       return -1;
   //    }
   //    else
   //    {
   //       return 1;
   //    }
   // }

   /** Adds animal to the zoo.
       @param animal
    */
   public void addAnimal(ZooAnimal animal)
   {
      animalList.add(animal);
   }

   /** Prints a text version of the zoo that lists the animals' names, species,
       and ages.
    */
   public void displayZooAsText()
   {
      for(int i = 0; i < animalList.size(); i++)
      {  
         ZooAnimal a = animalList.get(i);
         int age = 2018 - a.getBirthYear();
         System.out.print(a.getName() + " ");
         System.out.print(a.getSpecies() + " ");
         System.out.println(age);
      }
   }

   /** Displays a picture of the zoo where each animal's picture is concatenated
       to the right of the previous animal
    */
   public void displayZooAsPicture()
   throws FileNotFoundException, IOException
   {
      ZooAnimal a0 = animalList.get(0);
      EzImage image0 = new EzImage(a0.getImageLocation());

      //If there is only one image, display the image. 
      if (animalList.size() == 1)
      {
         image0.show(a0.getImageLocation());
      }

      //If there is more than one images, display all the images by appending the
      //second image to the right of the first image. 
      else
      {
         for (int i = 1; i < animalList.size(); i++)
         {
            ZooAnimal a = animalList.get(i);
            String fileName = a.getImageLocation();
            EzImage image = new EzImage(fileName);
            image0 = image0.appendToRight(image);

            //Show the last image along with all images on the left of it.
            if (i == (animalList.size() - 1))
            {
               image0.show("Zoo");
               return;
            }
         }
      }
   }
   
   public static void main(String[] args)
   {
      if (args.length == 2)
      {
         String filePath = args[0];
         String choice = args[1];

         if (filePath.length() == 0)
         {
            ZooDisplayer zoo = new ZooDisplayer();
            System.err.println("The file is empty!");
         }
         else
         {
            ZooDisplayer zoo = new ZooDisplayer(filePath);
            //ZooAnimal teddy = new ZooAnimal("Teddy", "cat", 2013, "zooPics/koala.jpg");
            //zoo.addAnimal(teddy);

            if (choice.equals("text"))
            {
               zoo.displayZooAsText();
            }
            else if (choice.equals("picture"))
            {
               try
               {
                  zoo.displayZooAsPicture();
               }
               catch (FileNotFoundException e)
               {
                  System.err.println("Please correct the image file. Catch exception: " + e.getMessage());
               }
               catch (IOException e)
               {
                  System.err.println("Catch the exception with message: " + e.getMessage());
               }
            }
            else
            {
               System.out.println("What are you doing? Choose picture or text please.");
            }
         }
      }
      else
      {
         ZooDisplayer zoo = new ZooDisplayer();
         System.out.println("Please check. You should type filename and text or picture.");
         //System.exit(0);
      }
   }
}