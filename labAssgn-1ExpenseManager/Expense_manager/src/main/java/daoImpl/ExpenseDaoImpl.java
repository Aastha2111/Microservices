package daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ExpenseDao;
import pojo.ExpenseDetails;

public class ExpenseDaoImpl implements ExpenseDao {

    @Override
    public void save(ExpenseDetails Expense) {
    	//step 1: create a new session or open an existing session
        Session session = HibernateUtil.getSessionFactory().openSession();
     // step 2: create a transaction boundary
        Transaction transaction = session.beginTransaction();
     // step 3: perform save/insert operation
        session.save(Expense);
     // step 4: commit the transaction
        transaction.commit();
     // step 5: close the session
        session.close();
    }

    @Override
    public List<ExpenseDetails> ListAllExp(){
        Session session = HibernateUtil.getSessionFactory().openSession();
      //create a new session or open an existing session
        @SuppressWarnings("unchecked")
		List<ExpenseDetails> ExpenseList = session.createQuery("from ExpenseDetails").getResultList();
        //close the session
        session.close();
        return ExpenseList;
    }
    
    @Override
    public ExpenseDetails expById(int id) {
    	//create a new session or open an existing session
		Session session = HibernateUtil.getSessionFactory().openSession();
		ExpenseDetails expense = session.get(ExpenseDetails.class, id);		
		//close the session
		session.close();
		return expense;
    }
    
    @Override
    public void updateExp(int id, String name, String review , int price , Date date , String color , String url) {
//    	create a new session or open an existing session
    	Session session = HibernateUtil.getSessionFactory().openSession();
//    	create a transaction boundary
        Transaction transaction = session.beginTransaction();
        ExpenseDetails expd = session.load(ExpenseDetails.class, id);
        expd.setName(name);
        expd.setReview(review);
        expd.setDate(date);
        expd.setColor(color);
        expd.setPrice(price);
        expd.setUrl(url);
        session.update(expd);
//        commit the transaction
        transaction.commit();
        session.close();  
    }

    @Override
    public void deleteExp(ExpenseDetails Expense) {
    	//step 1: create a new session or open an existing session
        Session session = HibernateUtil.getSessionFactory().openSession();
        // step 2: create a transaction boundary
        Transaction transaction = session.beginTransaction();
        // step 3: perform delete operation
        session.delete(Expense);
     // step 4: commit the transaction
        transaction.commit();
     // step 5: close the session
        session.close();
    }
    
}
