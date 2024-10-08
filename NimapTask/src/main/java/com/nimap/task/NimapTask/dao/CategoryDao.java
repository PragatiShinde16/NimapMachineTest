package com.nimap.task.NimapTask.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nimap.task.NimapTask.entity.Category;

@Repository
public class CategoryDao {

	@Autowired
	SessionFactory factory;
	
	public String addCategory(Category category) {
		Session session = null;
		Transaction transaction = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.persist(category);
			transaction.commit();
			msg = "Category Added Successfully............";
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Category> getAllCategory() {
		Session session = null;
		Transaction transaction = null;
		List<Category> list = null;
		
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			String hqlQuery = "from Category";
			Query<Category> query = session.createQuery(hqlQuery, Category.class);
			list = query.list();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return list;
	}

	public Category getParticularCategory(int c_id) {
		Session session = null;
		Transaction transaction = null;
		Category category = null;
		
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			category = session.get(Category.class, c_id);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return category;
	}

	public String updateCategory(Category category, int c_id) {
		Session session = null;
		Transaction transaction = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Category category2 = session.get(Category.class, c_id);
			category2.setC_name(category.getC_name());
			session.merge(category2);
			transaction.commit();
			msg = "Category Updated Successfully..........";
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteCategory(int c_id) {
		Session session = null;
		Transaction transaction = null;
		String msg = null;
		
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Category category = session.get(Category.class, c_id);
			session.remove(category);
			transaction.commit();
			msg = "Category Deleted Successfully........";
		} catch (Exception e) {
			// TODO: handle exception
			if (transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}

}
