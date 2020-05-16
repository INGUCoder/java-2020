// JavaScript Document
$(document).ready(function(){
	//教材1 tab					   
	var supplier =$(".supplier_intro_tab li");
	supplier.click(function(){
	$(this).addClass("selected")    
	 .siblings().removeClass("selected");  
		var index =  supplier.index(this); 
	$(".supplier_intro_bot > div")   	
	.eq(index).show()   
		.siblings().hide(); 
	});	
	//教材2 tab					   
	var supp_li =$(".supplier_d_tab li");
	supp_li.click(function(){
	$(this).addClass("selected")    
	 .siblings().removeClass("selected");  
		var index =  supp_li.index(this); 
	$(".supplier_d_tabcontent > div")   	
	.eq(index).show()   
		.siblings().hide();
		
	});	
	//资源 tab					   
	var resources_li =$("#resources_tab > li");
	resources_li.click(function(){
	$(this).addClass("selected")    
	 .siblings().removeClass("selected");  
		var index =  resources_li.index(this); 
	$(".resources_content > div")   	
	.eq(index).show()   
		.siblings().hide(); 
	});	
	//资源图片鼠标hover
	$(".tools_tabcontent li a").hover(
		function(){
			$(this).find("div").show();
			return false;
		},
		function(){
			$(this).find("div").hide();
			return false;
		});
	//added by zy
	$(".supplier_l_list input").bind("click",search);
});		
function tranlan(lan) {
	if(lan=="en") {
		$(".supplier_l_bt li").eq(0)
				.removeClass("selected").siblings().addClass("selected");
		$(".supplier_l_list label").each(function(){
			var spans = $(this).find("span");
			spans.eq(0).hide();
			spans.eq(1).show();
		});
	} else {
		$(".supplier_l_bt li").eq(1)
				.removeClass("selected").siblings().addClass("selected");
		$(".supplier_l_list label").each(function(){
			var spans = $(this).find("span");
			spans.eq(1).hide();
			spans.eq(0).show();
		});
	}
}
//added by zy
function getMore(){
	var title = $("input[name=seach_title]").val();
	var age = getCheckStr("age");
	var kind = getCheckStr("kind");
	var lang = getCheckStr("lang");
	var con = getCheckStr("content");
	var lang2 = getCheckStr("lang2");
	var nextPage = parseInt($("#pageNo").val()) + 1;
	var vendorId = $("#vendorId").val();
	var param = {pageNo:nextPage, vendorId:vendorId, age:age, kind:kind, lang:lang, lang2:lang2, content:con, title:title};
	$.get(url, param, function(data){
		if(data.length==26){
			//alert("没有更多了！");
			$("#a_more").hide();
			return;
		}
    	var lastLi = $("#supplier_div").children("ul").children("li").last();
    	lastLi.after(data);
    	$("#show_li").hide();
    	$("#pageNo").val(nextPage++);
  	});
}
//added by zy
function getCheckStr(name){
	var str = "";
	$("input[name="+name+"]").each(function(i){
		 if($(this).attr("checked")){
			 if(str!=""){
				 str += ",";
			 }
			 str += $(this).val();
		 }
	});
	//var inputObj = {str:str,vs:vs};
	return str;
}
//added by zy
function getVs(){
	var vs = "";
	var vs_en = "";
	$("input[type=checkbox][name!='']").each(function(i){
		 if($(this).attr("checked")){
			 if(vs!="") {
				 vs +="，";
				 vs_en += ", ";
			 }
			 vs += $(this).next("span").text();
			 vs_en += $(this).next("span").next("span").text()
		 }
	});
	$("#tiaojian").text(vs);
	$("#supplier_en").text(vs_en);
}
//added by zy
function search(){
	var title = $("input[name=seach_title]").val();
	var age = getCheckStr("age");
	var kind = getCheckStr("kind");
	var lang = getCheckStr("lang");
	var con = getCheckStr("content");
	var lang2 = getCheckStr("lang2");
	var vendorId = $("#vendorId").val();
	var param = {pageNo:1, vendorId:vendorId, age:age, kind:kind, lang:lang, lang2:lang2, content:con, title:title};
	getVs();
	$.get(url, param, function(data){
		$("#supplier_div").children("ul").html(data);
		if(data.length==165){
			$("#a_more").hide();
			$("#show_li").show();
		} else {
			//$("#a_more").show();
			$("#show_li").hide();
		}
  	});
}
//added by zy
function checkAll(name,currobj){
	var cval = false;
	if($(currobj).attr("checked")!=null)
		cval = true;
	$("input[name="+name+"]")
		.attr("checked", cval);
}
