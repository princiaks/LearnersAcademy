<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
                    <div class="logo"><a href="index.html">
                            <!-- <img src="${pageContext.request.contextPath}/images/logo.png" alt="" /> --><span>Learner's Academy</span></a></div>
                    <li><a href="dashboard"><i class="ti-home"></i> Dashboard </a>
                    </li>

                    <li class="label">Main Process</li>
                    
                  
                    <li><a class="sidebar-sub-toggle"><i class="ti-layout-grid4-alt"></i> Student <span
                                class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                            <li><a href="addNewStudent">Add New Student</a></li>

                            <li><a href="studentsList">Student List</a></li>
                        </ul>
                    </li>
                   
                    <li><a class="sidebar-sub-toggle"><i class="ti-target"></i> Teacher <span
                                class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                            <li><a href="addTeacher">Add New Teacher</a></li>
                            <li><a href="teachersList">Teachers List</a></li>
                            <li><a href="addDesignation">Add Designation</a></li>
                            
                        </ul>
                    </li>
                    <li class="label">Other Process</li>
                    <li><a href="addCourse"><i class="ti-close"></i>Add New Class</a></li>
                    <li><a href="addSubject"><i class="ti-close"></i>Add New Subject</a></li>
                    <li><a href="login"><i class="ti-close"></i>Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- /# sidebar -->

    <div class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="float-left">
                        <div class="hamburger sidebar-toggle">
                            <span class="line"></span>
                            <span class="line"></span>
                            <span class="line"></span>
                        </div>
                    </div>
                    <div class="float-right">
                        
                       
                        <div class="dropdown dib">
                            <div class="header-icon" >
                                <span class="user-avatar">Hello Admin,
                                   
                                </span>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>