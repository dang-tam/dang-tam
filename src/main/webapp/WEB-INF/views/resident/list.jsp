<%-- 
    Document   : list
    Created on : Jun 8, 2026, 11:55:00 AM
    Author     : LAB12-PC15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="d-flex justify-content-between align-items-center mb-3">
    <h2>Danh sách cư dân</h2>

    <a href="${pageContext.request.contextPath}/residents/add"
       class="btn btn-success">
        + Thêm mới
    </a>
</div>

<table class="table table-bordered table-hover">
    <thead class="table-primary">
        <tr>
            <th>ID</th>
            <th>Household ID</th>
            <th>Full Name</th>
            <th>Date of Birth</th>
            <th>Gender</th>
            <th>Relationship</th>
            <th>Hành động</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="r" items="${residents}">
            <tr>
                <td>${r.residentID}</td>
                <td>${r.householdID}</td>
                <td>${r.fullName}</td>
                <td>${r.dateOfBirth}</td>

                <td>
                    <c:choose>
                        <c:when test="${r.gender == 'Male'}">
                            <span class="badge bg-primary">Male</span>
                        </c:when>

                        <c:when test="${r.gender == 'Female'}">
                            <span class="badge bg-danger">Female</span>
                        </c:when>

                        <c:otherwise>
                            <span class="badge bg-secondary">Other</span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>${r.relationship}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/residents/edit/${r.residentID}"
                       class="btn btn-sm btn-primary">
                        Sửa
                    </a>

                    <a href="${pageContext.request.contextPath}/residents/delete/${r.residentID}"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Bạn chắc chắn muốn xóa?')">
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
