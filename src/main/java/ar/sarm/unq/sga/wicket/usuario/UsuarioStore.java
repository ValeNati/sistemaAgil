package ar.sarm.unq.sga.wicket.usuario;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.sarm.unq.sga.home.HomeGeneralSession;
import ar.sarm.unq.sga.model.Usuario;
import ar.sarm.unq.sga.model.Project;

@Component
public class UsuarioStore extends HomeGeneralSession<Usuario> {

	private static final long serialVersionUID = 1L;

	public List<Usuario> getUsuarios() {
		return getSession().createQuery("FROM Usuario", Usuario.class).list();
	}

	public void agregarUsuario(Usuario dev) {
		getSession().save(dev);
	}

	public void borrarUsuario(Usuario dev) {
		getSession().delete(dev);
	}

	@Override
	public Usuario findByName(String name) {
		return this.getSession().createQuery("FROM Usuario WHERE nombre = : name", Usuario.class)
				.setParameter("name", name).getSingleResult();
	}

	public List<Usuario> verUsuarios(Project proyecto) {
		return proyecto.getUsuarios();

	}

	// public List<Project> getProyectos(String apellido) {
	// return getSession().createQuery("FROM Project WHERE apellido = :
	// apellido", Project.class).list();
	// }
}
