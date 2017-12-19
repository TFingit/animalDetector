<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动物识别DEMO</title>
<!-- easyui的样式主题文件 -->
<link rel="stylesheet" type="text/css" href="/resources/js/easyui/themes/default/easyui.css">
<!-- easyui的系统图标-->   
<link rel="stylesheet" type="text/css" href="/resources/js/easyui/themes/icon.css">
<!-- 引入颜色的样式 -->
<link rel="stylesheet" type="text/css" href="/resources/js/easyui/themes/color.css">
<!-- easyui依赖的jquery库-->   
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<!-- easyui的插件库-->      
<script type="text/javascript" src="/resources/js/easyui/jquery.easyui.min.js"></script>
<!-- easyui的汉化包 -->
<script type="text/javascript" src="/resources/js/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	
</script>
</head>
<body>
${msg}
	<form action="/detect" method="post" enctype="multipart/form-data">
		<div class="easyui-panel" title="动物识别Demo"
			style="width: 400px; padding: 30px 70px 50px 70px">
			<div style="margin-bottom: 20px">
				<div>图片:</div>
				<input class="easyui-filebox" name="animalPic"
					data-options="prompt:'上传一张动物图片哦'" style="width: 100%">
			</div>
			<div>
				<button class="easyui-linkbutton" style="width: 100%">上传</button>
			</div>
		</div>
	</form>

</body>
</html>