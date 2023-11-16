package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import dao.JogoDao;
import entidades.Jogo;

@ManagedBean
@ViewScoped
public class JogoBean {
	
	private Jogo jogo = new Jogo();
	private List<Jogo> listaJogada;
	
	public void onRowEdit(RowEditEvent<Jogo> event) throws Exception {	
		JogoDao.editar(event.getObject());
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + event.getObject().getId()+"   ->   Jogadores Editados: ", String.valueOf(event.getObject().getTime1() + " e " + event.getObject().getTime2())));
    }
	
    public void onRowCancel(RowEditEvent<Jogo> event) throws Exception {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ID: " + event.getObject().getId()+"   ->   Edição cancelada: ", String.valueOf(event.getObject().getTime1() + " e " + event.getObject().getTime2())));
    }	
	
	public String salvar() throws Exception {
		if(!jogo.getTime1().equalsIgnoreCase(jogo.getTime2())) {
			JogoDao.salvar(jogo);
			resetInputs();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogada salvo com sucesso!", ""));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogada. O valor do time 1 é igual ao do time 2.", ""));
		}
		return null;
	}
	
	public void resetInputs() {
		jogo.setTime1(null);
        jogo.setTime2(null);
        jogo.setGolsTime1(null);
        jogo.setGolsTime2(null);
    }
	
	public List<Jogo> excluir() throws Exception {
		try {
			JogoDao.excluir(jogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Jogo "+ jogo.getId().toString() + " excluído com sucesso!", ""));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listaJogada = JogoDao.listar();
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getListaJogada() throws Exception {
		listaJogada = (listaJogada==null) ? listaJogada=JogoDao.listar() : listaJogada;
		return listaJogada;
	}

	public void setListaJogada(List<Jogo> listaJogada) {
		this.listaJogada = listaJogada;
	}

	
	
}
