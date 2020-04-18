/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.runtime.Debug.id;
import libraryinterface.Management;

/**
 *
 * @author Tarana
 */
public class ManagementImpl extends UnicastRemoteObject implements Management {

    public ManagementImpl() throws RemoteException {
        super();
    }

    @Override
    public String AdLogin(String u, String p) throws RemoteException {

//                            System.out.println("Username and password"+ u +p);
        String Name = "";
        try {
            Connection conn = new Connect().getConnection();
//        Statement stmt=conn.createStatement();
//        ResultSet rs=stmt.executeQuery("SELECT firstname FROM adminlogin WHERE username='"+u+"' and pwd='"+p+"'");
//        
//        

            if (conn != null) {

                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `adminlogin` WHERE `username` = ? AND `pwd` = ? ");
                stmt.setString(1, u);
                stmt.setString(2, p);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Name = rs.getString(1);
                }
                return (Name);

            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return null;
    }

    public int AddBooks(String name, String category, String author, String publisher, String edition, int qty) throws RemoteException {
        // System.out.println("hello123");
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("insert into Books(name,category,author,publisher,edition,count)values(?,?,?,?,?,?)");

                pst.setString(1, name);
                pst.setString(2, category);
                pst.setString(3, author);
                pst.setString(4, publisher);
                pst.setString(5, edition);
                pst.setInt(6, qty);
//ResultSet rs = pst.executeQuery();
                int k = pst.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return 0;
    }

    public Vector TableLoadBooks() throws RemoteException {
        int c;
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM books");

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                Vector outer = new Vector();
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v.add(rs.getString("ID"));
                        v.add(rs.getString("NAME"));
                        v.add(rs.getString("CATEGORY"));
                        v.add(rs.getString("AUTHOR"));
                        v.add(rs.getString("PUBLISHER"));
                        v.add(rs.getString("EDITION"));
                        v.add(rs.getString("count"));

                    }
                    outer.add(v);

                }

