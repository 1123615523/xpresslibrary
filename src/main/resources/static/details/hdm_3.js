function scrollDoor(){}
scrollDoor.prototype={sd:function(menus,divs,openClass,closeClass){var _this=this;if(menus.length!=divs.length)
{alert("˵ݲһ!");return false;}
for(var i=0;i<menus.length;i++)
{_this.j(menus[i]).value=i;_this.j(menus[i]).onmouseover=function(){for(var j=0;j<menus.length;j++)
{_this.j(menus[j]).className=closeClass;_this.j(divs[j]).style.display="none";}
_this.j(menus[this.value]).className=openClass;_this.j(divs[this.value]).style.display="block";}}},j:function(oid){if(typeof(oid)=="string")
return document.getElementById(oid);return oid;}}
window.onload=function(){var SDmodel=new scrollDoor();SDmodel.sd(["m001","m002"],["c001","c002"],"sd001","sd002");}