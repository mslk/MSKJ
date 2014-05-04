
/**
验证类
id  需要验证的id    : 在输入文本时是唯一   id 在单选按钮 或多选框时 是 name    

注意: 在使用对象封装时: 如 demo.sex 将自动采用裁剪后采用 sexTip 提示层
    
name  提示标题      
required 是否為必填項
type 輸入框类型   默认 1   类型: 1 为普通字符  2 为 整数 3 为小数  4 为邮箱  5 手机号码  
         6电话号码 7 身份证 8 邮编 9 字母  10 正整数 11 负整数 12 正浮点 13 负浮点 
         14 radio 验证  15 check   16 select单选  17 密码类型(如果带comparedId 则进行比较)  
         18 日期类型  19 (带comparedId 则进行比较)  日期类型大于 comparedId 
         21 正整数+0  22 比较数字<  23 比较数字>
         100 自定义验证方法 
compareId 比较ID   在密码比较和 日期比较 有使用 
minLen 最小长度 
maxLen 最大长度
defaultPassed 默认通过验证
**/
function Entity(obj) {
	
	if (obj.id && obj.name && obj.required!=null) {
		this.id = obj.id;
		this.name = obj.name;
		this.required = obj.required;
	}
	
	if (obj.type) {
		this.inputtype = obj.type;
	} else {
		this.inputtype = 1;
	}
	
	if(obj.compareId)
	{
	this.compareId =obj.compareId;
	}
	
	if (obj.minLen) {
		this.minLen = obj.minLen;
	}
	if (obj.maxLen) {
		this.maxLen = obj.maxLen;
	}
	
	if(obj.myValidate)
	{
	 this.myValidate=obj.myValidate;
	}
	
	if(obj.defaultPassed){
		this.defaultPassed = obj.defaultPassed;
	}
}
/**
验证自定义 验证函数
**/
function validateBase(list) {
	for (var i = 0; i < list.length; i++) {
		var entity = list[i];
		if (entity) {
			switch (entity.inputtype) {
			  case 1:
				if(entity.defaultPassed)
					validateStr(entity).defaultPassed();
				else
					validateStr(entity);
				break;
			  case 2:
				  if(entity.defaultPassed)
					  validateInteger(entity).defaultPassed();
			  	  else
			  		  validateInteger(entity);
				break;
			  case 3:
				  if(entity.defaultPassed)
					  validateDecmal(entity).defaultPassed();
				  else
					  validateDecmal(entity);
				break;
			  case 4:
				  if(entity.defaultPassed)
					  validateEmail(entity).defaultPassed();
				  else
					  validateEmail(entity);
				break;
			  case 5:
				  if(entity.defaultPassed)
					  validateMobile(entity).defaultPassed();
				  else
					  validateMobile(entity);
				break;
			  case 6:
				  if(entity.defaultPassed)
					  validateTelephone(entity).defaultPassed();
				  else
					  validateTelephone(entity);
				break;
			  case 7:
				  if(entity.defaultPassed)
					  validateIDCard(entity).defaultPassed();
				  else
					  validateIDCard(entity);
				break;
			  case 8:
				  if(entity.defaultPassed)
					  validateZipcode(entity).defaultPassed();
				  else
					  validateZipcode(entity);
				break;
			  case 9:
				  if(entity.defaultPassed)
					  validateLetter(entity).defaultPassed();
				  else
					  validateLetter(entity);
				break;
			  case 10:
				  if(entity.defaultPassed)
					  validatePositiveInteger(entity).defaultPassed();
				  else
					  validatePositiveInteger(entity);
				break;
			  case 11:
				  if(entity.defaultPassed)
					  validateNegativeInteger(entity).defaultPassed();
				  else
					  validateNegativeInteger(entity);
				break;
			  case 12:
				  if(entity.defaultPassed)
					  validatePositiveDecmal(entity).defaultPassed();
				  else
					  validatePositiveDecmal(entity);
				break;
			  case 13:
				  if(entity.defaultPassed)
					  validateNegetiveDecmal(entity).defaultPassed();
				  else
					  validateNegetiveDecmal(entity);
				break;
			  case 14:
				  if(entity.defaultPassed)
					  validateRadio(entity).defaultPassed();
				  else
					  validateRadio(entity);
				break;
			  case 15:
				  if(entity.defaultPassed)
					  validateCheck(entity).defaultPassed();
				  else
					  validateCheck(entity);
				break;
			  case 16:
				  if(entity.defaultPassed)
					  validateDropDownList(entity).defaultPassed();
				  else
					  validateDropDownList(entity);
				break;
			  case 17:
				  if(entity.defaultPassed)
					  validatePassword(entity).defaultPassed();
				  else
					  validatePassword(entity);
			  break;
			  case 18:
				  if(entity.defaultPassed)
					  validateDate(entity).defaultPassed();
				  else
					  validateDate(entity);
			  break;
			  case 19 :
				  if(entity.defaultPassed)
					  validateAfterDate(entity).defaultPassed();
				  else
					  validateAfterDate(entity);
			  break;
			  case 20 :
				  if(entity.defaultPassed)
					  validateUserName(entity).defaultPassed();
				  else
					  validateUserName(entity);
			  break;
			  case 21 :
				  if(entity.defaultPassed)
					  validatePositiveNum(entity).defaultPassed();
				  else
					  validatePositiveNum(entity);
			  break;
			  case 22 :
				  if(entity.defaultPassed)
					  compareNum_lt(entity).defaultPassed();
				  else
					  compareNum_lt(entity);
			  break;
			  case 23 :
				  if(entity.defaultPassed)
					  compareNum_gt(entity).defaultPassed();
				  else
					  compareNum_gt(entity);
			  break;
			  case 100:
				  if(entity.defaultPassed)
					  validateCustom(entity).defaultPassed();
				  else
					  validateCustom(entity);
			  break;
			}
		}
	}
}


