<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css" rel="stylesheet">
<style>
h5, i {
	display: inline;
}
</style>
</head>
<body class="gray-bg">
	<div class="row">
		<div class="col-sm-10">
			<div class="wrapper wrapper-content animated fadeInUp">
				<ul class="notes">
					<s:iterator value="result" var="list" status="status">
						<li>
							<div>
								<h5
									onclick="showDetail('<s:property value="#status.count" />','<s:property value="#list.ISBN" />',
											'<s:property value="#list.price" />','<s:property value="#list.publisher" /> ','<s:property value="#list.publishDate"/>',
											'<s:property value="#list.author.name"/>','<s:property value="#list.author.age"/>','<s:property value="#list.author.country"/>');this.onclick=null;">
									<s:property value="#list.Tiltle" />
								</h5>
								<i id='<s:property value="#status.count" />'
									style="float: right" class="fa fa-wrench" onclick="window.location.href='updatebook.jsp'"></i>
									 <a
									href="#"
									onclick='
                            this.parentNode.parentNode.style.display = "none";
                            var e = "<s:property value="#list.ISBN" />";
                            $.ajax({
    		   					 url:"deleteBook?book.ISBN="+String(e),
    		   					 type:"post",
    		   					 success:function(result){
    		   					 	alert(result);
    		   					 } 
    							});'>
									<i class="fa fa-trash-o "></i>
								</a>
								<!-- 
                            <a href="deleteBook?book.ISBN='<s:property value="#list.ISBN"/>'"><i class="fa fa-trash-o "></i></a>
                        	 -->
							</div>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
	</div>

	<script>
		function showDetail(Id,ISBN,Price,Publisher,PublishDate,Name,Age,Country){
			var d1 = document.getElementById(Id);
			d1.insertAdjacentHTML('afterend', '<br></br><p>ISBN:'+ISBN+'</p><p>价格:'+Price+'</p><p>出版社:'+Publisher
					+'</p><p>出版日期:'+PublishDate+'</p><p>作者:'+Name+'</p><p>作者年龄:'+Age+'</p><p>国家:'+Country+'</p>');
		};
	</script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/content.min.js"></script>
</body>
</html>