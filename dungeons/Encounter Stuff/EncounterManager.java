//Sawyer Zock
//
//
//
//


import java.util.*;


public final class EncounterManager 
{
   
   private static EncounterManager _instance = null;
   private static LinkedList<A_Entity> _entities;
   
   private EncounterManager(){}
   
   public static synchronized EncounterManager getInstance()
   {
      if(_instance == null)
      {
         _instance = new EncounterManager();
         _entities = new LinkedList();
      }
      return _instance;
   }
   
   public void Add (A_Entity creature)
   {  
      _entities.add(creature);
   }
   
   public void Remove(A_Entity creature)
   {
      _entities.remove(creature);
   }
   
   public void Round()
   {
      for(int i= 0; i < _entities.size(); i++)
      {
         _entities.get(i).turn();
      }
   }
}
