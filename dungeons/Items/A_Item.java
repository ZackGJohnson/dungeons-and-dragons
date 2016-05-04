//Sawyer
//package dungeons;

public class A_Item
{
	
   private int _maxHealth;
   private int _currentHealth;
   private int _attackModifier;
   private int _damageModifier;
   private int _damageReduction;
   private int _armor;
   private String _damageDi;
   private String _name;
	
   public A_Item(){
      this.setMaxHealth(0);
      this.setCurrentHealth(0);
      this.setAttackModifier(0);
      this.setDamageModifier(0);
      this.setDamageReduction(0);
      this.setDamageDie("");
      this.setArmor(0);
      this.setName("Deafalt Item");
      
   }
   
   public String getName()
   {
      return _name;
   }
   
   public void setName(String name)
   {
      this._name = name;
   }

   public int getMaxHealth() {
      return _maxHealth;
   }

   public void setMaxHealth(int health) {
      this._maxHealth = health;
   }

   public int getCurrentHealth() {
      return _currentHealth;
   }

   public void setCurrentHealth(int health) {
      this._currentHealth = health;
   }
   
   public int getAttackModifier() {
      return _attackModifier;
   }

   public void setAttackModifier(int attackModifier) {
      this._attackModifier = attackModifier;
   }

   public int getDamageModifier() {
      return _damageModifier;
   }

   public void setDamageModifier(int damageModifier) {
      this._damageModifier = damageModifier;
   }

   public String getDamageDie() {
      return _damageDi;
   }

   public void setDamageDie(String damageDi) {
      this._damageDi = damageDi;
   }

   public int getDamageReduction() {
      return _damageReduction;
   }

   public void setDamageReduction(int damageReduction) {
      this._damageReduction = damageReduction;
   }

   public int getArmor() {
      return _armor;
   }

   public void setArmor(int armor) {
      this._armor = armor;
   }
   
   
}
