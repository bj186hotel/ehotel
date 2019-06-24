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
    var enter_order_ID = now[0];//获取进货单id



    /*页面初始化加载，通过进货单id加载进货单明细*/
    $(function (){//动态添加option
        $.ajax({
            url: 'http://mockjs2',
            dataType : "json",
            async      : true, //请求是否异步，默认为异步，这也是ajax重要特性
            data       : {},    //参数值
            type       : "GET",   //请求方式
            success:function (backData) {
                var data = backData.data;
                for (var i = 0;i < data.length;i++){
                    $("#liveform").append(`
               
                        <div class="">
                        
		<div class="layui-form-item" style="border: #1E9FFF ;border-style: solid;
  border-width: 2px;">
			<br>
			<label class="layui-form-label">商品类型：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number" class="layui-input" placeholder="商品类型" readonly="readonly">
			</div>
			<label class="layui-form-label">商品：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number" class="layui-input" placeholder="商品" readonly="readonly">
			</div>
			<label class="layui-form-label">单价：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number" class="layui-input" placeholder="单价" readonly="readonly">
			</div>
			
			<br><br><br>
			<div class="layui-form-item">
			<label class="layui-form-label">预订数量：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number" class="layui-input" placeholder="商品数量" readonly="readonly">
			</div>
			<label class="layui-form-label">实际数量：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number" class="layui-input" placeholder="商品数量" readonly="readonly">
			</div>
			<label class="layui-form-label">本次数量：</label>
			<div class="layui-input-inline">
				<input type="text" name="pron_number" class="layui-input" placeholder="商品数量" id="pron_number">
			</div>
			</div>
			<br>
			<div class="layui-form-item">
				<label class="layui-form-label">备注：</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea" name="remark" idremark></textarea>
				</div>
			</div>
		</div>
		</div>
                    `);
                    //console.log("cheng"+data);
                }
                form.render();


            },
            error:function (e){
                console.log(e)
            }
        })
    })




})
