package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {

        String hello;

        try{
            ObjectMapper jsonObj = new ObjectMapper();
            Car superFast = new Car("Blue", "Very fast", "Toyota");
            Car superFast1 = new Car("Yellow", "Very average", "Toyota");
            Car superFast2 = new Car("Red", "Very slow", "Toyota");

            String superFastJson = jsonObj.writeValueAsString(superFast);
            System.out.println(superFastJson);

            Car myBMW = jsonObj.readValue(Car.class.getClassLoader().getResource("car.json"), Car.class);
            System.out.println(myBMW.getColour() + " " + myBMW.getType());

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
