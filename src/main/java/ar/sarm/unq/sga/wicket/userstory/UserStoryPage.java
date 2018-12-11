package ar.sarm.unq.sga.wicket.userstory;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import ar.sarm.unq.sga.model.Project;
import ar.sarm.unq.sga.wicket.project.ListProjectPage;
import ar.sarm.unq.sga.wicket.project.ProjectController;

public class UserStoryPage extends WebPage {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserStoryController userStoryController;
	@SpringBean
	private ProjectController projectController;
	@SuppressWarnings("unused")
	private Project project;

	public UserStoryPage() {
		this.agregarForm();

	}

	public UserStoryPage(Project proy) {
		project=proy;
		projectController.attach(proy);
		projectController.setProject(proy);
		userStoryController.setProject(proy);
		this.agregarForm();
	}

	private void agregarForm() {
		Form<UserStoryController> crearUserStoryForm = new Form<UserStoryController>("crearUserStoryForm") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit() {
					UserStoryPage.this.userStoryController.agregarUserStoryALaLista();
					this.setResponsePage(new ListProjectPage());
				
			}
		};

		crearUserStoryForm.add(new TextField<>("nombre", new PropertyModel<>(this.userStoryController, "nombre")));

		crearUserStoryForm
				.add(new TextArea<>("descripcion", new PropertyModel<>(this.userStoryController, "descripcion")));

		crearUserStoryForm
				.add(new TextField<>("valorCliente", new PropertyModel<>(this.userStoryController, "valorCliente")));

//		crearUserStoryForm
//				.add(new TextField<>("historyPoint", new PropertyModel<>(this.userStoryController, "historyPoint")));
		
		//Agregar dropchoise, pedir listFibonachi que está en el controller
		crearUserStoryForm.add(new DropDownChoice<>("fibonacci", new PropertyModel<>(this.userStoryController, "fibonacci"),
				new PropertyModel<>(this.userStoryController, "listFibonachi"), new ChoiceRenderer<>("numero")));
		
		crearUserStoryForm.add(new DropDownChoice<>("rol", new PropertyModel<>(this.userStoryController, "rol"),
				new PropertyModel<>(this.userStoryController, "roles"), new ChoiceRenderer<>("nombreRol")));

		crearUserStoryForm.add(new DropDownChoice<>("usuario", new PropertyModel<>(this.userStoryController, "usuario"),
				new PropertyModel<>(this.userStoryController, "usuarios"), new ChoiceRenderer<>("nombreUsuario")));

		crearUserStoryForm.add(new Link<String>("cancelar") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new ListProjectPage());

			}

		});
		this.add(crearUserStoryForm);

	}

}
