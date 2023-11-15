package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Jogo {
	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATE")
	private Date dataCadastro = new Date();
	//Valor para tima são A, B ou C
	private String time1;
	private String time2;
	private Integer golsTime1;
	private Integer golsTime2;
	
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
