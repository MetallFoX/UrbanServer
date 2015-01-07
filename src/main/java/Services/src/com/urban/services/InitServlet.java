package com.urban.services;

import com.urban.data.dao.DAO;
import src.com.urban.data.sqlite.SQLiteDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
        //DAO.setDAO(new JDBCDAO(""));
        DAO.setDAO(new SQLiteDAO("jdbc:sqlite:F:\\Projects\\Observer\\app\\src\\main\\assets\\urban.db"));
    }
}