
package com.campii.jsf.calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;



@ManagedBean(name="calendarView")
@SessionScoped
public class CalendarView {
 
  
    private Date date8;
 
    private Date date12;
 
  
 
  
 
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
 
    
 public String temp()
 {
	 return null;
 }
    
    public Date getDate8() {
    	
        return date8;
    }
 
    public void setDate8(Date date8) {
        this.date8 = date8;
    }
 
   
 
    public Date getDate12() {
        return date12;
    }
 
    public void setDate12(Date date12) {
        this.date12 = date12;
    }
 
   
 
 
   
}