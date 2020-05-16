$(document).ready(function(){
	//注册tab					   
	var wweya_li =$(".reg_m1_tab li");
	wweya_li.click(function(){
	$(this).addClass("selected")    
	 .siblings().removeClass("selected");  
		var index =  wweya_li.index(this); 
	$(".reg_m2_tabcontent > div")   	
	.eq(index).show()   
		.siblings().hide(); 
	});
	//首页张开
	$(".index_threebutton1").find("a").click(function(){
		$(".index_threebutton1,.login_container").hide();
		$(".index_leftcontent").show();
	})	
});
































