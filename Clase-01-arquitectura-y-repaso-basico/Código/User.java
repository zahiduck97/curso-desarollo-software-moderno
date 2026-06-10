public class User {
    // Atributos
    private String nombre; // zahid
    private int edad; // 29
    private boolean activo; // true
    private double salario; // 10.00

    // Constructores
    User() {
        /**
        nombre = "zahid";
        edad = 29;
        activo = true;
        salario = 10.00;
         **/
    }

    User(String nombre) {
        this.nombre = nombre;
        edad = 29;
        activo = true;
        salario = 10.00;
    }

    public User(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        activo = true;
        salario = 10.00;
    }

    public User(String nombre, int edad, boolean activo, double salario) {

    }


    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
