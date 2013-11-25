<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>

<div style="margin-left:30px;" class="container">
    <div class="hero-unit" style="padding-left: 20%;">
        <!-- Para mostrar las sections existentes en la BD -->
        <h2>Sections</h2>
        <form name="add_fm" id="add_fm" nonvalidate>
            <h4>Add Section</h4>
            <input type="text" name="sectionArticle" id="sectionArticle"/>
            <input type="button" value=<s:message code="button-add"/> name="addButton" id="addButton" class="btn btn-primary"/>
        </form>
        &nbsp;
        <h4><s:message code="list-sections"/></h4>
        <table border="1" name="sectionTable" id="sectionTable">
            <thead  class="btn btn-primary">
            <tr>
                <th><s:message code="section-id"/></th>
                <th><s:message code="section-name"/></th>
                <th><s:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        </br>
    </div>
</div>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.dataTables.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.min.js"/>'></script>
<script type="text/javascript"  src='<c:url value="/resources/js/section.js"/>'></script>