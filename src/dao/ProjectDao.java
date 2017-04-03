package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.TnProject;
import util.DBUtil;
public class ProjectDao {
	public static void insertProject(TnProject project) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(project);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateProject(TnProject p) {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(p);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void removeProject(TnProject p) {
		if(p == null){
			return ;
		}
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(p));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static TnProject getProjectById(long projectid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnProject project = null;
        String qString = "select b from TnProjects b where b.projectid = :id";
        
        try{
            TypedQuery<TnProject> query = em.createQuery(qString,TnProject.class);
            query.setParameter("id", projectid);
            project = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return project;  
	}
}
