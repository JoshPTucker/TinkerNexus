package dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import util.DBUtil;
import model.TnCollaborator;

public class collaboratordao {
	public static void insertCollaborator(TnCollaborator collaborator) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(collaborator);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateCollaborator(TnCollaborator c) {
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
	public static void removeCollaborator(TnCollaborator c) {
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
	public static TnCollaborator getCollaboratorById(long collabid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnCollaborator collaborator = null;
        String qString = "select b from TnCollaborators b where b.collaboratorid = :id";
        
        try{
            TypedQuery<TnCollaborator> query = em.createQuery(qString,TnCollaborator.class);
            query.setParameter("id", collabid);
            collaborator = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return collaborator;  
	}
}
