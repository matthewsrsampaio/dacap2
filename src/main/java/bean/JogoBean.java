package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import dao.JogoDao;
import entidades.Jogo;
import entidades.TimeA;
import entidades.TimeB;
import entidades.TimeC;

@ManagedBean
@ViewScoped
public class JogoBean {
	
	private String localizarInput;
	private Jogo jogo = new Jogo();
	private List<Jogo> listaJogada;
	private List<TimeA> listaTimeA;
	private List<TimeB> listaTimeB;
	private List<TimeC> listaTimeC;
	
	public void onRowEdit(RowEditEvent<Jogo> event) throws Exception {	
		JogoDao.editar(event.getObject());
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + event.getObject().getId()+"   ->   Jogadores Editados: ", String.valueOf(event.getObject().getTime1() + " e " + event.getObject().getTime2())));
    }
	
    public void onRowCancel(RowEditEvent<Jogo> event) throws Exception {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ID: " + event.getObject().getId()+"   ->   Edição cancelada: ", String.valueOf(event.getObject().getTime1() + " e " + event.getObject().getTime2())));
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
	
	public void localizar() {
//		localizarInput está com o valor do input
		String texto;
		List<Jogo> listaJogos = JogoDao.buscarJogosTime(localizarInput);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Lista de jogos " + listaJogos, ""));
	}
	
	public void infoTimeA() throws Exception {
		Integer pontos = 0;
		Integer vitorias = 0;
		Integer derrotas = 0;
		Integer empates =0;
		Integer gols = 0;
		Integer golsSofridos = 0;
		Integer saldoGols = 0;
		try {
			listaTimeA = JogoDao.buscarInfoTimeA();
			for(TimeA a :  listaTimeA) {
				pontos += a.getPontos();
				vitorias += a.getVitorias();
				derrotas += a.getDerrotas();
				empates += a.getEmpates();
				gols += a.getGolsTime();
				golsSofridos += a.getGolsSofridos();
			}
			saldoGols = gols - golsSofridos;
	        	FacesContext
	        	.getCurrentInstance()
	        	.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação sobre o time A => ", "Pontos: "+pontos.toString() + ", Vitórias: "+vitorias.toString() + ", Derrotas: "+derrotas.toString() + ", Empates: "+empates.toString()
	        	+ ", Gols marcados: "+gols.toString() + ", Gols sofridos: "+golsSofridos.toString() + ", Saldo de gols: " + saldoGols.toString()));
		}catch(Exception e) {
			throw e;
		}
    }
	
	public void infoTimeB() throws Exception {
		Integer pontos = 0;
		Integer vitorias = 0;
		Integer derrotas = 0;
		Integer empates =0;
		Integer gols = 0;
		Integer golsSofridos = 0;
		Integer saldoGols = 0;
		try {
			listaTimeB = JogoDao.buscarInfoTimeB();
			for(TimeB b :  listaTimeB) {
				pontos += b.getPontos();
				vitorias += b.getVitorias();
				derrotas += b.getDerrotas();
				empates += b.getEmpates();
				gols += b.getGolsTime();
				golsSofridos += b.getGolsSofridos();
			}
			saldoGols = gols - golsSofridos;
	        	FacesContext
	        	.getCurrentInstance()
	        	.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação sobre o time B => ", "Pontos: "+pontos.toString() + ", Vitórias: "+vitorias.toString() + ", Derrotas: "+derrotas.toString() + ", Empates: "+empates.toString()
	        	+ ", Gols marcados: "+gols.toString() + ", Gols sofridos: "+golsSofridos.toString() + ", Saldo de gols: " + saldoGols.toString()));
		}catch(Exception e) {
			throw e;
		}
    }
	
	public void infoTimeC() throws Exception {
		Integer pontos = 0;
		Integer vitorias = 0;
		Integer derrotas = 0;
		Integer empates =0;
		Integer gols = 0;
		Integer golsSofridos = 0;
		Integer saldoGols = 0;
		try {
			listaTimeC = JogoDao.buscarInfoTimeC();
			for(TimeC c :  listaTimeC) {
				pontos += c.getPontos();
				vitorias += c.getVitorias();
				derrotas += c.getDerrotas();
				empates += c.getEmpates();
				gols += c.getGolsTime();
				golsSofridos += c.getGolsSofridos();
			}
			saldoGols = gols - golsSofridos;
	        	FacesContext
	        	.getCurrentInstance()
	        	.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informação sobre o time C => ", "Pontos: "+pontos.toString() + ", Vitórias: "+vitorias.toString() + ", Derrotas: "+derrotas.toString() + ", Empates: "+empates.toString()
	        	+ ", Gols marcados: "+gols.toString() + ", Gols sofridos: "+golsSofridos.toString() + ", Saldo de gols: " + saldoGols.toString()));
		}catch(Exception e) {
			throw e;
		}
    }
	

	public String getLocalizarInput() {
		return localizarInput;
	}

	public void setLocalizarInput(String localizarInput) {
		this.localizarInput = localizarInput;
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

	public List<TimeA> getListaTimeA() {
		return listaTimeA;
	}

	public void setListaTimeA(List<TimeA> listaTimeA) {
		this.listaTimeA = listaTimeA;
	}

	public List<TimeB> getListaTimeB() {
		return listaTimeB;
	}

	public void setListaTimeB(List<TimeB> listaTimeB) {
		this.listaTimeB = listaTimeB;
	}

	public List<TimeC> getListaTimeC() {
		return listaTimeC;
	}

	public void setListaTimeC(List<TimeC> listaTimeC) {
		this.listaTimeC = listaTimeC;
	}

	
}
