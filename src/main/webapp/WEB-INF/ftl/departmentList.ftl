<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>部门列表</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/css/style.min.css" rel="stylesheet">
    <link href="/css/pagination.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <#--   头部信息  -->
        <#include "topbar.ftl" />
        <#--   侧边栏  -->
        <#include "slider.ftl"/>

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-toolbar clearfix">
                                <div class="pull-right search-bar">
                                    <div class="input-group">
                                        <div class="input-group-btn">
                                            <input type="hidden" name="search_field" id="search-field" value="name">
                                            <button class="btn btn-default dropdown-toggle" id="search-btn"
                                                    data-toggle="dropdown" type="button" aria-haspopup="true"
                                                    aria-expanded="false">
                                                名称 <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu">
                                                <li><a tabindex="-1" href="javascript:void(0)" data-field="name">名称</a>
                                                </li>
                                                <li><a tabindex="-1" href="javascript:void(0)"
                                                       data-field="address">地址</a></li>
                                            </ul>
                                        </div>
                                        <input id="search-input" type="text" class="form-control" value="" name="keyword"
                                               placeholder="请输入关键字">
                                    </div>
                                </div>
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-primary m-r-5" href="/department/toDepartmentAdd"><i class="mdi mdi-plus"></i> 新增</a>
<#--                                    <a class="btn btn-success m-r-5" href="#!"><i class="mdi mdi-check"></i> 启用</a>-->
<#--                                    <a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i>禁用</a>-->
                                </div>
                            </div>
                            <div class="card-body">

                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
<#--                                            全选-->
<#--                                            <th>-->
<#--                                                <label class="lyear-checkbox checkbox-primary">-->
<#--                                                    <input type="checkbox" id="check-all"><span></span>-->
<#--                                                </label>-->
<#--                                            </th>-->
                                            <th>编号</th>
                                            <th>名称</th>
                                            <th>地址</th>
                                            <th>状态</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody class="department-wrap">
                                        <#--                                            <td>-->
                                        <#--                                                <label class="lyear-checkbox checkbox-primary">-->
                                        <#--                                                    <input type="checkbox" name="ids[]" value="1"><span></span>-->
                                        <#--                                                </label>-->
                                        <#--                                            </td>-->
                                        </tbody>
                                    </table>
                                </div>
                                <ul class="pagination m-style">
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<script type="text/javascript" src="/js/admin/department-list.js"></script>
<#--引入模版自带的消息提示css-->
<script src="/js/bootstrap-notify.min.js"></script>
<script type="text/javascript" src="/js/lightyear.js"></script>
<#-- PageHelper css引入-->
<script type="text/javascript" src="/js/jquery.pagination.js"></script>

</body>
</html>