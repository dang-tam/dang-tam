<%-- 
    Document   : form
    Created on : Jun 8, 2026, 11:55:05 AM
    Author     : LAB12-PC15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container mt-4">
    <h3 class="mb-4">
        <c:choose>
            <c:when test="${resident.residentID != null}">
                Edit Resident
            </c:when>
            <c:otherwise>
                Add New Resident
            </c:otherwise>
        </c:choose>
    </h3>

    <form:form modelAttribute="resident" method="post">

        <form:hidden path="residentID"/>

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
            <form:label path="fullName" cssClass="form-label">
                Full Name
            </form:label>
            <form:input path="fullName"
                        cssClass="form-control"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="dateOfBirth" cssClass="form-label">
                Date of Birth
            </form:label>
            <form:input path="dateOfBirth"
                        cssClass="form-control"
                        type="date"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="gender" cssClass="form-label">
                Gender
            </form:label>
            <form:select path="gender" cssClass="form-select">
                <form:option value="Male">Male</form:option>
                <form:option value="Female">Female</form:option>
                <form:option value="Other">Other</form:option>
            </form:select>
        </div>

        <div class="mb-3">
            <form:label path="relationship" cssClass="form-label">
                Relationship
            </form:label>
            <form:select path="relationship" cssClass="form-select">
                <form:option value="Head">Head</form:option>
                <form:option value="Spouse">Spouse</form:option>
                <form:option value="Child">Child</form:option>
                <form:option value="Parent">Parent</form:option>
                <form:option value="Sibling">Sibling</form:option>
                <form:option value="Relative">Relative</form:option>
                <form:option value="Other">Other</form:option>
            </form:select>
        </div>

        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${resident.residentID != null}">
                    Update
                </c:when>
                <c:otherwise>
                    Save
                </c:otherwise>
            </c:choose>
        </button>

        <a href="<c:url value='/residents' />"
           class="btn btn-secondary">
            Cancel
        </a>

    </form:form>
</div>
