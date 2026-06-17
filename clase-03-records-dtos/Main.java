
public class Main {
    public static void main(String[] args) {

        // API - GET, POST ,PUT
        UsuarioService service = new UsuarioService();

        System.out.println("POST /usuarios");
        System.out.println(service.postUsuario("Juan", "juan@gmail.com", "12345"));
        System.out.println(service.postUsuario("Erick", "erick@gmail.com", "abcdef"));

        System.out.println("\n GET /usuarios");
        System.out.println(service.getUsuarios()); // USER DTO []

        System.out.println("\n GET /usuarios/1"); // USER DTO -> UsuarioDTO
        System.out.println(service.getUsuarioPorId(1L).orElse(null));

        System.out.println("\n PUT /usuarios/1");
        System.out.println(service.putUsuario(1L, "Juan Perez", "juan.perez@gmail.com").orElse(null)); // User DTO

        System.out.println("\n DELETE /usuario/2");
        System.out.println("Eliminado: " + service.deleteUsuario(2L)); // boolean True False

        System.out.println("\n GET /usuarios");
        System.out.println(service.getUsuarios()); // USER DTO []
    }
}