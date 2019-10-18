package repository;

import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RepositoryEmployee extends GenericoRepository<Employee> {

    public String employeeLogged (String user){
       try {
           EntityManager em = getConfigJPAHibernate().getManager();
           Query query = em.createNamedQuery("start-employee-access");
           query.setParameter("logged",user);
           Employee employee = (Employee)query.getSingleResult();
           return employee.getUser();
       }catch (Exception e){
           return null;
       }

    }

    public List<Employee> searchEemployeesByFilter (String filter){
        EntityManager em = getConfigJPAHibernate().getManager();
        Query query = em.createNamedQuery("consult-all-registered-employees");
        query.setParameter("filter", "%"+filter+"%");
        query.setMaxResults(10);
        List<Employee> employees = (List)query.getResultList();
        return employees;
    }
}
