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
   
   private EncounterManager(){}
   
   public static synchronized EncounterManager getInstance()
   {
      if(_instance == null)
      {
         _instance = new EncounterManager();
         _rangers = new LinkedList<A_Ranger>();
      }
      return _instance;
   }
   
   public void Add (A_Ranger creature)
   {  
      _rangers.add(creature);
   }
   
   public void Remove(A_Ranger creature)
   {
      _rangers.remove(creature);
   }
   
   public void Round()
   {
      for(int i= 0; i < _rangers.size(); i++)
      {
         _rangers.get(i).turn();
      }
   }
}
