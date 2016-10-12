package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import util.DButil;
import model.TnUser;
public class UserDao {
	public static void insertUser(TnUser user) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateUser(TnUser u) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(u);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void removeUser(TnUser u) {
		if(p == null){
			return ;
		}
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(u));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static TnUser getUserById(long userid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnUser user = null;
        String qString = "select b from TnUsers b where b.userid = :id";
        
        try{
            TypedQuery<TnUser> query = em.createQuery(qString,TnUser.class);
            query.setParameter("id", userid);
            user = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return user;  
	}
}
