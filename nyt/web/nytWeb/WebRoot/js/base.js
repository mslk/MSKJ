/**
 * 分页 js  begin
 * @param message
 * @param url
 */


 function toPage(i){
	   $("#page").val(i);
	   document.forms[0].submit();
   }
   
   
   function goPage(obj){
//		var gotoPage = document.getElementById("gotoPage");
	   var gotoPage =$(obj).prev();
		if(isNumber($(gotoPage).val())){
			$("#page").val($(gotoPage).val());
			document.forms[0].submit();
		}else{
			alert("请输入正整数！");
		}
   }
   
   
   function isNumber(number){
		var r,re;
		re=/\d*/i;//d表示数字,*表示匹配多个数据
		r=number.match(re);
		return (r==number)?1:0;
	}
/**
    * 分页 js  end
    * @param message
    * @param url
 */  
   

function delTips(message, url) {
    if (confirm(message || "您确定要删除这条信息吗？")) {
        window.location = url;
    }
}


function toPageUrl(url){
	window.location.href=url;
}


/**
 * 煤种选择页面
 */
function chooseCoalType(page)
{
	var url="choose/controller.action?type=1";
	if(page){
		url+="&page="+page;
	}
	lock(url);
}

/**
 * 选择煤种
 */
function checkCoalType(coaltypeid, coaltypename)
{
	if(coaltypeid && coaltypename ){
	
		cheked('coalTypeId','coalTypeName',coaltypeid,coaltypename,2);
		
		$("#coalTypeName").change(function(){
			  $("#coalTypeId").val("");
		});
	}
}



/**
 * 清除煤种
 */
function clearCoalType()
{
  dataClear('coalTypeId','coalTypeName',2);
}



/**
 * 煤种粒度选择页面
 */
function chooseCoalParticleSize(page)
{
	var url="choose/controller.action?type=2&coalTypeId=";
	
	var coalTypeId=$("#coalTypeId").val();
  	if( coalTypeId && coalTypeId!="" && coalTypeId>0 ){
  		
  		url+=coalTypeId;
  		if(page){
  			url+="&page="+page;
  		}
  		lock(url);
  	}else{
      alert("请选择煤种！");  		
  	}
	
}


/**
 * 选择煤种粒度
 */
function checkCoalParticleSize(coalParticleSizeId, coalParticleSizeName)
{
	if(coalParticleSizeId && coalParticleSizeName ){
	
		cheked('coalParticleSizeId','coalParticleSizeName',coalParticleSizeId,coalParticleSizeName,2);
	}
}

/**
 * 清除煤种粒度
 */
function clearCoalParticlesize()
{
	dataClear('coalParticleSizeId','coalParticleSizeName',2);
}


/**
 * 收货地类型选择页面
 */
function chooseDeliveryplaceType(page)
{
	var url="choose/controller.action?type=3";
  	if(page){
  			url+="&page="+page;
  	}
  	lock(url);
}

/**
 * 选择收货地类型
 */
function checkDeliveryplaceType(typeId, typeName)
{
	if( (typeId|| typeId==0 ) && typeName){
	
		cheked('deliveryplaceTypeId','deliveryplaceTypeName',typeId,typeName,2);
	}
}

/**
 * 清除收货地类型
 */
function clearDeliveryplaceType()
{
	dataClear('deliveryplaceTypeId','deliveryplaceTypeName',2);
}


/**
 * 清除数据
 * type  1 span
         2 text
 */
function dataClear(id,name,showType)
{
	
	var city=$("#"+id);
	var cityN=$("#"+name);
	if(city!=null && cityN!=null){
	  city.val("");
	  if(showType==1){
	    cityN.html("");
	  }else if(showType==2){
	    cityN.val("");
	  }
	}
	$("#ly").hide();
	$("#Layer2").html("");
	$("#Layer2").hide();
	
	
}

/**
showType 1 span
         2 text
**/
function cheked(id,name,idV,naV,showType){
	var city=$("#"+id);
	var cityN=$("#"+name);
	if(city!=null && cityN!=null){
	  city.val(idV);
	  if(showType==1){
	    cityN.html(naV);
	  }else if(showType==2){
	    cityN.val(naV);
	  }
	}
	$("#ly").hide();
	$("#Layer2").html("");
	$("#Layer2").hide();
}



/**
 * 解锁弹出层
 */
function unLock() {
	var obj1 = $("#ly");
	var obj2 = $("#Layer2");
	if (obj1 != null && obj2 != null) {
		obj1.hide();
		obj2.html("");
		obj2.hide();
        //location.replace(location.href);    //关闭后刷新此页面 
	}
	return false;
}

/**
 * 锁定弹出层
 */
function lock(targetPath) {
   	if(targetPath == null || targetPath=="" )return;
	lockLayerId="ly";
	showLayerId="Layer2";
	
	var obj = $("#"+lockLayerId);
	var obj2 = $("#"+showLayerId);
	if (obj != null && obj2 != null ) {
		obj.show();
		obj2.html("<div style='text-align:center'><image src='images/wait/04.gif' /></div>");
		obj2.show();
		var width = document.documentElement.clientWidth;
		var height = document.documentElement.clientHeight;
		obj.width(width);
		obj.height(height);
		obj.css("backgroundColor","#fff");
		obj.css("opacity",0.5);
		var width2 = obj2.width();
		var offHeight = document.body.clientHeight;
		var height2 = obj2.height();
		obj2.css("left" , (width - width2) / 2);
		obj2.css("top" , (offHeight - height2 ) / 2);
		$.get(targetPath, function(data){obj2.html(data);});
	}
}