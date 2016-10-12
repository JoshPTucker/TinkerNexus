package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.TnExpert;
import util.DButil;
public class ExpertDao {
	public static void insertExpert(TnExpert expert) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(expert);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateExpert(TnExpert ex) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(ex);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void removeExpert(TnExpert ex) {
		if(ex == null){
			return ;
		}
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(ex));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static TnExpert getExpertById(long expertid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnExpert expert = null;
        String qString = "select b from TnExperts b where b.expertid = :id";
        
        try{
            TypedQuery<TnExpert> query = em.createQuery(qString,TnExpert.class);
            query.setParameter("id", expertid);
            expert = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return expert;  
	}
}
