layui.config({
	base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		layedit = layui.layedit,
		laydate = layui.laydate,
		$ = layui.jquery;

    var data = decodeURI(location.search);//获取从列表页传过来的订单id和可住人数
	console.log("111111"+typeof data);
    var now = data.split('&');//切割
    var order = {"orderId":now[0].substring(1,now[0].length)};
    var mun = now[1];
    console.log(now[0].substring(1,now[0].length));

    //addlive();

    $.ajax({
        url: "/cusOrder/getCusByOrderId",
        dataType: "json",
        contentType: "application/json",
        async: true, //请求是否异步，默认为异步，这也是ajax重要特性
        data: JSON.stringify(order),    //参数值
        type: "post",   //请求方式
        success: function (data) {
            if(data.code == 200){
                if(data.data.length > 0){
                    console.log(data.data)
                    addlive(data.data);
                } else {
                    alert("请添加入住人员")
                    $('#linksAdd_btn').append(
                        `
                    <a class="layui-btn linksAdd_btn" id="add" style="background-color:#5FB878">新增</a>
                    `)
                    $('#linksAdd').append(
                        `
                    <a class="layui-btn linksAdd_btn" id="submit" style="background-color:#5FB878">保存</a>
                    `)
                    $("#add").click(function(){
                        $('#liveform').append(
                            `
       <div class="layui-form-item" style="border: #5c60ff ;border-style: solid;border-width: 2px;">
            <br>
       <div class="layui-form-item" >
		<label class="layui-form-label">真实姓名：</label>
		<div class="layui-input-inline">
			<input type="text" name="cusName"  class="layui-input" placeholder="姓名">
		</div>
		<label class="layui-form-label">身份证号：</label>
		<div class="layui-input-inline">
			<input type="text" name="IDcard" class="layui-input">
		</div>
		<div class="layui-input-inline">
			<a class="layui-btn linksAdd_btn del" style="background-color:#5FB878">删除</a>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">备注：</label>
		<div class="layui-input-block">
			<textarea placeholder="请输入内容" class="layui-textarea" name="remark" ></textarea>
		</div>
	</div>
	</div>
			`)
                        addDel();
                    })
                }
            }
        }
    })


    /*删除*/
    function addDel() {
        $(".del").click(function(){
            alert("确定要删除吗？")
            $(this).parent().parent().parent().remove();
            form.render('select');
        })
    }


    /*动态生成添加入住人员表单*/
    function addlive(data) {  //动态展示商品的方法
        for (let i = 0; i < data.length; i++) {
            $('#liveform').append(
                `
        <div class="layui-form-item" style="border: #5c60ff ;border-style: solid;border-width: 2px;">
            <br>
            	<div class="layui-form-item" >
		<label class="layui-form-label">真实姓名：</label>
		<div class="layui-input-inline">
			<input type="text" name="cusName" value="${data[i].cusname}" class="layui-input" placeholder="姓名">
		</div>
		<label class="layui-form-label">身份证号：</label>
		<div class="layui-input-inline">
			<input type="text" name="IDcard" value="${data[i].idcard}" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">备注：</label>
		<div class="layui-input-block">
			<textarea placeholder="请输入内容" class="layui-textarea" name="remark" >${data[i].remark}</textarea>
		</div>
	</div>
	</div>
			`)
        }
    }

    /*提交入住人员信息*/
    $("#submit").click(function(){
		for (var i=0;i<mun;i++) {
			var IDcard = $("#IDcard"+i+"").val();
			var cusName = $("#cusName"+i+"").val();
			var remark = $("#remark"+i+"").val();
            $.ajax({
                url : "http://mockjs",
                type : "get",
                dataType : "json",
                success : function(data){

                }
            })
		}
    })
})
