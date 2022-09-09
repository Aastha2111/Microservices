package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ExpenseDetails implements Serializable {
    
	//auto genrated id
    @Id @GeneratedValue
    int id;
    
    String name;
    String review;
    int price;
    @Temporal(value=TemporalType.DATE)
    Date date;
    String color;
    String url;
    
    
    public ExpenseDetails(int id, String name, String review, int price, Date date, String color, String url) {
		super();
		this.id = id;
		this.name = name;
		this.review = review;
		this.price = price;
		this.date = date;
		this.color = color;
		this.url = url;
	}
	public ExpenseDetails() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	


	

    
    
}
