$(function () {
    //登录验证的Controller的url
    var url = 'checkLogin';
    //累计登陆失败次数
    var loginAttempt = 0;

    $('#submit').click(function () {
        //获取输入的帐号
        var username = $('#username').val();
        //获取输入的密码
        var password = $('#password').val();
        //获取输入的验证码
        var verificationCodeInput = $('#j_captcha').val();
        //错误三次后 设置为true
        var needVerify = false;
        if(loginAttempt>=3){
            needVerify = true;
            if(!verificationCodeInput){
                lightyear.notify('请输入验证码~', 'warning', 1000, 'mdi mdi-emoticon-sad', 'top', 'center');
                return;
            }
        }
        $.ajax({
            url:url,
            type:"post",
            cache:false,
            async:false,
            dataType:'json',
            contentType:'application/json',
            //JSON.stringify把对象转换成JSON字符串
            data: JSON.stringify({
                //确保名字驼峰规则和Controller接收方法的参数一致
                userName: username,
                password: password,
                needVerify: needVerify,
                verificationCode: verificationCodeInput
            }),
            success:function (data) {
                if(data.success){
                    //通知
                    lightyear.notify('登录成功~', 'success', 1000, 'mdi mdi-emoticon-happy', 'top', 'center');
                    //跳转页面
                    window.location.href = '/main';
                }else{
                    lightyear.notify(data.errMsg, 'danger', 1000, 'mdi mdi-emoticon-sad', 'top', 'center');
                    loginAttempt++;
                    if(loginAttempt>=3){
                        $('#verifyPart').show();
                    }
                }
            }
        })
    })
});

//更新验证码图片
function changeVerificationCode(img) {
    img.src = "kaptcha?"+Math.floor(Math.random()*100);
}