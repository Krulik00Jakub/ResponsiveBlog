<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.io.IOException, java.io.PrintWriter, Mod.Modular"%>
 
<%
	Modular mod;
	try {
		mod = new Modular("C:\\Users\\Jakub\\eclipse-workspace\\Sinoling\\src\\main\\webapp\\content.html", "1D1");
	} catch (Exception e) {
		throw new IOException(e);
	}
%>
<!DOCTYPE html>
<html>
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