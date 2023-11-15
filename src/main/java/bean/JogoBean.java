package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDao;
import entidades.Jogo;

@ManagedBean
public class JogoBean {
	
	private Jogo jogo = new Jogo();
	private List<Jogo> listaJogada;
	
	public String salvar() throws Exception {
		if(!jogo.getTime1().equalsIgnoreCase(jogo.getTime2())) {
			JogoDao.salvar(jogo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogada salvo com sucesso!", ""));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogada. O valor do time 1 é igual ao do time 2.", ""));
		}
		return null;
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
