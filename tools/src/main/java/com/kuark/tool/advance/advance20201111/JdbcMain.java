package com.kuark.tool.advance.advance20201111;

import java.sql.*;

/**
 * @author rock
 * @detail
 * @date 2021/6/16 18:07
 */
public class JdbcMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.kuark.tool.advance.advance20201111.Apple");
//        Object o = aClass.newInstance();

    }
    public static void main1(String[] args) {
        // ���ݿ������������ַ���
        String driver = "com.mysql.jdbc.Driver";
        // ���ݿ����Ӵ�
        String url = "jdbc:mysql://127.0.0.1:3306/jdbctest";
        // �û���
        String username = "root";
        // ����
        String password = "mysqladmin";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 1���������ݿ������� �ɹ����غ󣬻ὫDriver���ʵ��ע�ᵽDriverManager���У�
            Class.forName("com.mysql.jdbc.Driver" );
            // 2����ȡ���ݿ�����
            conn = DriverManager.getConnection(url, username, password);
            // 3����ȡ���ݿ��������
            stmt = conn.createStatement();//��̬SQLִ�ж���
            /**
             * Ԥ��������
             * PreparedStatement pstmt = conn.prepareStatement("select * from user1 where id = ?") ;//��̬SQLִ�ж���
             *             pstmt.setString(1,"sss");
             *             pstmt.executeQuery();
             */
            // 4�����������SQL���
            String sql = "select * from user1 where id = 100";
            // 5��ִ�����ݿ����
            rs = stmt.executeQuery(sql);
            // 6����ȡ�����������
            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7���رն��󣬻������ݿ���Դ
            if (rs != null) { //�رս��������
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) { // �ر����ݿ��������
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) { // �ر����ݿ����Ӷ���
                try {
                    if (!conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
