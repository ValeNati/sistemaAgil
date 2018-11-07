package ar.sarm.unq.sga.wicket.backlog;

import java.io.Serializable;
import java.util.List;

import org.eclipse.jetty.security.UserStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ar.sarm.unq.sga.model.Backlog;
import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.model.UserStory;
import ar.sarm.unq.sga.wicket.project.ProjectStore;
import ar.sarm.unq.sga.wicket.userstory.UserStoryController;

@Controller
public class BacklogController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Project proyecto;

	private String nombreBacklog;

	@Autowired
	private BacklogStore backlogStore;
	
	@Autowired
	private ProjectStore projectStore;
	
	@Autowired
	private UserStoryController userStoryController;
	
	private UserStory userStory;
	
	private Backlog backlog;
	
	private Object back;
	private String message;

	public BacklogController(Project proy) {
		projectStore.attach(proy);
		Project proyecto = proy;
		Backlog back = proy.getBacklog();
	}

	public BacklogController() {

	}
	// public Project getProyecto() {
	// return proyecto;
	// }
	//
	// public void setProyecto(Project proyecto) {
	// this.proyecto = proyecto;
	// }

	public String getNombre() {
		return nombreBacklog;
	}

	public void setNombre(String nombre) {
		this.nombreBacklog = nombre;
	}

	// public void agregarUserStory() {
	// UserStory user = new UserStory(getNombre());
	// proyecto.getBacklog().
	// userStoryController.agregarBacklogStore(backlog);
	// getProyecto().setBacklog(getNombre());
	// }

	public Backlog findByName() {
		try {
			this.setMessage(null);
			Backlog back = backlogStore.findByName(getNombre());
		} catch (Exception e) {
			setMessage("no existe el objeto");// TODO: handle exception
			back = null;
		}
		return (Backlog) back;
	}

	// public void attach(Project proy) {
	// projectStore.attach(proy);
	// }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Project getProyecto() {
		return proyecto;
	}

	public void setProyecto(Project proyecto) {
		this.proyecto = proyecto;
	}

	public String getNombreBacklog() {
		return nombreBacklog;
	}

	public void setNombreBacklog(String nombreBacklog) {
		this.nombreBacklog = nombreBacklog;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}
	
	private Backlog getBacklog() {
		return backlog;
	}
	
	public void setBacklog(Backlog backlog){
		this.backlog=backlog;
	}
	
	public void attach(Backlog backlog){
		backlogStore.attach(backlog);
	}
	
	public void agregarUserStoyEnBacklog(UserStory us){
		Backlog backlog=new Backlog(getNombre());
		backlog.setUserStory(us);
		backlogStore.insert(backlog);	
		
	}

	
}
