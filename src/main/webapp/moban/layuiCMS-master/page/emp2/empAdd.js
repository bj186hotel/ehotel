layui.config({
    base : "js/"
}).use(['form','layer','jquery','layedit','laydate'],function(){
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    //创建一个编辑器
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

        addLinks = '{"linksName":"'+ $("#depId").val() +'",';  //部门ID
        addLinks += '"linksUrl":"'+ $("#empName").val() +'",';	 //姓名
        addLinks += '"linksDesc":"'+ $("#empSex").text() +'",'; //性别
        addLinks += '"linksTime":"'+ $("#empAge").val() +'",'; //年龄
        addLinks += '"masterEmail":"'+ $("#empPhone").val() +'",'; //联系方式
        addLinks += '"masterEmail":"'+ $("#empEmail").val() +'",'; //邮箱
        addLinks += '"masterEmail":"'+ $("#empPay").val() +'",'; //薪资
        addLinks += '"masterEmail":"'+ $("#remark").val() +'",'; //备注
        addLinks += '"showAddress":"'+ showAddress +'"}';  //展示位置
        addLinksArray.unshift(JSON.parse(addLinks));
        window.sessionStorage.setItem("addLinks",JSON.stringify(addLinksArray));
        //弹出loading
        var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            top.layer.close(index);
            top.layer.msg("文章添加成功！");
            console.log("22222222222");
/*            console.log(addLinksArray);*/
            layer.closeAll("iframe");
            //刷新父页面
            parent.location.reload();
        },2000);
        return false;
    })
});