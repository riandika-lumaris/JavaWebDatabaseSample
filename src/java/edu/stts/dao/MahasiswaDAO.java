/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stts.dao;

import edu.stts.model.Mahasiswa;
import edu.stts.util.ConnectionProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MahasiswaDAO {

    public static ArrayList<Mahasiswa> getAllMahasiswa() {
        ArrayList<Mahasiswa> arr_mhs = null;
        try {
            Connection conn = ConnectionProvider.getConnection();
            String sql = "select * from mahasiswa";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            arr_mhs = new ArrayList<Mahasiswa>();
            while (rs.next()) {
                arr_mhs.add(new Mahasiswa(rs.getString("nrp"), rs.getString("nama")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr_mhs;
    }
    
    public static void insert(String nrp, String nama) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            
            String sql = "insert into mahasiswa values(?,?,null)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nrp);
            stmt.setString(2, nama);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void delete(String nrp) {
        try {
            Connection conn = ConnectionProvider.getConnection();
            
            String sql = "delete from mahasiswa where nrp=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nrp);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
