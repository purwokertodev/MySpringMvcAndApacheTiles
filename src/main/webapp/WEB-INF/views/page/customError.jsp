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
				<li><i class="icon-home"></i> <a href="/adminpage">Home</a> <i
					class="icon-angle-right"></i></li>
				<li><a href="#">Dashboard</a></li>
			</ul>

			<div class="row-fluid">

				<div class="headline text-center">Error 404 - Access is
					denied</div>

				<div class="clearfix"></div>

			</div>
			<!--/row-->

		</div>
		<!--/.fluid-container-->
	</tiles:putAttribute>
</tiles:insertDefinition>