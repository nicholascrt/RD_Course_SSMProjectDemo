$(function () {
    //判断Pagination是否已被加载
    var pageFlag = false;

    $('.search-bar .dropdown-menu a').click(function () {
        var field = $(this).data('field') || '';
        $('#search-field').val(field);
        $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });

    $('#search-input').keydown(function (e) {
        //回车键的keyCode值是13
        if(e.keyCode===13){
            console.log("按下了回车键");
            //用户选择的搜索类型，获取搜索类型
            var type = $('#search-field').val();
            //用户输入的关键字
            var keyword = $('#search-input').val();
            //一旦做了过滤查询，一定要初始化分页插件PageHelper
            pageFlag = false;
            if("name"===type){
                //{name:"用户输入的关键字"}
                getList({name:keyword});
            } else{
                getList({address:keyword});
            }
        }
    })

    //初始化列表
    getList();

    //获取部门列表，动态渲染页面
    function getList(data) {
        if(data===undefined){
            data = {};
        }

        $.ajax({
            url: "/department/getList",
            type: "post",
            cache: false,
            async: false,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (data) {
                if (data.success) {
                    //将获取到的数据进行动态渲染
                    handleList(data.data);
                    if(!pageFlag){
                        getPageInfo(data.data);
                        pageFlag=true;
                    }
                } else {
                    //TODO:做一个提醒
                }
            }
        })
    }

    function handleList(data) {
        var i = 1;
        var html = '';
        data.list.map(function (item, index) {
            html += '<tr>'
                + '<td>' + (i++) + '</td>'
                + '<td>' + item.name + '</td>'
                + '<td>' + item.address + '</td>'
                + '<td>' + departmentStatusToString(item.status) + '</td>'
                + '<td>'
                + '<div class="btn-group">'
                + '<a class="btn btn-xs btn-default" href="/department/goDepartmentEdit?depId="' + item.depId + ' title="编辑"'
                + 'data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>'
                + '<a class="btn btn-xs btn-default" href="/department/goDepartmentView?depId="' + item.depId + ' title="查看"'
                + 'data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>'
                + departmentStatusEditButton(item.status, item.depId)
                + '</div>'
                + '</td></tr>';
        })
        //覆盖
        $('.department-wrap').html(html);
    }

    //将部门状态文字化处理
    function departmentStatusToString(status) {
        if (status == 1) {
            return '<font class="text-success">正常</font>';
        }
        return '<font class="text-danger">失效</font>';
    }

    function departmentStatusEditButton(status, depId) {
        if (status == 1) {
            return '<a data-id=' + depId + ' data-status='+status+' class="btn btn-xs btn-default department-status-btn" href="#!" title="修改状态" data-toggle="tooltip" ><i class="mdi mdi-toggle-switch"></i></a>'
        }
        return '<a data-id=' + depId + ' data-status='+status+' class="btn btn-xs btn-default department-status-btn" href="#!" title="修改状态" data-toggle="tooltip" ><i class="mdi mdi-toggle-switch-off"></i></a>'
    }

    $(".department-wrap").on('click', 'a', function (e) {
        console.log(e.currentTarget.dataset.id+":"+e.currentTarget.dataset.status);
        var target = $(e.currentTarget);
        if(target.hasClass('department-status-btn')){
            console.log("click修改状态");
            var depId = e.currentTarget.dataset.id;
            var status = e.currentTarget.dataset.status;
            $.ajax({
                url: "/department/switchDepartmentStatus",
                type: "post",
                cache: false,
                async: false,
                dataType: 'json',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify({depId:depId,status:status}),
                success: function (data) {
                    //从cookie中获得当前页
                    console.log(document.cookie);
                    var cookies = document.cookie.split(';');
                    //遍历cookies数组
                    $.each(cookies,function (index,item) {
                        var names = item.split("=");
                        if("currentPage"===names[0]){
                            //操作成功后重新渲染页面
                            getList({pageNum:names[1]});
                        }
                    })

                    if (data.success) {
                        lightyear.notify('部门状态更新成功~', 'success', 1000, 'mdi mdi-emoticon-happy', 'top', 'center');
                        //操作成功后重新渲染页面
                        // getList();
                    } else {
                        lightyear.notify(data.errMsg, 'danger', 1000, 'mdi mdi-emoticon-sad', 'top', 'center');
                        //操作成功后重新渲染页面
                        // getList();
                    }
                }
            })
        }
    })

    //分页数据
    function getPageInfo(data) {
        // console.log("初始化分页插件");
        console.log(data)
        $('.pagination').pagination({
            pageCount:data.pages,
            isHidden:true,
            coping:true,
            callback:function (e) {
                console.log(e.getCurrent());
                var data = {};
                data.pageNum = e.getCurrent();
                /**
                 * 保存cookie 保存当前页数
                 * cookie : 名称=内容； 名称=key：value ..
                 */
                document.cookie = "currentPage=" + e.getCurrent();
                getList(data);
            }
        });
    }
})