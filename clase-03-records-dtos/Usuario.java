public class Usuario {

    // Atributos
    private Long id;
    private String nombre;
    private String password;
    private String email;

    // Constructor
    public Usuario(Long id, String nombre, String password, String email) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }

    //geters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    // setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ToString()
}
