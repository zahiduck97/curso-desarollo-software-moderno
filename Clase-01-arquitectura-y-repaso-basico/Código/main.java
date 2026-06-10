
public class Main {
    public static void main(String[] args) {
        // Tipos Nativos
        String nombre = "Zahid";
        int edad = 29;
        double salario = 10000.00;
        boolean activo = true;


        // if - else
        if (edad >= 18) {
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }

        // Se crea la clase
        /**
         User usuario = new User();
         System.out.println(usuario.nombre);
         System.out.println(usuario.edad);

         User usuario2 = new User("Zahid");
         System.out.println(usuario2.nombre);
         System.out.println(usuario2.edad);

         usuario.edad = 50;
         System.out.println(usuario.edad);
         System.out.println(usuario2.edad);
         **/

        User usuario = new User();
        System.out.println(usuario.getEdad());
        usuario.setNombre("Zahid");
        usuario.setEdad(29);
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getEdad());

        User usuario2 = new User("Zahid", 29);

    }
}