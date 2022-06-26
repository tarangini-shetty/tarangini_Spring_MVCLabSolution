package com.greatlearning.studentmanagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.studentmanagement.entity.Student;

@Repository
public class StudentServiceImp implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImp(SessionFactory sessionFactory) {
		super();
		
		this.sessionFactory = sessionFactory;
		try
		{
			this.session = this.sessionFactory.getCurrentSession();
		}
		catch(HibernateException exptn)
		{
			this.session = this.sessionFactory.openSession();
		}
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = this.session.createQuery("from Student").list();
		return students;
	}

	@Override
	public Student findById(long studentid) {
		Student student = this.session.get(Student.class, studentid);
		return student;
	}

	@Override
	@Transactional
	public void save(Student student) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	@Transactional
	public void delete(long studentid) {
		Transaction tx = this.session.beginTransaction();
		Student student = this.session.get(Student.class, studentid);
		this.session.delete(student);
		tx.commit();
		
	}

	
}
