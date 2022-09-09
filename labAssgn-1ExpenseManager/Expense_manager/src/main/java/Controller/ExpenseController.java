package Controller;



import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ExpenseDao;
import daoImpl.ExpenseDaoImpl;
import pojo.ExpenseDetails;

public class ExpenseController extends HttpServlet {

		ExpenseDetails e = new ExpenseDetails();
        ExpenseDaoImpl ExpDaoImpl = new ExpenseDaoImpl();
        ExpenseDao edao;
       
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
             if(req.getParameter("showExpense")!=null){
                List<ExpenseDetails> ExpenseList = new ArrayList();
                ExpenseList = ExpDaoImpl.ListAllExp();
                req.setAttribute("ExpenseList", ExpenseList);
                RequestDispatcher rd = req.getRequestDispatcher("ExpenseAdd.jsp");
                rd.forward(req, res);
            }
             
              if(req.getParameter("updateExpense")!=null){
                 int id1 = Integer.parseInt(req.getParameter("id"));
                 String nameupdate = req.getParameter("nameupdate");
                 int priceupdate = Integer.parseInt(req.getParameter("priceupdate"));
                 String date = req.getParameter("dateupdate");
                 Date dateupdate = null;
     			try {
     				dateupdate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
     			} catch (ParseException e) {
     				e.printStackTrace();
     			}
                 String colorupdate = req.getParameter("colorupdate");
                 String urlupdate = req.getParameter("urlupdate");
                 String reviewupdate = req.getParameter("reviewupdate");
                 ExpDaoImpl.updateExp(id1, nameupdate, reviewupdate, priceupdate , dateupdate , colorupdate, urlupdate);
                 List<ExpenseDetails> ExpenseList = new ArrayList();
                 ExpenseList = ExpDaoImpl.ListAllExp();
                 req.setAttribute("ExpenseList", ExpenseList);
                 RequestDispatcher rd = req.getRequestDispatcher("ExpenseAdd.jsp");
                 rd.forward(req, res);
                 
             }
              
             if(req.getParameter("deleteExpense")!=null){
                 int id2 = Integer.parseInt(req.getParameter("id"));
                 e.setId(id2);
                 ExpDaoImpl.deleteExp(e);
                 List<ExpenseDetails> ExpenseList = new ArrayList();
                 ExpenseList = ExpDaoImpl.ListAllExp();
                 req.setAttribute("ExpenseList", ExpenseList);
                 RequestDispatcher rd = req.getRequestDispatcher("ExpenseAdd.jsp");
                rd.forward(req, res);
             }
             
          
          
        }
        
        
        
        
        
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("addExpense")!=null){
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            String date = request.getParameter("date");
            String color = request.getParameter("color");
            String url = request.getParameter("url");
            String remark = request.getParameter("review");
            e.setName(name);
            e.setPrice(price);
            e.setColor(color);
            e.setUrl(url);
            e.setReview(remark);
            
            Date edate1 = null;
			try {
				edate1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

            e.setDate(edate1);
            ExpDaoImpl.save(e);
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpDaoImpl.ListAllExp();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
          
        if(request.getParameter("showInfo")!=null){
        	 int id1 = Integer.parseInt(request.getParameter("id"));
           ExpenseDetails expense = ExpDaoImpl.expById(id1);
           request.setAttribute("record", expense);
            List<ExpenseDetails> ExpenseList = new ArrayList();
            ExpenseList = ExpDaoImpl.ListAllExp();
            request.setAttribute("ExpenseList", ExpenseList);
            RequestDispatcher rd = request.getRequestDispatcher("ExpenseAdd.jsp");
            rd.forward(request, response);
        }
        
    }



 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
