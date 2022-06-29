public class Main {

    public static void main(String[] args) throws IllegalStateException, IllegalArgumentException {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);


        try {
            // Не хватает имени
            new PersonBuilder().setName("").setSurname("..").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Не хватает фамилии
            new PersonBuilder().setName("..").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("..").setSurname("..").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}