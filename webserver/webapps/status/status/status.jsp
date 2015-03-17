<%@ page session="false" %>
<%java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");%>
{
  "Hostname": "<%= java.net.InetAddress.getLocalHost().getHostName() %>"
  "Tomcat Version": "<%= application.getServerInfo() %>"
  "Servlet Specification Version": "<%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>"
  "JSP version": "<%=JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>"
  "Now": <%= dateFormat.format(new java.util.Date()) %>"
}
