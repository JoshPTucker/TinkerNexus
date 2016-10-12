package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.TnProjectAsset;
import util.DButil;
public class ProjectAssetDao {
	public static void insertProjectAsset(TnProjectAsset asset) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(asset);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
	public static void updateProjectAsset(TnProjectAsset a) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(a);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static void removeProjectAsset(TnProjectAsset a) {
		if(a == null){
			return ;
		}
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.remove(em.merge(a));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
	public static TnProjectAsset getProjectAssetById(long projectid) {
		EntityManager em = DBUtil.getEmfFactory().createEntityManager();
        TnProjectAsset asset = null;
        String qString = "select b from TnProjectAssets b where b.projectassetid = :id";
        
        try{
            TypedQuery<TnProjectAsset> query = em.createQuery(qString,TnProjectAsset.class);
            query.setParameter("id", projectassetid);
            asset = query.getSingleResult();
        }catch (Exception e){
           return null;
        }
        finally{
                em.close();
            }
        return asset;  
	}
}
