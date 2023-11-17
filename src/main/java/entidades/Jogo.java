package entidades;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_time_a_fk", referencedColumnName = "idtimea")
//    private TimeA timeAFk;
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_time_b_fk", referencedColumnName = "idtimeb")
//    private TimeA timeBFk;
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_time_c_fk", referencedColumnName = "idtimec")
//    private TimeA timeCFk;
	
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
//	public TimeA getTimeAFk() {
//		return timeAFk;
//	}
//	public void setTimeAFk(TimeA timeAFk) {
//		this.timeAFk = timeAFk;
//	}
//	public TimeA getTimeBFk() {
//		return timeBFk;
//	}
//	public void setTimeBFk(TimeA timeBFk) {
//		this.timeBFk = timeBFk;	
//	}
//	public TimeA getTimeCFk() {
//		return timeCFk;
//	}
//	public void setTimeCFk(TimeA timeCFk) {
//		this.timeCFk = timeCFk;
//	}
}
