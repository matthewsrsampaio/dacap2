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
		/*	//pontuação
			 if(jogo.getGolsTime1().equals(jogo.getGolsTime2())) {
				jogo.setEmpates(1);
				jogo.setVitoriasTime1(0);
				jogo.setVitoriasTime2(0);
				jogo.setDerrotasTime1(0);
				jogo.setDerrotasTime2(0);
				jogo.setPontosTime1(1);
				jogo.setPontosTime2(1);
				/*
				 * Como vou fazer com os gols sofridos?
				 * 	-Os gols sofridos podem ser feitos a partir de uma query
				 *Como vou fazer o saldo de gols?
					- o saldo de gols pode ser feito a partir de uma query
				 *Como vou fazer buscar o resultado de cada time de forma separada?
				 *	- os times precisam ser entidades diferentes, com 1 tabela para cada time.
				*/
				
				
			//} 
		
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
