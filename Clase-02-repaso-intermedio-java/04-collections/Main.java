import java.util.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        
         // List [] = Arrays -> [ "Zahid", "Aldo", "Erick" ]
         List<String> nombres = new ArrayList<>();

         /**
         Metodos
         add() - > agregar
         get(posicion) -> obtener
         remove(posicion) -> eliminar
         contains(valor) -> buscar
         size() -> Tamaño
         isEmpty() -> Si esta vacia
         **/


         nombres.add("Juan");
         System.out.println(nombres.get(0));
         // System.out.println(nombres.get(1));

         nombres.remove("Juan");
         System.out.println(nombres.contains("Juan"));

         nombres.add("Aldo");
         System.out.println(nombres.size());
         

        
        // Set
        Set<String> correos = new HashSet<>();

        /**
         * add()
         * remove()
         * contains()
         * size()
         *
         * **/

        correos.add("aldo@gmail.com");
        correos.add("aldo@gmail.com");
        correos.add("aldo@gmail.com");

        System.out.println(correos.size());
        

        
        // Map -> dict { key: value }
        Map<Long, String> usuarios = new HashMap<>();

        /**
         * put()
         * get()
         * containsKey()
         * remove()
         * keySet()
         * values()
         * **/

        usuarios.put(1L, "Juan");
        usuarios.put(2L, "Aldo");

        System.out.println(usuarios.containsKey(3L));
        System.out.println(usuarios.size());

        usuarios.put(3L, "Pedro");
        System.out.println(usuarios.containsKey(3L));
        

        List<Usuario> users = new ArrayList<>();

        // filter
        users.stream()
               // .filter(user -> user.isActive()) // Lambda Expression
                .filter(Usuario::isActive)              // method reference
                .toList();

        // map()
        users.stream()
                .map(Usuario::logearse);

        // findFirst
        users.stream()
                .filter(u -> u.getId().equals(1L))
                .findFirst();

        // foreach
        users.forEach(System.out::println);
                //forEach(u -> System.out.println(u));

        // count()
        long total = users.stream().count();

        // Optional
        Optional<Usuario> user = Optional.ofNullable(users.get(0));
        if (user.isPresent()) {
            System.out.println("existe");
        }
        user.ifPresent(System.out::println);
    }
}