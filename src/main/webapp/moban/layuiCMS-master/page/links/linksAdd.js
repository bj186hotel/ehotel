layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

    $("#submit").click(function () {
    	var order ;
        /*order = '{"roomId":"'+ $("#roomId2 option:selected").val() +'",';*/
        order = '{"roomId":"'+ 1001 +'",';
        order += '"menNum":"'+ $("#memId").val() +'",';
        order += '"usersId":"'+ 1001 +'",';
        order += '"orderstate":"'+ 1 +'",';
        order += '"personnum":"'+ $("#personNum").val() +'",';
        order += '"intime":"'+ $("#inTime").val() +'",';
        order += '"outtime":"'+ $("#outTime").val() +'",';
        order += '"remark":"'+ $("#remark").val() +'"}';
        var parse = JSON.parse(order);
        console.log(JSON.stringify(parse));
        $.ajax({
            url: "/order/addOrder",
            dataType: "json",
            contentType: "application/json",
            async: true, //请求是否异步，默认为异步，这也是ajax重要特性
            data: JSON.stringify(parse),    //参数值
            type: "post",   //请求方式
            success:function (backData) {
                console.log('成功了'+JSON.stringify(backData));
                var a = JSON.stringify(backData);
                console.log('成功了'+backData.msg);
                console.log('成功了'+a.data);
                if(backData.code == 0){
                    window.location.href = "html/index.html";
                }

            },
            error:function (e){
                console.log(e)
            }
        })
	})

	/*//创建一个编辑器
 	var editIndex = layedit.build('links_content');
 	var addLinksArray = [],addLinks;
 	form.on("submit(addLinks)",function(data){
 		//是否添加过信息
	 	if(window.sessionStorage.getItem("addLinks")){
	 		addLinksArray = JSON.parse(window.sessionStorage.getItem("addLinks"));
	 	}
	 	//显示、审核状态
 		var homePage = data.field.homePage=="on" ? "首页" : "",
 			subPage = data.field.subPage=="on" ? "子页" : "";
 			showAddress = '';
 		if(subPage == '' && homePage == ''){
 			showAddress = "暂不展示";
 		}else if(homePage == ''){
 			showAddress = subPage;
 		}else if(subPage == ''){
 			showAddress = homePage;
 		}else{
 			showAddress = homePage + '，' + subPage;
 		}

 		addLinks = '{"linksName":"'+ $(".linksName").val() +'",';  //网站名称
 		addLinks += '"linksUrl":"'+ $(".linksUrl").val() +'",';	 //网站地址
 		addLinks += '"linksDesc":"'+ $(".linksDesc").text() +'",'; //站点描述
 		addLinks += '"linksTime":"'+ $(".linksTime").val() +'",'; //发布时间
 		addLinks += '"masterEmail":"'+ $(".masterEmail").val() +'",'; //站长邮箱
 		addLinks += '"showAddress":"'+ showAddress +'"}';  //展示位置
 		addLinksArray.unshift(JSON.parse(addLinks));
 		window.sessionStorage.setItem("addLinks",JSON.stringify(addLinksArray));
 		//弹出loading
 		var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            top.layer.close(index);
			top.layer.msg("文章添加成功！");
 			layer.closeAll("iframe");
	 		//刷新父页面
	 		parent.location.reload();
        },2000);
 		return false;
 	})*/
	
})
