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
				
				<div class="panel panel-primary">
					<div class="panel-heading">
						MEMORY USAGE
					</div>
					<div class="panel-body">
						<canvas id="cvs" width="450" height="450">[No canvas support]</canvas>
					</div>
				</div>

				<div class="clearfix"></div>

			</div>
			<!--/row-->
			

		</div>
		<!--/.fluid-container-->
		
		<script type="text/javascript">
			window.onload = function () {
				var target = 0;
	            var increment = 2;
	
	           $.getJSON("${pageContext.request.contextPath}/memory",function(data){
	               target = data;
	        	   var donut = new RGraph.Pie({
	                   id: 'cvs',
	                   data: [target,27],
	                   options: {
	                       variant: 'donut',
	                       colors: ['green','rgba(0,0,0,0)'],
	                       strokestyle: 'rgba(0,0,0,0)'
	                   }
	               }).on('draw', function (obj)
	               {
	                   // Update the text object with the value shown on the Donut chart
	                   if (text) {
	                       text.text = parseInt(target * obj.get('effect.roundrobin.multiplier')) + '%';
	                   }
	               }).roundRobin();
	       
	       
	               var text = new RGraph.Drawing.Text({
	                   id: 'cvs',
	                   x: donut.centerx,
	                   y: donut.centery,
	                   text: '0%',
	                   options: {
	                       size: 52,
	                       halign: 'center',
	                       valign: 'center'
	                   }
	               }).draw();
	               });
			}
		</script>
	</tiles:putAttribute>
</tiles:insertDefinition>