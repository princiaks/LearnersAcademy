<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.glvc.main.Course"%>
<%@page import="com.glvc.main.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.glvc.main.Report"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
    <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-r-0 title-margin-right">
                        <div class="page-header">
                            <div class="page-title">
                                <h1>Hello, <span>Welcome Admin</span></h1>
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
							<% if(request.getAttribute("dashCount") !=null){
								HashMap<String,String> desig =(HashMap<String,String>)request.getAttribute("dashCount");
								%>
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="stat-widget-one">
                                    <div class="stat-icon dib"><i class="ti-money color-success border-success"></i>
                                    </div>
                                    <div class="stat-content dib">
                                        <div class="stat-text">Teachers</div>
                                        <div class="stat-digit"><%= desig.get("teachercount") %></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="stat-widget-one">
                                    <div class="stat-icon dib"><i class="ti-user color-primary border-primary"></i>
                                    </div>
                                    <div class="stat-content dib">
                                        <div class="stat-text">Students</div>
                                        <div class="stat-digit"><%= desig.get("studentcount") %></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="stat-widget-one">
                                    <div class="stat-icon dib"><i class="ti-layout-grid2 color-pink border-pink"></i>
                                    </div>
                                    <div class="stat-content dib">
                                        <div class="stat-text">Courses/Classes</div>
                                        <div class="stat-digit"><%= desig.get("coursecount") %></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        	<%
							}%>
                    </div>
                    
                  

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-title pr">
                                    <h4>Get Report</h4>

                                </div>
                                <div class="card-body">
                                <form class="form-valide" action="getCourseReport" method="post">
                                <div class="row p-2">
                                <div class="col-6">
                                            <div class="form-group">
                                                <div class="">
                                                    <select class="form-control" id="val-select2" name="classname" style="width: 100%;" required data-placeholder="Choose one..">
                                                        <option value="">Choose Class</option>
                                                        <%ArrayList<Course> desig=(ArrayList<Course>)request.getAttribute("listCourse");
										        		for(Course c:desig){
										        			%>
										        			<option value="<%=c.getId()%>"><%=c.getClassname()%></option>
												               
										            	<% }%>
                                                    </select>
                                                </div>
                                            </div>
                                            </div>
                                            <div class="col-3">
                                            <div class="form-group">
                                                <div class="">
                                                    <button type="submit" class="btn btn-primary">Get Report</button>
                                                </div>
                                            </div>
                                            </div>
                                            </div>
                                        </form>
                                         <div class="card-title pr pt-3 mt-3">
                                        <h4>Class Report</h4>
                                        </div>
                                          <% int cslno=1; %>
                                          <div class="container">
                                      <div class="table-responsive">
                                        <table class="table student-data-table m-t-20">
                                            <thead>
                                                <tr>
                                                    <th>SL No</th>
                                                    <th>Class</th>
                                                    <th>Subject</th>
                                                    <th>Faculty</th>
                                                    <th>Faculty Designation</th>
                                                    <th></th>
                                                    
                                                   
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                            if(request.getAttribute("coursereport") !=null)
                                            {
                                            	ArrayList<Report> coursereport=(ArrayList<Report>)request.getAttribute("coursereport");
                                            	for(Report r:coursereport){
                                            		%>
                                            		<tr>
                                                    <td><%= cslno %></td>
                                                    <td><%= r.getClassname() %></td>
                                                    <td><%= r.getSubject() %></td>
                                                    <td><%= r.getTeacher() %></td>
                                                    <td><%= r.getDesignation() %></td>
                                                   <td></td>
                                                	</tr>
                                            		<%
                                            		cslno++;
                                            	}
                                            }
                                            %>
                                                
                                              
                                            </tbody>
                                        </table>
                                    </div>
                                    </div><br>
                                     <div class="card-title pr">
                                        <h4>Students List</h4>
                                        </div>
                                        <% int sslno=1; %>
                                    <div class="table-responsive">
                                        <table class="table student-data-table m-t-20">
                                            <thead>
                                                <tr>
                                                    <th>SL No.</th>
                                                    <th>First Name</th>
                                                    <th>Last Name</th>
                                                    <th>DOB</th>
                                                    <th>Address</th>
                                                    <th>Phone</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                            if(request.getAttribute("studentslist") !=null)
                                            {
                                            	ArrayList<User> studentslist=(ArrayList<User>)request.getAttribute("studentslist");
                                            	for(User s:studentslist){
                                            		%>
                                            		<tr>
                                                    <td><%= sslno %></td>
                                                    <td><%= s.getFname() %></td>
                                                    <td><%= s.getLname() %></td>
                                                    <td><%= s.getDob() %></td>
                                                    <td><%= s.getAddress() %></td>
                                                    <td><%= s.getPhone() %></td>
                                                   
                                                	</tr>
                                            		<%
                                            		sslno++;
                                            	}
                                            }
                                           
                                            	%>
                                               
                                              
                                            </tbody>
                                        </table>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        <!-- /# column -->
                    </div>
  <%@include file="footer.jsp" %>