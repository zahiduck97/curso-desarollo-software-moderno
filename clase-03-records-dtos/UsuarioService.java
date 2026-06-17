import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private List<Usuario> baseDatos = new ArrayList<>();
    private Long nextId = 1L;

    private UsuarioDTO convertirUDTO(Usuario user) {
        return new UsuarioDTO(
                user.getId(),
                user.getNombre(),
                user.getEmail()
        );
    }

    public UsuarioDTO postUsuario(String nombre, String email, String password) {
        Usuario newUser = new Usuario(nextId, nombre, password, email);
        baseDatos.add(newUser);
        nextId++;

        return convertirUDTO(newUser);
    }

    public List<UsuarioDTO> getUsuarios() {
        return baseDatos.stream()
                //.map(user -> this.convertirUDTO(user))
                .map(this::convertirUDTO)
                .toList();
    }

    public Optional<UsuarioDTO> getUsuarioPorId(Long id) {
        return baseDatos.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .map(this::convertirUDTO);
    }

    public Optional<UsuarioDTO> putUsuario(Long id, String nombre, String email) {
        return baseDatos.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .map(usuario -> {
                    usuario.setNombre(nombre);
                    usuario.setEmail(email);

                    return convertirUDTO(usuario);
                } );
    }

    public boolean deleteUsuario(Long id) {
        return baseDatos.removeIf(usuario -> usuario.getId().equals(id));
    }

}
