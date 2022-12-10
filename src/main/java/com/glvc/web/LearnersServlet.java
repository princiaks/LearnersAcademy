package com.glvc.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.glvc.dao.LearnersDao;
import com.glvc.main.User;
import com.mysql.cj.protocol.Resultset;
import com.glvc.main.Designation;
import com.glvc.main.Report;

import java.sql.ResultSet;
import com.glvc.main.Student;
import com.glvc.main.Teacher;
import com.glvc.main.Subject;
import com.glvc.main.Course;
import java.util.Map;


@WebServlet("/")
public class LearnersServlet extends HttpServlet {
    private LearnersDao learnersDao;

    public void init() {
    	learnersDao = new LearnersDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/dashboard":
                	getDashboard(request, response);
                    break;
                case "/userlogin":
                	userLogin(request,response);
                	break;
                case "/login":
                	viewLogin(request,response);
                	break;
                case "/addNewStudent":
                	viewAddStudent(request,response);
                	break;
                case "/editStudent":
                	viewAddStudent(request,response);
                	break;
                case "/addTeacher":
                	addTeacher(request,response);
                	break;
                case "/editTeacher":
                	addTeacher(request,response);
                	break;
                case "/saveUser":
                    insertUser(request, response);
                    break;
                case "/studentsList":
                	studentsList(request, response);
                    break;
                case "/teachersList":
                	teachersList(request, response);
                    break;
                case "/addDesignation":
                	addDesignation(request,response);
                	break;
                case "/editDesignation":
                	addDesignation(request,response);
                	break;
                case "/saveDesignation":
                	saveDesignation(request,response);
                	break;
                case "/addCourse":
                	addCourse(request,response);
                	break;
                case "/editCourse":
                	addCourse(request,response);
                	break;
                case "/saveCourse":
                	saveCourse(request,response);
                	break;
                case "/addSubject":
                	addSubject(request,response);
                	break;
                case "/editSubject":
                	addSubject(request,response);
                	break;
                case "/saveSubject":
                	saveSubject(request,response);
                	break;
                
                case "/delete":
                	deleteSingleItem(request, response);
                    break;
                case "/getCourseReport":
                	getCourseReport(request, response);
                    break;
                    
                default:
                	viewLogin(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException,SQLException
    {
    	User adminlog= new User();
    	adminlog.setUsername(request.getParameter("username"));
    	adminlog.setPassword(request.getParameter("password"));
    	long row=learnersDao.adminLogin(adminlog);
    	System.out.println(row);
    	if(row > 0)
    	{
    		response.sendRedirect("dashboard");	
    	}
    	else
    	{
    		response.sendRedirect("login");
    	}
    	
    }

    private void getDashboard(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	HashMap<String,String> dashCount = learnersDao.getDashCount();
		request.setAttribute("dashCount", dashCount);
		List < Course > listCourse = learnersDao.getCourseList();
        request.setAttribute("listCourse", listCourse);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);
    
    }
    private void viewAddStudent(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	String querystr= request.getQueryString();
    	if(querystr != null)
    	{
    		int id=Integer.parseInt(request.getParameter("eid"));
    		HashMap<String,String> forEdit = learnersDao.getSingleItemForEdit(id,"student");
    		request.setAttribute("forEdit", forEdit);
    	}
    	List < Course > listCourse = learnersDao.getCourseList();
        request.setAttribute("listCourse", listCourse);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
        dispatcher.forward(request, response);
    
    }
    private void studentsList(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	List < User > listUsers = learnersDao.getAllUsers("student");
        request.setAttribute("listUsers", listUsers);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("studentsList.jsp");
        dispatcher.forward(request, response);
    
    }
    private void addTeacher(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	String querystr= request.getQueryString();
    	if(querystr != null)
    	{
    		int id=Integer.parseInt(request.getParameter("eid"));
    		HashMap<String,String> forEdit = learnersDao.getSingleItemForEdit(id,"teacher");
    		request.setAttribute("forEdit", forEdit);
    	}
    	List < Subject > listSubject = learnersDao.getSubjectList();
        request.setAttribute("listSubject", listSubject);
        List < Designation > listDesig = learnersDao.getDesignationList();
        request.setAttribute("listDesignation", listDesig);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("addTeacher.jsp");
        dispatcher.forward(request, response);
    
    }
    private void teachersList(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	List < User > listUsers = learnersDao.getAllUsers("teacher");
        request.setAttribute("listUsers", listUsers);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("teachersList.jsp");
        dispatcher.forward(request, response);
    
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	    	User newUser = new User();
    	    	String redirect="";
    	    	newUser.setFname(request.getParameter("fname"));
    	    	newUser.setLname(request.getParameter("lname"));
    	    	newUser.setDob(request.getParameter("dob"));
    	    	newUser.setAddress(request.getParameter("address"));
    	    	newUser.setPhone(request.getParameter("phone"));
    	    	newUser.setRole(request.getParameter("role"));
    	    	if(request.getParameter("id") != "0")
    	    	{
    	    		newUser.setId(Integer.parseInt(request.getParameter("id")));	
    	    	}
    	    	if(newUser.getRole().equals("student"))
    	    	{
    	    		System.out.println(request.getParameter("course_id"));
    	    		newUser.setSclass(Integer.parseInt(request.getParameter("course_id")));	
    	    		redirect="studentsList";
    	    	}
    	    	else if(newUser.getRole().equals("teacher"))
    	    	{
    	    		System.out.println(request.getParameter("course_id"));
    	    		newUser.setSubject(Integer.parseInt(request.getParameter("subject")));
    	    		newUser.setDesignation(Integer.parseInt(request.getParameter("designation")));
    	    		redirect="teachersList";
    	    	}
    	        learnersDao.saveUser(newUser);
    	        response.sendRedirect(redirect);
    	    }
    private void addDesignation(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	String querystr= request.getQueryString();
    	if(querystr != null)
    	{
    		int id=Integer.parseInt(request.getParameter("eid"));
    		HashMap<String,String> forEdit = learnersDao.getSingleItemForEdit(id,"designation");
    		request.setAttribute("forEdit", forEdit);
    	}
    	
    	List < Designation > listDesig = learnersDao.getDesignationList();
        request.setAttribute("listDesignation", listDesig);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("addDesignation.jsp");
        dispatcher.forward(request, response);
    
    }
    
    private void saveDesignation(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, ServletException, IOException {
    	Designation desig=new Designation();
    	desig.setDesignation(request.getParameter("designation"));
    	desig.setStatus("Active");
    	if(request.getParameter("id") != "0")
    	{
    		desig.setId(Integer.parseInt(request.getParameter("id")));	
    	}
    	
    	learnersDao.saveDesignation(desig);
    	response.sendRedirect("addDesignation");
    }
    
    private void addCourse(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	String querystr= request.getQueryString();
    	if(querystr != null)
    	{
    		int id=Integer.parseInt(request.getParameter("eid"));
    		HashMap<String,String> forEdit = learnersDao.getSingleItemForEdit(id,"course");
    		request.setAttribute("forEdit", forEdit);
    	}
    	
    	List < Course > listCourse = learnersDao.getCourseList();
        request.setAttribute("listCourse", listCourse);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("addCourse.jsp");
        dispatcher.forward(request, response);
    
    }
    private void saveCourse(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, ServletException, IOException {
    	Course course=new Course();
    	course.setClassname(request.getParameter("classname"));
    	course.setStatus("Active");
    	if(request.getParameter("id") != "0")
    	{
    		course.setId(Integer.parseInt(request.getParameter("id")));	
    	}
    	learnersDao.saveCourse(course);
        response.sendRedirect("addCourse");
    }
    
    private void addSubject(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	String querystr= request.getQueryString();
    	if(querystr != null)
    	{
    		int id=Integer.parseInt(request.getParameter("eid"));
    		HashMap<String,String> forEdit = learnersDao.getSingleItemForEdit(id,"subject");
    		request.setAttribute("forEdit", forEdit);
    	}
    	
    	List < Course > listCourse = learnersDao.getCourseList();
        request.setAttribute("listCourse", listCourse);
        List < Subject > listSubject = learnersDao.getSubjectList();
        request.setAttribute("listSubject", listSubject);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("addSubject.jsp");
        dispatcher.forward(request, response);
    
    }
    private void saveSubject(HttpServletRequest request, HttpServletResponse response)
    		throws SQLException, ServletException, IOException {
    	Subject subject=new Subject();
    	subject.setCourse_id(Integer.parseInt(request.getParameter("course_id")));
    	subject.setSubject(request.getParameter("subject"));
    	subject.setStatus("Active");
    	if(request.getParameter("id") != "0")
    	{
    		subject.setId(Integer.parseInt(request.getParameter("id")));	
    	}
    	learnersDao.saveSubject(subject);
        response.sendRedirect("addSubject");
    }
    private void viewLogin(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    
    }

    private void deleteSingleItem(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("did"));
        String type=request.getParameter("type");
        String redirect=learnersDao.deleteSingleItem(id,type);
        response.sendRedirect(redirect);
    }
    public void getCourseReport(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException ,ServletException{
    	int id = Integer.parseInt(request.getParameter("classname"));
    	ArrayList<Report> coursereport = (ArrayList<Report>)learnersDao.getCourseReport(id);
		request.setAttribute("coursereport", coursereport);
		ArrayList<User> studentslist = (ArrayList<User>)learnersDao.getStudentReport(id);
		request.setAttribute("studentslist", studentslist);
		HashMap<String,String> dashCount = learnersDao.getDashCount();
		request.setAttribute("dashCount", dashCount);
		List < Course > listCourse = learnersDao.getCourseList();
        request.setAttribute("listCourse", listCourse);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
        dispatcher.forward(request, response);

    	
    }
}