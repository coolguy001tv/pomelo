//package com.cn.edu;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class JDBCTest {
    private Connection conn = null;
    PreparedStatement statement = null;
    // connect to MySQL
    void connSQL() {
        String url = "jdbc:mysql://localhost:3306/javatest";//���ݿ��ַ�����ݿ���
        String username = "root";
        String password = "123456"; 
        try { 
            Class.forName("com.mysql.jdbc.Driver" ); // ���������������������ݿ� 
            conn = DriverManager.getConnection( url,username, password ); // �������ݿ�
            }
        //����������������쳣
         catch ( ClassNotFoundException cnfex ) {
             System.err.println(
             "װ�� JDBC/ODBC ��������ʧ�ܡ�" );
             cnfex.printStackTrace(); 
         } 
         //�����������ݿ��쳣
         catch ( SQLException sqlex ) {
             System.err.println( "�޷��������ݿ�" );
             sqlex.printStackTrace(); 
         }
    }
    // disconnect to MySQL
    void deconnSQL() {
        try {
            if (conn != null){
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("�ر����ݿ����� ��");
            e.printStackTrace();
        }
    }
    // execute selection language
    ResultSet selectSQL(String sql) {
        ResultSet rs = null;
        try {
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    // execute insertion language
    boolean insertSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("�������ݿ�ʱ����");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("����ʱ����");
            e.printStackTrace();
        }
        return false;
    }
    //execute delete language
    boolean deleteSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("�������ݿ�ʱ����");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("����ʱ����");
            e.printStackTrace();
        }
        return false;
    }
    //execute update language
    boolean updateSQL(String sql) {
        try {
            statement = conn.prepareStatement(sql);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("�������ݿ�ʱ����");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("����ʱ����");
            e.printStackTrace();
        }
        return false;
    }
    // show data 
    void layoutStyle2(ResultSet rs) {
        System.out.println("----------------------------------");
        System.out.println("ִ�н��������ʾ:");
        System.out.println("----------------------------------");
        
        try {
            while (rs.next()) {
                System.out.println(rs.getInt("SNO")+ "\t"+rs.getString("SNAME")+"\t"+rs.getString("SEX")+"\t"+ rs.getString("BDATE"));
            }
        } catch (SQLException e) {
            System.out.println("��ʾʱ���ݿ����");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("��ʾ����");
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
        JDBCTest h = new JDBCTest();    
        h.connSQL();
        String s = "select * from student";
        String insert = "insert into student(SNO,SNAME,SEX,BDATE,HEIGHT) values('1','zl','1','20140421',2)";
        String update = "update student set SNAME ='hello' where SNAME= 'zl'";
        String delete = "delete  from student";
        if (h.insertSQL(insert) == true) {
            System.out.println("insert successfully");
            ResultSet resultSet = h.selectSQL(s);
            h.layoutStyle2(resultSet);
        }
        if (h.updateSQL(update) == true) {
            System.out.println("update successfully");
            ResultSet resultSet = h.selectSQL(s);    
            h.layoutStyle2(resultSet);
        }
        if (h.insertSQL(delete) == true) {
            System.out.println("delete successfully");
            ResultSet resultSet = h.selectSQL(s);
            h.layoutStyle2(resultSet);
        }
        
        h.deconnSQL();
    }
}