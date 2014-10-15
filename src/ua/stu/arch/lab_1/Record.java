package ua.stu.arch.lab_1;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String value;
	private int priority;
	private Date date;
	
	public Record(String value, int priority, Date date) {
		this.setValue(value);
		this.setPriority(priority);
		this.setDate(date);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
