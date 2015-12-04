<%@include file="/WEB-INF/views/layout/includes.jsp"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

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
					<div class="panel-heading">Chart</div>
					<div class="panel-body">
						<div id="chartContainer" style="height: 300px; width: 100%;"></div>
					</div>
				</div>

				<div class="clearfix"></div>

			</div>
			<!--/row-->
			
			<div class="row-fluid">

				<div class="panel panel-default">
					<div class="panel-heading">Chart</div>
					<div class="panel-body">
						<div id="chartContainer2" style="height: 300px; width: 100%;"></div>
					</div>
				</div>

				<div class="clearfix"></div>

			</div>
			<!--/row-->

			<div class="row-fluid">

				<div class="panel panel-default">
					<div class="panel-heading">Employee List</div>
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
			window.onload = function() {
				var dataPointsSalary = [];
				var dataPointsAge = [];

				// Ajax request for getting JSON data

				$.getJSON("${pageContext.request.contextPath }/employee/employees",function(data) {
					for ( var i = 0; i < data.length; i++) {
						dataPointsSalary.push({
							label : data[i].employeeName,
							y : data[i].salary
						});
						dataPointsAge.push({
							label : data[i].employeeName,
							y : data[i].age
						});
					}

					// Chart with label + y values

					var chart = new CanvasJS.Chart(
							"chartContainer",
							{
								backgroundColor : "2156E2",
								title : {
									text : "Employees Age"
								},
								data : [
										{
											type : "splineArea",
											dataPoints : dataPointsAge,
										}, ]
							});
					chart.render();
				});

				var dps = []; // dataPoints

				var chart = new CanvasJS.Chart("chartContainer2",{
					backgroundColor : "2156E2",
					title :{
						text: "CPU Loading"
					},			
					data: [{
						type: "area",
						dataPoints: dps 
					}]
				});

				var xVal = 0;
				var yVal = 100;	
				var updateInterval = 100;
				var dataLength = 500; // number of dataPoints visible at any point

				var updateChart = function (count) {
					count = count || 1;
					// count is number of times loop runs to generate random dataPoints.
					
					for (var j = 0; j < count; j++) {	
		 				yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
		 				dps.push({
		 					x: xVal,
		 					y: yVal
		 				});
		 				xVal++;
		 			};
		 			if (dps.length > dataLength)
					{
						dps.shift();				
					}
					
					chart.render();		

				};

				// generates first set of dataPoints
				updateChart(dataLength); 

				// update chart after specified time. 
				setInterval(function(){updateChart()}, updateInterval);
			}
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>