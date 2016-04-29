package dungeons;

public class A_Entity
{
    
    private int health;
    private int attackModifier;
    private int damageModifier;
    private String damageDi;
    private int damageReduction;
    private String armor;
    
    public A_Entity(){
        this.setHealth(0);
        this.setAttackModifier(0);
        this.setDamageModifier(0);
        this.setDamageDi("");
        this.setDamageReduction(0);
        this.setArmor("");
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getAttackModifier() {
        return attackModifier;
    }
    
    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }
    
    public int getDamageModifier() {
        return damageModifier;
    }
    
    public void setDamageModifier(int damageModifier) {
        this.damageModifier = damageModifier;
    }
    
    public String getDamageDi() {
        return damageDi;
    }
    
    public void setDamageDi(String damageDi) {
        this.damageDi = damageDi;
    }
    
    public int getDamageReduction() {
        return damageReduction;
    }
    
    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }
    
    public String getArmor() {
        return armor;
    }
    
    public void setArmor(String armor) {
        this.armor = armor;
    }
}
