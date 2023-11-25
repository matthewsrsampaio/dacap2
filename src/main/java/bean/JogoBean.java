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
		if(!(event.getObject().getTime1().equals(event.getObject().getTime2()))) {
			JogoDao.editar(event.getObject());
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ID: " + event.getObject().getId()+"   ->   Jogadores Editados: ", String.valueOf(event.getObject().getTime1() + " e " + event.getObject().getTime2())));
		}
			
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"ID: " + event.getObject().getId()+"   ->   Edição não salva. Times duplicados!", ""));
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
