package bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.JogoDao;
import entidades.Jogo;
import entidades.TimeA;
import entidades.TimeB;
import entidades.TimeC;

@ManagedBean
public class JogoBeanNoSessionAdmin {
	private Jogo jogo = new Jogo();
	private TimeA timeA = new TimeA();
	private TimeB timeB = new TimeB();
	private TimeC timeC = new TimeC();	
	
	public String salvar() throws Exception {
		//Se não for o mesmo time
		if(!jogo.getTime1().equalsIgnoreCase(jogo.getTime2())) {//os times precisam ser diferentes
		//pontuação
			 //Empate
			 if(jogo.getGolsTime1().equals(jogo.getGolsTime2())) {//se os gols do time1 forem os mesmo do time2																						
				//Guardando os resultados do Time A em caso de empate
				if(jogo.getTime1().equalsIgnoreCase("a")||jogo.getTime2().equalsIgnoreCase("a")) {
					if(jogo.getTime1().equalsIgnoreCase("a")) {
						timeA.setGolsTime(jogo.getGolsTime1());
						timeA.setPontos(1);
						timeA.setEmpates(1);
						timeA.setVitorias(0);
						timeA.setDerrotas(0);
						timeA.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("a")) {
						timeA.setGolsTime(jogo.getGolsTime2());
						timeA.setPontos(1);
						timeA.setEmpates(1);
						timeA.setVitorias(0);
						timeA.setDerrotas(0);
						timeA.setGolsSofridos(jogo.getGolsTime1());
					}
				}
				//Guardando os resultados do Time B em caso de empate
				if(jogo.getTime1().equalsIgnoreCase("b")||jogo.getTime2().equalsIgnoreCase("b")) {
					if(jogo.getTime1().equalsIgnoreCase("b")) {
						timeB.setGolsTime(jogo.getGolsTime1());
						timeB.setPontos(1);
						timeB.setEmpates(1);
						timeB.setVitorias(0);
						timeB.setDerrotas(0);
						timeB.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("b")) {
						timeB.setGolsTime(jogo.getGolsTime2());
						timeB.setPontos(1);
						timeB.setEmpates(1);
						timeB.setVitorias(0);
						timeB.setDerrotas(0);
						timeB.setGolsSofridos(jogo.getGolsTime1());
					}
				}
				//Guardando os resultados do Time C em caso de empate
				if(jogo.getTime1().equalsIgnoreCase("c")||jogo.getTime2().equalsIgnoreCase("c")) {
					if(jogo.getTime1().equalsIgnoreCase("c")) {
						timeC.setGolsTime(jogo.getGolsTime1());
						timeC.setPontos(1);
						timeC.setEmpates(1);
						timeC.setVitorias(0);
						timeC.setDerrotas(0);
						timeC.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("c")) {
						timeC.setGolsTime(jogo.getGolsTime2());
						timeC.setPontos(1);
						timeC.setEmpates(1);
						timeC.setVitorias(0);
						timeC.setDerrotas(0);
						timeC.setGolsSofridos(jogo.getGolsTime1());
					}
				}
			}
			if(jogo.getTime1().equalsIgnoreCase("a")||(jogo.getTime2().equalsIgnoreCase("b")||jogo.getTime2().equalsIgnoreCase("c"))) {
				 //Se o time 1 A ganhar
				if(jogo.getGolsTime1() > jogo.getGolsTime2()) {
						if(jogo.getTime1().equalsIgnoreCase("a")) {
							timeA.setGolsTime(jogo.getGolsTime1());
							timeA.setPontos(3);
							timeA.setEmpates(0);
							timeA.setVitorias(1);
							timeA.setDerrotas(0);
							timeA.setGolsSofridos(jogo.getGolsTime2());
						} else if(jogo.getTime2().equalsIgnoreCase("b")) {
							timeB.setGolsTime(jogo.getGolsTime2());
							timeB.setPontos(0);
							timeB.setEmpates(0);
							timeB.setVitorias(0);
							timeB.setDerrotas(1);
							timeB.setGolsSofridos(jogo.getGolsTime1());
						} else if(jogo.getTime2().equalsIgnoreCase("c")) {
							timeC.setGolsTime(jogo.getGolsTime2());
							timeC.setPontos(0);
							timeC.setEmpates(0);
							timeC.setVitorias(0);
							timeC.setDerrotas(1);
							timeC.setGolsSofridos(jogo.getGolsTime1());
						}
				}
				 //Se o time 1 A perder
				if(jogo.getGolsTime1() < jogo.getGolsTime2()) {
					if(jogo.getTime1().equalsIgnoreCase("a")) {
						timeA.setGolsTime(jogo.getGolsTime1());
						timeA.setPontos(0);
						timeA.setEmpates(0);
						timeA.setVitorias(0);
						timeA.setDerrotas(1);
						timeA.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("b")) {
						timeB.setGolsTime(jogo.getGolsTime2());
						timeB.setPontos(3);
						timeB.setEmpates(0);
						timeB.setVitorias(1);
						timeB.setDerrotas(0);
						timeB.setGolsSofridos(jogo.getGolsTime1());
					} else if(jogo.getTime2().equalsIgnoreCase("c")) {
							timeC.setGolsTime(jogo.getGolsTime2());
							timeC.setPontos(3);
							timeC.setEmpates(0);
							timeC.setVitorias(1);
							timeC.setDerrotas(0);
							timeC.setGolsSofridos(jogo.getGolsTime1());
						}
				}
				 //Se o time 1 B ganhar
				if(jogo.getGolsTime1() > jogo.getGolsTime2()) {
					if(jogo.getTime1().equalsIgnoreCase("b")) {
						timeB.setGolsTime(jogo.getGolsTime1());
						timeB.setPontos(3);
						timeB.setEmpates(0);
						timeB.setVitorias(1);
						timeB.setDerrotas(0);
						timeB.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("a")) {
						timeA.setGolsTime(jogo.getGolsTime2());
						timeA.setPontos(0);
						timeA.setEmpates(0);
						timeA.setVitorias(0);
						timeA.setDerrotas(1);
						timeA.setGolsSofridos(jogo.getGolsTime1());
					} else if(jogo.getTime2().equalsIgnoreCase("c")) {
							timeC.setGolsTime(jogo.getGolsTime2());
							timeC.setPontos(0);
							timeC.setEmpates(0);
							timeC.setVitorias(0);
							timeC.setDerrotas(1);
							timeC.setGolsSofridos(jogo.getGolsTime1());
						}
				}
				 //Se o time 1 B perder
				if(jogo.getGolsTime1() < jogo.getGolsTime2()) {
					if(jogo.getTime1().equalsIgnoreCase("b")) {
						timeB.setGolsTime(jogo.getGolsTime1());
						timeB.setPontos(0);
						timeB.setEmpates(0);
						timeB.setVitorias(0);
						timeB.setDerrotas(1);
						timeB.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("a")) {
						timeA.setGolsTime(jogo.getGolsTime2());
						timeA.setPontos(3);
						timeA.setEmpates(0);
						timeA.setVitorias(1);
						timeA.setDerrotas(0);
						timeA.setGolsSofridos(jogo.getGolsTime1());
					} else if(jogo.getTime2().equalsIgnoreCase("c")) {
							timeC.setGolsTime(jogo.getGolsTime2());
							timeC.setPontos(3);
							timeC.setEmpates(0);
							timeC.setVitorias(1);
							timeC.setDerrotas(0);
							timeC.setGolsSofridos(jogo.getGolsTime1());
					}
				}
				//Se o time 1 C ganhar
				if(jogo.getGolsTime1() > jogo.getGolsTime2()) {
					if(jogo.getTime1().equalsIgnoreCase("c")) {
						timeC.setGolsTime(jogo.getGolsTime1());
						timeC.setPontos(3);
						timeC.setEmpates(0);
						timeC.setVitorias(1);
						timeC.setDerrotas(0);
						timeC.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("a")) {
						timeA.setGolsTime(jogo.getGolsTime2());
						timeA.setPontos(0);
						timeA.setEmpates(0);
						timeA.setVitorias(0);
						timeA.setDerrotas(1);
						timeA.setGolsSofridos(jogo.getGolsTime1());
					} else if(jogo.getTime2().equalsIgnoreCase("b")) {
							timeB.setGolsTime(jogo.getGolsTime2());
							timeB.setPontos(0);
							timeB.setEmpates(0);
							timeB.setVitorias(0);
							timeB.setDerrotas(1);
							timeB.setGolsSofridos(jogo.getGolsTime1());
					}
				}
				 //Se o time 1 C perder
				if(jogo.getGolsTime1() < jogo.getGolsTime2()) {
					if(jogo.getTime1().equalsIgnoreCase("c")) {
						timeC.setGolsTime(jogo.getGolsTime1());
						timeC.setPontos(0);
						timeC.setEmpates(0);
						timeC.setVitorias(0);
						timeC.setDerrotas(1);
						timeC.setGolsSofridos(jogo.getGolsTime2());
					} else if(jogo.getTime2().equalsIgnoreCase("a")) {
						timeA.setGolsTime(jogo.getGolsTime2());
						timeA.setPontos(3);
						timeA.setEmpates(0);
						timeA.setVitorias(1);
						timeA.setDerrotas(0);
						timeA.setGolsSofridos(jogo.getGolsTime1());
					} else if(jogo.getTime2().equalsIgnoreCase("b")) {
						timeB.setGolsTime(jogo.getGolsTime2());
						timeB.setPontos(3);
						timeB.setEmpates(0);
						timeB.setVitorias(1);
						timeB.setDerrotas(0);
						timeB.setGolsSofridos(jogo.getGolsTime1());
					}
				}
			 }
			 JogoDao.salvar(jogo);
			 if(timeA.getPontos()!=null) {
				 JogoDao.salvarTimeA(timeA);
			 }
			 if(timeB.getPontos()!=null) {
				 JogoDao.salvarTimeB(timeB);
			 }
			 if(timeC.getPontos()!=null) {
				 JogoDao.salvarTimeC(timeC);
			 }
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
	
	public String localizar() {
		
		return "";
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public TimeA getTimeA() {
		return timeA;
	}

	public void setTimeA(TimeA timeA) {
		this.timeA = timeA;
	}

	public TimeB getTimeB() {
		return timeB;
	}

	public void setTimeB(TimeB timeB) {
		this.timeB = timeB;
	}

	public TimeC getTimeC() {
		return timeC;
	}

	public void setTimeC(TimeC timeC) {
		this.timeC = timeC;
	}
	
	
}
