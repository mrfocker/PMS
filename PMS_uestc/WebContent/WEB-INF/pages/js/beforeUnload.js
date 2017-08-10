/**
 * <p>
 * Title: beforeUnload
 * </p>
 * <p>
 * Description:TODO
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年8月10日
 * @version 1.0
 */

function onbeforeunload1() {
	var n = window.event.screenX - window.screenLeft;
	var b = n > document.documentElement.scrollWidth - 20;
	if (b && window.event.clientY < 0 || window.event.altKey) {
		alert("确认退出？");
		//window.event.returnValue = "确认退出?"; // 这里可以放置你想做的操作代码
		//var warning="确认退出?";   
		window.location.href = "${pageContext.request.contextPath }/pages/exitLogin.action";
		return true;
	}
}

//function onunload1() {
//	window.location.href = "${pageContext.request.contextPath }/pages/exitLogin.action";
//}