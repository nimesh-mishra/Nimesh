package com.lftechnology.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class connects to mysql database and performs insertions,queries and
 * delete operations.
 * 
 * @author nimesh
 */
public class DAO extends ConnectionManager{

	private static final Logger LOG = Logger.getLogger(DAO.class
			.getName());
	private PreparedStatement prepared;
	private ResultSet resultSet;
	private Connection con;

	/**
	 * This is default constructor. This constructor calls the constructor of
	 * class {@link ConnectionManager} which in turn loads the mysql driver for
	 * java. It also initializes {@link Connection} object for this class.
	 * 
	 * @author nimesh
	 */

	public DAO() {
		super();
		LOG.info("Into DAO constructor");
		con = ConnectionManager.getConnection();
	}
	
	public DeptBean[] getDepartmentName(){
		List<DeptBean> dept=new ArrayList<DeptBean>();
		DeptBean[] beanArray=null;
		LOG.info("Into method getDepartmentName");
		try {
			prepared = con
					.prepareStatement("select count(id) as rowCount from ERP.Department");
			resultSet = prepared.executeQuery();
			int rowCount=Integer.valueOf(resultSet.getInt("rowCount"));
			if( rowCount > 0){
			 beanArray = new DeptBean[rowCount];
			 prepared = con
						.prepareStatement("select name from ERP.Department");
				resultSet = prepared.executeQuery();
			 while(resultSet.next()){
					DeptBean bean=new DeptBean();
					String deptName=resultSet.getString("name");
					bean.setDeptName(deptName);
					dept.add(bean);
				}
				beanArray= (DeptBean[]) dept.toArray();
			}
			else{
				DeptBean bean=new DeptBean();
				bean.setDeptName("empty");
				beanArray = new DeptBean[1];
				beanArray[0]=bean;
			}
			return beanArray;
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, "Exception occurred @ getDepartmentName.");
			LOG.log(Level.SEVERE, "The message is " + e.getMessage());
		}
		return beanArray;
	}
}
