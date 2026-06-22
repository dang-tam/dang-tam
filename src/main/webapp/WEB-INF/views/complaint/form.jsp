<%-- 
    Document   : form
    Created on : Jun 8, 2026, 11:52:41 AM
    Author     : LAB12-PC15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container mt-4">
    <h3 class="mb-4">
        <c:choose>
            <c:when test="${complaint.complaintID != null}">
                Edit Complaint
            </c:when>
            <c:otherwise>
                Submit New Complaint
            </c:otherwise>
        </c:choose>
    </h3>

    <form:form modelAttribute="complaint" method="post" cssClass="needs-validation">

        <!-- Hidden ID for edit -->
        <form:hidden path="complaintID"/>

        <div class="mb-3">
            <form:label path="householdID" cssClass="form-label">
                Household ID
            </form:label>
            <form:input path="householdID"
                        cssClass="form-control"
                        type="number"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="description" cssClass="form-label">
                Description
            </form:label>
            <form:textarea path="description"
                           cssClass="form-control"
                           rows="4"
                           required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="submissionDate" cssClass="form-label">
                Submission Date
            </form:label>
            <form:input path="submissionDate"
                        cssClass="form-control"
                        type="date"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="status" cssClass="form-label">
                Status
            </form:label>
            <form:select path="status" cssClass="form-select">
                <form:option value="Pending">Pending</form:option>
                <form:option value="In Progress">In Progress</form:option>
                <form:option value="Resolved">Resolved</form:option>
                <form:option value="Rejected">Rejected</form:option>
            </form:select>
        </div>

        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${complaint.complaintID != null}">
                    Update
                </c:when>
                <c:otherwise>
                    Submit
                </c:otherwise>
            </c:choose>
        </button>

        <a href="<c:url value='/complaints' />"
           class="btn btn-secondary">
            Cancel
        </a>

    </form:form>
</div>
