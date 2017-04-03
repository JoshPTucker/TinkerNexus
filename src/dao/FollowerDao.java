package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.TnFollower;
import util.DBUtil;
public class FollowerDao {
	public static void insertFollower(TnFollower follower) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(follower);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateFollower(TnFollower f) {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(f);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void removeFollower(TnFollower f) {
		if(f == null){
			return ;
		}
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(f));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static TnFollower getFollowerById(long followerid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnFollower follower = null;
        String qString = "select b from TnFollowers b where b.followerid = :id";
        
        try{
            TypedQuery<TnFollower> query = em.createQuery(qString,TnFollower.class);
            query.setParameter("id", followerid);
            follower = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return follower;  
	}
}
