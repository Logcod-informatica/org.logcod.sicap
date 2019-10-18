package repository;

import model.Associate;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RepositoryAssociate extends GenericoRepository<Associate> {


    public List<Associate> searchAssociatesByFilter (String filter){
        EntityManager em = getConfigJPAHibernate().getManager();
        Query query = em.createNamedQuery("filter-associates-by-name");
        query.setParameter("filter", "%"+filter+"%");
        query.setMaxResults(5);
        List<Associate> employees = (List)query.getResultList();
        return employees;
    }
}
