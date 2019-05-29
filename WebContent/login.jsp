<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录页面</title>
        <style type="text/css">
    #div {
	position:absolute;
	top: 50%;
	left: 50%;
	-webkit-transform: translate(75%, -50%);	
	width: 300px;
	height: 200px;
	background:red;
	opacity: 0.8;
	font-size: large;
	margin:inherit;
	}
    </style>
    </head>
    <body>
    	
    	<img src="WebContent/img/6.jpg" width="100%" height="100%"/>
    	<div id="div"> 
    	<div>
    	<table >
    		<tr align="middle">欢迎登录图书管理系统！</tr>
    		<tr></tr>
    		<tr></tr>
    	</table>
    	</div>
    	<form action="User" method="post">
    	<input type="hidden" name="method" value="login">
    		<table align="center">
    			<tr >
    				<td >
    					账号：
    				</td>
    				<td>
    					<input type="text" name="username" id="" value="" />
    				</td>
    				<td>
    					<input type="submit" name="" id="" value="注册" />
    				</td>
    			</tr>
    			<tr>
    				<td>密码：</td>
    				<td>
    					<input type="password" name="password" id="" value="" />
    				</td>
    				<td>
    					<input type="reset" name="" id="" value="重置" />
    				</td>
    			</tr>
    			
    			<tr align="center">
    				<td>
    					
    				</td>
    				<td >
    					<input type="submit" value="登录" width="100px"/><br/>
    					${msg}
    				</td>
    				
    			</tr>
    				
    			<tr> 
    				<td>
    				</td>
    				<a href="register.jsp">跳转到注册页面</a>
    				</td>
    			</tr>
    		</table>
    	</form>
    	</div>
    	
 	</body>
</html>