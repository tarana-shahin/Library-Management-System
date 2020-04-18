/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryinterface;

/**
 *
 * @author Tarana
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;

public interface Management extends Remote {

    abstract String AdLogin(String u, String p) throws RemoteException;

    abstract int AddBooks(String name, String category, String author, String publisher, String edition, int qty) throws RemoteException;

    abstract Vector TableLoadBooks() throws RemoteException;

    abstract int UpdateBookRecord(String name, String category, String author, String publisher, String edition, int id, int qty) throws RemoteException;

    abstract int DelelteBookRecord(int id) throws RemoteException;

    abstract int AddStudents(String stdid, String name, String phoneno, String addr, String email) throws RemoteException;

    abstract Vector TableLoadStudents() throws RemoteException;

    abstract int UpdateStudentRecord(String name, String addr, String phoneno, String stdid, String email) throws RemoteException;

    abstract int DelelteStudentRecord(String id) throws RemoteException;

    abstract Vector SearchBooks(String text) throws RemoteException;

    abstract int IssueBooks(String stdid, int bookid, String issuedate, String returndate, String issuedby) throws RemoteException;

    abstract Vector TableIssueBookDetails() throws RemoteException;

    abstract int RemindsBooks(String stdid, int bookid) throws RemoteException;

    abstract Vector TableRemindBookDetails() throws RemoteException;

    abstract Date[] FetchData(String stdid, int bookid) throws RemoteException;

    abstract int[] ReturnBooks(String stdid, int bookid, String returndate) throws RemoteException;
    abstract Vector SendEmailIfUserHasRequestedForSameBook(int bookId) throws RemoteException;
    abstract int submitReturnBookDetails(int bookId,String stdId,String actualreturn,String exceededdays,String fine)throws RemoteException;
     abstract Vector TableReturnBookDetails() throws RemoteException;
}
