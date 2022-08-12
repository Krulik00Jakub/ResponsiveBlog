<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.io.IOException, java.io.PrintWriter, java.util.List, java.util.ArrayList, Mod.Articles"%>
 
<%
	Articles mod;
	try {
		mod = new Articles("C:\\Users\\Jakub\\eclipse-workspace\\Sinoling\\src\\main\\webapp\\content\\");
	} catch (Exception e) {
		throw new IOException(e);
	}
	
	int i = 0;
%>
<!DOCTYPE html>
<html lang="en-ca">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="utf-8">
<title><%out.print(1D + (i+1));%></title>
<link rel="stylesheet" href="sheet.css">
</head>
<body>
<%out.print(mod.topNav());%>

<%out.print(mod.htmList());%>

</body>
</html>

<!-- UMMMMMMM, UHMMMMMMM, IT'S GIVING ME WEIRD OUTPUT ~
RESOLVED!!!-->