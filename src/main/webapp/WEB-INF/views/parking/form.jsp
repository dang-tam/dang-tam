<%-- 
    Document   : form
    Created on : Jun 8, 2026, 11:54:32 AM
    Author     : LAB12-PC15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container mt-4">
    <h3 class="mb-4">
        <c:choose>
            <c:when test="${parking.parkingID != null}">
                Edit Parking
            </c:when>
            <c:otherwise>
                Add New Parking
            </c:otherwise>
        </c:choose>
    </h3>

    <form:form modelAttribute="parking" method="post">

        <form:hidden path="parkingID"/>

        <div class="mb-3">
            <form:label path="householdID" cssClass="form-label">
                Household ID
            </form:label>
            <form:input path="householdID"
                        cssClass="form-control"
                        type="number"/>
        </div>

        <div class="mb-3">
            <form:label path="parkingNumber" cssClass="form-label">
                Parking Number
            </form:label>
            <form:input path="parkingNumber"
                        cssClass="form-control"
                        required="true"/>
        </div>

        <div class="mb-3">
            <form:label path="vehicleType" cssClass="form-label">
                Vehicle Type
            </form:label>
            <form:select path="vehicleType" cssClass="form-select">
                <form:option value="Car">Car</form:option>
                <form:option value="Motorbike">Motorbike</form:option>
                <form:option value="Bicycle">Bicycle</form:option>
                <form:option value="Other">Other</form:option>
            </form:select>
        </div>

        <div class="mb-3">
            <form:label path="status" cssClass="form-label">
                Status
            </form:label>
            <form:select path="status" cssClass="form-select">
                <form:option value="Available">Available</form:option>
                <form:option value="Occupied">Occupied</form:option>
                <form:option value="Reserved">Reserved</form:option>
            </form:select>
        </div>

        <button type="submit" class="btn btn-primary">
            <c:choose>
                <c:when test="${parking.parkingID != null}">
                    Update
                </c:when>
                <c:otherwise>
                    Save
                </c:otherwise>
            </c:choose>
        </button>

        <a href="<c:url value='/parkings' />"
           class="btn btn-secondary">
            Cancel
        </a>

    </form:form>
</div>
