<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="init.jsp" %>

<div style="margin-left:5px;" class="container">
    <div class="hero-unit" style="padding-left: 5%;">
        <!-- Para mostrar las sections existentes en la BD -->
        <h2><s:message code="articles"/></h2>
        <table border="1" name="articlesTable" id="articlesTable">
            <thead  class="btn-primary">
            <tr>
                <th><s:message code="section-id"/></th>
                <th><s:message code="section-name"/></th>
                <th><s:message code="created-date"/></th>
                <th><s:message code="article-title"/></th>
                <th>Article id</th>
                <th><s:message code="article-author"/></th>
                <th><s:message code="article-content"/></th>
                <th>Comments</th>
                <th><s:message code="action"/></th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        </br>
    </div>
</div>

<script src='<c:url value="/resources/js/jquery-1.10.2.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.dataTables.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.validate.js"/>'></script>
<script src='<c:url value="/resources/DataTables-1.9.4/media/js/jquery.jeditable.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/articles.js"/>'></script>
<script type="text/javascript">
    $(document).ready(function(){
        var dataAjax;
        var $tableS= $('#articlesTable').dataTable( {
            "bProcessing": true,
            "aaSorting": [[ 2, "asc" ]],
            "sAjaxSource": $.ajax({
                type: "GET",
                url: "http://localhost:8080/service/article/all",
                async: false,
                data: ' ',
                contentType:"application/json",
                dataType: "json",
                success: function(data) {
                    dataAjax=  $.makeArray(data);
                    for(i=0; i<dataAjax.length;++i){
                        dataAjax[i].actions='<input type="button" class="deleteButton" value="Delete"/><input type="button" class="editButton" value="Edit"/>';
                    }
                },
            }),
            "aaData": dataAjax,
            aoColumns: [

                { mData: 'sectionid'},
                { mData: 'sectionName'},
                { mData: 'datearticle'},
                { mData: 'subject' },
                { mData: 'articleid' },
                { mData: 'author'},
                { mData: 'article' },
                { mData: 'comments'},
                {mData:'actions'}
            ],
        });

        $('.deleteButton').click(function(){
            var id=(this.parentNode.parentNode.children)[4].textContent;
            var tableRows= this.parentNode.parentNode.parentNode.children;
            var posicion=0;
            for(i=0; i<tableRows.length;++i){
                if((tableRows.item(i)).children.item(4).textContent==id){
                    posicion=i;
                }
            }
            deleteArticle(id, posicion);
        });

        $('.editButton').click(function(){
            var id=(this.parentNode.parentNode.children)[4].textContent;
            editArticle(id);
        });

    });
</script>
