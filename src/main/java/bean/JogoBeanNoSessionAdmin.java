package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDao;
import entidades.Auxiliar;
import entidades.Jogo;

@ManagedBean
public class JogoBeanNoSessionAdmin {
	
	private Auxiliar auxiliar = new Auxiliar();
	private Boolean visivel = false;
	private List<Jogo> listaJogos;
	private Jogo jogo = new Jogo();
	
	public String salvar() throws Exception {
		if(!jogo.getTime1().equals(jogo.getTime2().toLowerCase()) && !jogo.getTime1().isEmpty() && !jogo.getTime2().isEmpty() && jogo.getTime1()!=null && jogo.getTime2()!=null) {	
			jogo.setTime1(jogo.getTime1().equals("A") ? "a" : jogo.getTime1());
			jogo.setTime2(jogo.getTime2().equals("A") ? "a" : jogo.getTime2());
			jogo.setTime1(jogo.getTime1().equals("B") ? "b" : jogo.getTime1());
			jogo.setTime2(jogo.getTime2().equals("B") ? "b" : jogo.getTime2());
			jogo.setTime1(jogo.getTime1().equals("C") ? "c" : jogo.getTime1());
			jogo.setTime2(jogo.getTime2().equals("C") ? "c" : jogo.getTime2());
			jogo.setGolsTime1((jogo.getGolsTime1()==null) ? 0 : jogo.getGolsTime1());
        	jogo.setGolsTime2((jogo.getGolsTime2()==null) ? 0 : jogo.getGolsTime2());
			JogoDao.salvar(jogo);
			resetInputs();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogada salvo com sucesso!", ""));
		} else {
			if(jogo.getTime1().equalsIgnoreCase(jogo.getTime2())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogo. O time 1 é igual ao do time 2.", ""));
			} else if(jogo.getTime1()==null || jogo.getTime2()==null || jogo.getTime1().isEmpty() || jogo.getTime2().isEmpty() || jogo.getTime1().isBlank() || jogo.getTime2().isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogo. Os campos time 1 e time 2 não podem ficar em branco ou conter letras maiúsculas.", ""));
			}
		}
		return null;
	}
	
	public void resetInputs() {
		jogo.setTime1(null);
        jogo.setTime2(null);
        jogo.setGolsTime1(null);
        jogo.setGolsTime2(null);
        jogo.setDataPartida(null);
        auxiliar.setLetra(null);
    }
	
	public List<Jogo> localizar() throws Exception {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Time selecionado: " + auxiliar.getLetra().toString().toLowerCase(), null));
		this.visivel = true;
		listaJogos = (listaJogos==null) ? JogoDao.buscarJogosTime(auxiliar.getLetra().toLowerCase()) : listaJogos;
		resetInputs();
		return listaJogos;
	}
	

	public Auxiliar getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(Auxiliar auxiliar) {
		this.auxiliar = auxiliar;
	}
	
	public Boolean getVisivel() {
		return visivel;
	}

	public void setVisivel(Boolean visivel) {
		this.visivel = visivel;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}	
	
	public List<Jogo> getListaJogos() throws Exception {
		listaJogos = (listaJogos==null) ? localizar() : listaJogos; 
		return listaJogos;
	}

	public void setListaJogos(List<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}
}
