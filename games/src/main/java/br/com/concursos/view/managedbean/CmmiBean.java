package br.com.concursos.view.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.DragDropEvent;

import br.com.concursos.enumeration.ProcessoCmmi;

@Named
@SessionScoped
public class CmmiBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ProcessoCmmi> processosCmmi;

	private List<ProcessoCmmi> processosSelecionados;

	public CmmiBean() {
		processosCmmi = new ArrayList<ProcessoCmmi>();
		processosSelecionados = new ArrayList<ProcessoCmmi>();
		preencheProcessosCmmi();
	}

	public void preencheProcessosCmmi() {
		ProcessoCmmi[] arrayProcessosCmmi = ProcessoCmmi.values();
		for (int i = 0; i < arrayProcessosCmmi.length; i++) {
			processosCmmi.add(arrayProcessosCmmi[i]);
		}
	}

	public List<ProcessoCmmi> getProcessosCmmi() {
		return processosCmmi;
	}

	public List<ProcessoCmmi> getProcessosSelecionados() {
		return processosSelecionados;
	}

	public void onDrop(DragDropEvent event) {
		ProcessoCmmi processoCmmi = (ProcessoCmmi) event.getData();

		processosSelecionados.add(processoCmmi);
		processosCmmi.remove(processoCmmi);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(processoCmmi.getNome() + " adicionado", "Posição: " + event.getDropId()));
	}

}