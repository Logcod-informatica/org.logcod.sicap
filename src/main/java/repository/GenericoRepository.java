package repository;

import configs.ConfigJPAHibernate;
import model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class GenericoRepository<T extends Object> {
    public ConfigJPAHibernate configJPAHibernate;

    public GenericoRepository(){
         try {
             configJPAHibernate = (ConfigJPAHibernate)getClass().forName("configs.ConfigJPAHibernate").newInstance();
         }catch (Exception e){
             System.out.println("Log-> "+e.getLocalizedMessage());
         }

    }

    public ConfigJPAHibernate getConfigJPAHibernate() {
        return configJPAHibernate;
    }

    public void save(T t){
        EntityManager em = configJPAHibernate.getManager();
        EntityTransaction et = em.getTransaction();
        try{
            et.begin();
            em.merge(t);
            et.commit();
        }catch (Exception e){
            et.rollback();
        }
    }
    public Employee getEmployee (long id){
        EntityManager em = getConfigJPAHibernate().getManager();
        Employee employee = (Employee)em.find(Employee.class,id);
        return employee;
    }
    public void remove(long id){
        EntityManager em = configJPAHibernate.getManager();
        EntityTransaction et = em.getTransaction();
        Employee employee = getEmployee(id);
        try{
            et.begin();
            em.remove(employee);
            et.commit();
        }catch (Exception e){
            et.rollback();
        }
    }

}
