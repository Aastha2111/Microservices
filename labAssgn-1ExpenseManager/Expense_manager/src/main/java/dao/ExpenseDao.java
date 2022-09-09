package dao;

import java.util.Date;
import java.util.List;

import pojo.ExpenseDetails;

public interface ExpenseDao {
    //to add expense to list
    public void save(ExpenseDetails Expense);
  //get expense by Id
  	public ExpenseDetails expById(int id);
    //show list of all expenses
    public List<ExpenseDetails> ListAllExp();
    //update partiuclar exp in list
    public void updateExp (int id, String name, String review , int price , Date date , String color, String url);
    //delete expBYID
    public void deleteExp(ExpenseDetails Expense);
    
    
    
}
