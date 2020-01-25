
package com.campii.jsf.camp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

public class LazyCamp extends LazyDataModel<Camp> {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Camp> datasource;
     
    public LazyCamp(List<Camp> datasource) {
        this.datasource = datasource;
    }
     
    @Override
    public Camp getRowData(String rowKey) {
        for(Camp camp : datasource) {
            if(camp.getCampID().equals(rowKey))
                return camp;
        }
 
        return null;
    }
 
    @Override
    public Object getRowKey(Camp camp) {
        return camp.getCampID();
    }
 
    @Override
    public List<Camp> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
        List<Camp> data = new ArrayList<Camp>();
 
        //filter
        for(Camp camp : datasource) {
            boolean match = true;
 
            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(camp.getClass().getField(filterProperty).get(camp));
 
                        if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                    }
                    else {
                            match = false;
                            break;
                        }
                    } catch(Exception e) {
                        match = false;
                    }
                }
            }
 
            if(match) {
                data.add(camp);
            }
        }
 
        //sort
       
 
        //rowCount
        int dataSize = data.size();
        System.out.println("size" + dataSize);
        this.setRowCount(dataSize);
 
        //paginate
        if(dataSize > pageSize) {
            try {
            	System.out.println("first" + first);
            	System.out.println("page size" + pageSize);
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}