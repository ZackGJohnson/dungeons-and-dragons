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
   private static LinkedList<A_Entity> _init;
   
   private EncounterManager(){}
   
   public static synchronized EncounterManager getInstance()
   {
      if(_instance == null)
      {
         _instance = new EncounterManager();
         _rangers = new LinkedList<A_Ranger>();
         _enemies = new LinkedList<A_Villain>();
         _init = new LinkedList();
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
   
   public void replaceRanger(A_Ranger old, A_Ranger replacement)
   {
	   int initiative = _init.indexOf(old);
	   int order = _rangers.indexOf(old);
	   _rangers.remove(old);
	   _rangers.add(order, replacement);
	   
	   _init.remove(initiative);
	   _init.add(initiative, replacement);
   }
   
   public void replaceEnemy(A_Villain old, A_Villain replacement)
   {
	   int initiative = _init.indexOf(old);
	   int order = _enemies.indexOf(old);
	   _enemies.remove(old);
	   _enemies.add(order, replacement);
	   
	   _init.remove(initiative);
	   _init.add(initiative, replacement);
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
	   for(A_Ranger ranger : _rangers)
		   _init.add(ranger);
	   for(A_Villain villain : _enemies)
		   _init.add(villain);
	  Collections.sort(_init);
	  
      for(int i= 0; i < _init.size(); i++)
      {
         _init.get(i).turn();
         
        
      }
      
      for(A_Ranger ranger : _rangers)
      {
    	  if(!ranger.isAlive())
    	  {
    		  _rangers.remove(ranger);
    	  }
      }
	   for(A_Villain villain : _enemies)
	   {
	    	  if(!villain.isAlive())
	    	  {
	    		  _enemies.remove(villain);
	    	  }
	   }
	   
	   _init.clear();
   }
   
   public LinkedList<A_Villain> getEnemies()
   {
	   return _enemies;
   }
   
   public LinkedList<A_Ranger> getRangers()
   {
	   return _rangers;
   }
   
   public boolean enemiesAreAlive()
   {
	   for(A_Villain enemy: _enemies)
	   {
		   if(enemy.getHealth() > 0)
			   return true;
	   }
	   return false;
   }
   
   public boolean rangersAreAlive()
   {
	   for(A_Ranger ranger: _rangers)
	   {
		   if(ranger.getHealth() > 0)
			   return true;
	   }
	   return false;
   }
}
