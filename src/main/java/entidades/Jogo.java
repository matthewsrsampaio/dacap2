package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name= "listarJogos", query = "select j from Jogo j"),
	@NamedQuery(name = "listarResumo", query = "select j from Jogo j where j.time1 like :time or j.time2 like :time")	
})

@Entity
public class Jogo {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATE")
	private Date dataCadastro = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATE")
	private Date dataPartida;
	@Column(name = "time_1")
	private String time1;
	@Column(name = "time_2")
	private String time2;
	@Column(name = "gols_time_1")
	private Integer golsTime1;
	@Column(name = "gols_time_2")
	private Integer golsTime2;
	
	@Override
	public String toString() {
		return "Jogo [id=" + id + ", dataCadastro=" + dataCadastro + ", dataPartida=" + dataPartida + ", time1=" + time1
				+ ", time2=" + time2 + ", golsTime1=" + golsTime1 + ", golsTime2=" + golsTime2 + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataPartida() {
		return dataPartida;
	}
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public Integer getGolsTime1() {
		return golsTime1;
	}
	public void setGolsTime1(Integer golsTime1) {
		this.golsTime1 = golsTime1;
	}
	public Integer getGolsTime2() {
		return golsTime2;
	}
	public void setGolsTime2(Integer golsTime2) {
		this.golsTime2 = golsTime2;
	}
}
