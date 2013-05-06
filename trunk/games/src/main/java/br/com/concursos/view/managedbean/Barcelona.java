package br.com.concursos.view.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.DragDropEvent;

import br.com.concursos.entity.Player;

@Named
public class Barcelona implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Player> players;

	private List<Player> selectedPlayers;

	public Barcelona() {
		players = new ArrayList<Player>();
		selectedPlayers = new ArrayList<Player>();

		players.add(new Player("Messi", 10, "messi.jpg", "forward"));
		players.add(new Player("Villa", 7, "villa.jpg", "forward"));
		players.add(new Player("Pedro", 17, "pedro.jpg", "forward"));
		players.add(new Player("Bojan", 9, "bojan.jpg", "forward"));
		players.add(new Player("Xavi", 6, "xavi.jpg", "midfield"));
		players.add(new Player("Iniesta", 8, "iniesta.jpg", "midfield"));
		players.add(new Player("Mascherano", 16, "mascherano.jpg", "defence"));
		players.add(new Player("Puyol", 5, "puyol.jpg", "defence"));
		players.add(new Player("Alves", 2, "alves.jpg", "defence"));
		players.add(new Player("Valdes", 1, "valdes.jpg", "goalkeeper"));
		players.add(new Player("Abidal", 22, "abidal.jpg", "defence"));
		players.add(new Player("Adriano", 16, "adriano.jpg", "defence"));
		players.add(new Player("Pinto", 13, "pinto.jpg", "goalkeeper"));
		players.add(new Player("Pique", 3, "pique.jpg", "defence"));
		players.add(new Player("Keita", 7, "keita.jpg", "midfield"));
		players.add(new Player("Maxwell", 5, "maxwell.jpg", "defence"));
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Player> getSelectedPlayers() {
		return selectedPlayers;
	}

	public void onDrop(DragDropEvent event) {
		Player player = (Player) event.getData();

		selectedPlayers.add(player);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(player.getName() + " added", "Position:"
						+ event.getDropId()));
	}
}