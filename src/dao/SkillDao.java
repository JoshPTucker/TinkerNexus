package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.TnSkill;
import util.DBUtil;;
public class SkillDao {
	public static void insertSkill(TnSkill skill) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(skill);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateSkill(TnSkill s) {
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(s);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void removeSkill(TnSkill s) {
		if(s == null){
			return ;
		}
        EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(s));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static TnSkill getSkillById(long skillid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnSkill skill = null;
        String qString = "select b from TnSkills b where b.skillid = :id";
        
        try{
            TypedQuery<TnSkill> query = em.createQuery(qString,TnSkill.class);
            query.setParameter("id", skillid);
            skill = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return skill;  
	}
}
