package dao;

import db.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;


public class DataAccess {
    
    private static final String STR_INSERT        =  "INSERT INTO `student`(`id`, `name`, `address`, `age`) VALUES (?, ?, ?, ?)"; 
    private static final String STR_SELECT        =  "SELECT `id`, `name`, `address`, `age` FROM `student` WHERE 1"; 
    private static final String STR_SELECT_BY_ID  =  "SELECT `id`, `name`, `address`, `age` FROM `student` WHERE id = "; 
    private static final String STR_EDIT          =  "UPDATE `student` SET `name`=?,`address`=?,`age`=? WHERE `id`=?"; 
    private static final String STR_DELETE        =  "DELETE FROM `student` WHERE id=?"; 
    
    public static void addNew(Student n){
        try {
            PreparedStatement ps = DBUtil.getPreparedStatement(STR_INSERT);
            ps.setInt(1, n.getId());
            ps.setString(2, n.getName());
            ps.setString(3, n.getAddress());
            ps.setInt(4, n.getAge());
            ps.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Student> getAll(){
        List<Student> ls = new LinkedList<>();
        
        try {
            ResultSet rs = DBUtil.getPreparedStatement(STR_SELECT).executeQuery();
            while(rs.next()){
                Student n = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ls.add(n);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return ls;
    }
    
    public static List<Student> getNewById(int id){
        List<Student> ls = new LinkedList<>();
        try {
            ResultSet rs = DBUtil.getPreparedStatement(STR_SELECT_BY_ID + id).executeQuery();
            while(rs.next()){
                Student n = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                ls.add(n);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ls;
    }
    
    public static void edit(int id, String name, String address, int age){
        try {
            PreparedStatement ps= DBUtil.getPreparedStatement(STR_EDIT);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void delete(int id){
        try {
            PreparedStatement ps = DBUtil.getPreparedStatement(STR_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //test methods
//    public static void main(String[] args) {
//        Student st = new Student(77, "gary", "poter", 22);
//
//        addNew(st);
//        
//        // Print all names from the list....
//        for(Student student : getAll()) {
//            System.out.println(student.getName());
//        }
//        
//        // Print selected name from the list....
//        for(Student student : getNewById(st.getId())) {
//            System.out.println(student.getName());
//        }
//        
//        edit(77, "qwert", "twerk", 12);
//        delete(77);
//    }
}
