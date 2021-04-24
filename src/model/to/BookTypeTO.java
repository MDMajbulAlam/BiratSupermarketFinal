/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

/**
 *
 * @author DELL
 */
public class BookTypeTO {
    private String TypeID,TypeName;

    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String TypeID) {
        this.TypeID = TypeID;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
    public String toString(){
        return  TypeID ;
        
    }
    
}
