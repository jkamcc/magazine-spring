<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../init.jsp" %>

<div class="container-fluid">
		<!-- Para mostrar las sections existentes en la BD -->
		<h2><s:message code="sections"/></h2>  
		<form name="add_fm" id="add_fm" class="well form-horizontal"  novalidate>
			<fieldset>
				<legend><s:message code="section-add"/></legend>
				<div class="control-group">
					 <label class="control-label" for="sectionArticle"><s:message code="section-name"/></label>
					<div class="controls">
						<input type="text" name="sectionArticle" id="sectionArticle"  pattern="^[a-zA-Z]+(?=\d?)"/>
					</div>
                </div>
				
				 <div class="form-actions">	
					<button name="addButton" id="addButton" class="btn btn-primary btn-xxlarge">
						<s:message code="button-add"/> &nbsp;
            			<i class="fa fa-plus"></i>
            		</button>
				</div>
			</fieldset>
		</form>
		<form class="well form-horizontal" >
			<fieldset>
				<legend><s:message code="list-sections"/></legend>
				<table border="1" name="sectionTable" id="sectionTable" style="text-align:center;"> 
					<thead  class="btn-primary">
						<tr>
						<th><s:message code="section-id"/></th>
						<th><s:message code="section-name"/></th>
						<th style="width:50%;"><s:message code="action"/></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</fieldset>
		</form>
</div>

<script src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
<script src='<c:url value="/resources/js/jquery.dataTables.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script type="text/javascript"  src='<c:url value="/resources/js/section.js"/>'></script>