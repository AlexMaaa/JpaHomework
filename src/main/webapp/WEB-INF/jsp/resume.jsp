
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<style type="text/css">

    a:link{color:red;}

    a:visited{color:black;}

</style>
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#create").bind("click",function(){
            var name = $("#0_name").val()
            var address = $("#0_address").val()
            var phone = $("#0_phone").val()
            $.ajax({
                url:'/save',
                type:'POST',    //GET
                async:false,    //或false,是否异步
                contentType: 'application/json',
                data:JSON.stringify({
                    name:name,
                    address:address,
                    phone:phone
                }),
                timeout:5000,    //超时时间
                dataType:'json', //返回的数据格式：json/xml/html/script/jsonp/text
                success:function(data){
                    alert("ok")
                    window.location.reload()  //刷新页面
                }
            })
        })


    })
    function update(id) {
        var name = $("#"+id+"_name").val()
        var address = $("#"+id+"_address").val()
        var phone = $("#"+id+"_phone").val()
        $.ajax({
            url:'/save',
            type:'POST',    //GET
            async:false,    //或false,是否异步
            contentType: 'application/json',
            data:JSON.stringify({
                id:id,
                name:name,
                address:address,
                phone:phone
            }),
            timeout:5000,    //超时时间
            dataType:'json', //返回的数据格式：json/xml/html/script/jsonp/text
            success:function(data){
                alert("ok")
                window.location.reload()  //刷新页面
            }
        })
    }

    function del(id) {
        $.ajax({
            url:'/delete',
            type:'GET',    //GET
            async:false,    //或false,是否异步
            data:{
                id:id
            },
            timeout:5000,    //超时时间
            dataType:'json', //返回的数据格式：json/xml/html/script/jsonp/text
            success:function(data){
                alert(data)
                window.location.reload()  //刷新页面
            }
        })
    }
</script>
<head>
    <title>简历列表</title>
</head>
<body>

    <table>
        <tr>
            <td>id</td>
            <td>名字</td>
            <td>address</td>
            <td>phone</td>
            <td>操作</td>
        </tr>
        <tr>
            <td></td>
            <td><input id="0_name" name="name" value="" ></td>
            <td><input id="0_address" name="address" value="" ></td>
            <td><input id="0_phone" name="phone" value="" ></td>
            <td><a id="create" >新增</a></td>
        </tr>
        <c:forEach items="${list}" var="resume">
        <tr>
            <td><input id="${resume.id}_id" name="id" value="${resume.id}" ></td>
            <td><input id="${resume.id}_name" name="name" value="${resume.name}" ></td>
            <td><input id="${resume.id}_address" name="address" value="${resume.address}" ></td>
            <td><input id="${resume.id}_phone" name="phone" value="${resume.phone}" ></td>
            <td>
                <a href="javascript:update('${resume.id}')" class="update" >修改</a>
                <a href="javascript:del('${resume.id}')" class="delete" >删除</a>

            </td>
        </tr>

        </c:forEach>

    </table>
</body>
</html>
