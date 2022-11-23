package com.jbk.insurancemanagement.dao;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.insurancemanagement.entity.Client;
import com.jbk.insurancemanagement.entity.ClientInsuranceData;
import com.jbk.insurancemanagement.entity.Insurance;



@Repository
public class ClientInsuranceDataDaoImpl implements ClientInsuranceDataDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private InsuranceDao insuranceDao;
	@Autowired
	private ClientDao clientDao;
	public boolean saveClientInsuranceData(ClientInsuranceData clientInsuranceData) {

		Session session = null;
		Transaction transaction = null;
		
		boolean isAdded = false;
		try {
			Calendar date = Calendar.getInstance(); 
			date.setTime(new Date());
			Calendar date1=Calendar.getInstance();;
			date1.add(Calendar.YEAR,1);
			 Format dateFormat = new SimpleDateFormat("dd-MMMM-yyyy");  
			String issueDate = dateFormat.format(date.getTime()); 
			String expDate = dateFormat.format(date1.getTime());
			clientInsuranceData.setIssueDate(issueDate);
			clientInsuranceData.setExpDate(expDate);
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			ClientInsuranceData cid = session.get(ClientInsuranceData.class, clientInsuranceData.getInsuranceDataId());
			if (cid == null) {
				
				Client client=clientDao.getClientByAadharNo(clientInsuranceData.getAadharNo());
				clientInsuranceData.setfName(client.getfName());
				clientInsuranceData.setlName(client.getlName());
				clientInsuranceData.setCity(client.getCity());
				clientInsuranceData.setAge(client.getAge());
				Insurance insurance=insuranceDao.getInsuranceById(clientInsuranceData.getInsuranceId());
				clientInsuranceData.setInsuranceType(insurance.getInsuranceType());
				clientInsuranceData.setInsurancePrice(insurance.getInsurancePrice());
				session.save(clientInsuranceData);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}

		return isAdded;

	}

	@Override
	public ClientInsuranceData getClientInsuranceDataById(String clientInsuranceDataId) {
		Session session = null;
		ClientInsuranceData clientInsuranceData = null;
		
		try {
			session = sessionFactory.openSession();
			clientInsuranceData = session.get(ClientInsuranceData.class, clientInsuranceDataId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientInsuranceData;
	}

	@Override
	public List<ClientInsuranceData> getClientInsuranceData() {
		List<ClientInsuranceData> list = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ClientInsuranceData.class);

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
