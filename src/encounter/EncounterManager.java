//Sawyer Zock
//
//
//
//


package encounter;
import java.util.*;

import entities.*;


public final class EncounterManager 
{
   
   private static EncounterManager _instance = null;
   private static LinkedList<A_Ranger> _rangers;
   private static LinkedList<A_Villain> _enemies;
   
   private EncounterManager(){}
   
   public static synchronized EncounterManager getInstance()
   {
      if(_instance == null)
      {
         _instance = new EncounterManager();
         _rangers = new LinkedList<A_Ranger>();
         _enemies = new LinkedList<A_Villain>();
      }
      return _instance;
   }
   
   public void addRanger (A_Ranger creature)
   {  
      _rangers.add(creature);
   }
   
   public void removeRanger(A_Ranger creature)
   {
      _rangers.remove(creature);
   }
   
   public void addEnemy (A_Villain creature)
   {  
	   _enemies.add(creature);
   }
   
   public void removeEnemy(A_Villain creature)
   {
	   _enemies.remove(creature);
   }
   
   public void round()
   {
      for(int i= 0; i < _rangers.size(); i++)
      {
         _rangers.get(i).turn();
         _enemies.get(i).turn();
      }
   }
   
   public LinkedList<A_Villain> getEnemies()
   {
	   return _enemies;
   }
   
   public LinkedList<A_Ranger> getRangers()
   {
	   return _rangers;
   }
}
