/**
 * @cookie  验证
 *  
 */
layui.define(['layer'], function (exports) {
    var layer = layui.layer;
    (() => {
        let welcome = document.querySelector('.welcome');
        let loginout = document.querySelector('.loginout');
        var name = getCookie('login_name');
        console.log(name);
        if (!name) {
            var index = layer.msg('检测到您未登录，请登录！！！'+name, { icon: 16, time: false, shade: 1 });
            setTimeout(() => {
                layer.close(index);
                location.href = "../index.html";
            }, 2000);
        }

        if (name) {
            welcome.innerHTML = name+'';
        }

        //    退出
        loginout.onclick = (e) => {
            $.ajax({
                url: '/login',
                type: 'get',
                data: {'method': 'delCookie'},
                dataType: 'json',
                success: function (backData) {
                    if(backData.code == 0){
                        layer.msg("退出成功！");
                        location.href = "../index.html";
                    }
                }
            })
        }
    })();
});

function clearCookie(name) {
    //获取当前时间
    var date=new Date();
//将date设置为过去的时间
    date.setTime(date.getTime()-1000000000);
//将userId这个cookie删除
    document.cookie=name+"="+getCookie(name)+"828; expires="+date.toGMTString();
}

function getCookie(cookieName){
    var cookieValue="";
    if (document.cookie && document.cookie != '') {
        console.log(document.cookie);
        var cookies = document.cookie.split(';');
        for (var i = 0; i < cookies.length; i++) {
            var cookie = cookies[i];
            console.log(cookie.substring(0, cookieName.length).trim())
            if (cookie.substring(0, cookieName.length).trim() == cookieName.trim()) {
                cookieValue = cookie.substring(cookieName.length+1, cookie.length);
                break;
            }
        }
    }
    return cookieValue;
}