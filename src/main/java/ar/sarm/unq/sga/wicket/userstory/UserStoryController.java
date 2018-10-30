package ar.sarm.unq.sga.wicket.userstory;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import ar.sarm.unq.sga.home.Home;
import ar.sarm.unq.sga.model.UserStory;
@Controller
@Transactional
public class UserStoryController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	@Autowired
	private Home<UserStory>userStoryStore;
	
	public UserStoryController(){
		
	}
	public UserStoryController(String nombre){
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarUserStory(){
		UserStory userStory=new UserStory(getNombre());
		userStoryStore.insert(userStory);
	}
	
    
}
