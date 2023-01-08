public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
    This method returns the name of the pet as a string
     @return String
     */

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
