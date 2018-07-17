/**
 *The class that holds zoo animal.
 * @author Yingqi Ding (hw03, hw07), 2018-04-28
 *
 * @author Starr Wang (hw03), 2018-04-06
 */

public class ZooAnimal implements Comparable<ZooAnimal>
{
   private String name;
   private String species;
   private int birthYear;
   private String imageLocation;

   /**
    * Construct a new instance of ZooAnimal.
    * @param name, species, birth year, image location
    */
   public ZooAnimal(String name, String species, int birthYear, String imageLocation)
   {
      this.name = name;
      this.species = species;
      this.birthYear = birthYear;
      this.imageLocation = imageLocation;
   }

  /**
   * Compare current ZooAnimal instances to another ZooAnimal instance. 
   * @param other ZooAnimal instance
   * @return -1 if myAnimal < otherAnimal, 0 if myAnimal = otherAnimal,
   *         1 if myAnimal > otherAnimal.
   */
   public int compareTo(ZooAnimal otherZooAnimal)
   {
      //ZooAnimal instances are alphabetized by animal species, 
      //then name in case of identical species, 
      //and then year of birth in case of identical names 
      int spNum = species.compareTo(otherZooAnimal.getSpecies());
      int nameNum = name.compareTo(otherZooAnimal.getName());
      int yearNum = birthYear - otherZooAnimal.getBirthYear();

      //If myZooAnimal and otherZooAnimal are equal in the sorted order
      if (spNum == 0 && nameNum == 0 && yearNum == 0)
      {
         return 0;
      }
      //If myZooAnimal comes before otherZooAnimal in sorted order
      if (spNum < 0 || spNum == 0 && nameNum < 0
        || spNum == 0 && nameNum == 0 && yearNum > 0)
      {
        return -1;
      }
      //If myZooAnimal comes after otherZooAnimal in sorted order
      return 1;
   }

   /**
    * Test if current ZooAnimal and another ZooAnimal is equal.
    * @param other ZooAnimal instance
    * @return true if species, name, and birthYear are all equal, false otherwise.
    */
   public boolean equals(ZooAnimal otherZooAnimal)
   {
      if (compareTo(otherZooAnimal) == 0)
      {
        return true;
      }
      return false;
   }

   /**
    * Get the name of the animal.
    * @return name 
    */
   public String getName()
   {
      return name;
   }

   /**
    * Get the species of the animal.
    * @return species
    */
   public String getSpecies()
   {
      return species;
   }

   /**
    * Get the birth year of the animal.
    * @return birth year
    */
   public int getBirthYear()
   {
      return birthYear;
   }

   /**
    * Get the location of the image of the animal.
    * @return location
    */
   public String getImageLocation()
   {
      return imageLocation;
   }

   /**
     * Set a new name to the animal.
     * @param new name
     */
   public void setName(String name)
   {
      this.name = name;
   }

   /**
    * Set a new species to the animal.
    * @param new species
    */
   public void setSpecies(String species)
   {
      this.species = species;
   }

   /**
    * Set a new birth year to the animal.
    * @param new birth year
    */
   public void setBirthYear(int birthYear)
   {
      this.birthYear = birthYear;
   }

   /**
    * Set a image location to the animal.
    * @param new image location
    */
   public void setImageLocation(String imageLocation)
   {
      this.imageLocation = imageLocation;
   }

   public static void main(String[] arg)
    {
        ZooAnimal a1 = new ZooAnimal("Lola", "lemur", 2005, "zooPics/lemur.jpg");
        ZooAnimal a2 = new ZooAnimal("Leanne", "koala", 2000, "zooPics/koala2.jpg");
        System.out.println(a1.compareTo(a2));
        System.out.println(a2.compareTo(a1));
        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(a1));
    }
}