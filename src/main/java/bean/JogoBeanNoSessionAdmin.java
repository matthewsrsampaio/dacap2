package bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
	private List<Jogo> listaTimeA = new ArrayList<>();;
	private List<Jogo> listaTimeB = new ArrayList<>();;
	private List<Jogo> listaTimeC = new ArrayList<>();;
	private Jogo jogo = new Jogo();
	
	public String salvar() throws Exception {		
		//Se não for o mesmo time
		if(jogo.getTime1().equals(jogo.getTime1().toLowerCase()) && jogo.getTime2().equals(jogo.getTime2().toLowerCase()) && !jogo.getTime1().equals(jogo.getTime2().toLowerCase()) && !jogo.getTime1().isEmpty() && !jogo.getTime2().isEmpty() && jogo.getTime1()!=null && jogo.getTime2()!=null) {	
			JogoDao.salvar(jogo);
			resetInputs();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogada salvo com sucesso!", ""));
		} else {
			if(jogo.getTime1().equalsIgnoreCase(jogo.getTime2())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogo. O time 1 é igual ao do time 2.", ""));
			} else if(jogo.getTime1()!=null || jogo.getTime2()!=null) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogo. Time 1 ou time 2 não existem ou estão em maiúsculo.", ""));
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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Time selecionado: " + auxiliar.getLetra().toString(), null));
		this.visivel = true;
		listaJogos = (listaJogos==null) ? JogoDao.buscarJogosTime(auxiliar.getLetra()) : listaJogos;
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

	public List<Jogo> getListaTimeA() {
		return listaTimeA;
	}

	public void setListaTimeA(List<Jogo> listaTimeA) {
		this.listaTimeA = listaTimeA;
	}

	public List<Jogo> getListaTimeB() {
		return listaTimeB;
	}

	public void setListaTimeB(List<Jogo> listaTimeB) {
		this.listaTimeB = listaTimeB;
	}

	public List<Jogo> getListaTimeC() {
		return listaTimeC;
	}

	public void setListaTimeC(List<Jogo> listaTimeC) {
		this.listaTimeC = listaTimeC;
	}

	
	
}
