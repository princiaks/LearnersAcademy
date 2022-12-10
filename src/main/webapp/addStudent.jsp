<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.glvc.main.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%
String fname="",lname="",dob="",phone="",address="";
String course_id="0";
String id="0";
String subbtn="Save";
String title="Add Student";
%>
<%

if(request.getAttribute("forEdit") !=null){
	subbtn="Update";
	title="Update Student";
	HashMap<String,String> desig =(HashMap<String,String>)request.getAttribute("forEdit");
	id=desig.get("id");
	fname=desig.get("fname");
	lname=desig.get("lname");
	dob=desig.get("dob");
	phone=desig.get("phone");
	address=desig.get("address");
	course_id=desig.get("course_id");
}
%>
<div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-r-0 title-margin-right">
                        <div class="page-header">
                            <div class="page-title">
                                <h1><%= title%></h1>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                    <div class="col-lg-4 p-l-0 title-margin-left">
                       
                    </div>
                    <!-- /# column -->
                </div>
                <!-- /# row -->
                <section id="main-content">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="form-validation">
                                        <form class="form-valide" action="saveUser" method="post">
                                            <div class="form-group row">
                                                <label class="col-lg-4 col-form-label" for="val-username">First Name <span class="text-danger">*</span></label>
                                                <div class="col-lg-8">
                                                    <input type="text" class="form-control" id="val-username" value="<%= fname%>" name="fname" placeholder="Enter first name.." required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-lg-4 col-form-label" for="val-username">Last Name <span class="text-danger">*</span></label>
                                                <div class="col-lg-8">
                                                    <input type="text" class="form-control" id="val-username" value="<%= lname%>" name="lname" placeholder="Enter last name.." required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-lg-4 col-form-label" for="val-email">Date of Birth <span class="text-danger">*</span></label>
                                                <div class="col-lg-8">
                                                    <input type="date" class="form-control" id="val-dob" value="<%= dob%>" name="dob" placeholder="Enter Date of Birth.." required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-lg-4 col-form-label" for="val-phoneus">Phone<span class="text-danger">*</span></label>
                                                <div class="col-lg-6">
                                                    <input type="text" class="form-control" id="val-phoneus" value="<%= phone%>" name="phone" placeholder="Enter Phone no..." required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-lg-4 col-form-label" for="val-suggestions">Address <span class="text-danger">*</span></label>
                                                <div class="col-lg-8">
                                                    <textarea class="form-control" id="val-suggestions" name="address" rows="5" placeholder="Enter Address..." required><%= address%></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-lg-4 col-form-label" for="val-select2">Course/Class <span class="text-danger">*</span></label>
                                                <div class="col-lg-8">
                                                    <select class="form-control" id="val-select2" name="course_id" style="width: 100%;" required data-placeholder="Choose one..">
                                                        <option value="">Choose Class</option>
                                                        <%ArrayList<Course> course=(ArrayList<Course>)request.getAttribute("listCourse");
										        		for(Course c:course){
										        			if(c.getId()== Integer.parseInt(course_id)){
										        			
										        			%>
										        			<option value="<%=c.getId()%>" selected><%=c.getClassname()%></option>
										        			<% }else{%>
										        			<option value="<%=c.getId()%>"><%=c.getClassname()%></option>
												               
										            	<% }}%>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-8 ml-auto">
                                                	<input type="hidden" name="role" value="student">
                                                    <input type="hidden" name="id" value="<%= id%>">
                                                    <button type="submit" class="btn btn-primary"><%= subbtn%></button>
                                                    
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
<%@include file="footer.jsp" %>