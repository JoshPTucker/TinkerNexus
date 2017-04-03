package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import util.DBUtil;
import model.TnComment;
public class commentDao {
	public static void insertComment(TnComment comment) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(comment);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateComment(TnComment c) {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(c);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void removeComment(TnComment c) {
		if(c == null){
			return ;
		}
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(c));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static TnComment getCommentById(long commentid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnComment comment = null;
        String qString = "select b from TnComment b where b.commentid = :id";
        
        try{
            TypedQuery<TnComment> query = em.createQuery(qString,TnComment.class);
            query.setParameter("id", commentid);
            comment = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return comment;  
	}
}
