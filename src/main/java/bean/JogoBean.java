package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import dao.JogoDao;
import entidades.Jogo;
import entidades.ResumoTime;

@ManagedBean
@ViewScoped
public class JogoBean {
	
	private Jogo jogo = new Jogo();
	private List<Jogo> listaJogada;
	private List<Jogo> listaResumo = new ArrayList<Jogo>();
	private List<ResumoTime> listaResumoFinal;
	private boolean visivel = false;
	
	public void onRowEdit(RowEditEvent<Jogo> event) throws Exception {	
		if(!(event.getObject().getTime1().equals(event.getObject().getTime2()))) {
			JogoDao.editar(event.getObject());
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + event.getObject().getId()+"   ->   Jogadores Editados: ", String.valueOf(event.getObject().getTime1() + " e " + event.getObject().getTime2())));
		} else {			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"ID: " + event.getObject().getId()+"   ->   Edição não salva.", ""));
		}
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
	
	public void fechar() {
		this.visivel = false;
	}
	
	public void resumo() throws Exception {
	    listaResumo = JogoDao.listar();
	    listaResumoFinal = new ArrayList<ResumoTime>();
	    String[] listaFixa = {"a", "b", "c"};
	    
	    for (String time : listaFixa) {
	        List<Jogo> listaResumo = JogoDao.buscarJogosTime(time);
	        int vitorias = 0;
	        int derrotas = 0;
	        int empates = 0;
	        int gols_marcados = 0;
	        int gols_sofridos = 0;
	        int saldo_gols = 0;
	        int pontuacao = 0;

	        for (Jogo jogo : listaResumo) {
	        	if(jogo.getGolsTime1()==null || jogo.getGolsTime2()==null) {
	        		jogo.setGolsTime1(0);
	        		jogo.setGolsTime2(0);
	        	}
	            gols_marcados += jogo.getTime1().equals(time) ? jogo.getGolsTime1() : jogo.getGolsTime2();
	            gols_sofridos += jogo.getTime1().equals(time) ? jogo.getGolsTime2() : jogo.getGolsTime1();
	            saldo_gols += jogo.getTime1().equals(time) ? (jogo.getGolsTime1() - jogo.getGolsTime2()) : (jogo.getGolsTime2() - jogo.getGolsTime1());

	            if (jogo.getTime1().equals(time) && jogo.getGolsTime1() > jogo.getGolsTime2() || jogo.getTime2().equals(time) && jogo.getGolsTime2() > jogo.getGolsTime1()) {
	                vitorias++;
	                pontuacao += 3;
	            } else if (jogo.getGolsTime1().equals(jogo.getGolsTime2())) {
	                empates++;
	                pontuacao++;
	            } else {
	                derrotas++;
	            }
	        }

	        listaResumoFinal.add(new ResumoTime(time, pontuacao, vitorias, derrotas, empates, gols_marcados, gols_sofridos, saldo_gols));
	        this.visivel = true;
	    }
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

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public List<Jogo> getListaResumo() {
		return listaResumo;
	}

	public void setListaResumo(List<Jogo> listaResumo) {
		this.listaResumo = listaResumo;
	}

	public List<ResumoTime> getListaResumoFinal() {
		return listaResumoFinal;
	}

	public void setListaResumoFinal(List<ResumoTime> listaResumoFinal) {
		this.listaResumoFinal = listaResumoFinal;
	}
	
}
