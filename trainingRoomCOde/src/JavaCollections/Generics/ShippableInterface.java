package JavaCollections.Generics;

/**
 * Like classes, interface can declare a formal type parameter
 * Ways of implementing generic interfaces
 * -Specify generic type within the class
 *- Create a generic class
 *- Don't use generics at all
 * **/
public interface ShippableInterface<T> {

    void ship(T t);//ship takes a generic type as the argument to its ship
}

//Implements a generic interface by using adding a generic data type to the class
class ShippableAnimals implements ShippableInterface<Elephant>{

    public void ship(Elephant elephant) { }
}

//Implements a generic interface by creating a generic class
class ShippableGenericAnimals<U> implements ShippableInterface<U>{

    public void ship(U t){ }
}

//Implements a generic interface using a normal class
//this uses a process called type erasure
//after code complies, all generic types return back to object - type erasure
class Shippable implements ShippableInterface{

    public void ship(Object t){}
}
