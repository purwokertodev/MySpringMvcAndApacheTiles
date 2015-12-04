<%@include file="/WEB-INF/views/layout/includes.jsp" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="main-layout">
	<tiles:putAttribute name="body">

		<noscript>
			<div class="alert alert-block span10">
				<h4 class="alert-heading">Warning!</h4>
				<p>
					You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
						target="_blank">JavaScript</a> enabled to use this site.
				</p>
			</div>
		</noscript>

		<!-- start: Content -->
		<div id="content" class="span10">


			<ul class="breadcrumb">
				<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
					class="icon-angle-right"></i></li>
				<li><a href="#">Dashboard</a></li>
			</ul>

			<div class="row-fluid">

				<div class="panel panel-default">
					<div class="panel-heading">
						Chart
					</div>
					<div class="panel-body">
						<div id="chartContainer" style="height: 300px; width: 100%;"></div>
					</div>
				</div>

				<div class="clearfix"></div>

			</div>
			<!--/row-->
			
			<div class="row-fluid">

				<div class="panel panel-default">
					<div class="panel-heading">
						Employee List
					</div>
					<div class="panel-body">
						<table class="table table-hover table-bordered table-striped">
							<thead>
								<tr>
									<th>EMPLOYEE ID</th>
									<th>EMPLOYEE NAME</th>
									<th>EMPLOYEE SALARY</th>
									<th>EMPLOYEE AGE</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${emList }" var="e">
									<tr>
										<td>${e.id }</td>
										<td>${e.employeeName }</td>
										<td>${e.salary }</td>
										<td>${e.age }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>

				<div class="clearfix"></div>

			</div>
			<!--/row-->

		</div>
		<!--/.fluid-container-->
		
		<script type="text/javascript">
		window.onload = function () {
			var dataPointsTemp = [];

		// Ajax request for getting JSON data

			$.getJSON("${pageContext.request.contextPath }/employee/employees", function(data) {
				for( var i = 0; i < data.length; i++) {
					dataPointsTemp.push({ label: data[i].employeeName, y: data[i].salary });
				}	
			
				// Chart with label + y values

				var options = 
				{
						title:{
							text: "Employees Salary"
						},	
						exportEnabled:true,
						animationEnabled:true,
						data: [
						{	type : "column",
							dataPoints: dataPointsTemp,
						}]	
				};
				$("#chartContainer").CanvasJSChart(options);
			});
	}
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>