/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.to;

/**
 *
 * @author DELL
 */
public class BookInfoTO {
    private int BookID,Qty,NoOfPages;
    private String BookName,AuthorName,TypeID,Publication,TypeName;

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
    private float BookPrice;

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public int getNoOfPages() {
        return NoOfPages;
    }

    public void setNoOfPages(int NoOfPages) {
        this.NoOfPages = NoOfPages;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String AuthorName) {
        this.AuthorName = AuthorName;
    }

    public String getTypeID() {
        return TypeID;
    }

    public void setTypeID(String TypeID) {
        this.TypeID = TypeID;
    }

    public String getPublication() {
        return Publication;
    }

    public void setPublication(String Publication) {
        this.Publication = Publication;
    }

    public float getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(float BookPrice) {
        this.BookPrice = BookPrice;
    }
    public String toString(){
        return BookName +"["+BookID+"]";
    }
       
    
}
