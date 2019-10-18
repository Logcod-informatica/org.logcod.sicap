package repository;

import model.Admin;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RepositoryAdmin extends GenericoRepository<Admin> {

    public String administratorLoggedIn( String user, String passwd){
        try {
            EntityManager em = getConfigJPAHibernate().getManager();
            Query query = em.createNamedQuery("start-admin-access");
            query.setParameter("user",user);
            query.setParameter("passwd",passwd);
            Admin admin = (Admin) query.getSingleResult();
            return admin.getUser();
        }catch (Exception e){
            System.out.println("Não encontrado");
            return "user-not-logged-in";
        }
    }

}
