<%@include file="init.jsp" %>

<div class="container-fluid">
    <h2><s:message code="articles"/></h2>

    <div class="element-add">
        <button class="btn btn-primary btn-xxlarge" onclick="location.href='<c:url value="/articles/new"/>'">
            <s:message code="article-add-new"/> &nbsp;
            <i class="fa fa-plus"></i>
        </button>
    </div>

    <hr>

    <fieldset>
        <legend><s:message code="article-list"/></legend>
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
    </fieldset>
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

        $(document).on("click", ".deleteButton", function() {
            deleteArticle(this);
        });

        $(document).on("click", ".editButton", function() {
            var id=(this.parentNode.parentNode.children)[4].textContent;
            editArticle(id);
        });

    });
</script>
