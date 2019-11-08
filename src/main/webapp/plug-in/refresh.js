$(function(){ 
	setTimeout(function(){ 
		if($("#btnQuery").size()>0 && $("#doQuery").size()==0){
			$("#btnQuery").css('display','none');
			$("#btnQuery").after('&nbsp;<span><input id="doQuery" style="width:50px;height:22px;color:black;" type="button" value="查询" /></span>');
			$("#doQuery").bind('click',doqy); 
		}	 
	},100);
});
function doqy(){
	$("#btnQuery").click();
	setTimeout(function(){LBUI.fun.refresh();i++;},20);//延迟刷新时间
}
