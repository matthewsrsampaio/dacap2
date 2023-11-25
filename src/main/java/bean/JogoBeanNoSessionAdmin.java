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
	private List<Jogo> listaStatus;
	private List<Jogo> listaTimeA;
	private List<Jogo> listaTimeB;
	private List<Jogo> listaTimeC;
	private Jogo jogo = new Jogo();
	
	public String salvar() throws Exception {		
		//Se não for o mesmo time
		if(!jogo.getTime1().equalsIgnoreCase(jogo.getTime2()) && !jogo.getTime1().isEmpty() && !jogo.getTime2().isEmpty()) {					
				 
			JogoDao.salvar(jogo);
			
			resetInputs();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Jogada salvo com sucesso!", ""));
		} else {
			if(jogo.getTime1().equalsIgnoreCase(jogo.getTime2())) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogo. O time 1 é igual ao do time 2.", ""));
			} else if( jogo.getTime1().isEmpty() || jogo.getTime2().isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Imposssível salvar jogo. Time 1 ou time 2 não existem.", ""));
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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Time selecionado: " + auxiliar.getLetra().toString().toUpperCase(), null));
		this.visivel = true;
		listaJogos = (listaJogos==null) ? JogoDao.buscarJogosTime(auxiliar.getLetra()) : listaJogos;
		resetInputs();
		return listaJogos;
	}
	
	public List<Jogo> exibirListaTimes() throws Exception {
		listaTimeA = JogoDao.listarTimeA();
		listaTimeB = JogoDao.listarTimeB();
		listaTimeC = JogoDao.listarTimeC();
		
		//TIME A
		for(Jogo a : listaTimeA) {
				//VITORIA time A1
			if(a.getTime1()=="a" && a.getGolsTime1() > a.getGolsTime2()) {
				jogo.setPontuacao(jogo.getPontuacao()+3);
				jogo.setVitorias(jogo.getVitorias()+1);
				jogo.setDerrotas(jogo.getDerrotas()+0);
				jogo.setEmpates(jogo.getEmpates()+0);
				jogo.setGols_marcados(jogo.getGols_marcados()+a.getGolsTime1());
				jogo.setGols_sofridos(jogo.getGols_sofridos()+a.getGolsTime2());
				//VITORIA time A2
			} else if(a.getTime2()=="a" && a.getGolsTime2() > a.getGolsTime1()) {
				jogo.setPontuacao(jogo.getPontuacao()+3);
				jogo.setVitorias(jogo.getVitorias()+1);
				jogo.setDerrotas(jogo.getDerrotas()+0);
				jogo.setEmpates(jogo.getEmpates()+0);
				jogo.setGols_marcados(jogo.getGols_marcados()+a.getGolsTime2());
				jogo.setGols_sofridos(jogo.getGols_sofridos()+a.getGolsTime1());
				//DERROTA time A1
			} else if(a.getTime1()=="a" && a.getGolsTime1() < a.getGolsTime2()) {
				jogo.setPontuacao(jogo.getPontuacao()+0);
				jogo.setVitorias(jogo.getVitorias()+0);
				jogo.setDerrotas(jogo.getDerrotas()+1);
				jogo.setEmpates(jogo.getEmpates()+0);
				jogo.setGols_marcados(jogo.getGols_marcados()+a.getGolsTime1());
				jogo.setGols_sofridos(jogo.getGols_sofridos()+a.getGolsTime2());
				//DERROTA time A2
			} else if(a.getTime2()=="a" && a.getGolsTime1() > a.getGolsTime2()) {
				jogo.setPontuacao(jogo.getPontuacao()+0);
				jogo.setVitorias(jogo.getVitorias()+0);
				jogo.setDerrotas(jogo.getDerrotas()+1);
				jogo.setEmpates(jogo.getEmpates()+0);
				jogo.setGols_marcados(jogo.getGols_marcados()+a.getGolsTime1());
				jogo.setGols_sofridos(jogo.getGols_sofridos()+a.getGolsTime2());
				//EMPATE time A1
			} else if(a.getTime1()=="a" && a.getGolsTime1() == a.getGolsTime2()) {
				jogo.setPontuacao(jogo.getPontuacao()+1);
				jogo.setVitorias(jogo.getVitorias()+0);
				jogo.setDerrotas(jogo.getDerrotas()+0);
				jogo.setEmpates(jogo.getEmpates()+1);
				jogo.setGols_marcados(jogo.getGols_marcados()+a.getGolsTime1());
				jogo.setGols_sofridos(jogo.getGols_sofridos()+a.getGolsTime2());
				//EMPATE time A2
			}  else if(a.getTime2()=="a" && a.getGolsTime1() == a.getGolsTime2()) {
				jogo.setPontuacao(jogo.getPontuacao()+1);
				jogo.setVitorias(jogo.getVitorias()+0);
				jogo.setDerrotas(jogo.getDerrotas()+0);
				jogo.setEmpates(jogo.getEmpates()+1);
				jogo.setGols_marcados(jogo.getGols_marcados()+a.getGolsTime1());
				jogo.setGols_sofridos(jogo.getGols_sofridos()+a.getGolsTime2());
			}
		}
		jogo.setTime("A");
		jogo.setSaldo_gols(jogo.getGols_marcados()-jogo.getGols_sofridos());
		listaStatus.add(jogo);
		resetInputs();
		
		//TIME B
		for(Jogo b : listaTimeB) {
			//VITORIA time B1
		if(b.getTime1()=="b" && b.getGolsTime1() > b.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+3);
			jogo.setVitorias(jogo.getVitorias()+1);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+b.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+b.getGolsTime2());
			//VITORIA time B2
		} else if(b.getTime2()=="b" && b.getGolsTime2() > b.getGolsTime1()) {
			jogo.setPontuacao(jogo.getPontuacao()+3);
			jogo.setVitorias(jogo.getVitorias()+1);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+b.getGolsTime2());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+b.getGolsTime1());
			//DERROTA time A1
		} else if(b.getTime1()=="b" && b.getGolsTime1() < b.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+0);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+1);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+b.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+b.getGolsTime2());
			//DERROTA time A2
		} else if(b.getTime2()=="b" && b.getGolsTime1() > b.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+0);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+1);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+b.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+b.getGolsTime2());
			//EMPATE time A1
		} else if(b.getTime1()=="b" && b.getGolsTime1() == b.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+1);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+1);
			jogo.setGols_marcados(jogo.getGols_marcados()+b.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+b.getGolsTime2());
			//EMPATE time A2
		}  else if(b.getTime2()=="b" && b.getGolsTime1() == b.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+1);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+1);
			jogo.setGols_marcados(jogo.getGols_marcados()+b.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+b.getGolsTime2());
		}
	}
	jogo.setTime("B");
	jogo.setSaldo_gols(jogo.getGols_marcados()-jogo.getGols_sofridos());
	listaStatus.add(jogo);
	resetInputs();
	
	//TIME C
	for(Jogo c : listaTimeC) {
			//VITORIA time C1
		if(c.getTime1()=="c" && c.getGolsTime1() > c.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+3);
			jogo.setVitorias(jogo.getVitorias()+1);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+c.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+c.getGolsTime2());
			//VITORIA time C2
		} else if(c.getTime2()=="c" && c.getGolsTime2() > c.getGolsTime1()) {
			jogo.setPontuacao(jogo.getPontuacao()+3);
			jogo.setVitorias(jogo.getVitorias()+1);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+c.getGolsTime2());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+c.getGolsTime1());
			//DERROTA time C1
		} else if(c.getTime1()=="c" && c.getGolsTime1() < c.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+0);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+1);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+c.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+c.getGolsTime2());
			//DERROTA time C2
		} else if(c.getTime2()=="c" && c.getGolsTime1() > c.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+0);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+1);
			jogo.setEmpates(jogo.getEmpates()+0);
			jogo.setGols_marcados(jogo.getGols_marcados()+c.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+c.getGolsTime2());
			//EMPATE time C1
		} else if(c.getTime1()=="c" && c.getGolsTime1() == c.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+1);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+1);
			jogo.setGols_marcados(jogo.getGols_marcados()+c.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+c.getGolsTime2());
			//EMPATE time C2
		}  else if(c.getTime2()=="c" && c.getGolsTime1() == c.getGolsTime2()) {
			jogo.setPontuacao(jogo.getPontuacao()+1);
			jogo.setVitorias(jogo.getVitorias()+0);
			jogo.setDerrotas(jogo.getDerrotas()+0);
			jogo.setEmpates(jogo.getEmpates()+1);
			jogo.setGols_marcados(jogo.getGols_marcados()+c.getGolsTime1());
			jogo.setGols_sofridos(jogo.getGols_sofridos()+c.getGolsTime2());
		}
	}
	jogo.setTime("C");
	jogo.setSaldo_gols(jogo.getGols_marcados()-jogo.getGols_sofridos());
	listaStatus.add(jogo);
	resetInputs();
		
		this.visivel = true;
		return listaStatus;
	}
	
	public Auxiliar getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(Auxiliar auxiliar) {
		this.auxiliar = auxiliar;
	}

	public List<Jogo> getListaStatus() throws Exception {
		return listaStatus;
	}

	public void setListaStatus(List<Jogo> listaStatus) {
		this.listaStatus = listaStatus;
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
