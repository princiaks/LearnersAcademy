package com.glvc.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.glvc.main.User;
import com.glvc.main.Designation;
import com.glvc.main.Report;
import com.glvc.main.Course;
import com.glvc.main.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.glvc.dbutil.LearnersDbutil;
public class LearnersDao {
	
	public long adminLogin(User user) {
		  Transaction transaction = null;
		  long success = 0;
		  Session session = LearnersDbutil.getSessionFactory().openSession();
		  //(Session session = LearnersDbutil.getSessionFactory().openSession()) 
	        try {
	            // start a transaction
	            transaction = session.beginTransaction();
	            Query q=session.createQuery("select count(*) from User where username=:username and password=:password");
	            q.setParameter("username",user.getUsername());
	            q.setParameter("password",user.getPassword());
	    		success=(long)q.uniqueResult();
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return success;
	}
	public HashMap<String, String> getDashCount()
	{
		HashMap<String, String> listCount = new HashMap<String, String>(); 
        Transaction transaction = null;
        List<Object[]> des=null;
        Session session = LearnersDbutil.getSessionFactory().openSession();
        try {
            // start a transaction
            transaction = session.beginTransaction();
            		Query desig= session.createQuery("select count(*) from User where role='student'");
                	des=desig.list();
                	listCount.put("studentcount",String.valueOf(des.get(0)));
                	Query desig1= session.createQuery("select count(*) from User where role='teacher'");
                	des=desig1.list();
                	listCount.put("teachercount",String.valueOf(des.get(0)));
                	Query desig2= session.createQuery("select count(*) from Course");
                	des=desig2.list();
                	listCount.put("coursecount",String.valueOf(des.get(0)));
                    transaction.commit();
                    
           
	    	} catch (Exception e) {
		        if (transaction != null) {
		            //transaction.rollback();
		        }
		        e.printStackTrace();
		    }
		    return listCount;
	}
	public List<Designation> getDesignationList()
	{
		Transaction transaction = null;
        List < Designation > listOfDesig = null;
        try (Session session = LearnersDbutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfDesig = session.createQuery("from Designation").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfDesig;
	}
	public void saveDesignation(Designation desig)
	{
		  Transaction transaction = null;
		  Session session = LearnersDbutil.getSessionFactory().openSession();
	        try {
	            // start a transaction
	            transaction = session.beginTransaction();
	            if(desig.getId()==0)
	            {
	            	session.save(desig);	
	            }
	            else
	            {
	            	session.update(desig);
	            }
	            
	            transaction.commit();
	           
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
	
	public List<Course> getCourseList()
	{
		Transaction transaction = null;
        List < Course > listOfcourse = null;
        try (Session session = LearnersDbutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfcourse = session.createQuery("from Course").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfcourse;
	}
	public void saveCourse(Course course)
	{
		  Transaction transaction = null;
		  Session session = LearnersDbutil.getSessionFactory().openSession();
	        try {
	            // start a transaction
	            transaction = session.beginTransaction();
	            if(course.getId()==0)
	            {
	            	session.save(course);
	            }
	            else
	            {
	            	session.update(course);
	            }
	            
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
	public List<Subject> getSubjectList()
	{
		Transaction transaction = null;
        List < Subject > listOfsubject = null;
        try (Session session = LearnersDbutil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            listOfsubject = session.createQuery("from Subject").getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfsubject;
	}
	public void saveSubject(Subject subject)
	{
		  Transaction transaction = null;
		  Session session = LearnersDbutil.getSessionFactory().openSession();
	        try {
	            // start a transaction
	            transaction = session.beginTransaction();
	            if(subject.getId()==0)
	            {
	            	session.save(subject);	
	            }
	            else
	            {
	            	session.update(subject);	
	            }
	            
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
	public void saveUser(User user) {
        Transaction transaction = null;
         Session session = LearnersDbutil.getSessionFactory().openSession();
        try{
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            if(user.getId()==0)
            {
            	session.save(user);	
            }
            else
            {
            	session.update(user);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	 public String deleteSingleItem(int id,String type) {
		 
	        Transaction transaction = null;
	        String redirect="dashboard";
	        System.out.println(type);
	        try (Session session = LearnersDbutil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            switch(type)
	            {
	            	case "designation":
	            		Designation desig = session.get(Designation.class, id);
	    	            if (desig != null) {
	    	                session.delete(desig);
	    	                redirect="addDesignation";
	    	               
	    	            }	
	    	            break;
	            	case "subject":
	            		Subject sub = session.get(Subject.class, id);
	    	            if (sub != null) {
	    	                session.delete(sub);
	    	                redirect="addSubject";
	    	               
	    	            }	
	    	            break;
	            	case "student":
	            		User stud = session.get(User.class, id);
	    	            if (stud != null) {
	    	                session.delete(stud);
	    	                redirect="studentsList";
	    	               
	    	            }	
	    	            break;
	            	case "teacher":
	            		User teach = session.get(User.class, id);
	    	            if (teach != null) {
	    	                session.delete(teach);
	    	                redirect="teachersList";
	    	               
	    	            }	
	    	            break;
	            	case "course":
	            		Course course = session.get(Course.class, id);
	    	            if (course != null) {
	    	                session.delete(course);
	    	                redirect="addCourse";
	    	               
	    	            }	
	    	            break;
	    	            default:
	    	            	break;
	            }
	             // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return redirect;
	    }
	  @SuppressWarnings("unchecked")
	public HashMap<String,String> getSingleItemForEdit(int id,String type) {
		  	HashMap<String, String> listEdit = new HashMap<String, String>(); 
	        Transaction transaction = null;
	        
	        try (Session session = LearnersDbutil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            //user = session.get(User.class, id);
	            switch(type)
	            {
	            	case "designation":
	                	List<Designation> designation=null;
	                	Query desig= session.createQuery("from Designation where id=:id");
	                	desig.setParameter("id",id);
	                	designation=desig.getResultList();
	                	for(Designation d:designation){
	                		listEdit.put("id",String.valueOf(d.getId()));
	                		listEdit.put("designation",d.getDesignation());
	                		
	                	}
	                    break;
	            	case "subject":
	                	List<Subject> subject=null;
	                	Query sub= session.createQuery("from Subject where id=:id");
	                	sub.setParameter("id",id);
	                	subject=sub.getResultList();
	                	for(Subject d:subject){
	                		listEdit.put("id",String.valueOf(d.getId()));
	                		listEdit.put("subject",d.getSubject());
	                		listEdit.put("course_id",String.valueOf(d.getCourse_id()));
	                		
	                	}
	                    break;
	            	case "course":
	                	List<Course> course=null;
	                	Query cou= session.createQuery("from Course where id=:id");
	                	cou.setParameter("id",id);
	                	course=cou.getResultList();
	                	for(Course d:course){
	                		listEdit.put("id",String.valueOf(d.getId()));
	                		listEdit.put("classname",d.getClassname());
	                		
	                	}
	                    break;
	            	case "student":
	                	List<User> student=null;
	                	Query stud= session.createQuery("from User where id=:id");
	                	stud.setParameter("id",id);
	                	student=stud.getResultList();
	                	for(User d:student){
	                		listEdit.put("id",String.valueOf(d.getId()));
	                		listEdit.put("fname",d.getFname());
	                		listEdit.put("lname",d.getLname());
	                		listEdit.put("dob",d.getDob());
	                		listEdit.put("phone",d.getPhone());
	                		listEdit.put("address",d.getAddress());
	                		listEdit.put("course_id",String.valueOf(d.getSclass()));
	                		
	                	}
	                    break;
	            	case "teacher":
	            		List<User> teacher=null;
	                	Query teach= session.createQuery("from User where id=:id");
	                	teach.setParameter("id",id);
	                	teacher=teach.getResultList();
	                	for(User d:teacher){
	                		listEdit.put("id",String.valueOf(d.getId()));
	                		listEdit.put("fname",d.getFname());
	                		listEdit.put("lname",d.getLname());
	                		listEdit.put("dob",d.getDob());
	                		listEdit.put("phone",d.getPhone());
	                		listEdit.put("address",d.getAddress());
	                		listEdit.put("subject",String.valueOf(d.getSubject()));
	                		listEdit.put("designation",String.valueOf(d.getDesignation()));
	                		
	                	}
	                    break;
	            		
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                //transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listEdit;
	    }
	  @SuppressWarnings("unchecked")
	    public List < User > getAllUsers(String role) {

	        Transaction transaction = null;
	        List < User > listOfUser = null;
	        try (Session session = LearnersDbutil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object

	            Query q= session.createQuery("from User where role=:role");
	            q.setParameter("role",role);
	            listOfUser=q.getResultList();
	            
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return listOfUser;
	    }
	  
	  	@SuppressWarnings("deprecation")
		public ArrayList<Report> getCourseReport(int classid)
	  	{
	  		
	  		Transaction transaction = null;
	  		ArrayList rs=null;
	  		ArrayList<Report> reportList=new ArrayList<>();
	  		Session session = LearnersDbutil.getSessionFactory().openSession();
	  		try {
        	
        	String sql="select tblsubjectdetails.subject,tblclassdetails.classname,tbluser.fname,tbluser.lname,tbldesignationmaster.designation from tblsubjectdetails left join tbluser on tbluser.subject=tblsubjectdetails.id left join tbldesignationmaster on tbldesignationmaster.id=tbluser.designation left join tblclassdetails on tblclassdetails.id=tblsubjectdetails.course_id where tblsubjectdetails.course_id=:param1 ";
        	Query ps=session.createSQLQuery(sql);
        	ps.setParameter("param1",classid);
        	List<Object[]> result=ps.getResultList();
        	for(Object[] record : result) {
        		Report r=new Report();
        		r.setSubject((String)record[0]);
        		r.setClassname((String)record[1]);
        		r.setTeacher((String) record[2]+" "+(String) record[3]);
    			r.setDesignation((String)record[4]);
    			reportList.add(r);
        		};
	  		
	  	}catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	  		return reportList;
	  	}
		
	  	public ArrayList<User> getStudentReport(int classid)
	  	{
	  		Transaction transaction = null;
	  		ArrayList rs=null;
	  		ArrayList<User> reportList=new ArrayList<>();
	  		Session session = LearnersDbutil.getSessionFactory().openSession();
	  		try {
        	
        	String sql="select tbluser.fname,tbluser.lname,tbluser.dob,tbluser.address,tbluser.phone from tbluser left join tblclassdetails on tbluser.sclass=tblclassdetails.id where tblclassdetails.id=:param1";
        	Query ps=session.createSQLQuery(sql);
        	ps.setParameter("param1",classid);
        	List<Object[]> result=ps.getResultList();
        	for(Object[] record : result) {
        		User r=new User();
        		r.setFname((String)record[0]);
        		r.setLname((String) record[1]);
    			r.setDob((String)record[2]);
    			r.setAddress((String)record[3]);
    			r.setPhone((String)record[4]);
    			reportList.add(r);
        		};
	  		
	  	}catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	  		return reportList;
	  	}
	}

