<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<input type="text" id="userName">
<input type="text" id="userPassword">
<input type="date" id="userDate">
<input type="file" id="userFile">
<input type="button" id="butt" value="点击">
</body>
<script type="text/javascript" src="statics/js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript">
    $(function () {
    	
    		var addCompanyIDs=[1,2,3,4];
         $("#butt").click(function () {
        	 alert($("#userDate").val());
        	 var entity = {
         			"userId": 1,
         			"userName": "测试商品",
         			"userPassword": "100",
         			"userDate":$("#userDate").val(),
         			"email": "测试商品描述",
         			"phone": "123456",
                 };
        	 alert( $("#userName").val())
        	 $.ajax({
        		    type: "post",
        		    url: "user/index.html",
                    contentType : "application/json;charset=UTF-8",
        		    data: JSON.stringify(entity),
        		    dataType: "json",
        		    success: function(data){
        		    	alert(data.userName);
        		    },
        		    error: function() {
        		          alert("数据加载失败");
        		    }
        		});
            });
        
    });
</script>
</html>
