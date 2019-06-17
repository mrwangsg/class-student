## 班级增删查改接口 ##
- **列表班级**：  
	**GET** /class  
	示例：http://localhost:8080/class  
    请求头：无  
	参数：无  
  
	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |[] 或对象数组     	| 没有查询到返回空数组     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |

- **单个班级**：  
	**GET** /class/{uuid}  
	示例：http://localhost:8080/class/1  
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

- **删除班级**：  `注意删除会影响学生表`  
	**DELETE** /class/{uuid}  
	示例：http://localhost:8080/class/1  
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

- **批量删除班级**：  `注意删除会影响学生表`  
	**DELETE** /class/batch  
	示例：http://localhost:8080/class/batch  
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

- **增加班级**：
 	**POST** /class/  
	示例：http://localhost:8080/class  
	请求头：  

	| #    		| key 				| value 						|
	| ---- 		| ---- 				| ---- 							|
	| payload   |Content-Type     	| application/json       		|
	参数：  

	| 参数  			| 是否必填 	| 备注 				|
	| ---- 			| ---- 		| ---- 				|
	| className   	|是     		| 班级名       		|
	| classTeacher  |是     		| 班主任       		|

	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |null 或对象数组     	| 没有查询到返回空对象     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |

- **修改班级**：
 	**PUT** /class/  
	示例：http://localhost:8080/class  
	请求头：  

	| #    		| key 				| value 						|
	| ---- 		| ---- 				| ---- 							|
	| payload   |Content-Type     	| application/json       		|
	参数：  

	| 参数  			| 是否必填 	| 备注 				|
	| ---- 			| ---- 		| ---- 				|
	| uuid   		|是     		| 班级名Id       	|
	| classTeacher  |否     		| 班主任       		|

	返回结果：

	| #    		| 内容 				| 备注 							|
	| ---- 		| ---- 				| ---- 							|
	| payload   |null 或对象     	| 没有查询到返回空对象     		|
	| code    	| 200 或 404     	| 查询成功返回200 失败提示404  	|
	| msg    	| ok 或 其他信息     	| 查询成功返回ok  失败提示对应信息  |
