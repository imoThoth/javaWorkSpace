// making an object immutable means that the data cannot be shared among threads
// the data will always be constant
//Immutable objects can be updated by creating a new obj and updating the values
// the old object when it is no longer being ussed within a project scope will be GCed

// the class is made final to stop subclasses to mutability
public final class ImmutableObjects {
    // fields are set to final, meaning they cant be changed
    // once set
    private final String name;
    private final int age;

    public ImmutableObjects(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
