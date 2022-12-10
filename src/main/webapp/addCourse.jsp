<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.glvc.main.Course"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<%
String classname="";
String id="0";
String subbtn="Save";
String title="Add Course";
int i=1;
String type="course";
%>
<%

if(request.getAttribute("forEdit") !=null){
	subbtn="Update";
	title="Update Course";
	HashMap<String,String> desig =(HashMap<String,String>)request.getAttribute("forEdit");
	id=desig.get("id");
	classname=desig.get("classname");
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
                                        <form class="form-valide" action="saveCourse" method="post">
                                            <div class="form-group row">
                                                <label class="col-lg-4 col-form-label" for="val-username">Class Name<span class="text-danger">*</span></label>
                                                <div class="col-lg-8">
                                                    <input type="text" class="form-control" id="val-username" value="<%= classname%>" name="classname" placeholder="Enter Class Name.." required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-8 ml-auto">
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
    <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-r-0 title-margin-right">
                        <div class="page-header">
                            <div class="page-title">
                                <h1>Class List</span></h1>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /# row -->
                <section id="main-content">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-title">
                                    
                                </div>
                                <div class="bootstrap-data-table-panel">
                                    <div class="table-responsive">
                                        <table id="row-select" class="display table table-borderd table-hover">
                                            <thead>
                                                <tr>
                                                    <th>SL No</th>
                                                    <th>Class</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                            	 <%ArrayList<Course> course=(ArrayList<Course>)request.getAttribute("listCourse");
										        		for(Course c:course){%>
										        
												            <tr>
												                <td><%=i%></td>
												                <td><%=c.getClassname() %></td>
												                <td> <a href="editCourse?eid=<%=c.getId()%>"/>Edit</a>
                     												&nbsp;&nbsp;&nbsp;&nbsp;
                     												<a href="delete?did=<%=c.getId()%>&type=<%=type%>"/>Delete</a></td>
												            </tr>
										            	<% i++;}%>
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- /# card -->
                        </div>
                        <!-- /# column -->
                    </div>
                    <!-- /# row -->
                </section>
            </div>
        </div>
    </div>
<%@include file="footer.jsp" %>