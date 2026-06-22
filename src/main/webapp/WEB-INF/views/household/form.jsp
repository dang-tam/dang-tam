<%-- 
    Document   : form
    Created on : Jun 8, 2026, 11:53:46 AM
    Author     : LAB12-PC15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container mt-4">
    <h3 class="mb-4">
        <c:choose>
            <c:when test="${household.householdID != null}">
                Edit Household
            </c:when>
            <c:otherwise>
                Add New Household
            </c:otherwise>
        </c:choose>
    </h3>

    <form:form modelAttribute="household" method="post">

        <form:hidden path="householdID"/>

        <div class="mb-3">
            <form:label path="apartmentID" cssClass="form-label">
                Apartment ID
            </form:label>
            <form:input path="apartmentID"
                        cssClass="form-control"
                        type="number"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="headOfHousehold" cssClass="form-label">
                Head Of Household
            </form:label>
            <form:input path="headOfHousehold"
                        cssClass="form-control"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="contactNumber" cssClass="form-label">
                Contact Number
            </form:label>
            <form:input path="contactNumber"
                        cssClass="form-control"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="email" cssClass="form-label">
                Email
            </form:label>
            <form:input path="email"
                        cssClass="form-control"
                        type="email"
                        required="true"/>
        </div>

        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${household.householdID != null}">
                    Update
                </c:when>
                <c:otherwise>
                    Save
                </c:otherwise>
            </c:choose>
        </button>

        <a href="<c:url value='/households' />"
           class="btn btn-secondary">
            Cancel
        </a>

    </form:form>
</div>
