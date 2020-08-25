jQuery(document).ready(function(){var setCount=5;var key="wenku365HistoryRecord";var regStr="www.wenku365.com/p-(.+)";var mRegStr="pay.wenku365.com/p-(.+)";var mRegStr2="m.wenku365.com/p-(.+)";var btnHtml="<div id='cd-nav' class='is-fixed'>"+
    "    <a href='#0' class='cd-nav-trigger'>bookList<span></span></a>"+
    "    <nav id='cd-main-nav'>"+
    "        <ul id='cd-nav-ul'>"+
    "<div style='border-bottom:1px solid rgba(0, 162, 202, 0.4); font-size: 16px;width:100%;line-height: 20px;padding: 14px;'><span style='color: #0a0a0a'>鏈€杩戦瑙�</span></div>"+
    "</ul>"+
    "    </nav>"+
    "</div>"
    $('body').append(btnHtml);var navigationContainer=$('#cd-nav'),mainNavigation=navigationContainer.find('#cd-main-nav ul');$('.cd-nav-trigger').on('click',function(){$(this).toggleClass('menu-is-open');mainNavigation.off('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend').toggleClass('is-visible');});getRecord();function getRecord(){var recordJson=getCookie(key);if(recordJson===""){$("#cd-nav-ul").innerHTML="";$("#cd-nav-ul").append("<li><a href= 'javascript:void(0)'><span>鎮ㄥ皻鏈湁娴忚璁板綍</span></a></li>");}else{var data=eval("("+recordJson+")");var record=data["record"];var length=record.length;if(length>setCount){length=setCount;}
        if(length>0){for(var i=length-1;i>=0;i--){var temp="<li><a href= '"+record[i].url+"' style='overflow: hidden;text-overflow:ellipsis;white-space: nowrap;'>"+record[i].title+" </a></li>"
            $("#cd-nav-ul").append(temp);}}else{$("#cd-nav-ul").innerHTML="";$("#cd-nav-ul").append("<li><a href= 'javascript:void(0)'><span>鎮ㄥ皻鏈湁娴忚璁板綍</span></a></li>");}}}
    function getCookie(cookName){if(document.cookie.length>0){var c_start=document.cookie.indexOf(cookName+"=");if(c_start!=-1){c_start=c_start+cookName.length+1;var c_end=document.cookie.indexOf(";",c_start);if(c_end==-1){c_end=document.cookie.length;}
        return unescape(document.cookie.substring(c_start,c_end));}}
        return "";}
    $(function(){var url=window.location.href;var reg=new RegExp(regStr)
        var mReg=new RegExp(mRegStr)
        var mReg2=new RegExp(mRegStr2)
        if(reg.test(url)||mReg.test(url)||mReg2.test(url)){var index=url.indexOf("html");url=url.substring(0,index+4)
            var title="";if(reg.test(url)){title=$("#box1 > div > h1").text();}
            if(mReg.test(url)||mReg2.test(url)){title=$("#recentBrowse").text();}
            if(title){addRecord(url,title)}}})
    function addRecord(url,title){stringCookie=getCookie(key);var stringHistory=""!==stringCookie?stringCookie:"{\"record\":[]}";var json=new JSONHistory(stringHistory);var list=json["record"];for(var i=0;i<list.length;i++){try{if(list[i].url===url){list.splice(i,1);i=i-1;}}catch(e){break;}}
        if(list.length>=setCount){var count=list.length-setCount+1;list.splice(0,count);}
        var e="{url:\""+url+"\",title:\""+title+"\"}";json["record"].push(e);setCookie(key,json.toString(),365);}
    function setCookie(cookName,cookValue,expiredays){var date=new Date();date.setDate(date.getDate()+expiredays*24*3600*1000);var cookieVal=cookName+"="+escape(cookValue)+((expiredays==null)?"":";expires="+date.toGMTString())+";path=/";document.cookie=cookieVal;}
    var JSONHistory=function(sJSON){this.objType=(typeof sJSON);if(this.objType=='string'&&''==sJSON){sJSON='{"record":[]}';}
        this.self=[];(function(s,o){for(var i in o){o.hasOwnProperty(i)&&(s[i]=o[i],s.self[i]=o[i])};})(this,(this.objType=='string')?eval('0,'+sJSON):sJSON);};JSONHistory.prototype={toString:function(){return this.getString();},valueOf:function(){return this.getString();},getString:function(){var sA=[];(function(o){var oo=null;sA.push('{');for(var i in o){if(o.hasOwnProperty(i)&&i!='prototype'){oo=o[i];if(oo instanceof Array){sA.push(i+':[');for(var b in oo){if(oo.hasOwnProperty(b)&&b!='prototype'){sA.push(oo[b]+',');if(typeof oo[b]=='object')arguments.callee(oo[b]);}}
            sA.push('],');continue;}else{sA.push(i+':\''+oo+'\',');}
            if(typeof oo=='object')arguments.callee(oo);}}
            sA.push('},');})(this.self);return sA.slice(0).join('').replace(/\[object object\],/ig,'').replace(/,\}/g,'}').replace(/,\]/g,']').slice(0,-1);},push:function(sName,sValue){this.self[sName]=sValue;this[sName]=sValue;}};});
