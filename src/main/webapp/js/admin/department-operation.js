$(function () {

    $('#status-off').click(function () {
        $('#status-off').attr("checked",true);
        $('#status-on').removeAttr("checked");
    })
    $('#status-on').click(function () {
        $('#status-on').attr("checked",true);
        $('#status-off').removeAttr("checked");
    })

    $('#submit').click(function () {
        var department = {};
        department.name = $('#dep-name').val();
        department.address = $('#dep-address').val();
        console.log("状态:"+$("input[name='dep-status'][checked]").val());
        department.status = $("input[name='dep-status'][checked]").val();

        var formData = new FormData();
        formData.append("departmentStr",JSON.stringify(department));

        $.ajax({
            url: "/department/insertDepartment",
            type: "post",
            cache: false,
            async: false,
            dataType: 'json',
            data:formData,
            contentType:false,
            processData:false,
            success: function (data) {
                if (data.success) {
                    lightyear.notify('部门添加成功~', 'success', 1000, 'mdi mdi-emoticon-happy', 'top', 'center');
                    //操作成功后重新渲染页面
                    window.location.href = '/department/toList';
                } else {
                    lightyear.notify(data.errMsg, 'danger', 1000, 'mdi mdi-emoticon-sad', 'top', 'center');
                    //操作成功后重新渲染页面
                    // getList();
                }
            }
        })
    })


})