package Quiz4Prep.W10.W10;

import java.lang.reflect.Field;

class Macka {
    private final String name;
    private int age;

    public Macka(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }



   public static void main(String[] args) throws IllegalAccessException {
        Macka macka = new Macka("Cici",15);
        Field[] mackaField = macka.getClass().getDeclaredFields();

        for(Field fields : mackaField) { // moramo koristiti .getName() jer ovo vraca niz objekata tipa Field, koji predstavljaju atribute klase Macka
            System.out.println(fields.getName());
        }
       System.out.println(macka.getName());
       System.out.println(macka.getAge());
        for (Field field : mackaField) {
            if (field.getName().equals("name")) {
                field.setAccessible(true);
                field.set(macka,"Mici");
            }

            if (field.getName().equals("age")) {
                field.setAccessible(true);
                field.set(macka,25);
            }
        }



       System.out.println(macka.getName());
       System.out.println(macka.getAge());

   }

}