package ejbs;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity
public class Calculation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int num1;
	private int num2;
	private String operation;
	
	public Calculation() {}
	public Calculation(Calculation request) 
	{
	  num1 = request.getNum1();
	  num2 = request.getNum2();
	  operation = request.getOperation();
	 } 
	
	
	public void setNum1(int num1)
	{
		this.num1 = num1;
	}
	
	public void setNum2(int num2)
	{
		this.num2 = num2;
	}
	
	public void setOperation(String operation)
	{
		this.operation = operation;
	}
	
	public int getNum1()
	{
		return num1;
	}
	
	public int getNum2()
	{
		return num2;
	}
	
	public String getOperation()
	{
		return operation;
	}
	
	@Override
    public String toString() {
        // Build a JSON string representing the object's state
        return "{\"number1\":\"" + num1 + "\", \"number2\":\"" + num2 + "\", \"operation\":\"" + operation + "\"}";
    }
	
	public int calculateNumber(String operation)
	{
		int result = -50;
		if(operation.equals("+"))
		{
			result = num1 + num2;
		}
		else if(operation.equals("-"))
		{
			result = num1 - num2;
		}
		else if(operation.equals("*"))
		{
			result = num1 * num2;
		}
		else if(operation.equals("/"))
		{
			result = num1 / num2;
		}
		return result;
	}
	
	
	
	
	
	
	
}