/**
自定义验证规则 需要重写验证方法
**/
function validateCustom(obj)
{
   if (obj) 
   {
     if (obj.required) 
     {
        return $("#"+obj.id).formValidator({empty:false,tipID:obj.id+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选择正确"}).functionValidator({
	    fun:function(val,elem){
	         return obj.myValidate(elem);
		},
		onError:obj.name+"验证失败"
	});
     }else
     {
       return $("#"+obj.id).formValidator({empty:true,tipID:obj.id+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选择正确", onEmpty:""}).functionValidator({
	    fun:function(val,elem){
	         return obj.myValidate(elem);
		},
		onError:obj.name+"验证失败"
	  });
     }
   }
}


/**
通用  字符文本验证 不为空情况
字段      备注               是否可为空
obj.id  需要验证的id          否  
obj.name  提示标题              否
obj.required 是否为必填         否
obj.inputtype 输入框类型        是
obj.minLen 最小长度 默认 10    是
obj.maxLen 最大长度 默认 20    是
**/
function validateStr(obj) {
	if (obj) {
		if (!obj.minLen) {
			obj.minLen = 5;
		}
		if (obj.minLen && !obj.maxLen) {
			if (obj.required) {
				return $("#" + obj.id).formValidator({empty:false, onShow:"请输入" + obj.name, onFocus:"至少" + obj.minLen + "个长度", onCorrect:"输入" + obj.name + "正确！"}).inputValidator({ min:obj.minLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"});
			} else {
				return $("#" + obj.id).formValidator({empty:true, onShow:"请输入" + obj.name, onFocus:"至少" + obj.minLen + "个长度", onCorrect:"输入" + obj.name + "正确！", onEmpty:""}).inputValidator({min:obj.minLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"});
			}
		}
		if (obj.minLen && obj.maxLen) {
			if (obj.required) {
				return $("#" + obj.id).formValidator({empty:false, onShow:"请输入" + obj.name, onFocus:obj.name+"长度为" + obj.minLen + "-"+obj.maxLen, onCorrect:"输入" + obj.name + "正确！"}).inputValidator({min:obj.minLen, max:obj.maxLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"});
			} else {
				return $("#" + obj.id).formValidator({empty:true, onShow:"请输入" + obj.name, onFocus:obj.name+"长度为" + obj.minLen + "-"+obj.maxLen, onCorrect:"输入" + obj.name + "正确！", onEmpty:""}).inputValidator({min:obj.minLen, max:obj.maxLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"});
			}
		}
	}
}

/**
通用  用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
字段      备注               是否可为空
obj.id  需要验证的id          否  
obj.name  提示标题              否
obj.required 是否为必填         否
obj.inputtype 输入框类型        是
obj.minLen 最小长度 默认 10    是
obj.maxLen 最大长度 默认 20    是
**/
function validateUserName(obj) {
	if (obj) {
		if (!obj.minLen) {
			obj.minLen = 5;
		}
		if (obj.minLen && !obj.maxLen) {
			if (obj.required) {
				return $("#" + obj.id).formValidator({empty:false, onShow:"请输入" + obj.name, onFocus:"至少" + obj.minLen + "个长度", onCorrect:"输入" + obj.name + "正确！", defaultValue:"maodong"}).inputValidator({ min:obj.minLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"}).regexValidator({regExp:"username", dataType:"enum", onError:"必填"});
			} else {
				return $("#" + obj.id).formValidator({empty:true, onShow:"请输入" + obj.name, onFocus:"至少" + obj.minLen + "个长度", onCorrect:"输入" + obj.name + "正确！", onEmpty:""}).inputValidator({min:obj.minLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"}).regexValidator({regExp:"username", dataType:"enum", onError:"xxx"});
			}
		}
		if (obj.minLen && obj.maxLen) {
			if (obj.required) {
				return $("#" + obj.id).formValidator({empty:false, onShow:"请输入" + obj.name, onFocus:obj.name+"长度为" + obj.minLen + "-"+obj.maxLen, onCorrect:"输入" + obj.name + "正确！", defaultValue:"maodong"}).inputValidator({min:obj.minLen, max:obj.maxLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"}).regexValidator({regExp:"username", dataType:"enum", onError:"必填"});
			} else {
				return $("#" + obj.id).formValidator({empty:false, onShow:"请输入" + obj.name, onFocus:obj.name+"长度为" + obj.minLen + "-"+obj.maxLen, onCorrect:"输入" + obj.name + "正确！", onEmpty:""}).inputValidator({min:obj.minLen, max:obj.maxLen, empty:{leftEmpty:false, rightEmpty:false, emptyError:obj.name + "两边不能有空符号"}, onError:obj.name + "输入错误"}).regexValidator({regExp:"username", dataType:"enum", onError:"xxx"});
			}
		}
	}
}

/**
验证手机号码
**/
function validateMobile(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入手机号码", onFocus:"请输入正确手机号码", onCorrect:"手机号码输入正确！"}).inputValidator({min:11, max:11, onError:"正确的手机号码必须是11位"}).regexValidator({regExp:"mobile", dataType:"enum", onError:"输入的正确的手机号码格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入手机号码", onFocus:"必须输入正确的手机号码", onCorrect:"输入正确", onEmpty:""}).inputValidator({min:11, max:11, onError:"输入手机号码长度错误"}).regexValidator({regExp:"mobile", dataType:"enum", onError:"输入手机号码错误"});
		}
	}
}
/**
验证电话号码
**/
function validateTelephone(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入手机号码", onFocus:"格式例如：0755-88888888 ", onCorrect:"输入正确！"}).regexValidator({regExp:"^[[0-9]{3}-|[0-9]{4}-]?([0-9]{8}|[0-9]{7})?$", onError:"输入的电话格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入手机号码", onFocus:"格式例如：0755-88888888 ", onCorrect:"输入正确！", onEmpty:""}).regexValidator({regExp:"^[[0-9]{3}-|[0-9]{4}-]?([0-9]{8}|[0-9]{7})?$", onError:"输入的电话格式不正确！"});
		}
	}
}
/**
验证身份证
**/
function validateIDCard(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入身份证", onfocus:"输入15或18位的身份证", onCorrect:"输入正确！"}).regexValidator({regExp:"idcard", dataType:"enum", onError:"输入的身份证格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入身份证", onfocus:"输入15或18位的身份证", onCorrect:"输入正确！", onEmpty:""}).regexValidator({regExp:"idcard", dataType:"enum", onError:"输入的身份证格式不正确！"});
		}
	}
}
/**
验证邮箱
**/
function validateEmail(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入email", onfocus:"请注意email格式，例如:xxxxx@163.com", onCorrect:"输入正确！"}).regexValidator({regExp:"email", dataType:"enum", onError:"email格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入email", onfocus:"请注意email格式，例如:xxxxx@163.com", onCorrect:"输入正确！", onEmpty:""}).regexValidator({regExp:"email", dataType:"enum", onError:"email格式不正确！"});
		}
	}
}
/**
验证邮编
**/
function validateZipcode(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入邮编", onfocus:"邮编由6位数字组成", onCorrect:"输入邮编正确！"}).regexValidator({regExp:"zipcode", dataType:"enum", onError:"邮编格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入邮编", onfocus:"邮编由6位数字组成", onCorrect:"输入邮编正确！", onEmpty:""}).regexValidator({regExp:"zipcode", dataType:"enum", onError:"邮编格式不正确！"});
		}
	}
}
/**
验证字母
**/
function validateLetter(obj) 
{
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入字母", onCorrect:"输入字母正确！"}).regexValidator({regExp:"letter", dataType:"enum", onError:"字母格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入字母", onCorrect:"输入字母正确！", onEmpty:""}).regexValidator({regExp:"letter", dataType:"enum", onError:"字母格式不正确！"});
		}
	}
}
/**
验证整数 (正 负)
**/
function validateInteger(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入整数", onCorrect:"输入整数正确！"}).regexValidator({regExp:"intege", dataType:"enum", onError:"输入整数格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入整数", onCorrect:"输入整数正确！", onEmpty:""}).regexValidator({regExp:"intege", dataType:"enum", onError:"输入整数格式不正确！"});
		}
	}
}
/**
验证 正整数
**/
function validatePositiveInteger(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入正整数", onCorrect:"输入正整数正确！"}).regexValidator({regExp:"intege1", dataType:"enum", onError:"正整数格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入正整数", onCorrect:"输入正整数正确！", onEmpty:""}).regexValidator({regExp:"intege1", dataType:"enum", onError:"正整数格式不正确！"});
		}
	}
}
/**
验证 负整数
**/
function validateNegativeInteger(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入负整数", onCorrect:"输入负整数正确！"}).regexValidator({regExp:"intege2", dataType:"enum", onError:"负整数格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入负整数", onCorrect:"输入负整数正确！", onEmpty:""}).regexValidator({regExp:"intege2", dataType:"enum", onError:"负整数格式不正确！"});
		}
	}
}
/**
驗證 浮点数(正 負)
**/
function validateDecmal(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入浮点数", onCorrect:"输入浮点数正确！"}).regexValidator({regExp:"decmal", dataType:"enum", onError:"输入浮点数格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入浮点数", onCorrect:"输入浮点数正确！", onEmpty:""}).regexValidator({regExp:"decmal", dataType:"enum", onError:"输入浮点数格式不正确！"});
		}
	}
}
/**
驗證 正浮点数
**/
function validatePositiveDecmal(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入正浮点数", onCorrect:"输入正浮点数正确！"}).regexValidator({regExp:"decmal1", dataType:"enum", onError:"正浮点数格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入正浮点数", onCorrect:"输入正浮点数正确！", onEmpty:""}).regexValidator({regExp:"decmal1", dataType:"enum", onError:"正浮点数格式不正确！"});
		}
	}
}
/**
驗證 負浮点数
**/
function validateNegetiveDecmal(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入负浮点数", onCorrect:"输入负浮点数正确！"}).regexValidator({regExp:"decmal2", dataType:"enum", onError:"负浮点数格式不正确！"});
		} else {
			return $("#" + obj.id).formValidator({empty:true, onShow:"请输入负浮点数", onCorrect:"输入负浮点数正确！", onEmpty:""}).regexValidator({regExp:"decmal2", dataType:"enum", onError:"负浮点数格式不正确！"});
		}
	}
}
/**
验证 单选按钮  
**/
function validateRadio(obj) {
	if (obj) {
	 
	 var tip=obj.id;
	 
	 var index=obj.id.indexOf(".");
	 
	 if(index!=-1)
	 {
	   tip=obj.id.substring(index+1);
	 }
		if (obj.required) {
		  return $(":radio[name='"+obj.id+"']").formValidator({empty:false,tipID:tip+"Tip",onShow:"请选择"+obj.name,onFocus:"请选择"+obj.name,onCorrect:"选择正确"}).inputValidator({min:1,max:1,onError:"请确认选择"+obj.name});
		}else
		{
		  return $(":radio[name='"+obj.id+"']").formValidator({empty:true,tipID:tip+"Tip",onShow:"请选择"+obj.name,onFocus:"请选择"+obj.name,onCorrect:"选择正确", onEmpty:""}).inputValidator({min:1,max:1,onError:"请确认选择"+obj.name});
		}
	}
}
/**
验证 多选按钮  
**/
function validateCheck(obj) {
	
	if (obj) 
	{

     var tip=obj.id;
	 
	 var index=obj.id.indexOf(".");
	 
	 if(index!=-1)
	 {
	   tip=obj.id.substring(index+1);
	 }
	   if (obj.required) {
	     return $(":checkbox[name='"+obj.id+"']").formValidator({empty:false,tipID:tip+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选对正确"}).inputValidator({min:1,onerror:"最少必须选择一个"});
 	   }else
 	   {
 	     return $(":checkbox[name='"+obj.id+"']").formValidator({empty:true,tipID:tip+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选对正确", onEmpty:""}).inputValidator({min:1,onerror:"你选的个数不对"});
 	   }
	}
}
/**
验证 下拉列表 单选  
**/
function validateDropDownList(obj) {
	if (obj) {
	return $("#"+obj.id).formValidator({onShow:"请选择你的学历",onFocus:"学历必须选择",onCorrect:"选择正确"}).functionValidator({
	   
	    fun:function(val,elem){
           
           var result=false;
           
	       if(val &&  val!=""  && val.length>0 && obj.required)
	       {
	        result=true;
	       }
	       return result;
		},
		onError:"请选择"+obj.name
	  });
	}
}

/**
验证密码
如果带comparId 则是 需要和此id的内容进行比较
minLen 默认 6
maxLen 默认 9
**/
function validatePassword(obj)
{
if (obj) {

     if(!obj.minLen )
	 {
	 obj.minLen=6;
     }
     
      if(!obj.maxLen )
	 {
	 obj.maxLen=9;
     }

	   if (!obj.compareId)
	   {   
		   if(obj.minLen==obj.maxLen){
             return $("#"+obj.id).formValidator({empty:false,onShow:"请输入"+obj.name,onFocus:"请输入"+obj.name,onCorrect:"输入"+obj.name+"正确"}).inputValidator({min:obj.minLen,max:obj.maxLen,onError:obj.name+"长度（"+obj.minLen+"位）！",empty:{leftEmpty:false,rightEmpty:false,emptyError:obj.name+"两边不能有空符号"}});	     
		   }else
		   {
			     return $("#"+obj.id).formValidator({empty:false,onShow:"请输入"+obj.name,onFocus:"请输入"+obj.name,onCorrect:"输入"+obj.name+"正确"}).inputValidator({min:obj.minLen,max:obj.maxLen,onError:obj.name+"长度（"+obj.minLen+"至"+obj.maxLen+"位）！",empty:{leftEmpty:false,rightEmpty:false,emptyError:obj.name+"两边不能有空符号"}});	     
		   }
       }else
       {   
		   if(obj.minLen==obj.maxLen){
		   
		   return $("#"+obj.id).formValidator({empty:false,onShow:"请输入"+obj.name,onFocus:"请输入"+obj.name,onCorrect:obj.name+"两次一致"}).inputValidator({min:obj.minLen,max:obj.maxLen,onError:obj.name+"长度（"+obj.minLen+"位）！",empty:{leftEmpty:false,rightEmpty:false,emptyError:obj.name+"两边不能有空符号"}}).compareValidator({desID:obj.compareId,operateor:"=",onError:"两次密码不一致,请确认"});	     
		  
		   }else{
          return $("#"+obj.id).formValidator({empty:false,onShow:"请输入"+obj.name,onFocus:"请输入"+obj.name,onCorrect:"两次密码一致"}).inputValidator({min:obj.minLen,max:obj.maxLen,onError:obj.name+"长度（"+obj.minLen+"至"+obj.maxLen+"位）！",empty:{leftEmpty:false,rightEmpty:false,emptyError:obj.name+"两边不能有空符号"}}).compareValidator({desID:obj.compareId,operateor:"=",onError:"两次密码不一致,请确认"});	     
		   }
          
       }
     }
}

/**
验证日期类型
**/
function validateDate(obj)
{
   if (obj) 
   {
     if (obj.required) 
     {
        return $("#"+obj.id).formValidator({empty:false,tipID:obj.id+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选对正确"}).functionValidator({
	    fun:function(val,elem){
	      var t=/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	        return t.test(val);
		},
		onError:"日期格式错误"
	});
     }else
     {
      return $("#"+obj.id).formValidator({empty:true,tipID:obj.id+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选对正确", onEmpty:""}).functionValidator({
	    fun:function(val,elem){
	        var t=/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
	        return t.test(val);
		},
		onError:"日期格式错误"
	});
     }
   }
}

/**
验证日期 并带有 compareId 并要大于compareId 的时间 
**/
function validateAfterDate(obj)
{
  
   if (obj) 
   {
     if (obj.required) 
     {
       var begin=$("#"+obj.compareId);
        return $("#"+obj.id).formValidator({empty:false,tipID:obj.id+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选对正确"}).inputValidator({regExp:"^(19|20)\d{2}-(0?\d|1[012])-(0?\d|[12]\d|3[01])$",onerror:"日期类型错误!"}).functionValidator({
	    fun:function(val,elem){
	        if(begin){
	         return comptime($(begin).val(),val);
	        }else
	        {
	        //alert(elem.);
	        return false;
	        }
		},
		onError:"结束日期小于开始日期"
	});
     }else
     {
      return $("#"+obj.id).formValidator({empty:true,tipID:obj.id+"Tip",onshow:"请选择"+obj.name,onfocus:"请选择"+obj.name,oncorrect:"选对正确", onEmpty:""}).inputValidator({regExp:"^(19|20)\d{2}-(0?\d|1[012])-(0?\d|[12]\d|3[01])$",onerror:"日期类型错误!"}).functionValidator({
	    fun:function(val,elem){
	        if(begin){
	         return comptime($(begin).val(),val);
	        }else
	        {
	        //alert(elem.);
	        return false;
	        }
		},
		onError:"结束日期小于开始日期"
	  });
     }
   }
}

/**
日期比较 
结束时间大于开始时间 true
其他false
**/
function comptime(begin,end) {

  try{
		var beginTime = begin.toString();
		var beginTimes = beginTime.substring(0, 10).split('-');
		beginTime = beginTimes[1] + '-' + beginTimes[2] + '-' + beginTimes[0]
				+ ' ' + beginTime.substring(10, 19);
		//firefox对于类似“2010-12-20 15:55:00”这种时间的转换格式不感冒，返回Nan，查了查资料，把“-”替换为“/”就可以了
		beginTime = beginTime.replace("-", "/").replace("-", "/");
		
		var endTime = end.toString();
		var endTimes = endTime.substring(0, 10).split('-');
		endTime = endTimes[1] + '-' + endTimes[2] + '-' + endTimes[0]
				+ ' ' + endTime.substring(10, 19);
		//firefox对于类似“2010-12-20 15:55:00”这种时间的转换格式不感冒，返回Nan，查了查资料，把“-”替换为“/”就可以了
		endTime = endTime.replace("-", "/").replace("-", "/");
		var a = (Date.parse(endTime) - Date.parse(beginTime)) / 3600 / 1000;
		if (a >0) {

			return true;
		} else {
			return false;
		}
	}catch(ex){
		return false;
	}
}

/**
验证 正整数+0
**/
function validatePositiveNum(obj) {
	if (obj) {
		if (obj.required) {
			return $("#" + obj.id).formValidator({empty:false, onShow:"请输入正整数", onCorrect:"输入正整数正确"}).regexValidator({regExp:"num1", dataType:"enum", onError:"正整数格式不正确"});
		} else {
			return $("#" + obj.id).formValidator({empty:true,  onShow:"请输入正整数", onCorrect:"输入正整数正确", onEmpty:""}).regexValidator({regExp:"num1", dataType:"enum", onError:"正整数格式不正确"});
		}
	}
}
/***
 * 比较数字<
 * @param {Object} obj
 * @return {TypeName} 
 */
function compareNum_lt(obj){
	if (obj) {
		var required = true;
		if (obj.required) {
			required = false;
		}
		var srcObj = $("#" + obj.id);
		if(srcObj){
			return srcObj.formValidator({ empty:required, tipID:obj.id+"Tip", leftTrim:true, rightTrim:true, onEmpty:"", onShow:"", onCorrect:"", onFocus:""}).regexValidator({regExp:"intege1", dataType:"enum", onError:"请输入正整数"}).functionValidator({onError:"必须前小于后", fun:function(val, elem){
				var desVal = $("#" + obj.compareId).val();	
				var result = true;
				if(val && desVal){
					var srcVal = parseInt(val);
					desVal = parseInt(desVal);
					result = (srcVal<desVal);
				}
				return result;
				}});
		}
	}
}
/***
 * 比较数字>
 * @param {Object} obj
 * @return {TypeName} 
 */
function compareNum_gt(obj){
	if (obj) {
		var required = true;
		if (obj.required) {
			required = false;
		}
		var srcObj = $("#" + obj.id);
		if(srcObj){
			return srcObj.formValidator({ empty:required, tipID:obj.compareId+"Tip", leftTrim:true, rightTrim:true, onEmpty:"", onShow:"", onCorrect:"", onFocus:""}).regexValidator({regExp:"intege1", dataType:"enum", onError:"请输入正整数"}).functionValidator({onError:"必须后大于前", fun:function(val, elem){
				var desVal = $("#" + obj.compareId).val();	
				var result = true;
				if(val && desVal){
					var srcVal = parseInt(val);
					desVal = parseInt(desVal);
					result = (srcVal>desVal);
				}
				return result;
				}});
		}
	}
}