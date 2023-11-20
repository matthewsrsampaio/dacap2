package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Jogo;
import entidades.TimeA;
import entidades.TimeB;
import entidades.TimeC;
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
	
	public static void salvarTimeA(TimeA a) throws Exception {
	    EntityManager em = Jpa.criarEntityManager();
	    try {
		    em.getTransaction().begin();
		    em.persist(a);
		    em.getTransaction().commit();
	    } catch (Exception e) {
		    throw e;
	    } finally {
		    em.close();
	    }
	}
	
	public static void salvarTimeB(TimeB b) throws Exception {
	    EntityManager em = Jpa.criarEntityManager();
	    try {
		    em.getTransaction().begin();
		    em.persist(b);
		    em.getTransaction().commit();
	    } catch (Exception e) {
		    throw e;
	    } finally {
		    em.close();
	    }
	}
	
	public static void salvarTimeC(TimeC c) throws Exception {
	    EntityManager em = Jpa.criarEntityManager();
	    try {
		    em.getTransaction().begin();
		    em.persist(c);
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
	
	public static void excluirTimeA(TimeA timeA) throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			em.getTransaction().begin();
			timeA = em.find(TimeA.class, timeA.getId());
			em.remove(timeA);
			em.getTransaction().commit();
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static void excluirTimeB(TimeB timeB) throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			em.getTransaction().begin();
			timeB = em.find(TimeB.class, timeB.getId());
			em.remove(timeB);
			em.getTransaction().commit();
		}catch(Exception e) {
			throw e;
		}finally {
			em.close();
		}
	}
	
	public static void excluirTimeC(TimeC timeC) throws Exception {
		EntityManager em = Jpa.criarEntityManager();
		try {
			em.getTransaction().begin();
			timeC = em.find(TimeC.class, timeC.getId());
			em.remove(timeC);
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
	
	public static List<TimeA> buscarInfoTimeA() throws Exception {
	    EntityManager em = Jpa.criarEntityManager();
	    try {
	        Query query = em.createQuery("select t from TimeA t");
	        List<TimeA> listaTimeA = query.getResultList();
	        return listaTimeA;
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	
	public static List<TimeB> buscarInfoTimeB() throws Exception {
	    EntityManager em = Jpa.criarEntityManager();
	    try {
	        Query query = em.createQuery("select t from TimeB t");
	        List<TimeB> listaTimeB = query.getResultList();
	        return listaTimeB;
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        em.close();
	    }
	}
	
	public static List<TimeC> buscarInfoTimeC() throws Exception {
	    EntityManager em = Jpa.criarEntityManager();
	    try {
	        Query query = em.createQuery("select t from TimeC t");
	        List<TimeC> listaTimeC = query.getResultList();
	        return listaTimeC;
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
