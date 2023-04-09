package com.sensemeka .tweaksense;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DbManager {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private DataSource dataSource;
	private Connection conn = null;
	private Statement stmt = null;

	public DbManager(DataSource ds) {
		this.dataSource = ds;
	}

	public boolean open() {
		try {
			conn = dataSource.getConnection(); 
			stmt = conn.createStatement();
		}
		catch (Exception e) {
			e.printStackTrace();

			conn = null;
			stmt = null;

			return false;
		}

		return true;
	}

	public void close() {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		catch (Exception e) {}

		conn = null;
		stmt = null;
	}

	public boolean execute(String strSql) {
		try {
			stmt.execute(strSql);
        }
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean select(List<Map<String, String>> dst, String strSql) {
		try {
			// select result to List
			ResultSet rs = stmt.executeQuery(strSql);

			while (rs.next()) {
				Map<String, String> mapTmp = new HashMap<String, String>();
				ResultSetMetaData rsmd = rs.getMetaData();
				int nRows = rsmd.getColumnCount();
                for (int i = 0; i < nRows; i++) {
                    String colName = rsmd.getColumnLabel(i + 1);
                    String colValue = rs.getString(i + 1);
                    mapTmp.put(colName, colValue);
                }
				dst.add(mapTmp);
			}
        }
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean selectSingle(Map<String, String> dst, String strSql) {
		try {
			// select result to List
			ResultSet rs = stmt.executeQuery(strSql);

			if (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int nRows = rsmd.getColumnCount();
                for (int i = 0; i < nRows; i++) {
                    String colName = rsmd.getColumnLabel(i + 1);
                    String colValue = rs.getString(i + 1);
                    dst.put(colName, colValue);
                }
			}
        }
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public String selectSingleStr(String strSql) {
		try {
			ResultSet rs = stmt.executeQuery(strSql);
			if (rs.next())
                return rs.getString(1);
        }
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int selectSingleInt(String strSql) {
		try {
			ResultSet rs = stmt.executeQuery(strSql);
			if (rs.next())
				return rs.getInt(1);
        }
		catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
}
