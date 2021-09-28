$(function () {
    $('#log-out').click(function () {
        //清除Session
        $.ajax({
            url:'/logout',
            type:'POST',
            async:false,
            cache:false,
            dataType:'json',
            success:function (data) {
                if(data.success){
                    //清除Session成功并跳转到登录页面
                    window.location.href = '/login';
                }
            },
            error:function (data,error) {
                alert(error);
            }
        })
    })
})