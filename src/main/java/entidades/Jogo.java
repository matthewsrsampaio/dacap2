package entidades;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name = "listarJogosTime", query = "select j from Jogo j where j.time1 = :time or j.time2 = :time")
})

@Entity
public class Jogo {	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_jogo")
	private Integer id;
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime dataCadastro = LocalDateTime.now();
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
		return "<br> Jogo ->" + " Data da Partida = " + dataCadastro + ", Time 1 = " + time1 + ", Gols Time 1 = " + golsTime1 + ", Time 2 = " + time2 + ", Gols Time 2 = " + golsTime2 + ", ID = " + id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
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
