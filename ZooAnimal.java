/**
   The class that holds zoo animal.
   @author Yingyi Ding and Starr Wang, 2018-04-06
*/

public class ZooAnimal
{
   private String name;
   private String species;
   private int birthYear;
   private String imageLocation;

   /**
     * Construct a new instance of ZooAnimal.
     * @param name, species, birth year, image location
     */
   public ZooAnimal(String name, String species, 
                  int birthYear, String imageLocation)
   {
      this.name = name;
      this.species = species;
      this.birthYear = birthYear;
      this.imageLocation = imageLocation;
   }

   //Use the following methods to get values from the instance
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

   //Use the following methods to set values of the instance
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
}