package encounter;

//Sawyer Zock
//
//
//
//


import java.math.*;
import java.util.regex.Pattern;

public final class RollManager 
{
   
   private static RollManager _instance = null;
   private RollManager(){}
   
   public static synchronized RollManager getInstance()
   {
      if(_instance == null)
      {
         _instance = new RollManager();
      }
      return _instance;
   }
   
   public int roll(String parameters)
   {
      return Generate(parse(parameters));
   }
   
   protected int[] parse(String parameters)
   {
	  //System.out.println(parameters);
      int [] result = new int[3];
      String[] seperated = parameters.split("d");
      result[0] = Integer.parseInt(seperated[0]);
      seperated = seperated[1].split(Pattern.quote("+"));
      result[1] = Integer.parseInt(seperated[0]);
      result[2] = Integer.parseInt(seperated[1]);
      
      
      return result;
   }
   
   protected int Generate(int [] split)
   {
      int result = 0;
      for(int i = 0; i < split[0]; i++)
      {
         result += (int)(Math.random() * split[1]);
      }
      result += split[2];
      return result;
   }
}
