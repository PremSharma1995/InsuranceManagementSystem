package com.jbk.insurancemanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.insurancemanagement.entity.Insurance;

@Repository
public class InsuranceDaoImpl implements InsuranceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveInsurance(Insurance insurance) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Insurance ins = session.get(Insurance.class, insurance.getInsuarnceId());
			if (ins == null) {
				session.save(insurance);
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
	public List<Insurance> getAllInsurance() {
		List<Insurance> list = null;
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Insurance.class);

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Insurance getInsuranceById(int insuranceId) {
		Session session = null;
		Insurance insurance = null;
		try {
			session = sessionFactory.openSession();
			insurance = session.get(Insurance.class, insuranceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insurance;
	}

}
