package com.jbk.insurancemanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.insurancemanagement.entity.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveClient(Client client) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Client clnt = session.get(Client.class, client.getAadharNo());
			if (clnt == null) {
				session.save(client);
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
	public List<Client> getAllClient() {
		List<Client> list = null;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Client.class);

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Client getClientByAadharNo(String aadharNo) {
		Session session = null;
		Client client = null;
		try {
			session = sessionFactory.openSession();
			client = session.get(Client.class, aadharNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

}
