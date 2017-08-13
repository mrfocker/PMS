/*
  第一步的提交方法
*/
function one() 
{
    if (confirm("确定提交？")) {
        $("#one").hide();
        $("#two").show();
        $("#grxx").attr("class","current_prev");
        $("#zjxx").attr("class","current");
    }
}

/*
  第二步的提交方法
*/
function two() 
{
    if (confirm("确定提交？")) {
        $("#two").hide();
        $("#three").show();

        $("#grxx").attr("class","done");
        $("#zjxx").attr("class","current_prev");
        $("#qzxx").attr("class","current");
    }
}

/*
  第三步的提交方法
*/
function three() 
{
    if (confirm("确定提交？")) {
        $("#three").hide();
        $("#four").show();

        $("#grxx").attr("class","done");
        $("#zjxx").attr("class","done");
        $("#qzxx").attr("class","current_prev");
        $("#qzfs").attr("class","current");
    }
}

/*
  返回第一步的提交方法
*/
function reone() 
{
    if (confirm("确定返回？")) {
        $("#one").show();
        $("#two").hide();
        $("#grxx").attr("class","current");
        $("#zjxx").attr("class","");
    }
}
/*
  返回第二步的提交方法
*/        
function retwo() 
{
    if (confirm("确定返回？")) {
        $("#three").hide();
        $("#two").show();
        $("#grxx").attr("class","current_prev");
        $("#zjxx").attr("class","current");
        $("#qzxx").attr("class","");
    }
}
/*
  返回第三步的提交方法
*/
function rethree() 
{
    if (confirm("确定返回？")) {
        $("#four").hide();
        $("#three").show();
        $("#grxx").attr("class","done");
        $("#zjxx").attr("class","current_prev");
        $("#qzxx").attr("class","current");
        $("#qzfs").attr("class","last");
    }
}