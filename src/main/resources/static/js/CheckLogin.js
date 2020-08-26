function checkLogin(uid,pid)
{var oUser=document.getElementById(uid);if(oUser)
{if(oUser.value=="")
{alert("请输入用户名！");oUser.focus();return false;}}
var oPwd=document.getElementById(pid);if(oPwd)
{if(oPwd.value=="")
{alert("请输入密码！");oPwd.focus();return false;}}
return true;}