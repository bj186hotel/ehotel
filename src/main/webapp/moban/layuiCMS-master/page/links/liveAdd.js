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
    console.log("2222222"+now[0]);
    var orderId = now[0];
    var mun = now[1];

    addlive();

    /*动态生成添加入住人员表单*/
    function addlive() {  //动态展示商品的方法
        for (let i = 0; i < mun; i++) {
            $('#liveform').append(
                `
            	<div class="layui-form-item" >
		<label class="layui-form-label">真实姓名：</label>
		<div class="layui-input-inline">
			<input type="text" name="cusName${i}" class="layui-input" placeholder="姓名" id="cusName${i}">
		</div>
		<label class="layui-form-label">身份证号：</label>
		<div class="layui-input-inline">
			<input type="text" name="IDcard${i}" class="layui-input" id="IDcard${i}">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">备注：</label>
		<div class="layui-input-block">
			<textarea placeholder="请输入内容" class="layui-textarea" name="remark${i}" id="remark${i}"></textarea>
		</div>
	</div>
			`)

			if(i == mun-1){
                $('#liveform').append(
                    `
                    <div class="layui-form-item">
		<div class="layui-input-block">
			<button type="button" class="layui-btn layui-btn-normal" id="sub">提交</button>
		</div>
	</div>
                    `)
			}
        }
    }

    /*提交入住人员信息*/
    $("#sub").click(function(){
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
