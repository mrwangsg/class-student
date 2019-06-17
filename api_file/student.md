## 学生增删查改接口 ##
- **列表学生**：  
	**GET** /student  
	示例：http://localhost:8080/student  
    请求头：无  
	参数：无  
  
	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |[] 或对象数组     	| 没有查询到返回空数组     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |

- **单个学生**：  
	**GET** /student/{uuid}  
	示例：http://localhost:8080/student/1  
	请求头：  

	| #    		| key 				| value 						|
	| ---- 		| ---- 				| ---- 							|
	| payload   |Content-Type     	| application/json       		|
	参数：无  
	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   | null 或对象数组    	| 没有查询到返回空对象     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |

- **删除学生**：  
	**DELETE** /student/{uuid}  
	示例：http://localhost:8080/student/1  
	请求头：  

	| #    		| key 				| value 						|
	| ---- 		| ---- 				| ---- 							|
	| payload   |Content-Type     	| application/json       		|
	参数：无  
	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |null 或对象数组     	| 没有查询到返回空对象     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |

- **批量删除学生**：  
	**DELETE** /student/batch  
	示例：http://localhost:8080/student/batch  
	请求头：  

	| #    		| key 				| value 						|
	| ---- 		| ---- 				| ---- 							|
	| payload   |Content-Type     	| application/json       		|
	参数：[*] &nbsp;&nbsp;&nbsp; `*表示要删除的id集合` &nbsp;&nbsp;&nbsp; `列如:[1,2]` 

	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |[] 或对象数组     	| 没有查询到返回空数组     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |

- **增加学生**：`需要判断插入的班级是否已经存在`  
 	**POST** /class/  
	示例：http://localhost:8080/class  
	请求头：  

	| #    		| key 				| value 						|
	| ---- 		| ---- 				| ---- 							|
	| payload   |Content-Type     	| application/json       		|
	参数：  

	| 参数  			| 是否必填 	| 备注 				|
	| ---- 			| ---- 		| ---- 				|
	| studentNum   	|是     		| 班级名       		|
	| studentName  |是     		| 学号       		|
	| sex   	|是     		| 性别       		|
	| birthDate  |是     		| 出生日期       		|
	| address   	|是     		| 地址       		|
	| aliasClass  |是     		| 班级       		|

	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |null 或对象数组     	| 没有查询到返回空对象     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |
- **修改学生**：
 	**PUT** /class/  
	示例：http://localhost:8080/class  
	请求头：  

	| #    		| key 				| value 						|
	| ---- 		| ---- 				| ---- 							|
	| payload   |Content-Type     	| application/json       		|
	参数：  

	| 参数  			| 是否必填 	| 备注 				|
	| ---- 			| ---- 		| ---- 				|
	| uuid   	|是     		| 班级名       		|
	| studentName  |否    		| 学号       		|
	| sex   	|否     		| 性别       		|
	| birthDate  |否     		| 出生日期       		|
	| address   	|否     		| 地址       		|
	| aliasClass  |否     		| 班级       		|
	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |null 或对象     	| 没有查询到返回空对象     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |


