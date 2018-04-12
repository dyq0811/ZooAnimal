/**
   The class that holds the Zoo Animal Displayer.
   @author Yingyi Ding and Starr Wang, 2018-04-06
*/

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ZooDisplayer
{
   public static void main(String[] args)
   {
      //Ask the user the file name, convert the text file data into a List<ZooAnimal>
      //and sort the list alphabetically. 
      Scanner kb = new Scanner(System.in);
      System.out.println("What is the file name?");
      String fileName = kb.nextLine();
      List<ZooAnimal> list = loadZoo(fileName);
      sortSpecies(list);

      //Ask the user whether to display zoo picture or text. 
      Scanner kb2 = new Scanner(System.in);
      System.out.println("Display zoo picture or text? Type picture or text.");
      String choice = kb2.nextLine();

      //Display the list via text
      if(choice.equals("text"))
      {
         displayTextZoo(list);
      }

      //Display the list via pictures
      else if(choice.equals("picture"))
      {
         try
         {
            displayZooImage(list);
         }
         catch (FileNotFoundException e)
         {
            System.err.println("Please correct the file name. Catch the exception: " + e.getMessage());
         }
         catch (IOException e)
         {
            System.err.println("Catch the exception with message: " + e.getMessage());
         }
      }

      //Ask the user to enter correct instruction. 
      else
      {
         System.out.println("What are you doing? Enter picture or text please.");
      }
   }


   /**
     * Read the file, use each line of the file to create a ZooAnimal instance,
     * and create an arrayList that contains all the instances.
     * @param filePath the name of the file
     * @return         the arrayList that contains all the ZooAnimal instance. 
     */
   public static List<ZooAnimal> loadZoo(String filePath)
   {  
      //First, ask the user to give the filename. 
      //If the file does not exist, tell the user to give the correct file name. 
      File inputFile = new File(filePath);
      Scanner scanner = null;
      try
      {
         scanner = new Scanner(inputFile);
      }
      catch (FileNotFoundException e)
      {
         System.err.println("Please correct the file name. Catch the exception: " + e.getMessage());
      }

      //Next, use scanner to read through each line of the file. 
      //Use numbersOfLines to keep track of the numbers of line in the file, 
      //Use animalList to keep track of the instances created 
      //Use the textLine to store all the lines in the file 
      int numberOfLines = 0;
      List<ZooAnimal> animalList = new ArrayList<ZooAnimal>();
      List<String> textList = new ArrayList<String>();
      while (scanner.hasNextLine())
      {
         numberOfLines++;
         String line = scanner.nextLine();

         //If the new line is not identical as any of the previous line, use the elements  
         //in the new line to create a zooAnimal instance and add that instance to the animalList
         if (textList.contains(line) == false)
         {
            textList.add(line);
            String[] array = line.split(",");
            ZooAnimal animal = new ZooAnimal(array[0],array[1],Integer.valueOf(array[2]),array[3]);
            animalList.add(animal);
         }
      }
      System.out.println("\nNumber of lines: " + numberOfLines);
      scanner.close();

      //If the file is empty, tell the user that the file is empty and exit the program. 
      if (numberOfLines == 0)
      {
         System.out.print("The file is empty!");
         System.exit(1);
      }
      
      return animalList;
   }

   /**
     * Sort the arrayList in the alphabetic order. 
     * 
     * @param animalList  the arrayList that contains all the ZooAnimal instance. 
     * @return            the sorted arrayList in the alphabetic order. 
     */
   public static void sortSpecies(List<ZooAnimal> animalList)
   {
      boolean change = true;
      ZooAnimal temp;
      while (change)
      {  
         //If there is not change made, we skip the while loop and finish sorting.
         change = false; 
         for (int i = 1; i < animalList.size(); i++)
         {  
            //First, get the consecutive ZooAnimal instances from the list
            //and the species, name and birth year of these two instances.
            ZooAnimal a1 = animalList.get(i);
            ZooAnimal a2 = animalList.get(i-1);
            int spNum = a1.getSpecies().compareTo(a2.getSpecies());
            int nameNum = a1.getName().compareTo(a2.getName());
            int yearNum = a1.getBirthYear() - a2.getBirthYear();

            //Then zoo animals are alphabetized by animal species, 
            //then name in case of identical species, 
            //and then year of birth in case of identical names 
            if (spNum < 0 || spNum == 0 && nameNum < 0
               || spNum == 0 && nameNum == 0 && yearNum > 0)
            {
               temp = animalList.get(i);
               animalList.set(i, animalList.get(i-1));
               animalList.set(i-1, temp);
               change = true;
            }
         }
      }
   }

   /**
     * Display the sorted animal text. 
     * 
     * @param animalList  the arrayList that contains all the ZooAnimal instance.
     */
   public static void displayTextZoo(List<ZooAnimal> animalList)
   {
      for(ZooAnimal a:animalList)
      {  
         int age = 2018 - a.getBirthYear();
         System.out.print(a.getName() + " ");
         System.out.print(a.getSpecies() + " ");
         System.out.println(age);
      }
   }

   /**
     * Display the sorted animal images. 
     * 
     * @param animalList  the arrayList that contains all the ZooAnimal instance. 
     */
   public static void displayZooImage(List<ZooAnimal> animalList)
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
               }
            }
      }
      
   }
}