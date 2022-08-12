<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8" import="java.io.IOException, java.io.PrintWriter, Mod.Modular"%>
 
<%
	Modular mod;
	try {
		mod = new Modular("C:\\Users\\Jakub\\eclipse-workspace\\Sinoling\\src\\main\\webapp\\About.html", "About");
	} catch (Exception e) {
		throw new IOException(e);
	}
%>
<!DOCTYPE html>
<html lang="en-ca">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<title><%out.print(mod.name());%></title>
<link rel="stylesheet" href="sheet.css">
</head>
<body>
<%
	
	out.print(mod.topNav());
	out.print(mod.content());
	
%>
</body>
</html>