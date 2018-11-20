---
layout:     post
title:      Spring MVC Date类型参数BindException
date:       2018-11-20
author:     Shuning Wan
header-img: img/post-bg-coffee.jpeg
catalog: true
tags:
    - Java
    - Code
---
```text
异常信息：

Failed to convert from type java.lang.String to type java.util.Date for value '2014-12-02'; 
```
```java
//解决办法
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
```

