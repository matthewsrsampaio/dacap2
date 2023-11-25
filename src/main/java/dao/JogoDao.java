package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Jogo;
import util.Jpa;

public class JogoDao {
	
	public static void salvar(Jogo jogo) throws Exception {
	    EntityManager em = Jpa.criarEntityManager();
	    try {
		    em.getTransaction().begin();
		    em.persist(jogo);
		    em.getTransaction().commit();
	    } catch (Exception e) {
		    throw e;
	    } finally {
		    em.close();
	    }
	}
	
	public static void editar(Jogo jogo) {
		EntityManager em = Jpa.criarEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(jogo);
			em.getTransaction().commit();
		} catch(Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}
	
	public static void excluir(Jogo jogo) throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			em.getTransaction().begin();
			jogo = em.find(Jogo.class, jogo.getId());
			em.remove(jogo);
			em.getTransaction().commit();
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static List<Jogo> listar() throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			Query query = em.createQuery("select j from Jogo j");
			List<Jogo> lista = query.getResultList();
			return lista;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static List<Jogo> listarTimeA() throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			Query query = em.createQuery("ETA");
			List<Jogo> lista = query.getResultList();
			return lista;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static List<Jogo> listarTimeB() throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			Query query = em.createQuery("ETB");
			List<Jogo> lista = query.getResultList();
			return lista;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static List<Jogo> listarTimeC() throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			Query query = em.createQuery("ETC");
			List<Jogo> lista = query.getResultList();
			return lista;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static List<Jogo> buscarJogosTime(String time) throws Exception{
		EntityManager em = Jpa.criarEntityManager();
		try {
			Query query = em.createNamedQuery("listarJogosTime");
			query.setParameter("time", time);
			List<Jogo> lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}
	
//	public static List<Jogo> listaEstatistica() throws Exception{
//		EntityManager em = Jpa.criarEntityManager();
//		try {
//			Query query = em.createQuery("select time, sum(pontuacao) as pontuacao, sum(case when resultado = 'Vitoria' then 1 else 0 end) as numero_vitorias,  sum(case when resultado = 'Derrota' then 1 else 0 end) as numero_derrotas, sum(case when resultado = 'Empate' then 1 else 0 end) as numero_empates, sum(gols_marcados) as gols_marcados, sum(gols_sofridos) as gols_sofridos, sum(gols_marcados - gols_sofridos) as saldo_gols from ( select j.time1 as time, j.golsTime1 as gols_marcados, j.golsTime2 as gols_sofridos, case when j.time1 = 'a' and j.golsTime1 > j.golsTime2 then 3 when j.time1 = 'a' and j.golsTime1 < j.golsTime2 then 0 when j.time1 = 'a' and j.golsTime1 = j.golsTime2 then 1 when j.time1 = 'b' and j.golsTime1 > j.golsTime2 then 3 when j.time1 = 'b' and j.golsTime1 < j.golsTime2 then 0 when j.time1 = 'b' and j.golsTime1 = j.golsTime2 then 1 when j.time1 = 'c' and j.golsTime1 > j.golsTime2 then 3 when j.time1 = 'c' and j.golsTime1 < j.golsTime2 then 0 when j.time1 = 'c' and j.golsTime1 = j.golsTime2 then 1 end as pontuacao, case when j.time1 = 'a' and j.golsTime1 > j.golsTime2 then 'Vitoria' when j.time1 = 'a' and j.golsTime1 < j.golsTime2 then 'Derrota' when j.time1 = 'a' and j.golsTime1 = j.golsTime2 then 'Empate' when j.time1 = 'b' and j.golsTime1 > j.golsTime2 then 'Vitoria' when j.time1 = 'b' and j.golsTime1 < j.golsTime2 then 'Derrota' when j.time1 = 'b' and j.golsTime1 = j.golsTime2 then 'Empate' when j.time1 = 'c' and j.golsTime1 > j.golsTime2 then 'Vitoria' when j.time1 = 'c' and j.golsTime1 < j.golsTime2 then 'Derrota' when j.time1 = 'c' and j.golsTime1 = j.golsTime2 then 'Empate' end as resultado from Jogo j union all select j.time2 as time, j.golsTime2 as gols_marcados, j.golsTime1 as gols_sofridos, case when j.time2 = 'a' and j.golsTime2 > j.golsTime1 then 3 when j.time2 = 'a' and j.golsTime2 < j.golsTime1 then 0 when j.time2 = 'a' and j.golsTime2 = j.golsTime1 then 1 when j.time2 = 'b' and j.golsTime2 > j.golsTime1 then 3 when j.time2 = 'b' and j.golsTime2 < j.golsTime1 then 0 when j.time2 = 'b' and j.golsTime2 = j.golsTime1 then 1 when j.time2 = 'c' and j.golsTime2 > j.golsTime1 then 3 when j.time2 = 'c' and j.golsTime2 < j.golsTime1 then 0 when j.time2 = 'c' and j.golsTime2 = j.golsTime1 then 1 end as pontuacao, case when j.time2 = 'a' and j.golsTime2 > j.golsTime1 then 'Vitoria' when j.time2 = 'a' and j.golsTime2 < j.golsTime1 then 'Derrota' when j.time2 = 'a' and j.golsTime2 = j.golsTime1 then 'Empate' when j.time2 = 'b' and j.golsTime2 > j.golsTime1 then 'Vitoria' when j.time2 = 'b' and j.golsTime2 < j.golsTime1 then 'Derrota' when j.time2 = 'b' and j.golsTime2 = j.golsTime1 then 'Empate' when j.time2 = 'c' and j.golsTime2 > j.golsTime1 then 'Vitoria' when j.time2 = 'c' and j.golsTime2 < j.golsTime1 then 'Derrota' when j.time2 = 'c' and j.golsTime2 = j.golsTime1 then 'Empate' end as resultado from Jogo j ) as subquery group by time");
//			List<Jogo> lista = query.getResultList();
//			return lista;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			em.close();
//		}
//	}
	
//	public static List<Jogo> listaEstatistica() throws Exception{
//		EntityManager em = Jpa.criarEntityManager();
//		try {
//			Query query = em.createNamedQuery("ET", String.class);
//			List<Jogo> lista = query.getResultList();
//			return lista;
//		} catch (Exception e) {
//			throw e;
//		} finally {
//			em.close();
//		}
//	}
	
	public static Jogo buscarPorId(Integer id) throws Exception{
		EntityManager em = Jpa.criarEntityManager();
		try {
			Jogo jogo = em.find(Jogo.class, id);
			return jogo;
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}

}