                return outer;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return null;

    }

    public int UpdateBookRecord(String name, String category, String author, String publisher, String edition, int id, int qty) throws RemoteException {
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("UPDATE books set NAME=?,CATEGORY=?,AUTHOR=?,PUBLISHER=?,EDITION=?,count=? where ID=?");

                pst.setString(1, name);
                pst.setString(2, category);
                pst.setString(3, author);
                pst.setString(4, publisher);
                pst.setString(5, edition);
                pst.setInt(6, qty);
                pst.setInt(7, id);
//ResultSet rs = pst.executeQuery();
                int k = pst.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return 0;

    }

    public int DelelteBookRecord(int id) throws RemoteException {
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("DELETE FROM books where ID=?");

                pst.setInt(1, id);

                int k = pst.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return 0;

    }

    public int AddStudents(String stdid, String name, String phoneno, String addr, String email) throws RemoteException {
        //   System.out.println("hello123");
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("insert into STUDENTINFO(STUDENTID,NAME,PHONENO,ADDRESS,EMAIL)values(?,?,?,?,?)");

                pst.setString(1, stdid);
                pst.setString(2, name);
                pst.setString(3, phoneno);
                pst.setString(4, addr);
                pst.setString(5, email);
                //   pst.setString(5,edition);
//ResultSet rs = pst.executeQuery();
                int k = pst.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return 0;
    }

    public Vector TableLoadStudents() throws RemoteException {
        int c;
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM STUDENTINFO");

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                Vector outer = new Vector();
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v.add(rs.getString("STUDENTID"));
                        v.add(rs.getString("NAME"));
                        v.add(rs.getString("PHONENO"));
                        v.add(rs.getString("ADDRESS"));
                        v.add(rs.getString("EMAIL"));
                    }
                    outer.add(v);

                }

                return outer;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return null;

    }

    public int UpdateStudentRecord(String name, String addr, String phoneno, String stdid, String email) throws RemoteException {
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("UPDATE STUDENTINFO set NAME=?,PHONENO=?,ADDRESS=?,EMAIL=? where STUDENTID=?");

                pst.setString(1, name);
                pst.setString(2, phoneno);
                pst.setString(3, addr);
                pst.setString(4, email);
                pst.setString(5, stdid);
                //pst.setString(5,edition);
                //pst.setInt(6,id);
//ResultSet rs = pst.executeQuery();
                int k = pst.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return 0;

    }

    public int DelelteStudentRecord(String id) throws RemoteException {
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("DELETE FROM STUDENTINFO where STUDENTID=?");

                pst.setString(1, id);

                int k = pst.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return 0;

    }

    public Vector SearchBooks(String text) throws RemoteException {

        int c;
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM BOOKS WHERE NAME  LIKE  CONCAT('%', ? ,'%')");

                pst.setString(1, text);
                // pst.setString(2, text);

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                Vector outer = new Vector();
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v.add(rs.getString("ID"));
                        v.add(rs.getString("NAME"));
                        v.add(rs.getString("AUTHOR"));
                        v.add(rs.getString("count"));
                        v.add("issue");
                        v.add("remind");

                        //v.add(rs.getString("ADDRESS"));
                    }
                    outer.add(v);

                }
                return outer;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        //System.out.println("hey");
        return null;

    }

    public int IssueBooks(String stdid, int bookid, String issuedate, String returndate, String issuedby) throws RemoteException {
        System.out.println("hello1");
        System.out.println(6);
        System.out.println(returndate);
        try {
            Connection conn = new Connect().getConnection();

//            DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
//            String issue = dateFormat.format(issuedate);
//            String returnd = dateFormat.format(returndate);
            if (conn != null) {

                PreparedStatement ps1 = conn.prepareStatement("Select StudentId FROM IssuedBooks where BookId=? AND StudentId=? AND IsIssued=1");
                ps1.setInt(1, bookid);
                ps1.setString(2, stdid);
                // int l=ps1.executeUpdate();
                ResultSet rs1 = ps1.executeQuery();
                rs1.last();
                int l = rs1.getRow();
                System.out.println(l);
                System.out.println("hello2");
                PreparedStatement ps2 = conn.prepareStatement("Select BookId FROM IssuedBooks where StudentId=? AND IsIssued=1");
                //ps2.setInt(1,bookid);
                ps2.setString(1, stdid);
                // int m=ps2.executeUpdate(); 
                ResultSet rs2 = ps2.executeQuery();
                rs2.last();
                int m = rs2.getRow();
                System.out.println(m);
                System.out.println("hello3");
                int setIssue = 1;

                if (l == 0 && m < 4) {
                    PreparedStatement pst = conn.prepareStatement("insert into ISSUEDBOOKS(BookId,StudentId,IssuedDate,ReturnDate,IssuedByAdmin,IsIssued)values(?,?,?,?,?,?)");

                    pst.setInt(1, bookid);
                    pst.setString(2, stdid);
//                    java.util.Date issueDate = new java.sql.Date(issuedate.getTime());
//                    java.util.Date returnDate = new java.sql.Date(returndate.getTime());
                    pst.setString(3, issuedate);
                    pst.setString(4, returndate);
                    pst.setString(5, issuedby);
                    pst.setInt(6, setIssue);
                    // pst.setString(5,email);
                    //   pst.setString(5,edition);
//ResultSet rs = pst.executeQuery();
                    pst.executeUpdate();
                    System.out.println("hello2");
                    PreparedStatement ps = conn.prepareStatement("update BOOKS SET count=count-1 WHERE ID=?");
                    ps.setInt(1, bookid);
                    ps.executeUpdate();
                    return 1;
// System.out.println("hello3");
                } else if (l > 0) {
                    return 2;
                } else if (m == 4) {
                    return 3;
                }

            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return 0;
    }

    public Vector TableIssueBookDetails() throws RemoteException {
        int c;
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM ISSUEDBOOKS");

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                Vector outer = new Vector();
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v.add(rs.getString("BookId"));
                        //  v.add(name);
                        v.add(rs.getString("StudentId"));
                        // v.add(bookname);
                        v.add(rs.getString("IssuedDate"));
                        v.add(rs.getString("ReturnDate"));

                        v.add(rs.getString("IssuedByAdmin"));
                        v.add(rs.getString("IsIssued"));

                    }
                    outer.add(v);

                }

                return outer;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return null;
    }

    public int RemindsBooks(String stdid, int bookid) throws RemoteException {
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("insert into REMINDEDBOOKS(STDID,BOOKID,IsReminded)values(?,?,1)");

                pst.setString(1, stdid);
                pst.setInt(2, bookid);

                int k = pst.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }

        return 0;
    }

    public Vector TableRemindBookDetails() throws RemoteException {
        int c;
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM REMINDEDBOOKS");

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                Vector outer = new Vector();
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v.add(rs.getString("STDID"));
                        //  v.add(name);
                        v.add(rs.getString("BOOKID"));
                        v.add(rs.getString("IsReminded"));

                        // v.add(bookname);
                        // v.add(rs.getString("IssuedDate"));
                        //v.add(rs.getString("ReturnDate"));
                        //v.add(rs.getString("IssuedByAdmin"));
                    }
                    outer.add(v);

                }

                return outer;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }

        return null;
    }

    public Date[] FetchData(String stdid, int bookid) throws RemoteException {
        java.sql.Date arr[] = new java.sql.Date[10];
        try {
            Connection conn = new Connect().getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement("SELECT * FROM issuedbooks where StudentId=? AND BookId=?");
                pst.setString(1, stdid);
                pst.setInt(2, bookid);
                ResultSet rs = pst.executeQuery();
                if (rs.next() == false) {
                    System.out.println("wrong studentid or bookid!!");
                } else {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    String x = rs.getString("IssuedDate");
                    String y = rs.getString("ReturnDate");
                    arr[0] = (java.sql.Date) dateFormat.parse(x);
                    arr[1] = (java.sql.Date) dateFormat.parse(y);
                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);
        }
        return null;
    }

    public int[] ReturnBooks(String stdid, int bookid, String returndate) throws RemoteException {
//        System.out.println("hello2");
        int arr[] = new int[10];
        java.sql.Date d;
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement ps1 = conn.prepareStatement("Select ReturnDate From IssuedBooks where BookId=? AND StudentId=?");
//                System.out.println(stdid);
//                System.out.println(bookid);
                //ps1.setString(1, stdid);
                ps1.setInt(1, bookid);
                ps1.setString(2, stdid);
                ResultSet rs = ps1.executeQuery();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
//                System.out.println("hello3");
                String y = null;
                while (rs.next()) {
                    System.out.println(rs.getString("ReturnDate"));
                    System.out.println(returndate);
                    y = (String) rs.getString("ReturnDate");
                }
//                System.out.println("hello3");
                //  d = (java.sql.Date) dateFormat.parse(y);
//                DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
//                String returnd = dateFormat.format(returndate);

                SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yy");

                try {

                    Date date1 = myFormat.parse(y);
                    Date date2 = myFormat.parse(returndate);
                    long diff = date2.getTime() - date1.getTime();
                    System.out.println(diff);
                    long x = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    System.out.println(x);
                    int i = (int) x;
                    if (i < 0) {
                        arr[0] = 0;
                        arr[1] = 0;
                    } else {
                        arr[0] = i;
                        int j = i * 2;
                        arr[1] = j;
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return arr;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return null;
    }

    @Override
    public Vector SendEmailIfUserHasRequestedForSameBook(int bookId) throws RemoteException {
//
////        Vector v = new Vector();
////        Vector v1 = new Vector();
        EmailSend email = new EmailSend();
//
        try {
            Connection conn = new Connect().getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement("SELECT si.EMAIL FROM remindedbooks rb join studentinfo si on si.STUDENTID=rb.STDID where rb.BOOKID=? AND rb.IsReminded=1");
                pst.setInt(1, bookId);
                ResultSet rs = pst.executeQuery();
                //bookname
                PreparedStatement ps2 = conn.prepareStatement("SELECT NAME FROM BOOKS where ID=?");
                //  ps1.setString(1, stdid);
                ps2.setInt(1, bookId);
                ResultSet rs1 = ps2.executeQuery();
                rs1.next();
                String book = rs1.getString("NAME");
                System.out.println(book);
//                
//
                if (rs != null) {

                    while (rs.next()) {
////                    v.add(v1.add(rs.getString("EMAIL")));
                        System.out.println(rs.getString("EMAIL"));
//                       // System.out.println(rs1.getString("NAME"));

                        email.sendEmail(rs.getString("EMAIL"), book);
                    }

//
                    PreparedStatement ps1 = conn.prepareStatement("update remindedbooks SET IsReminded=0 WHERE BOOKID=?");
//
                    ps1.setInt(1, bookId);
                    ps1.executeUpdate();
                } else {
                    System.out.println("no need to send mail ");
                }
            
        }
        else {
               System.out.println("Connection is null");
           }
//
    }
    catch (Exception e

    
        ) {
            e.printStackTrace();
    }

return null;
    }

    @Override
        public int submitReturnBookDetails(int bookId, String stdId, String actualreturn, String exceededdays, String fine) throws RemoteException {
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("insert into returnbook(BookId,StdId,ActualReturnDate,ExceededDays,Fine)values(?,?,?,?,?)");

                pst.setInt(1, bookId);
                pst.setString(2, stdId);
                pst.setString(3, actualreturn);
                pst.setString(4, exceededdays);
                pst.setString(5, fine);
                //   pst.setString(5,edition);
                //ResultSet rs = pst.executeQuery();
                pst.executeUpdate();

                PreparedStatement ps1 = conn.prepareStatement("update BOOKS SET count=count+1 WHERE ID=?");

                ps1.setInt(1, bookId);
                int k = ps1.executeUpdate();
                PreparedStatement ps2 = conn.prepareStatement("update IssuedBooks SET IsIssued=0 WHERE BookId=? AND StudentId=?");

                ps2.setInt(1, bookId);
                ps2.setString(2, stdId);
                ps2.executeUpdate();

                return k;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }

        return 0;
    }

    public Vector TableReturnBookDetails() throws RemoteException {
        int c;
        try {
            Connection conn = new Connect().getConnection();

            if (conn != null) {

                PreparedStatement pst = conn.prepareStatement("SELECT * FROM returnbook");

                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();
                Vector outer = new Vector();
                while (rs.next()) {
                    Vector v = new Vector();
                    for (int i = 1; i <= c; i++) {
                        v.add(rs.getString("BookId"));
                        //  v.add(name);
                        v.add(rs.getString("StdId"));

                        v.add(rs.getString("ActualReturnDate"));

                        v.add(rs.getString("ExceededDays"));
                        v.add(rs.getString("Fine"));

                    }
                    outer.add(v);

                }

                return outer;
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
//            System.out.println("error in login "+e.getMessage());
            e.printStackTrace();
//                System.out.println("error in login "+ Name);

        }
        return null;
    }
}
