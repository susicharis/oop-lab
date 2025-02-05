package DesignPatterns_W13_Class.FactoryMethod.Hard;

interface Character {
    void attack();
    void defend();
}

class Warrior implements Character {
    public void attack() {
        System.out.println("Attack : Sword");
    }
    public void defend() {
        System.out.println("Defend : Shield");
    }
}

class Mage implements Character {
    public void attack() {
        System.out.println("Attack : Magic Spells");
    }
    public void defend() {
        System.out.println("Defend : Magic Barrier");
    }
}

class Archer implements Character {
    public void attack() {
        System.out.println("Attack : Bow");
    }
    public void defend() {
        System.out.println("Defend : Dodge");
    }
}





interface CharacterFactory {
    Character createCharacter(String characterType);
}

class ConcreteCharacterFactory implements CharacterFactory {
    public Character createCharacter(String characterType) {
        if (characterType.equals("Warrior")) {
            return new Warrior();
        } else if (characterType.equals("Mage")) {
            return new Mage();
        } else if (characterType.equals("Archer")) {
            return new Archer();
        } else
            throw new IllegalArgumentException();
    }
}





interface SkillEnhancer {
    void enhanceSkill(Character character);

}

class AttackEnhancer implements SkillEnhancer {
   public void enhanceSkill(Character character) {
       System.out.println("Enhancing attack skill....");
        character.attack();
       System.out.println("UPGRADED !");
    }
}

class DefenceEnhancer implements SkillEnhancer {
    public void enhanceSkill(Character character) {
        System.out.println("Enhancing Defence Skill...");
        character.defend();
        System.out.println("UPGRADED !");
    }
}

class MainCharacter {
    public static void main(String[] args) {
        ConcreteCharacterFactory factory = new ConcreteCharacterFactory();
        Character warrior = factory.createCharacter("Warrior");
        warrior.attack();
        warrior.defend();
        AttackEnhancer attackPlus = new AttackEnhancer();
        attackPlus.enhanceSkill(warrior);
    }
}