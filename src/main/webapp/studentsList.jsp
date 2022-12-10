<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.glvc.main.User"%>
<%@page import="com.glvc.main.Course"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>
<% int i=1;
   String type="student"; %>
<div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-r-0 title-margin-right">
                        <div class="page-header">
                            <div class="page-title">
                                <h1>Students List</span></h1>
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
                                                    <th>Fist Name</th>
                                                    <th>Last Name</th>
                                                    <th>Phone</th>
                                                    <th>DOB</th>
                                                    <th>Address</th>
                                                    <th>Course</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                            	 <%ArrayList<User> user=(ArrayList<User>)request.getAttribute("listUsers");
										        		for(User u:user){%>
										        
												            <tr>
												                <td><%=i++%></td>
												                <td><%=u.getFname() %></td>
												                <td><%=u.getLname() %></td>
												                <td><%=u.getPhone() %></td>
												                <td><%=u.getDob() %></td>
												                <td><%=u.getAddress() %></td>
												                <td><%=u.getSclass() %></td>
												                <td> <a href="editStudent?eid=<%=u.getId()%>"/>Edit</a>
                     												&nbsp;&nbsp;&nbsp;&nbsp;
                     												<a href="delete?did=<%=u.getId()%>&type=<%=type%>"/>Delete</a></td>
												            </tr>
										            	<% }%>
                                                
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