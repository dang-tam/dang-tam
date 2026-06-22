<%-- 
    Document   : list
    Created on : Jun 8, 2026, 11:54:25 AM
    Author     : LAB12-PC15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="d-flex justify-content-between align-items-center mb-3">
    <h2>Danh sách chỗ đậu xe</h2>

    <a href="${pageContext.request.contextPath}/parkings/add"
       class="btn btn-success">
        + Thêm mới
    </a>
</div>

<table class="table table-bordered table-hover">
    <thead class="table-primary">
        <tr>
            <th>ID</th>
            <th>Household ID</th>
            <th>Parking Number</th>
            <th>Vehicle Type</th>
            <th>Status</th>
            <th>Hành động</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="p" items="${parkings}">
            <tr>
                <td>${p.parkingID}</td>

                <td>
                    <c:choose>
                        <c:when test="${p.householdID != null}">
                            ${p.householdID}
                        </c:when>
                        <c:otherwise>
                            <span class="text-muted">Unassigned</span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>${p.parkingNumber}</td>
                <td>${p.vehicleType}</td>

                <td>
                    <c:choose>
                        <c:when test="${p.status == 'Available'}">
                            <span class="badge bg-success">
                                Available
                            </span>
                        </c:when>

                        <c:when test="${p.status == 'Occupied'}">
                            <span class="badge bg-danger">
                                Occupied
                            </span>
                        </c:when>

                        <c:otherwise>
                            <span class="badge bg-warning text-dark">
                                Reserved
                            </span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <a href="${pageContext.request.contextPath}/parkings/edit/${p.parkingID}"
                       class="btn btn-sm btn-primary">
                        Sửa
                    </a>

                    <a href="${pageContext.request.contextPath}/parkings/delete/${p.parkingID}"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Bạn chắc chắn muốn xóa?')">
                        Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
