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
			Query query = em.createNamedQuery("listarJogos");
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
			Query query = em.createNamedQuery("listarResumo");
			query.setParameter("time", time);
			List<Jogo> lista = query.getResultList();
			return lista;
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}
	
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
