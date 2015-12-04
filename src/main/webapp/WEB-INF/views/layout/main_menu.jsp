<!-- start: Main Menu -->
<%@include file="/WEB-INF/views/layout/includes.jsp"%>
<div id="sidebar-left" class="span2">
	<div class="nav-collapse sidebar-nav">
		<ul class="nav nav-tabs nav-stacked main-menu">
			<li><a href="adminpage"><i class="icon-bar-chart"></i><span
					class="hidden-tablet"> Dashboard</span></a></li>
			<li><a class="dropmenu" href="#"><i class="icon-envelope"></i><span
					class="hidden-tablet"> Example</span></a>
				<ul>
					<li><a class="submenu" href='<spring:url value="employee"/>'><i
							class="icon-file-alt"></i><span class="hidden-tablet">
								Employee Line</span></a></li>
					<li><a class="submenu" href='<spring:url value="employee_multi_line"/>'><i
							class="icon-file-alt"></i><span class="hidden-tablet">
								Employee Multi</span></a></li>
					<li><a class="submenu" href='<spring:url value="cpu_example"/>'><i
							class="icon-file-alt"></i><span class="hidden-tablet">
							Cpu Meter Example
							</span></a></li>
				</ul></li>
			<li><a href="tasks.html"><i class="icon-tasks"></i><span
					class="hidden-tablet"> Tasks</span></a></li>
			<li><a href="widgets.html"><i class="icon-dashboard"></i><span
					class="hidden-tablet"> Widgets</span></a></li>
			<li><a class="dropmenu" href="#"><i
					class="icon-folder-close-alt"></i><span class="hidden-tablet">
						Monitoring</span></a>
				<ul>
					<li><a class="submenu" href="database_server"><i
							class="icon-file-alt"></i><span class="hidden-tablet">
								Database Server</span></a></li>
					<li><a class="submenu" href="web_service_server"><i
							class="icon-file-alt"></i><span class="hidden-tablet"> Web
								Service Server</span></a></li>
					<li><a class="submenu" href="report_server"><i
							class="icon-file-alt"></i><span class="hidden-tablet">
								Report Server</span></a></li>
				</ul></li>
		</ul>
	</div>
</div>
<!-- end: Main Menu -->