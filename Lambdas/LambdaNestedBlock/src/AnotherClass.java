public class AnotherClass {

    public String doString(){

        //Using an annonymous class
//        System.out.println("The Another class name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The annonymous class name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");

        //Using a lambda
//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("Lambda expression is " + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result; };


        //using a short-hand lambda
//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        System.out.println("The Another clas name is: " + getClass().getSimpleName());
//            return  Main.doStringStuff(uc,"BOMBA", "CLARRTT");

//        using a nested lambda
//        {
//            UpperConcat uc = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
//            System.out.println("The Another clas name is: " + getClass().getSimpleName());
//            return  Main.doStringStuff(uc,"String1", "String 2");
//        }

            return "";

   }

}
