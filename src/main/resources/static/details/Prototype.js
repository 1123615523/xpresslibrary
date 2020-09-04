var Ajax={xmlhttp:function(){try{return new ActiveXObject('Msxml2.XMLHTTP');}catch(e){try{return new ActiveXObject('Microsoft.XMLHTTP');}catch(e){return new XMLHttpRequest();}}}};Ajax.Request=function(){if(arguments.length<2)return;var _p={asynchronous:true,method:"GET",parameters:""};for(var key in arguments[1]){_p[key]=arguments[1][key];}
var _x=Ajax.xmlhttp();var _url=arguments[0];if(_p["parameters"].length>0)_p["parameters"]+='&_=';if(_p["method"].toUpperCase()=="GET")_url+=(_url.match(/\?/)?'&':'?')+_p["parameters"];_x.open(_p["method"],_url,_p["asynchronous"]);_x.onreadystatechange=function(){if(_x.readyState==4){if(_x.status==200){_p["onSuccess"]?_p["onSuccess"](_x):"";}else{_p["onFailure"]?_p["onFailure"](_x):"";}}}
if(_p["method"].toUpperCase()=="POST")_x.setRequestHeader("Content-Type","application/x-www-form-urlencoded");_x.send(_p["method"].toUpperCase()=="POST"?_p["parameters"]:null);};function RefreshImageVerifier(id,srcname){var elm=document.getElementById(id);var dt=new Date();elm.src=srcname+'&ts='+dt;return false;}
function $$(element){element=document.getElementById(element);return element;}
function $F(element){element=document.getElementById(element);return element.value;}
function topCloseWindowAndRefreshParent(){try{window.parent.ClosePopupAndRefresh();}catch(e){alert(e);}
try{window.parent.refresh();window.close();}catch(e){alert(e);}}
function topCloseWindow(){try{window.parent.closePopup();}catch(e){}
try{window.close();}catch(e){}}
function openCenterWindow(url,openWindowName,wishWidth,wishHeight){var realWidth=wishWidth;if(realWidth>=screen.width){realWidth=screen.width-20;}
var realHeight=wishHeight;if(realHeight>=screen.height){realHeight=screen.height-80;}
var realTop=0;realTop=(screen.height-realHeight)/2-20;var realLeft=0;realLeft=(screen.width-realWidth)/2-5;var openWindow=window.open(url,openWindowName,"width="+realWidth+",height="+realHeight+",top="+realTop+",left="+realLeft+",Status=no,toolbar=no,menubar=no,location=no,scrollbars=yes,resizable=no")
openWindow.focus();}
function openCenterWindow1(url,openWindowName,wishWidth,wishHeight,showbg,showClose)
{if(showbg==null)showbg="true";var title=openWindowName;tipsWindown("<span style='font-size:12px;'>"+title+"</span>","iframe:"+url,wishWidth,wishHeight,"false","",showbg,"",showClose);}
var prevSwapObj;var prevSwapClass;function swapOut(){if(prevSwapObj!=undefined)prevSwapObj.className=prevSwapClass;prevSwapObj=undefined;return true;}
function swapOver(obj,cName){swapOut();prevSwapObj=obj;prevSwapClass=obj.className;obj.className=cName;return true;}
function ResetPage(){}
function closeMe()
{window.close();return false;}
function closeMeWithConfirm(msg){if(confirm(msg))
{window.close();}
return false;}
function createCookie(name,value,days){if(days){var date=new Date();date.setTime(date.getTime()+(days*24*60*60*1000));var expires="; expires="+date.toGMTString();}
else var expires="";document.cookie=name+"="+value+expires+"";}
function readCookie(name){var nameEQ=name+"=";var ca=document.cookie.split(';');for(var i=0;i<ca.length;i++){var c=ca[i];while(c.charAt(0)==' ')c=c.substring(1,c.length);if(c.indexOf(nameEQ)==0)return c.substring(nameEQ.length,c.length);}
return null;}
function eraseCookie(name){createCookie(name,"",-1);}
function trim(theString){var checkedAll=false;var checkString=theString;while((!checkedAll)&&(checkString.length!=0)){if(checkString.indexOf(' ')==0)
{checkString=checkString.substring(1);continue;}
if(checkString.lastIndexOf(' ')==(checkString.length-1))
{checkString=checkString.substring(0,checkString.length-1);continue;}
checkedAll=true;}
return checkString;}
function focus(theObj){if(theObj!=null){if(!theObj.disabled)
{theObj.focus();}}}
function SetIcon(urlroot,icon){new Ajax.Request(urlroot+"index.html",{method:"post",parameters:"icon="+icon,onSuccess:function(transport){var response=transport.responseText||"";if(response!=""){window.location.href=window.location.href;}},onFailure:function(){alert('操作失败.');}});}
function getClientHeight(){var clientHeight=document.body.clientHeight;if(navigator.userAgent.indexOf("MSIE 6.0")!=-1){clientHeight=document.body.clientHeight;}
else if(navigator.userAgent.indexOf("MSIE")!=-1){clientHeight=document.documentElement.offsetHeight}
if(navigator.userAgent.indexOf("Chrome")!=-1){clientHeight=document.body.scrollHeight;}
if(navigator.userAgent.indexOf("Firefox")!=-1){clientHeight=document.documentElement.scrollHeight;}
return clientHeight;}
function getContentHeight(){var ContentHeight=document.body.scrollHeight;if(navigator.userAgent.indexOf("Chrome")!=-1){ContentHeight=document.body.clientHeight;}
if(navigator.userAgent.indexOf("Firefox")!=-1){ContentHeight=document.body.offsetHeight;}
return ContentHeight;}
function searchPre(){var $ipt=$('.cmn_search_box input[type="text"]');var $preBox=$('.search_pre');var $a=$('.search_pre ul li a');$ipt.hover(function(){$preBox.stop().show();},function(){$preBox.stop().hide();});$preBox.hover(function(){$(this).stop().show();},function(){$(this).stop().hide();});$a.each(function(){$(this).click(function(){var dataTxt=$(this).text();console.log(dataTxt);$preBox.hide();});});}
var loadLoginUI=function(){var arr=$("[getloginedcontent]");for(var i=0;i<arr.length;i++){(function(index){var url=arr.eq(index).attr("getloginedcontent");$.get(url+"?t="+(new Date()).valueOf(),function(d){try{arr.eq(index).empty().html(d);}catch(e){}
try{arr.html(d);}catch(e){}});})(i);}
var el=document.getElementById('iframeComment');if(el){var url=""+el.src;el.src=url;}}
$(document).ready(function(){loadLoginUI();$('#gotop').hide();$("#gotop").click(function(){$(window).scrollTop(0);});if(screen.width<1000){$('#gotop').hide();}
$(window).bind("scroll",function(event){if($(window).scrollTop()>300){$('#gotop').show();}
else
$('#gotop').hide();});var tag=document.getElementById("conAll0");var con=document.getElementById("conAll");if(!con)con=document.getElementById("conAll2");if(tag&&con){tag.onmouseover=con.onmouseover=function(){con.style.display="block";con.style.zIndex=999999;}
tag.onmouseout=con.onmouseout=function(){con.style.display="none";}}
var tag2=document.getElementById("conz0");var con2=document.getElementById("conz");if(tag2&&con2){tag2.onmouseover=con2.onmouseover=function(){con2.style.display="block";con2.style.zIndex=999999;}
tag2.onmouseout=con2.onmouseout=function(){con2.style.display="none";}}});function setFileType(type){document.getElementById("fileType").value=type;}
function CheckKeyWords(){var k=document.getElementById("hotKeyword").value;if(k.length<2){alert("关键字至少输入2个字符")
return false;}
return true;}
function toQzoneLogin(){var A=window.open("oauth/QQlogin.aspx","TencentLogin");}
function toWeiboLogin(){var A=window.open("oauth/sinalogin.aspx","Weibologin");}
function toAplipayLogin(){var A=window.open("oauth/Alipaydefault.aspx","AplipayLogin");}
function toRenrenLogin(){var A=window.open("oauth/Renrenlogin.aspx","RenrenLogin");}
function toWeixinLogin(){var A=window.open("oauth/weixinlogin.aspx","Weixinlogin");}
function SubmitKeyWords(){document.getElementById("submit_search").click();}
function initFileType(){if(document.getElementById("all")){if(fileType=="-1")document.getElementById("all").checked=true;else{document.getElementById("all").checked=false;if(fileType=="1")document.getElementById("doc").checked=true;if(fileType=="2")document.getElementById("pdf").checked=true;if(fileType=="3")document.getElementById("pic").checked=true;if(fileType=="4")document.getElementById("flash").checked=true;if(fileType=="5")document.getElementById("mp3").checked=true;if(fileType=="6")document.getElementById("mp4").checked=true;}}}
function WriteLog(){}
function ReadLog(id,table){}
function Dealbook(id,flag){}
function AddFavorite(sURL,sTitle){try{window.external.addFavorite(sURL,sTitle);}
catch(e){try{window.sidebar.addPanel(sTitle,sURL,"");}
catch(e){alert("加入收藏失败，请使用Ctrl+D进行添加");}}}
function SetHome(obj,vrl){try{obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);}
catch(e){if(window.netscape){try{netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");}
catch(e){alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");}
var prefs=Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);prefs.setCharPref('browser.startup.homepage',vrl);}}}