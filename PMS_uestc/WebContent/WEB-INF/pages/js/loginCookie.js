/**
 *  * <p>
 * name: loginCookie.js
 * </p>
 * <p>
 * Description:Cookie
 * </p>
 * <p>
 * Company: uestc_xr
 * </p>
 * 
 * @author Xiaozhe
 * @date 创建时间：2017年6月29日
 * @version 1.0
 */

var login = {
		cookie:{
			init:function(param){
				//登录
				$.cookie('userId', usr-field, {expires:1, path:'${pageContext.request.contextPath }/pages/login'});
			}
		}
}