function louad(type){
    $.ajax({
        type:'post',
        url:'getArticle',
        dataType:'json',
        data:{'limit':2,'curr':1,'type':type},
        success:function (data) {
            $('#danum').text(data.code);//总日志数
            $('#sum').text(data.state);//文章访问量
            laypage.render({
                elem: 'demo'
                ,count: data.msg
                ,limit: 2
                , curr: 1
                ,jump:function (e) {
                    $.ajax({
                        type:'post',
                        url:'getArticle',
                        dataType:'json',
                        data:{'limit':2,'curr':e.curr,'type':type},
                        success:function (datas) {
                            var html = "";
                            var big = $("#big");
                            for (var i = 0;i<datas.data.length;i++) {
                                html += "<div class=\"item\">\n" +
                                    "          <div class=\"layui-fluid\">\n" +
                                    "            <div class=\"layui-row\">\n" +
                                    "              <div class=\"layui-col-xs12 layui-col-sm4 layui-col-md5\">\n" +
                                    "                <div class=\"img\"><a href=\"todetails?id="+datas.data[i].id+"\"><img src=\" " + datas.data[i].aCover + "\" alt=\"\"></a></div>\n" +
                                    "              </div>\n" +
                                    "              <div class=\"layui-col-xs12 layui-col-sm8 layui-col-md7\">\n" +
                                    "                <div class=\"item-cont\">\n" +
                                    "                  <h3><a href=\"todetails?id="+datas.data[i].id+"\" style=''>" + datas.data[i].aTitle + "</a><button class=\"layui-btn layui-btn-danger new-icon\">new</button></h3>\n" +
                                    "                  <h5>" + datas.data[i].aType + "</h5>\n" +
                                    "                  <p title='"+datas.data[i].aDec+"'>"+ datas.data[i].aDec + "</p>\n" +
                                    "                  <a href=\"todetails?id="+datas.data[i].id+"\" class=\"go-icon\"></a>\n" +
                                    "                </div>\n" +
                                    "            </div>\n" +
                                    "            </div>\n" +
                                    "           </div>\n" +
                                    "        </div>";

                            }

                            big.html(html);
                        }
                    })
                }
            });
        }
    })

}



layui.config({
    base: 'static/res/js/util/'
}).use(['element','laypage','jquery','menu'],function(){
    element = layui.element,laypage = layui.laypage,$ = layui.$,menu = layui.menu;
    var te =  $("a[class='active']").text().substring(2);
    menu.init();
    louad(te);
})

$("a[name='type']").click(function() {
    var type = $(this).text();
    var choose = this;
    $("a[name='type']").removeClass();
    choose.className = 'active';
    louad(type);
})
